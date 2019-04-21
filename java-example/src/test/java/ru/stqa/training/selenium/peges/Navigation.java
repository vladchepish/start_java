package ru.stqa.training.selenium.peges;

import org.openqa.selenium.WebDriver;


public class Navigation extends BasePage {

    public Navigation(WebDriver driver) {
        super(driver);
    }

    public void goToAdminAuatorizationPage() {
        driver.get("http://localhost/litecart/admin/");
    }

    public MainWebSitePage goToWebSiteMainPage(){
        driver.get("http://localhost/litecart/");
        return new MainWebSitePage(driver);
    }
}
