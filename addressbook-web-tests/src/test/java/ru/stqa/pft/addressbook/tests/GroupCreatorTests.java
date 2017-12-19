package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDate;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupCreatorTests extends TestBase {

    @Test
    public void testGroupCreator() {
        app.getNavigationHelper().goToGroup();
        List<GroupDate> before = app.getGroupHelper().getGroupList();
        GroupDate group = new GroupDate("testName2", null, null);
        app.getGroupHelper().createGroup(group);
        List<GroupDate> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(group);
        Comparator<? super GroupDate> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }

}
