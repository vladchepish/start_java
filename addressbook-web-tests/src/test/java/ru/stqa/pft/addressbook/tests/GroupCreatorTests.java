package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDate;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class GroupCreatorTests extends TestBase {

    @Test
    public void testGroupCreator() {
        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupDate group = new GroupDate().withName("testName");
        app.group().create(group);
        assertThat(app.group().count(),equalTo(before.size() + 1));
        Groups after = app.group().all();
        assertThat(after, equalTo(
                before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }

    @Test
    public void testBadGroupCreator() {
        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupDate group = new GroupDate().withName("testName'");
        app.group().create(group);
        assertThat(app.group().count(),equalTo(before.size()));
        Groups after = app.group().all();
        assertThat(after, equalTo(before));
    }

}
