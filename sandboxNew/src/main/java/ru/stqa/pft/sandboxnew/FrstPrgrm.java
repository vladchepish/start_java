package ru.stqa.pft.sandboxnew;

public class FrstPrgrm{

	public static void main(String[] args){

		hello("world");
		hello("User");
		hello("Vlad");

		Square s = new Square(10);
		System.out.println("Площадь квадрата со стороной " + s.len + " = " + s.area());

		Rectangle r = new Rectangle(3,6);
		System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());


	}

	public static void hello(String somebody){

		System.out.println("Hello," + somebody + "!");

	}





}