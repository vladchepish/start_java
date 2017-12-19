package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification(){
        app.getNavigationHelper().goToHomePage();
        if (! app.getContactHelper().isContactExisting()){
            app.getContactHelper().creationContact(new ContactDate("testFirstName1", "testMiddleName1", "testLastName1", "testAddress1", "+79797979797", "test@test.test", "testName"), true);
        }
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().openContactModificationTest(before - 1);
        app.getContactHelper().fillingContactForm(new ContactDate("name", "middle", "last", "sad", "23123124", "aas@as.as", null), false);
        app.getContactHelper().submitCintactModification();
        app.getContactHelper().returnHomePage();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before);
    }

}
