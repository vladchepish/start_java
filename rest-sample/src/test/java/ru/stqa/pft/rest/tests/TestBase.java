package ru.stqa.pft.rest.tests;

import org.testng.SkipException;
import ru.stqa.pft.rest.appmanager.ApplicationManager;

import javax.xml.rpc.ServiceException;
import java.io.IOException;

public class TestBase {

    protected static final ApplicationManager app = new ApplicationManager();

    public void skipIfNotFixed(int issueId) throws IOException, ServiceException {
        if (isIssueOpen(issueId)) {
            throw new SkipException("Ignored because of issue " + issueId);
        }
    }

    private boolean isIssueOpen(int issueId) throws IOException, ServiceException {
        if(app.restSession().getStatus(issueId)){
            return false;
        }
        return true;
    }
}
