package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

import java.io.File;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.junit.MatcherAssert.*;

public class ContactAddressTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        File photo = new File("src/test/resources/avatar.png");
        app.goTo().homePage();
        if (app.db().contacts().size() == 0) {
            app.contact().create(new ContactDate().withFirstName("testFirstName1").withHomePhone("11111").withMobilePhone("22222").withWorkPhone("333333").withGroup("testName").withPhoto(photo), true);
        }
    }

    @Test
    public void testContactAdress(){
        app.goTo().homePage();
        ContactDate contact = app.contact().all().iterator().next();
        ContactDate contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));
    }



}
