package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;

public class MyFirstTest extends TestBase{

    @Test
    public void myFirstTest(){
        driver.get("https://www.google.com/");
        driver.findElement(By.cssSelector("input.gLFyf.gsfi")).sendKeys("webdriver");
        driver.findElement(By.cssSelector("div.FPdoLc input[value='Поиск в Google']")).click();
    }

}
