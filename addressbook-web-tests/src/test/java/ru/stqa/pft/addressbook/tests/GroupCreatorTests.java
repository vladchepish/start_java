package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDate;

import java.util.Set;

public class GroupCreatorTests extends TestBase {

    @Test
    public void testGroupCreator() {
        app.goTo().groupPage();
        Set<GroupDate> before = app.group().all();
        GroupDate group = new GroupDate().withName("testName");
        app.group().create(group);
        Set<GroupDate> after = app.group().all();
        Assert.assertEquals(after.size(), before.size() + 1);

        group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
        before.add(group);
        Assert.assertEquals(before, after);
    }

}
