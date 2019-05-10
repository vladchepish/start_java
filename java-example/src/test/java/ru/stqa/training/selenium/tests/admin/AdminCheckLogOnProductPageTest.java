package ru.stqa.training.selenium.tests.admin;

import org.junit.Before;
import org.junit.Test;
import ru.stqa.training.selenium.peges.Navigation;
import ru.stqa.training.selenium.peges.admin.AdminCatalogPage;
import ru.stqa.training.selenium.peges.admin.AdminLoginPage;
import ru.stqa.training.selenium.peges.admin.AdminMainPage;
import ru.stqa.training.selenium.tests.TestBase;

public class AdminCheckLogOnProductPageTest extends TestBase {

    private static AdminLoginPage loginPage;
    private static Navigation navigation;
    private static AdminMainPage mainPage;
    private static AdminCatalogPage catalogPage;

    @Before
    public void beforeMEthod() {
        loginPage = new AdminLoginPage(driver);
        navigation = new Navigation(driver);
        navigation.goToAdminAuatorizationPage();
        mainPage = loginPage.login("admin", "admin");
        catalogPage = mainPage.goToCatalogPage();
    }

    @Test
    public void checkLogsOnProductPageTest(){
        String categoryId = "1";
        catalogPage.openCategory(categoryId);
        catalogPage.openAllProductInCategoryAbdCheckLog(categoryId);
    }

}
