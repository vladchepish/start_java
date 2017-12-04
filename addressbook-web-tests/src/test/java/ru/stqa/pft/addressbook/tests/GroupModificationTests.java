package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDate;

public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupMoodification(){
        app.getNavigationHelper().goToGroup();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillingGroupForm(new GroupDate("newTestName", "newTestHeader", "newTestFooter"));
        app.getGroupHelper().submitGroupMoodification();
        app.getGroupHelper().returnToGroupPage();
    }
}
