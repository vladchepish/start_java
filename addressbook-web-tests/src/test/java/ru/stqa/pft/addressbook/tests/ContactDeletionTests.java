package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

public class ContactDeletionTests extends TestBase{

    @Test
    public void testContactDeletion () {
        app.getNavigationHelper().goToHomePage();
        if (! app.getContactHelper().isContactExisting()){
            app.getContactHelper().creationContact(new ContactDate("testFirstName1", "testMiddleName1", "testLastName1", "testAddress1", "+79797979797", "test@test.test", "testName"), true);
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();
        app.getContactHelper().closeAlert();
    }

}
