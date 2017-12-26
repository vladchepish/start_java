package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDate;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensureConditions(){
        app.goTo().groupPage();
        if (app.group().all().size() == 0){
            app.group().create(new GroupDate().withName("testName"));
        }
    }

    @Test
    public void testGroupMoodification(){

        Set<GroupDate> before = app.group().all();
        GroupDate modifiedGroup = before.iterator().next();
        int index = before.size() - 1;
        GroupDate group = new GroupDate()
                .withId(modifiedGroup.getId()).withName("newTestName").withHeader("newTestHeader").withFooter("newTestFooter");
        app.group().modify(group);
        Set<GroupDate> after = app.group().all();
        Assert.assertEquals(after.size(), before.size() );

        before.remove(modifiedGroup);
        before.add(group);
        Assert.assertEquals(before, after);
    }
}
