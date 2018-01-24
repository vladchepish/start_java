package ru.stqa.pft.mantis.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.mantis.model.Users;
import ru.stqa.pft.mantis.model.UsersDate;

public class ChengingPasswordTests extends TestBase {

    @BeforeMethod
    public void startMailServer(){
        app.mail().start();
    }

    @Test
    public void testChangingPassword(){
        Users atStart = app.db().users();
        UsersDate resetedPasswordUser = atStart.iterator().next();
        UsersDate userNumber = new UsersDate().withId(resetedPasswordUser.getId()).withEmail(resetedPasswordUser.getEmail()).withUsername(resetedPasswordUser.getUsername());
        app.session().enterToSystem();
        /*Позже не помешает добавить сюда проверку, что мы залогинились, например по тому же отображению имени пользователя.
        * Нежно будет написать метод, который проверяет на вебе наличие блока отображающего имя пользователя*/
        app.session().goToUsersPage();
        app.session().selectUser(userNumber);
        app.session().resetPassword();

    }

    @AfterMethod(alwaysRun = true)
    public void stopMailServer(){
        app.mail().stop();
    }
}
