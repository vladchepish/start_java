package ru.stqa.training.selenium.peges;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.LinkedList;
import java.util.List;

public class AdminEditCountryPage extends BasePage{

    public static final By MAIN_FORM = By.xpath("//form[contains(@enctype, 'multipart')]");
    public static final By ZONES_TABLE = By.cssSelector("table#table-zones");
    public static final By GEO_ZONE_NAME_IN_TABLE = By.cssSelector("tr:not(.header) td:nth-child(3)");

    public AdminEditCountryPage(WebDriver driver) {
        super(driver);
        shortWait.until(ExpectedConditions.visibilityOfElementLocated(MAIN_FORM));
    }

    public LinkedList<String> getGeoZonesNames(){
        List<WebElement> linesList = getElement(ZONES_TABLE).findElements(GEO_ZONE_NAME_IN_TABLE);
        LinkedList<String> geoZones = new LinkedList<>();
        for (WebElement line : linesList){
            String value = line.findElement(By.cssSelector("input")).getAttribute("value");
            if (!value.equals("")){
                geoZones.add(value);
            }
        }
        return geoZones;
    }


}
