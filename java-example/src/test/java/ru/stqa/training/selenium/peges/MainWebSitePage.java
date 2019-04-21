package ru.stqa.training.selenium.peges;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class MainWebSitePage extends BasePage{

    private static final By GOODS_ITEM = By.cssSelector("ul.products li");
    private static final By STICKER = By.cssSelector("div.sticker");
    private static final By CART = By.cssSelector("div#cart");

    public MainWebSitePage(WebDriver driver) {
        super(driver);
        shortWait.until(ExpectedConditions.visibilityOfElementLocated(CART));
    }


    public void checkStickersOnGoods() {
        List<WebElement> goodsList = getElements(GOODS_ITEM);
        assertTrue("Количество товаров на главной странице сайта должно быть больше нуля",
                goodsList.size() > 0);
        for(WebElement goodItem : goodsList){
            List<WebElement> stickersList = goodItem.findElements(STICKER);
            assertTrue("Каждый товар должен иметь по одному стикеру",
                    stickersList.size() == 1);
        }
    }
}
