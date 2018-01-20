package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.File;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
     public void ensurePreconditions() {
        Groups groups = app.db().groups();
        File photo = new File("src/test/resources/avatar.png");
        app.goTo().homePage();
        if (app.db().contacts().size() == 0) {
            app.contact().create(new ContactDate().withFirstName("testFirstName1").withMiddleName("testMiddleName").withLastName("testLastName")
                    .withAddress("testAddress").withHomePhone("11111").withMobilePhone("22222").withWorkPhone("333333")
                    .withEmail1("test@test.test").withEmail2("test@test2.test").withEmail3("test@test3.test")
                    .inGroup(groups.iterator().next()).withPhoto(photo), true);
        }
    }


    @Test
    public void testContactModification(){
        File photo = new File("src/test/resources/avatar.png");
        Contacts before = app.db().contacts();
        ContactDate modifiedContact = before.iterator().next();
        ContactDate contact = new ContactDate()
                .withId(modifiedContact.getId()).withFirstName("name").withMiddleName("middle").withLastName("last")
                .withAddress("address").withHomePhone("9999").withMobilePhone("8888").withWorkPhone("77777")
                .withEmail1("aas@as.as").withEmail2("aas2@as.as").withEmail3("asaa3@asd.as").withPhoto(photo);
        app.goTo().homePage();
        app.contact().modify(contact);
        assertThat(app.contact().count(),equalTo( before.size()));
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.withOut(modifiedContact).withAdded(contact)));
        verifyContactListUi();
    }

}
