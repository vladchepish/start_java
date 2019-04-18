package ru.stqa.training.selenium.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stqa.training.selenium.peges.BasePage;

import java.io.*;

public class TestBase {

    protected WebDriver driver;
    protected WebDriverWait wait;
    public static String baseUrl;

    @Before
    public void start() throws IOException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver = new InternetExplorerDriver();
        //driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
        BasePage basePage = new BasePage(driver);
    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}
