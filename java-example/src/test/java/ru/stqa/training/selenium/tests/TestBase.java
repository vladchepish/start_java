package ru.stqa.training.selenium.tests;

import com.google.common.io.Files;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stqa.training.selenium.peges.BasePage;

import java.io.*;

public class TestBase {

    protected EventFiringWebDriver driver;
    protected WebDriverWait wait;
    public static String baseUrl;

    public static class MyListener extends AbstractWebDriverEventListener{
        @Override
        public void beforeFindBy(By by, WebElement element, WebDriver driver) {
            System.out.println(by);
        }

        @Override
        public void afterFindBy(By by, WebElement element, WebDriver driver) {
            System.out.println(by + " found");
        }

        @Override
        public void onException(Throwable throwable, WebDriver driver) {
            System.out.println(throwable);
            File tempFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File screen = new File("screen.png");
            try {
                Files.copy(tempFile, screen);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(screen);
        }
    }

    @Before
    public void start() throws IOException {
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.register(new MyListener());
        //driver = new InternetExplorerDriver();
        //driver = new FirefoxDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
        BasePage basePage = new BasePage(driver);
    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}
