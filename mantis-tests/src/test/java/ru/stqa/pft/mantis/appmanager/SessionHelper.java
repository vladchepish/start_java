package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.testng.Assert;

public class SessionHelper extends HelperBase{


    public SessionHelper(ApplicationManager app) {
        super(app);
    }

    public void enterToSystem(){
        String username = app.getProperty("web.adminLogin");
        String password = app.getProperty("web.adminPass");
        wd.get(app.getProperty("web.baseUrl"));
        type(By.name("username"), username);
        click(By.cssSelector("input[type='submit']"));
        type(By.name("password"), password);
        click(By.cssSelector("input[type='submit']"));

    }

    public void selectUser(int userNamber){
        wd.findElement(By.xpath("//a[@href='manage_user_edit_page.php?user_id=" + userNamber +"']")).click();
    }

    public void goToUsersPage() {
        wd.get(app.getProperty("web.baseUrl") + "/manage_user_page.php");
    }

    public void resetPassword() {
        wd.findElement(By.cssSelector("input[value='Сбросить пароль']")).click();
    }
}
