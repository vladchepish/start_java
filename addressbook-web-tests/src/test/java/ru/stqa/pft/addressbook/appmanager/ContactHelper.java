package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactDate;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase{

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void returnHomePage() {
        click(By.linkText("home page"));
    }

    public void submitContact() {
        click(By.xpath("//div[@id='content']/form/input[21]"));

    }

    public void fillingContactForm(ContactDate contactDate, boolean creation) {
        type(By.name("firstname"),contactDate.getFirstName());
        type(By.name("middlename"),contactDate.getMiddleName());
        type(By.name("lastname"), contactDate.getLastName());
        type(By.name("address"),contactDate.getAddress());
        type(By.name("home"), contactDate.getPhone());
        type(By.name("email"), contactDate.geteMail());


        if (creation){
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactDate.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void initCintactCreation() {
        click(By.linkText("add new"));
    }
    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void deleteSelectedContact() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void closeAlert() {
        wd.switchTo().alert().accept();
    }

    public void openContactModificationTest(int index) {
        wd.findElements(By.xpath("//img[@title='Edit']")).get(index).click();
    }

    public void submitCintactModification() {
        click(By.name("update"));
    }

    public void create(ContactDate contact, boolean boolDate) {
        initCintactCreation();
        fillingContactForm(contact, boolDate);
        submitContact();
        returnHomePage();
    }

    public void modify(int index, ContactDate contact) {
        openContactModificationTest(index);
        fillingContactForm(contact, false);
        submitCintactModification();
        returnHomePage();
    }

    public void deletion(int index) {
        selectContact(index);
        deleteSelectedContact();
        closeAlert();

    }


    public boolean isContactExisting() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getContactCount() {
        return  wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactDate> contactList() {
        List<ContactDate> contacts = new ArrayList<ContactDate>();
        List<WebElement> elements = wd.findElements(By.xpath("//table[@id='maintable']//tr[@name='entry']"));
        for (WebElement element : elements){
            String userLastname = element.findElement(By.xpath(".//td[2]")).getText();
            String userName = element.findElement(By.xpath(".//td[3]")).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            contacts.add(new ContactDate().withId(id).withFirstName(userName).withLastName(userLastname));
        }
        return contacts;
    }
}
