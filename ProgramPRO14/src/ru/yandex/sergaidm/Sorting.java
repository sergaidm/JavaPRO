package ru.yandex.sergaidm;

import java.util.Arrays;

public class Sorting {

	public static SomeClass[] sortingByFieldOne(SomeClass[] array) {
		Arrays.sort(array, (a, b) -> Integer.compare(a.getFieldOne(), b.getFieldOne()));
		return array;
	}

	public static SomeClass[] sortingByFieldTwo(SomeClass[] array) {
		Arrays.sort(array, (a, b) -> a.getFieldTwo().compareToIgnoreCase(b.getFieldTwo()));
		return array;
	}

	public static SomeClass[] sortingByFieldThree(SomeClass[] array) {
		Arrays.sort(array, (a, b) -> Double.compare(a.getFieldThree(), b.getFieldThree()));
		return array;
	}

}