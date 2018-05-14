package ru.stqa.pft.adrbook;

import org.testng.annotations.Test;


public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.goToGroupPage();
        app.initGroupCrreation();
        app.fillGroupForm(new GroupDate("testName", "testGroupHeader1", "testGroupFooter1"));
        app.submitGroupCreation();
        app.returnToGroupPage();
    }

}