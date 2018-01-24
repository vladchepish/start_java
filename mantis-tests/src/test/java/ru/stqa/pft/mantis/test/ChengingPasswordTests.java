package ru.stqa.pft.mantis.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.Users;
import ru.stqa.pft.mantis.model.UsersDate;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ChengingPasswordTests extends TestBase {

    @BeforeMethod
    public void startMailServer(){
        app.mail().start();
    }

    @Test
    public void testChangingPassword() throws IOException, MessagingException {
        String password = "password";
        Users atStart = app.db().users();
        UsersDate resetedPasswordUser = atStart.iterator().next();
        UsersDate userNumber = new UsersDate().withId(resetedPasswordUser.getId()).withEmail(resetedPasswordUser.getEmail()).withUsername(resetedPasswordUser.getUsername());
        app.session().enterToSystem();
        app.session().goToUsersPage();
        app.session().selectUser(userNumber);
        app.session().resetPassword();
        List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
        String confirmationLink = findConfirmationLink(mailMessages, userNumber.getEmail());
        app.session().finishRestor(confirmationLink, password);
        assertTrue(app.newSession().login(userNumber.getUsername(), password));

    }

    private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }


    @AfterMethod(alwaysRun = true)
    public void stopMailServer(){
        app.mail().stop();
    }
}
