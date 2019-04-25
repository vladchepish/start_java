package ru.stqa.training.selenium.tests.admin;

import org.junit.Before;
import org.junit.Test;
import ru.stqa.training.selenium.peges.admin.AdminLoginPage;
import ru.stqa.training.selenium.peges.admin.AdminMainPage;
import ru.stqa.training.selenium.peges.Navigation;
import ru.stqa.training.selenium.tests.TestBase;


public class LoginIntoAdminPanelTest extends TestBase {

    private static AdminLoginPage loginPage;
    private static Navigation navigation;
    private static AdminMainPage mainPage;

    @Before
    public void openPageMethod(){
        loginPage = new AdminLoginPage(driver);
        navigation = new Navigation(driver);
        navigation.goToAdminAuatorizationPage();
    }

    @Test
    public void loginIntoAdminPanelTest(){
        mainPage = loginPage.login("admin", "admin");
    }





}
