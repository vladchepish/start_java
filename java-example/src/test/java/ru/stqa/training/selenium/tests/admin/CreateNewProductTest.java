package ru.stqa.training.selenium.tests.admin;

import org.junit.Before;
import org.junit.Test;
import ru.stqa.training.selenium.objects.Good;
import ru.stqa.training.selenium.peges.*;
import ru.stqa.training.selenium.peges.admin.AdminAddNewProductPage;
import ru.stqa.training.selenium.peges.admin.AdminCatalogPage;
import ru.stqa.training.selenium.peges.admin.AdminLoginPage;
import ru.stqa.training.selenium.peges.admin.AdminMainPage;
import ru.stqa.training.selenium.tests.TestBase;

import java.io.File;

import static org.junit.Assert.assertTrue;
import static ru.stqa.training.selenium.Utils.DataGenerator.*;

public class CreateNewProductTest extends TestBase {

    private static AdminLoginPage loginPage;
    private static Navigation navigation;
    private static AdminMainPage mainPage;
    private static AdminCatalogPage catalogPage;
    private static AdminAddNewProductPage addNewProduct;

    @Before
    public void openPageMethod(){
        loginPage = new AdminLoginPage(driver);
        navigation = new Navigation(driver);
        navigation.goToAdminAuatorizationPage();
        mainPage = loginPage.login("admin", "admin");
    }

    @Test
    public void createNewProductTest(){
        File photo = new File("src/test/resources/pic.jpg");
        Good product = new Good().setName(generateString(6)).setCode(geniratorNumeric(4)).setPhoto(photo)
                .setDescription(generateString(50)).setRegularPrice(geniratorNumeric(2));
        catalogPage = mainPage.goToCatalogPage();
        int numberProductsBefore = catalogPage.getProductsNumber();
        addNewProduct = catalogPage.clickAddNewProductBtn();
        addNewProduct.createNewProduct(product);
        int numberProductsAfter = catalogPage.getProductsNumber();
        assertTrue("После создания товара количество изменилось неверно",
                numberProductsAfter == (numberProductsBefore + 1));
    }
}
