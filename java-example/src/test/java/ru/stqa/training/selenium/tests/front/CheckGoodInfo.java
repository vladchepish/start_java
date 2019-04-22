package ru.stqa.training.selenium.tests.front;

import org.junit.Before;
import org.junit.Test;
import ru.stqa.training.selenium.Objects.Good;
import ru.stqa.training.selenium.peges.MainWebSitePage;
import ru.stqa.training.selenium.peges.Navigation;
import ru.stqa.training.selenium.peges.WebSiteProductPage;
import ru.stqa.training.selenium.tests.TestBase;

import static org.junit.Assert.assertEquals;

public class CheckGoodInfo extends TestBase {

    private static Navigation navigation;
    private static MainWebSitePage mainWebSitePage;
    private static WebSiteProductPage productPage;

    @Before
    public void openPageMethod(){
        navigation = new Navigation(driver);
        mainWebSitePage = navigation.goToWebSiteMainPage();
    }

    @Test
    public void checkGoodInfo(){
        Good goodOnMainPage = mainWebSitePage.getGoodInfoFromComparingBox().get(0);
        productPage = mainWebSitePage.openFirstGoodFullPage();
        Good goodFromFullPage = productPage.getGood();
        productPage.checkAttribytes();
        assertEquals("Информация о товарах должна совпадать",
                goodOnMainPage,
                goodFromFullPage);


    }

}
