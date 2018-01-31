package ru.stqa.pft.mantis.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.mantis.model.Issue;
import ru.stqa.pft.mantis.model.Project;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Set;

public class SoapTests extends TestBase{

    @Test
    public void testGetProject() throws MalformedURLException, ServiceException, RemoteException {
        Set<Project> projects = app.soapHelper().getProjects();
        System.out.println(projects.size());
        for (Project project : projects){
            System.out.println(project.getName());
        }
    }

    @Test
    public void testCreateIssue() throws RemoteException, ServiceException, MalformedURLException {
        Set<Project> projects = app.soapHelper().getProjects();
        Issue issue = new Issue().withSummery("testSummery")
                .withDescription("testDescription").withProject(projects.iterator().next());
        Issue created = app.soapHelper().addIssue(issue);
        Assert.assertEquals(issue.getSummery(), created.getSummery());

    }

    @Test
    public void testGetStaus() throws RemoteException, ServiceException, MalformedURLException {
        int id = 5;
        System.out.println(app.soapHelper().getStatus(id));
    }

}
