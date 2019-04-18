package ru.stqa.training.selenium.tests;

import org.junit.Before;
import org.junit.Test;
import ru.stqa.training.selenium.peges.LoginPage;
import ru.stqa.training.selenium.peges.MainAdminPage;
import ru.stqa.training.selenium.peges.Navigation;


public class LoginIntoAdminPanelTest extends TestBase {

    private static LoginPage loginPage;
    private static Navigation navigation;
    private static MainAdminPage mainPage;

    @Before
    public void openPageMethod(){
        loginPage = new LoginPage(driver);
        navigation = new Navigation(driver);
        navigation.goToAdminAuatorizationPage();
    }

    @Test
    public void loginIntoAdminPanelTest(){
        mainPage = loginPage.login("admin", "admin");
    }





}
