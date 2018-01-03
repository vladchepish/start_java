package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.Contacts;

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

    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "' ")).click();
    }

    public void deleteSelectedContact() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void closeAlert() {
        wd.switchTo().alert().accept();
    }

    public void openContactModificationTestById(int id) {
        wd.findElement(By.xpath("//a[@href='edit.php?id="+ id +"']/img[@title='Edit']")).click();
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

    public void modify(ContactDate contact) {
        openContactModificationTestById(contact.getId());
        fillingContactForm(contact, false);
        submitCintactModification();
        returnHomePage();
    }

    public void deletion(ContactDate contact) {
        selectContactById(contact.getId());
        deleteSelectedContact();
        closeAlert();
    }


    public boolean isContactExisting() {
        return isElementPresent(By.name("selected[]"));
    }

    public int count() {
        return  wd.findElements(By.name("selected[]")).size();
    }

    public Contacts all() {
        Contacts contacts = new Contacts();
        List<WebElement> elements = wd.findElements(By.xpath("//table[@id='maintable']//tr[@name='entry']"));
        for (WebElement element : elements){
            String userLastname = element.findElement(By.xpath(".//td[2]")).getText();
            String userName = element.findElement(By.xpath(".//td[3]")).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            contacts.add(new ContactDate().withId(id).withFirstName(userName).withLastName(userLastname));
        }
        return contacts;
    }


    public ContactDate infoFromEditForm(ContactDate contact) {
        openContactModificationTestById(contact.getId());
        String userName = wd.findElement(By.name("firstname")).getAttribute("value");
        String userLastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        wd.navigate().back();
        return new ContactDate().withId(contact.getId()).withFirstName(userName).withLastName(userLastname)
                .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work);
    }
}
