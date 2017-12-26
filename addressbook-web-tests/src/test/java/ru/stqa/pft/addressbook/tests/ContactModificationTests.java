package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
     public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().contactList().size() == 0) {
            app.contact().create(new ContactDate().withFirstName("testFirstName1"), true);
        }
    }


    @Test
    public void testContactModification(){
        List<ContactDate> before = app.contact().contactList();
        int index = before.size() - 1;
        ContactDate contact = new ContactDate()
                .withId(before.get(index).getId()).withFirstName("name").withMiddleName("middle").withLastName("last").withAddress("sad").withPhone("23123124").witheMail("aas@as.as");
        app.contact().modify(index, contact);
        List<ContactDate> after = app.contact().contactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(contact);
        Comparator<? super ContactDate> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }

}
