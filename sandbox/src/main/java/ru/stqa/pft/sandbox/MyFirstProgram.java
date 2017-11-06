package ru.stqa.pft.sandbox;

public class MyFirstProgram{

	public static void main (String[] args) {
		hello("world");
		hello("Vlad");
		hello("user");

		Square s = new Square(0.287);
		System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

		Rectangle r = new Rectangle(2.5678, 111.3333);
		System.out.println("Площадь прямолгольника со сторонами " + r.a + " и " + r.b + " = " + r.area());
	}

	public static void hello(String somebody) {

		System.out.println("Hello, " + somebody + "!");
	}


}