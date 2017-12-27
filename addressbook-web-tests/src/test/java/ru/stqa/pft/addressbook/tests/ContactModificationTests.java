package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
     public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().contactList().size() == 0) {
            app.contact().create(new ContactDate().withFirstName("testFirstName1"), true);
        }
    }


    @Test
    public void testContactModification(){
        Set<ContactDate> before = app.contact().all();
        ContactDate modifiedContact = before.iterator().next();
        ContactDate contact = new ContactDate()
                .withId(modifiedContact.getId()).withFirstName("name").withMiddleName("middle").withLastName("last").withAddress("sad").withPhone("23123124").witheMail("aas@as.as");
        app.contact().modify(contact);
        Set<ContactDate> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size());

        before.remove(modifiedContact);
        before.add(contact);
        Assert.assertEquals(before, after);
    }

}
