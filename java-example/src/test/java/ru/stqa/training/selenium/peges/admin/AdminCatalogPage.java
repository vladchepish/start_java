package ru.stqa.training.selenium.peges.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.stqa.training.selenium.peges.BasePage;

public class AdminCatalogPage extends BasePage {

    private static final By ADD_NEW_PRODUCT_BTN = By.cssSelector("a.button[href*='product']");
    private static final By ROW_IN_CATALOG_TABLE = By.cssSelector("tr.row");

    public AdminCatalogPage(WebDriver driver) {
        super(driver);
        shortWait.until(ExpectedConditions.visibilityOfElementLocated(ADD_NEW_PRODUCT_BTN));
    }

    public int getProductsNumber() {
        int numder = getElements(ROW_IN_CATALOG_TABLE).size();
        return numder;
    }

    public AdminAddNewProductPage clickAddNewProductBtn() {
        clickByElement(ADD_NEW_PRODUCT_BTN);
        return new AdminAddNewProductPage(driver);
    }
}
