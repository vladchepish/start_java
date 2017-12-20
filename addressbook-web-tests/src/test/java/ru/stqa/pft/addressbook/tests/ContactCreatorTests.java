package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

import java.util.List;

public class ContactCreatorTests extends TestBase {

    @Test
    public void ContactCreatorTests(){
        app.getNavigationHelper().goToHomePage();
        List<ContactDate> before = app.getContactHelper().getContactList();
        app.getContactHelper().creationContact(new ContactDate("testFirstName1", "testMiddleName1", "testLastName1", "testAddress1", "+79797979797", "test@test.test", "testName"), true);
        List<ContactDate> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);
    }

}
