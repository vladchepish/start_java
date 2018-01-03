package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class ContactCreatorTests extends TestBase {

    @Test
    public void ContactCreatorTests(){
        app.goTo().homePage();
        Contacts before = app.contact().all();
        ContactDate contact = new ContactDate()
                .withFirstName("testFirstName1").withMiddleName("testMiddleName1").withLastName("testLastName1").withAddress("testAddress1")
                .withHomePhone("79797979797").withMobilePhone("32332323").withWorkPhone("56565656").witheMail("test@test.test").withGroup("testName");
        app.contact().create(contact, true);
        assertThat(app.contact().count(),equalTo( before.size() + 1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }

}
