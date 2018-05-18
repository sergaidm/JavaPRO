package ru.yandex.sergaidm;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		SomeClass sc = new SomeClass();
		SomeClass scOne = new SomeClass(10, "First object", 20.5);
		SomeClass scTwo = new SomeClass(1, "Second object", 1.5);
		SomeClass scThree = new SomeClass(50, "Third object", 40);
		SomeClass scFour = new SomeClass(17, "Fourth object", 49);
		SomeClass[] array = new SomeClass[] { scOne, scTwo, scThree, scFour };
		System.out
				.println("Unsorted array of objects of some class: " + System.lineSeparator() + Arrays.toString(array));
		System.out.println("Sorted array of objects of some class by annotated field:");
		sc.checkAnnotation(array);
		System.out.println(Arrays.toString(array));

	}

}
