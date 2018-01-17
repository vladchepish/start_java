package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDate;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.junit.MatcherAssert.*;

public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void ensureConditions(){
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupDate().withName("testName"));
        }
    }

    @Test
    public void testGroupDeletion() {
        Groups before = app.db().groups();
        GroupDate deletedGroup = before.iterator().next();
        app.goTo().groupPage();
        app.group().delete(deletedGroup);
        assertThat(app.group().count(), equalTo(before.size() - 1));
        Groups after = app.db().groups();
        assertThat(after, equalTo(before.withOut(deletedGroup)));
    }

}
