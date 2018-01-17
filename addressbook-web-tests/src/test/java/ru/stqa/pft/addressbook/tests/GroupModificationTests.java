package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDate;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.junit.MatcherAssert.*;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensureConditions(){
        if (app.db().groups().size() == 0) {
        app.goTo().groupPage();
        app.group().create(new GroupDate().withName("testName"));
        }
    }

    @Test
    public void testGroupMoodification(){
        Groups before = app.db().groups();
        GroupDate modifiedGroup = before.iterator().next();
        GroupDate group = new GroupDate()
                .withId(modifiedGroup.getId()).withName("testName").withHeader("newTestHeader").withFooter("newTestFooter");
        app.goTo().groupPage();
        app.group().modify(group);
        assertThat(app.group().count(), equalTo( before.size()));
        Groups after = app.db().groups();
        assertThat(after, equalTo(before.withOut(modifiedGroup).withAdded(group)));
    }
}
