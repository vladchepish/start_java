package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestBase {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @Before
    public void start() {
        //driver = new ChromeDriver();
        //driver = new InternetExplorerDriver();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);

    }


    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}
