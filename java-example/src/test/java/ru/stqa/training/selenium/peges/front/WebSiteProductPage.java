package ru.stqa.training.selenium.peges.front;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.stqa.training.selenium.objects.Good;
import ru.stqa.training.selenium.peges.BasePage;

import static org.junit.Assert.assertTrue;

public class WebSiteProductPage extends BasePage {

    private static final By BOX_PRODUCT = By.cssSelector("div#box-product");
    private static final By PRODUCT_NAME = By.cssSelector("h1.title");
    private static final By REGULAR_PRICE = By.cssSelector("s.regular-price");
    private static final By COMPARING_PRICE = By.cssSelector("strong.campaign-price");

    public WebSiteProductPage(WebDriver driver) {
        super(driver);
        shortWait.until(ExpectedConditions.visibilityOfElementLocated(BOX_PRODUCT));
    }


    public Good getGood() {
        return new Good()
                .setName(getElement(PRODUCT_NAME).getText())
                .setRegularPrice(getElement(REGULAR_PRICE).getText())
                .setComparingPrice(getElement(COMPARING_PRICE).getText());
    }

    public void checkAttribytes() {
        assertTrue("Цвет обычной цены должен быть серым",
                getElement(REGULAR_PRICE).getCssValue("color").contains("102, 102, 102"));
        assertTrue("Значение обычной цены должно быть перечёркнутым",
                getElement(REGULAR_PRICE).getCssValue("text-decoration").contains("line-through"));
        assertTrue("Цвет акционной цены должен быть красным",
                getElement(COMPARING_PRICE).getCssValue("color").contains("204, 0, 0"));
        assertTrue("Значение акционной цены должно быть жирным",
                getElement(COMPARING_PRICE).getCssValue("font-weight").contains("700"));
        assertTrue("Акционная цена должна быть большего размера, нежели обычная",
                Float.parseFloat(getElement(REGULAR_PRICE).getCssValue("font-size").replaceAll("px", ""))
                        < Float.parseFloat(getElement(COMPARING_PRICE).getCssValue("font-size").replaceAll("px", "")));
    }
}
