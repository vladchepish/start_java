package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDate;

public class GroupCreatorTests extends TestBase {

    @Test
    public void testGroupCreator() {
        app.getNavigationHelper().goToGroup();
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().createGroup(new GroupDate("testName", null, null));
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before + 1);
    }

}
