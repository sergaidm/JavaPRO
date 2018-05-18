package ru.yandex.sergaidm;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class JavaBeansChecker {

	private boolean checkConstructors(Class<?> cl) {
		boolean result = false;
		try {
			Constructor<?>[] con = cl.getDeclaredConstructors();
			for (Constructor<?> constructor : con) {
				if (constructor.getParameterCount() == 0
						&& Modifier.isPublic(cl.getDeclaredConstructor().getModifiers())) {
					result = true;
				}
			}
		} catch (SecurityException | NoSuchMethodException e) {
			e.printStackTrace();
		}
		return result;
	}

	private boolean checkMethods(Class<?> cl) {
		Method[] methods = cl.getDeclaredMethods();
		boolean flagOne = false;
		boolean flagTwo = false;
		boolean flagThree = false;
		boolean flagFour = false;
		boolean flagFive = false;
		for (Method method : methods) {
			if (method.toString().contains("get")) {
				flagOne = true;
			}
			if (method.toString().contains("set")) {
				flagTwo = true;
			}
			if (method.toString().contains("equals(")) {
				flagThree = true;
			}
			if (method.toString().contains("hashCode(")) {
				flagFour = true;
			}
			if (method.toString().contains("toString(")) {
				flagFive = true;
			}
			if (flagOne && flagTwo && flagThree && flagFour && flagFive) {
				return true;
			}
		}
		return false;
	}

	private boolean checkSerializable(Class<?> cl) {
		boolean result = false;
		Class<?>[] interfaces = cl.getInterfaces();
		for (Class<?> class1 : interfaces) {
			if (class1 == Serializable.class) {
				result = true;
			}
		}
		return result;
	}

	private boolean checkJavaBeans(Class<?> cl) {
		if (checkConstructors(cl) == true && checkMethods(cl) == true && checkSerializable(cl) == true) {
			return true;
		} else {
			return false;
		}
	}

	public String printResult(Class<?> cl) {
		String result = "";
		if (checkJavaBeans(cl)) {
			result = "Class meets JavaBeans specification";
		} else {
			result = "Class doesn't meet JavaBeans specification";
		}
		return result;
	}

}
