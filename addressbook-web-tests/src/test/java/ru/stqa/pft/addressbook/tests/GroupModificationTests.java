package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDate;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupMoodification(){
        app.getNavigationHelper().goToGroup();
        if (! app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupDate("test1", null, null));
        }
        List<GroupDate> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size() - 1);
        app.getGroupHelper().initGroupModification();
        GroupDate group = new GroupDate(before.get(before.size() - 1).getId(),"newTestName", "newTestHeader", "newTestFooter");
        app.getGroupHelper().fillingGroupForm(group);
        app.getGroupHelper().submitGroupMoodification();
        app.getGroupHelper().returnToGroupPage();
        List<GroupDate> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() );

        before.remove(before.size() - 1);
        before.add(group);
        Comparator<? super GroupDate> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
