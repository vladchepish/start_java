package ru.stqa.pft.sandboxnew;

public class PointCalculated {

    public static void main (String[] args) {
        Point p1 = new Point(2, 2);
        Point p2 = new Point(4, 2);
        System.out.println("Расстояние между точками A c координатами (" + p1.x + "; " + p1.y + ") и B с координатами (" + p2.x + "; " + p2.y + ") равняется " + p1.distance(p2));
    }

    /* Функция, которая расчитывает расстояние между точками в двухмерном пространстве было реализовано для пунктов 1-3
    public static double distance(Point p1, Point p2){   // Вся магия будет происходит тут.
        double X = ((p1.x - p2.x) * (p1.x - p2.x));      // Возводим в корень разность координат по осм X
        double Y = ((p1.y - p2.y) * (p1.y - p2.y));      // Возводим в корень разность координат по оси Y
        return Math.sqrt(X + Y);                         // Извлекаем корень из суммы квадратов разностей
    }
    */
}
