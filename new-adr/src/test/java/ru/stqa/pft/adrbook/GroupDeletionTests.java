package ru.stqa.pft.adrbook;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupDeletion(){
        app.goToGroupPage();
        app.selectGroup();
        app.deleteSelectedGroup();
        app.returnToGroupPage();
    }

}
