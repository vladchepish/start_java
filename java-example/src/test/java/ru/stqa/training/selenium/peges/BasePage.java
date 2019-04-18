package ru.stqa.training.selenium.peges;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stqa.training.selenium.lib.TimeOut;

import java.util.ArrayList;
import java.util.List;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait loadingWait;
    protected WebDriverWait shortWait;
    protected WebDriverWait actionWait;
    protected WebDriverWait betWait;
    protected WebDriverWait defaultWait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.shortWait = new WebDriverWait(driver, TimeOut.shortTimeout);
        this.defaultWait = new WebDriverWait(driver, TimeOut.defaultTimeout);
        this.actionWait = new WebDriverWait(driver, TimeOut.action);
        this.loadingWait = new WebDriverWait(driver, TimeOut.loading);
        this.betWait = new WebDriverWait(driver, TimeOut.betTimeout);
    }

    protected WebElement getElement(By by){
        return driver.findElement(by);
    }

    public List<WebElement> getElements(By by){
        try {
            return driver.findElements(by);
        } catch (InvalidSelectorException e) {
            return new ArrayList<WebElement>(); //empty list
        }
    }

    public void sleep(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e){
            //
        }
    }

    protected void findAndFeelField(By by, String text){
        clickByElement(by);
        getElement(by).clear();
        getElement(by).sendKeys(text);
    }

    protected void clickByElement(By by){
        getElement(by).click();
    }
}
