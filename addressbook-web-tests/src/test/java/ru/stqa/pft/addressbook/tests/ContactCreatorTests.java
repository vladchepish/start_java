package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

import java.util.Date;

public class ContactCreatorTests extends TestBase {

    Date date = new Date();  // Добавил текущую дату в милисекундах, чтобы добавлять её к передаваемым параметрам и делать их уникальными

    @Test
    public void ContactCreatorTests(){
        app.getContactHelper().initCintactCreation();
        app.getContactHelper().fillingContactForm(new ContactDate("testFirstName1" + date.getTime(), "testMiddleName1" + date.getTime(), "testLastName1" + date.getTime(), "testAddress1" + date.getTime(), "+79797979797", "test@test.test", "testName"), true);
        app.getContactHelper().submitContact();
        app.getContactHelper().returnHomePage();
    }

}
