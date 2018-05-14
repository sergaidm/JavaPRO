package ru.yandex.sergaidm;

public class SumClass {

	@MethodAnnotation(a = 1, b = 10)
	public int sumCalculation(int a, int b) {
		int sum = 0;
		sum = a + b;
		return sum;
	}

}
