package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertTrue;

public class LoginIntoAdminPanelTest extends TestBase {

    @Test
    public void loginIntoAdminPanelTest(){
        goToAdminAuatorizationPage();
        login("admin", "admin");
        assertTrue(driver.findElement(By.cssSelector("td[id='sidebar']")).isDisplayed());
    }


    private void goToAdminAuatorizationPage() {
        driver.get("http://localhost/litecart/admin/");
    }

    private void login(String login, String passwword){
        findAndFeelField(By.cssSelector("input[name='username']"), login);
        findAndFeelField(By.cssSelector("input[name='password']"), passwword);
        clickByElement(By.cssSelector("button[name='login']"));

    }

    private void findAndFeelField(By by, String text){
        clickByElement(by);
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }

    private void clickByElement(By by){
        driver.findElement(by).click();
    }

}
