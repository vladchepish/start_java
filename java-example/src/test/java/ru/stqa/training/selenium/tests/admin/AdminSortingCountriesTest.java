package ru.stqa.training.selenium.tests.admin;

import org.junit.Before;
import org.junit.Test;
import ru.stqa.training.selenium.peges.*;
import ru.stqa.training.selenium.peges.admin.AdminCountriesPage;
import ru.stqa.training.selenium.peges.admin.AdminGeoZonesPage;
import ru.stqa.training.selenium.peges.admin.AdminLoginPage;
import ru.stqa.training.selenium.peges.admin.AdminMainPage;
import ru.stqa.training.selenium.tests.TestBase;

import java.util.LinkedList;

public class AdminSortingCountriesTest extends TestBase {

    private static AdminLoginPage loginPage;
    private static Navigation navigation;
    private static AdminMainPage mainPage;
    private static AdminCountriesPage adminCountriesPage;
    private static AdminGeoZonesPage adminGeoZonesPage;

    @Before
    public void beforeMEthod() {
        loginPage = new AdminLoginPage(driver);
        navigation = new Navigation(driver);
        navigation.goToAdminAuatorizationPage();
        mainPage = loginPage.login("admin", "admin");

    }

    @Test
    public void sortingCountriesTest() {
        adminCountriesPage = mainPage.goToCountriesPage();
        LinkedList<String> countrysNameList = adminCountriesPage.getCountriesList();
        LinkedList<String> sortedCountysNameList = adminCountriesPage.sortListByAlphabet(countrysNameList);
        adminCountriesPage.compareCountryLists(countrysNameList, sortedCountysNameList);
    }

    @Test
    public void sortingLocationInGeoZone() {
        adminGeoZonesPage = mainPage.goToGeoZonePage();
        int countCountries = adminGeoZonesPage.countCountries();
        adminGeoZonesPage.checkInfoOrderInside(countCountries);
    }

    @Test
    public void sortingIntoCountriesTest(){
        adminCountriesPage = mainPage.goToCountriesPage();
        LinkedList<String> notEmptyCountries = adminCountriesPage.getNotEmptyCountries();
        System.out.println(notEmptyCountries.size());
        adminCountriesPage.goInsideCountryAndCheckGeoZOneOrder(notEmptyCountries);

    }
}