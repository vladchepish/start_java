package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class GroupCreatorTests extends TestBase {

    @Test
    public void testGroupCreator() {
        goToGroup();
        initGroupCreation();
        fillingGroupForm(new GroupDate("testName", "testGroupHeader1", "testGroupFooter1"));
        submitGroupCreation();
        returnToGroupPage();
    }

}
