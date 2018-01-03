package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

public class ContactPhoneTests extends TestBase {

    @Test
    public void testContactPhones(){
        app.goTo().homePage();
        ContactDate contact = app.contact().all().iterator().next();
        ContactDate contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    }
}
