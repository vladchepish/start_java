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
        Groups after = app.group().all();
        assertThat(after.size(),equalTo(before.size() + 1));
        assertThat(after, equalTo(
                before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }

}
