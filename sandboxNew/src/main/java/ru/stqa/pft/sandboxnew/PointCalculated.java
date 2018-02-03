package ru.stqa.pft.sandboxnew;

public class PointCalculated {

    public static void main (String[] args) {
        Point p1 = new Point(2, 2);
        Point p2 = new Point(4, 2);
        System.out.println("Расстояние между точками A c координатами (" + p1.x + "; " + p1.y + ") и B с координатами (" + p2.x + "; " + p2.y + ") равняется " + p1.distance(p2));
    }
}
