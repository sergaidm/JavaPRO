package ru.yandex.sergaidm;

import java.lang.reflect.Field;

public class SomeClassAction {
	
	public void action(SomeClass sc) {
		Class<?> cl = sc.getClass();
		Field[] fields = cl.getDeclaredFields();
		System.out.println("All fields in class " + cl.getName() + ":");
		for (Field field : fields) {
			Class<?> fieldClass = field.getType();
			System.out.println(field.getName() + " - " + fieldClass.getName());
		}

	}

}
