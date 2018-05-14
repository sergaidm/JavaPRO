package ru.yandex.sergaidm;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Mani {

	public static void main(String[] args) {

		TextContainer tc = new TextContainer();
		tc.setText("Annotations for saving text to file");
		Class<?> cl = tc.getClass();
		try {
			SaveTo st = cl.getAnnotation(SaveTo.class);
			Method[] methods = cl.getDeclaredMethods();
			for (Method method : methods) {
				if (method.isAnnotationPresent(Saver.class)) {
					method.invoke(tc, st.path());
					break;
				}
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
		}
		System.out.println("Text is saved to \"File.txt\"");

	}

}
