package ru.stqa.training.selenium.peges;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AdminCountriesPage extends BasePage {

    private static AdminEditCountryPage editCountryPage;

    private static final By COUNTRIES_FORM = By.cssSelector("form[name='countries_form']");
    private static final By LINE_IN_COUNTRY_TABLE = By.xpath("//table[@class='dataTable']//tr[@class='row']");

    public AdminCountriesPage(WebDriver driver) {
        super(driver);
        shortWait.until(ExpectedConditions.visibilityOfElementLocated(COUNTRIES_FORM));
    }

    public LinkedList<String> getCountriesList() {
        List<WebElement> countriesList = getElements(LINE_IN_COUNTRY_TABLE);
        LinkedList<String> countriesNameList = new LinkedList<>();
        for (WebElement country : countriesList){
            String countryName = country.findElement(By.xpath(".//td[5]")).getText();
            countriesNameList.add(countryName);
        }
        return countriesNameList;
    }

    public void compareCountryLists(List<String> countrysNameList, List<String> sortedCountysNameList) {
        assertTrue("Количество элементов списков должно совпадать",
                countrysNameList.size() == sortedCountysNameList.size());
        assertEquals("Элементы списков не соответствуют",
                countrysNameList, sortedCountysNameList);
    }

    public LinkedList<String> getNotEmptyCountries() {
        List<WebElement> countriesList = getElements(LINE_IN_COUNTRY_TABLE);
        LinkedList<String> countriesNameList = new LinkedList<>();
        for (WebElement country : countriesList){
            //int numberGeoZones = country.findElement(By.xpath(".//td[6]")).getText();
            if (!country.findElement(By.xpath(".//td[6]")).getText().equals("0")){
                countriesNameList.add(country.findElement(By.xpath(".//td[5]")).getText());
            }
        }
        return countriesNameList;
    }

    public void goInsideCountryAndCheckGeoZOneOrder(LinkedList<String> list) {
        assertTrue("Количество стран должно быть больше нуля",
                list.size() > 0);
        for (String country : list){
            editCountryPage = openEditCountryPageByName(country);
            LinkedList<String> geoZones = editCountryPage.getGeoZonesNames();
            LinkedList<String> sortedGeoZones = sortListByAlphabet(geoZones);
            assertEquals("Списки должны совпадать",
                    geoZones,
                    sortedGeoZones);
            driver.navigate().back();
        }
    }

    public AdminEditCountryPage openEditCountryPageByName(String name){
        getElement(By.xpath("//td//a[text()='" + name + "']")).click();
        return new AdminEditCountryPage(driver);
    }
}
