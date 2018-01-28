package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupDate;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.File;
import java.util.Iterator;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddedToGroupTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        Groups groups = app.db().groups();
        File photo = new File("src/test/resources/avatar.png");
        app.goTo().homePage();

        if (app.db().contacts().size() == 0) {
            if (app.db().groups().size() == 0) {
                app.goTo().groupPage();
                app.group().create(new GroupDate().withName("testName"));
                groups = app.db().groups();
            }
            app.contact().create(new ContactDate().withFirstName("testFirstName1").withMiddleName("testMiddleName").withLastName("testLastName")
                    .withAddress("testAddress").withHomePhone("11111").withMobilePhone("22222").withWorkPhone("333333")
                    .withEmail1("test@test.test").withEmail2("test@test2.test").withEmail3("test@test3.test")
                    .inGroup(groups.iterator().next()).withPhoto(photo), true);
        }
    }

    @Test
    public void testCantactAddedToGroup(){
        Groups groupsAtStart = app.db().groups();
        Contacts contactsAtStart = app.db().contacts();

        ContactDate selectedContact = contactsAtStart.iterator().next();
        Groups groupSelectedContact = selectedContact.getGroups();

        GroupDate selectedGroup;
        Iterator<ContactDate> iteratorContacts = contactsAtStart.iterator();

        while (iteratorContacts.hasNext()){
            if(groupSelectedContact.equals(groupsAtStart)){
                selectedContact = iteratorContacts.next();
                groupSelectedContact = selectedContact.getGroups();
            } else {
                break;
            }
        }
        if (groupSelectedContact.equals(groupsAtStart)){
            app.goTo().groupPage();
            app.group().create(new GroupDate().withName("testNameGroup"));
        }
        groupsAtStart = app.db().groups();
        groupSelectedContact = selectedContact.getGroups();
        groupsAtStart.removeAll(groupSelectedContact);

        if (groupsAtStart.size() > 0 ){
            selectedGroup = groupsAtStart.iterator().next();
        } else {
            throw new RuntimeException("no groups");
        }

        app.goTo().homePage();
        app.contact().selectAddedContactById(selectedContact.getId());
        app.contact().addingInGroupById(selectedGroup.getId());
        app.goTo().selectedGroupPage(selectedGroup.getId());

        ContactDate contactAfter = app.db().contactById(selectedContact.getId()).iterator().next();
        Groups groupsContactAfter = contactAfter.getGroups();

        assertThat(groupsContactAfter, equalTo(groupSelectedContact.withAdded(selectedGroup)));

    }
}
