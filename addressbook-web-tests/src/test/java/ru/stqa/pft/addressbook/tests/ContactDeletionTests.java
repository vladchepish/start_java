package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        File photo = new File("src/test/resources/avatar.png");
        app.goTo().homePage();
        if (app.db().contacts().size() == 0) {
            app.contact().create(new ContactDate().withFirstName("testFirstName1").withHomePhone("11111").withMobilePhone("22222")
                    .withWorkPhone("333333").withGroup("testName").withPhoto(photo), true);
        }
    }

    @Test
    public void testContactDeletion () {
        Contacts before = app.db().contacts();
        ContactDate deletedContact = before.iterator().next();
        app.contact().deletion(deletedContact);
        app.goTo().homePage();
        assertThat(app.contact().count(),equalTo( before.size() -1));
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.withOut(deletedContact)));
        verifyContactListUi();
    }

}
