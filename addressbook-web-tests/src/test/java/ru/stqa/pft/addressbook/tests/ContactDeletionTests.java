package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.GroupDate;

import java.util.List;
import java.util.Set;

public class ContactDeletionTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().contactList().size() == 0) {
            app.contact().create(new ContactDate().withFirstName("testFirstName1"), true);
        }
    }


    @Test
    public void testContactDeletion () {
        Set<ContactDate> before = app.contact().all();
        ContactDate deletedContact = before.iterator().next();
        app.contact().deletion(deletedContact);
        app.goTo().homePage();
        Set<ContactDate> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() -1);

        before.remove(deletedContact);
        Assert.assertEquals(before, after);
    }

}
