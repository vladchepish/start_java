package ru.stqa.pft.rest.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.rest.model.Issue;

import javax.xml.rpc.ServiceException;
import java.io.IOException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class RestTests extends TestBase{

    @Test
    public void testCreateIssue() throws IOException, ServiceException {
        skipIfNotFixed(827);
        Set<Issue> oldIssues = app.restSession().getIssues();
        Issue newIssue = new Issue().withSubject("test Issue Chepish").withDescription("new test Issue");
        int issueId = app.restSession().createIssue(newIssue);
        Set<Issue> newIssues = app.restSession().getIssues();
        oldIssues.add(newIssue.withId(issueId));
        assertEquals(newIssues, oldIssues);
    }


}
