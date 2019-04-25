package ru.stqa.training.selenium.tests.front;

import org.junit.Before;
import org.junit.Test;
import ru.stqa.training.selenium.objects.User;
import ru.stqa.training.selenium.peges.front.WebSiteMainPage;
import ru.stqa.training.selenium.peges.Navigation;
import ru.stqa.training.selenium.peges.front.WebSiteHomePage;
import ru.stqa.training.selenium.peges.front.WebSiteRegistrationPage;
import ru.stqa.training.selenium.tests.TestBase;

import static ru.stqa.training.selenium.Utils.DataGenerator.*;

public class RegistrationTest extends TestBase {

    private static Navigation navigation;
    private static WebSiteMainPage mainWebSitePage;
    private static WebSiteRegistrationPage registrationPage;
    private static WebSiteHomePage homePage;

    @Before
    public void openPageMethod(){
        navigation = new Navigation(driver);
        mainWebSitePage = navigation.goToWebSiteMainPage();
    }

    @Test
    public void registrationTest(){
        User newUser = new User()
                .setTaxID(geniratorNumeric(5))
                .setCompany(generateString(5))
                .setFirstName(generateString(6))
                .setLastName(generateString(6))
                .setFrstAddress(generateString(5))
                .setScndAddress(generateString(5))
                .setPostocode(geniratorNumeric(5))
                .setCity(generateString(5))
                .setCountry("United States")
                .setEmail(generateEmail())
                .setPhone("+1" + geniratorNumeric(9))
                .setPassword(generatePassword(8));
        registrationPage = mainWebSitePage.openRegistrationPage();
        homePage = registrationPage.registrateNewUser(newUser);
        homePage.logout();
        mainWebSitePage.login(newUser);
    }

}
