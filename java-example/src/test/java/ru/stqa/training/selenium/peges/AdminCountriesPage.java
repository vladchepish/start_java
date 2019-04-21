package ru.stqa.training.selenium.peges;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AdminCountriesPage extends BasePage {

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

    public LinkedList<String> sortListByAlphabet(List<String> countrysNameList) {
        LinkedList<String> sortedList = new LinkedList<>();
        for (String item : countrysNameList){
            sortedList.add(item);
        }
        sortedList.sort(Comparator.naturalOrder());
        return sortedList;
    }

    public void compareCountryLists(List<String> countrysNameList, List<String> sortedCountysNameList) {
        assertTrue("Количество элементов списков должно совпадать",
                countrysNameList.size() == sortedCountysNameList.size());
        assertEquals("Элементы списков не соответствуют",
                countrysNameList, sortedCountysNameList);
    }

}
