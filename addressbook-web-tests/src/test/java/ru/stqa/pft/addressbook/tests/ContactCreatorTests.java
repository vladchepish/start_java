package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

import java.util.Date;

public class ContactCreatorTests extends TestBase {

    @Test
    public void ContactCreatorTests(){
        app.getContactHelper().creationContact(new ContactDate("testFirstName1", "testMiddleName1", "testLastName1", "testAddress1", "+79797979797", "test@test.test", "testName"), true);
    }

}
