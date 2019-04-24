package ru.stqa.training.selenium.peges;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WebSiteHomePage extends BasePage {

    private static final By LOGOUT_LINK = By.cssSelector("div#box-account a[href*='logout']");

    public WebSiteHomePage(WebDriver driver) {
        super(driver);
        shortWait.until(ExpectedConditions.visibilityOfElementLocated(LOGOUT_LINK));
    }

    public void logout(){
        clickByElement(LOGOUT_LINK);
    }
}
