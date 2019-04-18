package ru.stqa.training.selenium.peges;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void findAndFeelField(By by, String text){
        clickByElement(by);
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }

    protected void clickByElement(By by){
        driver.findElement(by).click();
    }
}
