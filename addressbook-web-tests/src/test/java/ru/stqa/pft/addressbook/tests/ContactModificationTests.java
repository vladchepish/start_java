package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification(){
        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().openContactModificationTest();
        app.getContactHelper().fillingContactForm(new ContactDate("name", "middle", "last", "sad", "23123124", "aas@as.as"));
        app.getContactHelper().submitCintactModification();
        app.getContactHelper().returnHomePage();
    }

}
