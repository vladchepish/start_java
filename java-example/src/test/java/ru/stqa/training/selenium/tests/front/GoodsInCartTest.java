package ru.stqa.training.selenium.tests.front;

import org.junit.Before;
import org.junit.Test;
import ru.stqa.training.selenium.peges.Navigation;
import ru.stqa.training.selenium.peges.front.WebSiteMainPage;
import ru.stqa.training.selenium.peges.front.WebSitreCartPage;
import ru.stqa.training.selenium.tests.TestBase;

public class GoodsInCartTest extends TestBase {

    private static Navigation navigation;
    private static WebSiteMainPage mainPage;
    private static WebSitreCartPage cartPage;

    @Before
    public void beforeMethod(){
        navigation = new Navigation(driver);
        mainPage = navigation.goToWebSiteMainPage();
    }

    @Test
    public void goodsInCartTest(){
        mainPage.addGoodsToCart(3);
        cartPage = mainPage.openCart();
        cartPage.deleteAllProductsFromCart();
    }
}
