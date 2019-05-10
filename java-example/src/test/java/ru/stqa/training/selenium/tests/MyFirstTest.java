package ru.stqa.training.selenium.tests;

import org.junit.Test;
import org.openqa.selenium.By;

public class MyFirstTest extends TestBase{

    @Test
    public void myFirstTest(){
        //driver.get("https://www.google.com/");
        driver.get("https://www.seleniumhq.org");
        System.out.println(driver.manage().logs().getAvailableLogTypes());
        driver.manage().logs().get("browser").forEach(l -> System.out.println(l));

        //driver.findElement(By.cssSelector("input.gLFyf.gsfi")).sendKeys("webdriver");
        //driver.findElement(By.cssSelector("div.FPdoLc input[value='Поиск в Google']")).click();
    }

}
