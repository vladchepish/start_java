package ru.stqa.training.selenium.tests.admin;

import org.junit.Before;
import org.junit.Test;
import ru.stqa.training.selenium.peges.admin.AdminLoginPage;
import ru.stqa.training.selenium.peges.admin.AdminMainPage;
import ru.stqa.training.selenium.peges.Navigation;
import ru.stqa.training.selenium.tests.TestBase;

public class LeftMenuTest extends TestBase {

    private static AdminLoginPage loginPage;
    private static Navigation navigation;
    private static AdminMainPage mainPage;
    
    @Before
    public void openPageMethod(){
        loginPage = new AdminLoginPage(driver);
        navigation = new Navigation(driver);
        navigation.goToAdminAuatorizationPage();
        mainPage = loginPage.login("admin", "admin");
    }

    @Test
    public void leftMenuTest(){
        mainPage.clickEachItemAndSubItemLeftMenu();
    }
}
