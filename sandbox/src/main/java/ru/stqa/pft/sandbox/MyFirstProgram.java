package ru.stqa.pft.sandbox;

public class MyFirstProgram{

	public static void main (String[] args) {
		hello("world");
		hello("Vlad");
		hello("user");

		double len = 5;
		System.out.println("Площадь квадрата со стороной " + len + " = " + area(len));

		double a = 6;
		double b = 8;
		System.out.println("Площадь прямолгольника со сторонами " + a + " и " + b + " = " + area(a,b));
	}

	public static void hello(String somebody) {

		System.out.println("Hello, " + somebody + "!");
	}

	public static double area(double l){
		return l * l;
	}

	 public static double area(double a, double b){
		return a * b;
	 }
}