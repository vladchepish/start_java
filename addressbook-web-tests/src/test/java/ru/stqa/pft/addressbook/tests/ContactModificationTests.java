package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
     public void ensurePreconditions() {
        File photo = new File("src/test/resources/avatar.png");
        app.goTo().homePage();
        if (app.db().contacts().size() == 0) {
            app.contact().create(new ContactDate().withFirstName("testFirstName1").withHomePhone("11111").withMobilePhone("22222")
                    .withWorkPhone("333333").withGroup("testName").withPhoto(photo), true);
        }
    }


    @Test
    public void testContactModification(){
        File photo = new File("src/test/resources/avatar.png");
        Contacts before = app.db().contacts();
        ContactDate modifiedContact = before.iterator().next();
        ContactDate contact = new ContactDate()
                .withId(modifiedContact.getId()).withFirstName("name").withMiddleName("middle").withLastName("last").withAddress("sad").withPhone("23123124").witheMail("aas@as.as").withPhoto(photo);
        app.goTo().homePage();
        app.contact().modify(contact);
        assertThat(app.contact().count(),equalTo( before.size()));
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.withOut(modifiedContact).withAdded(contact)));
        System.out.println(before);
        System.out.println(after);
    }

}
