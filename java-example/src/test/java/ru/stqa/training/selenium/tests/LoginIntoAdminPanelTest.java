package ru.stqa.training.selenium.tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import ru.stqa.training.selenium.peges.LoginPage;
import ru.stqa.training.selenium.peges.Navigation;

import static org.junit.Assert.assertTrue;

public class LoginIntoAdminPanelTest extends TestBase {

    private static LoginPage loginPage;
    private static Navigation navigation;

    @Before
    public void openPageMethod(){
        loginPage = new LoginPage(driver);
        navigation = new Navigation(driver);
        navigation.goToAdminAuatorizationPage();
    }
    
    @Test
    public void loginIntoAdminPanelTest(){
        loginPage.login("admin", "admin");
        assertTrue(driver.findElement(By.cssSelector("td[id='sidebar']")).isDisplayed());
    }





}
