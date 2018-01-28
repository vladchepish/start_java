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
        type(By.name("email"), contactDate.getEmail1());
        type(By.name("email2"), contactDate.getEmail2());
        type(By.name("email3"), contactDate.getEmail3());
        type(By.name("home"), contactDate.getHomePhone());
        type(By.name("mobile"), contactDate.getMobilePhone());
        type(By.name("work"), contactDate.getWorkPhone());
        attach(By.name("photo"), contactDate.getPhoto());


        if (creation) {
            if(contactDate.getGroups().size() > 0){
                Assert.assertTrue(contactDate.getGroups().size() == 1);
                new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactDate.getGroups().iterator().next().getName());
            }
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

    public void selectAddedContactById(int id){
        wd.findElement(By.cssSelector("input[id='" + id + "']")).click();
    }

    public void addingInGroupById(int id){
        click(By.cssSelector("select[name='to_group']"));
        click(By.cssSelector(".right>select>option[value='" + id + "']"));
        click(By.name("add"));
    }

    public void create(ContactDate contact, boolean boolDate) {
        initCintactCreation();
        fillingContactForm(contact, boolDate);
        submitContact();
        contactCache = null;
        returnHomePage();
    }

    public void modify(ContactDate contact) {
        openContactModificationTestById(contact.getId());
        fillingContactForm(contact, false);
        submitCintactModification();
        contactCache = null;
        returnHomePage();
    }

    public void deletion(ContactDate contact) {
        selectContactById(contact.getId());
        deleteSelectedContact();
        contactCache = null;
        closeAlert();
    }

    public boolean isContactExisting() {
        return isElementPresent(By.name("selected[]"));
    }

    public int count() {
        return  wd.findElements(By.name("selected[]")).size();
    }

    private Contacts contactCache = null;

    public Contacts all() {
        if (contactCache != null){
            return new Contacts(contactCache);
        }

        contactCache = new Contacts();
        List<WebElement> elements = wd.findElements(By.xpath("//table[@id='maintable']//tr[@name='entry']"));
        for (WebElement element : elements){
            String userLastname = element.findElement(By.xpath(".//td[2]")).getText();
            String userName = element.findElement(By.xpath(".//td[3]")).getText();
            String allPhones = element.findElement(By.xpath(".//td[6]")).getText();
            String allEmails = element.findElement(By.xpath(".//td[5]")).getText();
            String address = element.findElement(By.xpath(".//td[4]")).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            contactCache.add(new ContactDate().withId(id).withFirstName(userName).withLastName(userLastname).withAllPhones(allPhones).withAllEmails(allEmails).withAddress(address));
        }
        return new Contacts(contactCache);
    }


    public ContactDate infoFromEditForm(ContactDate contact) {
        openContactModificationTestById(contact.getId());
        String userName = wd.findElement(By.name("firstname")).getAttribute("value");
        String userLastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String email1 = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");

        wd.navigate().back();
        return new ContactDate().withId(contact.getId()).withFirstName(userName).withLastName(userLastname)
                .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work)
                .withEmail1(email1).withEmail2(email2).withEmail3(email3).withAddress(address);
    }
}
