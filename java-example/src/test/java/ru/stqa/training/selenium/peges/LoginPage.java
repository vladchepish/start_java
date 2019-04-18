package ru.stqa.training.selenium.peges;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private static final By LOGIN_INPUT = By.cssSelector("input[name='username']");
    private static final By PASSWORD_INPUT = By.cssSelector("input[name='password']");
    private static final By LOGIN_BTN = By.cssSelector("button[name='login']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String login, String passwword){
        findAndFeelField(LOGIN_INPUT, login);
        findAndFeelField(PASSWORD_INPUT, passwword);
        clickByElement(LOGIN_BTN);

    }

}
