package ru.stqa.training.selenium.peges;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.stqa.training.selenium.Objects.Good;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class MainWebSitePage extends BasePage{

    private static final By GOODS_ITEM = By.cssSelector("ul.products li");
    private static final By STICKER = By.cssSelector("div.sticker");
    private static final By CART = By.cssSelector("div#cart");
    private static final By COMPARING_SECTION = By.cssSelector("div#box-campaigns");
    private static final By GOOD_ITEM = By.cssSelector("li.product");
    private static final By GOOD_NAMNE = By.cssSelector("div.name");
    private static final By REGULAR_PRICE = By.cssSelector("s.regular-price");
    private static final By COMPARING_PRICE = By.cssSelector("strong.campaign-price");


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

    public LinkedList<Good> getGoodInfoFromComparingBox() {
        LinkedList<Good> goodsList = new LinkedList<>();
        WebElement comparingBox = getElement(COMPARING_SECTION);
        List<WebElement> goodsElementLIst = comparingBox.findElements(GOOD_ITEM);
        assertTrue("Количество товаров в блоке должно быть больше нуля",
                goodsElementLIst.size() > 0);
        for (WebElement goodInComparingBox : goodsElementLIst){
            WebElement goodName = goodInComparingBox.findElement(GOOD_NAMNE);
            WebElement goodRegularPrice = goodInComparingBox.findElement(REGULAR_PRICE);
            WebElement goodComparingPrice = goodInComparingBox.findElement(COMPARING_PRICE);
            assertTrue("Название товара должно отображаться",
                    goodName.isDisplayed());
            assertTrue("Старая цена товара должно отображаеться",
                    goodRegularPrice.isDisplayed());
            assertTrue("Акционная цена товара должно отображаеться",
                    goodComparingPrice.isDisplayed());
            goodsList.add(new Good()
                    .setName(goodName.getText())
                    .setRegularPrice(goodRegularPrice.getText())
                    .setComparingPrice(goodComparingPrice.getText()));
            checkAttribytes(goodRegularPrice, goodComparingPrice);
        }
        return goodsList;
    }

    private void checkAttribytes(WebElement regPrice, WebElement compPrice) {
        assertTrue("Цвет обычной цены должен быть серым",
                regPrice.getCssValue("color").contains("119, 119, 119"));
        assertTrue("Значение обычной цены должно быть перечёркнутым",
                regPrice.getCssValue("text-decoration").contains("line-through"));
        assertTrue("Цвет акционной цены должен быть красным",
                compPrice.getCssValue("color").contains("204, 0, 0"));
        assertTrue("Значение акционной цены должно быть жирным. Actual: " + compPrice.getCssValue("font-weight"),
                compPrice.getCssValue("font-weight").contains("700") ||
                        compPrice.getCssValue("font-weight").contains("900"));
        assertTrue("Акционная цена должна быть большего размера, нежели обычная",
                Float.parseFloat(regPrice.getCssValue("font-size").replaceAll("px", ""))
                        < Float.parseFloat(compPrice.getCssValue("font-size").replaceAll("px", "")));
    }

    public WebSiteProductPage openFirstGoodFullPage() {
        WebElement comparingBox = getElement(COMPARING_SECTION);
        WebElement goodsElementLIst = comparingBox.findElements(GOOD_ITEM).get(0);
        goodsElementLIst.findElement(By.cssSelector("a")).click();
        return new WebSiteProductPage(driver);
    }
}
