package ru.stqa.training.selenium.tests.admin;

import org.junit.Before;
import org.junit.Test;
import ru.stqa.training.selenium.peges.Navigation;
import ru.stqa.training.selenium.peges.admin.*;
import ru.stqa.training.selenium.tests.TestBase;

public class OpeningLinksInNewWindowTest extends TestBase {

    private static AdminLoginPage loginPage;
    private static Navigation navigation;
    private static AdminMainPage mainPage;
    private static AdminCountriesPage countriesPage;
    private static AdminEditCountryPage editCountryPage;

    @Before
    public void beforeMEthod() {
        loginPage = new AdminLoginPage(driver);
        navigation = new Navigation(driver);
        navigation.goToAdminAuatorizationPage();
        mainPage = loginPage.login("admin", "admin");
    }

    @Test
    public void openingLinksInNewWindowTest(){
        countriesPage = mainPage.goToCountriesPage();
        editCountryPage = countriesPage.openFirstCountry();
        editCountryPage.openAllLinksInNewTab();
    }

}
