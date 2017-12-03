package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.madel.GroupDate;

public class GroupCreatorTests extends TestBase {

    @Test
    public void testGroupCreator() {
        app.goToGroup();
        app.initGroupCreation();
        app.fillingGroupForm(new GroupDate("testName", "testGroupHeader1", "testGroupFooter1"));
        app.submitGroupCreation();
        app.returnToGroupPage();
    }

}
