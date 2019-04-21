package ru.stqa.training.selenium.tests.admin;

import org.junit.Before;
import org.junit.Test;
import ru.stqa.training.selenium.peges.AdminCountriesPage;
import ru.stqa.training.selenium.peges.LoginPage;
import ru.stqa.training.selenium.peges.MainAdminPage;
import ru.stqa.training.selenium.peges.Navigation;
import ru.stqa.training.selenium.tests.TestBase;

import java.util.LinkedList;

public class AdminSortingCountriesTest extends TestBase {

    private static LoginPage loginPage;
    private static Navigation navigation;
    private static MainAdminPage mainPage;
    private static AdminCountriesPage adminCountriesPage;

    @Before
    public void beforeMEthod(){
        loginPage = new LoginPage(driver);
        navigation = new Navigation(driver);
        navigation.goToAdminAuatorizationPage();
        mainPage = loginPage.login("admin", "admin");
        adminCountriesPage = mainPage.goToCountriesPage();
    }

    @Test
    public void sortingCountriesTest(){
        LinkedList<String> countrysNameList = adminCountriesPage.getCountriesList();
        LinkedList<String> sortedCountysNameList = adminCountriesPage.sortListByAlphabet(countrysNameList);
        adminCountriesPage.compareCountryLists(countrysNameList, sortedCountysNameList);
    }
}
