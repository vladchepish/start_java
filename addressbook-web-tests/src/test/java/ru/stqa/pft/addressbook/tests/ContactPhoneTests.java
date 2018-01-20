package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        Groups groups = app.db().groups();
        File photo = new File("src/test/resources/avatar.png");
        app.goTo().homePage();
        if (app.db().contacts().size() == 0) {
            app.contact().create(new ContactDate().withFirstName("testFirstName1").withHomePhone("11111").withMobilePhone("22222").withWorkPhone("333333")
                    .inGroup(groups.iterator().next()).withPhoto(photo), true);
        }
    }

    @Test
    public void testContactPhones(){
        app.goTo().homePage();
        ContactDate contact = app.contact().all().iterator().next();
        ContactDate contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    }

    private String mergePhones(ContactDate contact) {
        return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
                .stream().filter((s) -> ! s.equals(""))
                .map(ContactPhoneTests::cleaned)
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned(String phone){
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }
}
