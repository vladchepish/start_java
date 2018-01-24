package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import ru.stqa.pft.mantis.model.UsersDate;

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

    public void selectUserById(int id){
        wd.findElement(By.xpath("//a[@href='manage_user_edit_page.php?user_id=" + id +"']")).click();
    }

    public void goToUsersPage() {
        wd.get(app.getProperty("web.baseUrl") + "/manage_user_page.php");
    }

    public void resetPassword() {
        wd.findElement(By.cssSelector("input[value='Сбросить пароль']")).click();
    }

    public void selectUser(UsersDate userNumber) {
        selectUserById(userNumber.getId());
    }

    public void finishRestor(String confirmationLink, String password) {
        wd.get(confirmationLink);
        type(By.name("password"), password);
        type(By.name("password_confirm"), password);
        click(By.cssSelector("button[type='submit']"));
    }
}
