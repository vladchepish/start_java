package ru.stqa.training.selenium.tests.admin;

import org.junit.Before;
import org.junit.Test;
import ru.stqa.training.selenium.peges.*;
import ru.stqa.training.selenium.tests.TestBase;

import java.util.LinkedList;

public class AdminSortingCountriesTest extends TestBase {

    private static LoginPage loginPage;
    private static Navigation navigation;
    private static MainAdminPage mainPage;
    private static AdminCountriesPage adminCountriesPage;
    private static AdminGeoZonesPage adminGeoZonesPage;

    @Before
    public void beforeMEthod(){
        loginPage = new LoginPage(driver);
        navigation = new Navigation(driver);
        navigation.goToAdminAuatorizationPage();
        mainPage = loginPage.login("admin", "admin");

    }

    @Test
    public void sortingCountriesTest(){
        adminCountriesPage = mainPage.goToCountriesPage();
        LinkedList<String> countrysNameList = adminCountriesPage.getCountriesList();
        LinkedList<String> sortedCountysNameList = adminCountriesPage.sortListByAlphabet(countrysNameList);
        adminCountriesPage.compareCountryLists(countrysNameList, sortedCountysNameList);
    }

    @Test
    public void sortingLocationInGeoZone(){
        adminGeoZonesPage = mainPage.goToGeoZonePage();
        int countCountries = adminGeoZonesPage.countCountries();
        adminGeoZonesPage.checkInfoOrderInside(countCountries);

    }
}
