package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
     public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactDate().withFirstName("testFirstName1").withGroup("testName"), true);
        }
    }


    @Test
    public void testContactModification(){
        Contacts before = app.contact().all();
        ContactDate modifiedContact = before.iterator().next();
        ContactDate contact = new ContactDate()
                .withId(modifiedContact.getId()).withFirstName("name").withMiddleName("middle").withLastName("last").withAddress("sad").withPhone("23123124").witheMail("aas@as.as");
        app.contact().modify(contact);
        assertThat(app.contact().count(),equalTo( before.size()));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.withOut(modifiedContact).withAdded(contact)));
    }

}
