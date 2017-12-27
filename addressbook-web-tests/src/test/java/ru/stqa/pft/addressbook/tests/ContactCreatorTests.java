package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactCreatorTests extends TestBase {

    @Test
    public void ContactCreatorTests(){
        app.goTo().homePage();
        Set<ContactDate> before = app.contact().all();
        ContactDate contact = new ContactDate()
                .withFirstName("testFirstName1").withMiddleName("testMiddleName1").withLastName("testLastName1").withAddress("testAddress1")
                .withPhone("79797979797").witheMail("test@test.test").withGroup("testName");
        app.contact().create(contact, true);
        Set<ContactDate> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() + 1);

        contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
        before.add(contact);
        Assert.assertEquals(before, after);
    }

}
