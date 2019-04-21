package ru.stqa.training.selenium.tests;

import org.junit.Before;
import org.junit.Test;
import ru.stqa.training.selenium.peges.MainWebSitePage;
import ru.stqa.training.selenium.peges.Navigation;

public class CheckStickersOnGoodsTest extends TestBase {

    private static Navigation navigation;
    private static MainWebSitePage mainWebSitePage;

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
