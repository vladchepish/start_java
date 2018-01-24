package ru.stqa.pft.mantis.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChengingPasswordTests extends TestBase {

    WebDriver wd;

    @BeforeMethod
    public void startMailServer(){
        app.mail().start();
    }

    @Test
    public void testChangingPassword(){
        int userNumber = 5;
        app.session().enterToSystem();
        /*Позже не помешает добавить сюда проверку, что мы залогинились, например по тому же отображению имени пользователя.
        * Нежно будет написать метод, который проверяет на вебе наличие блока отображающего имя пользователя*/
        app.session().goToUsersPage();
        app.session().selectUser(userNumber);
        //app.session().resetPassword();

    }

    @AfterMethod(alwaysRun = true)
    public void stopMailServer(){
        app.mail().stop();
    }
}
