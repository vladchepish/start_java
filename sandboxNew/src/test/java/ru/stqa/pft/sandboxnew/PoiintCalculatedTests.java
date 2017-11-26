package ru.stqa.pft.sandboxnew;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PoiintCalculatedTests {

    @Test
    public void testDistance(){

        Point p1 = new Point(2, 2);
        Point p2 = new Point(4, 2);
        Assert.assertEquals( p1.distance(p2), 2.0);
    }

}