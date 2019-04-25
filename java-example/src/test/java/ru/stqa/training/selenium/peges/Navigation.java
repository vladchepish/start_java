package ru.stqa.training.selenium.peges;

import org.openqa.selenium.WebDriver;
import ru.stqa.training.selenium.peges.front.WebSiteMainPage;


public class Navigation extends BasePage {

    public Navigation(WebDriver driver) {
        super(driver);
    }

    public void goToAdminAuatorizationPage() {
        driver.get("http://localhost/litecart/admin/");
    }

    public WebSiteMainPage goToWebSiteMainPage(){
        driver.get("http://localhost/litecart/");
        return new WebSiteMainPage(driver);
    }
}
