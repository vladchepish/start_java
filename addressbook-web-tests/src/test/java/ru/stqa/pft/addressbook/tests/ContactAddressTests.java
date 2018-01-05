package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.junit.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

public class ContactAddressTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactDate().withFirstName("testFirstName1").withHomePhone("11111").withMobilePhone("22222").withWorkPhone("333333").withGroup("testName"), true);
        }
    }

    @Test
    public void testContactAdress(){
        app.goTo().homePage();
        ContactDate contact = app.contact().all().iterator().next();
        ContactDate contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        MatcherAssert.assertThat(contact.getAddress(), CoreMatchers.equalTo(contactInfoFromEditForm.getAddress()));
        System.out.println(contact.getAddress());
        System.out.println(contactInfoFromEditForm.getAddress());
    }



}
