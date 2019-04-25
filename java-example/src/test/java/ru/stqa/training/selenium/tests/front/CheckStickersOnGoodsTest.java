package ru.stqa.training.selenium.tests.front;

import org.junit.Before;
import org.junit.Test;
import ru.stqa.training.selenium.peges.front.WebSiteMainPage;
import ru.stqa.training.selenium.peges.Navigation;
import ru.stqa.training.selenium.tests.TestBase;

public class CheckStickersOnGoodsTest extends TestBase {

    private static Navigation navigation;
    private static WebSiteMainPage mainWebSitePage;

    @Before
    public void openPageMethod(){
        navigation = new Navigation(driver);
        mainWebSitePage = navigation.goToWebSiteMainPage();
    }

    @Test
    public void checkStickersOnGoodsTest(){
        mainWebSitePage.checkStickersOnGoods();
    }

}
