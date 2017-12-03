package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDate;

public class GroupCreatorTests extends TestBase {

    @Test
    public void testGroupCreator() {
        app.getNavigationHelper().goToGroup();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillingGroupForm(new GroupDate("testName", "testGroupHeader1", "testGroupFooter1"));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupPage();
    }

}
