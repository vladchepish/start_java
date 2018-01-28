package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
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

public class ContactRemovedFromGroupTests extends TestBase {

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
    public void testContactRemoveFromGroup(){
        Contacts contacts = app.db().contacts();
        Iterator<ContactDate> iteratorContacts = contacts.iterator();
        ContactDate contact = iteratorContacts.next();
        GroupDate group = contact.getGroups().iterator().next();

        app.goTo().homePage();
        while(iteratorContacts.hasNext()){
            if(contact.getGroups().size() > 0){
                group = contact.getGroups().iterator().next();
                app.contact().filterGroupById(group.getId());
                break;
            } else {
                contact = iteratorContacts.next();
            }
        }
        app.contact().selectAddedContactById(contact.getId());
        app.contact().removeFromGroup();
        app.goTo().selectedGroupPage(group.getId());
        Groups groupsContactsAfter = app.db().contactById(contact.getId()).iterator().next().getGroups();

        assertThat(groupsContactsAfter, equalTo(contact.getGroups().withOut(group)));
    }
}
