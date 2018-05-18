package ru.yandex.sergaidm;

public class Main {

	public static void main(String[] args) {

		SomeClass sc = new SomeClass(10, "15", 20.5);
		JavaBeansChecker sca = new JavaBeansChecker();
		Class<?> cl = sc.getClass();
		System.out.println(sca.printResult(cl));

	}

}
