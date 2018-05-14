package ru.yandex.sergaidm;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) {

		SumClass sc = new SumClass();
		Class<?> cl = sc.getClass();
		try {
			Method method = cl.getDeclaredMethod("sumCalculation", int.class, int.class);
			MethodAnnotation ma = method.getAnnotation(MethodAnnotation.class);
			System.out.println(method.invoke(sc, ma.a(), ma.b()));
		} catch (NoSuchMethodException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
		}

	}

}
