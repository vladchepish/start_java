package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

import java.util.Comparator;
import java.util.List;

public class ContactCreatorTests extends TestBase {

    @Test
    public void ContactCreatorTests(){
        app.goTo().homePage();
        List<ContactDate> before = app.contact().contactList();
        ContactDate contact = new ContactDate("testFirstName2", "testMiddleName1", "testLastName1", "testAddress1", "+79797979797", "test@test.test", "testName");
        app.contact().create(contact, true);
        List<ContactDate> after = app.contact().contactList();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(contact);
        Comparator<? super ContactDate> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }

}
