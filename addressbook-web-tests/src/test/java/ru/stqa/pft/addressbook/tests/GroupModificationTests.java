package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDate;

public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupMoodification(){
        app.getNavigationHelper().goToGroup();
        int before = app.getGroupHelper().getGroupCount();
        if (! app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupDate("test1", null, null));
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillingGroupForm(new GroupDate("newTestName", "newTestHeader", "newTestFooter"));
        app.getGroupHelper().submitGroupMoodification();
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before );
    }
}
