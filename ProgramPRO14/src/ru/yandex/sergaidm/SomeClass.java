package ru.yandex.sergaidm;

import java.lang.reflect.Field;

public class SomeClass {

	private int fieldOne;
	private String fieldTwo;
	private double fieldThree;

	public SomeClass(int fieldOne, String fieldTwo, double fieldThree) {
		super();
		this.fieldOne = fieldOne;
		this.fieldTwo = fieldTwo;
		this.fieldThree = fieldThree;
	}

	public SomeClass() {
		super();
	}

	public int getFieldOne() {
		return fieldOne;
	}

	public void setFieldOne(int fieldOne) {
		this.fieldOne = fieldOne;
	}

	public String getFieldTwo() {
		return fieldTwo;
	}

	public void setFieldTwo(String fieldTwo) {
		this.fieldTwo = fieldTwo;
	}

	public double getFieldThree() {
		return fieldThree;
	}

	public void setFieldThree(double fieldThree) {
		this.fieldThree = fieldThree;
	}

	public void getFields() {
		Class<?> cl = this.getClass();
		Field[] fields = cl.getDeclaredFields();
		System.out.println("All fields in class " + cl.getName() + ":");
		for (Field field : fields) {
			Class<?> fieldClass = field.getType();
			System.out.println(field.getName() + " - " + fieldClass.getName());
		}
	}
	
	@Override
	public String toString() {
		return "SomeClass: integer number = " + fieldOne + ", String value = \"" + fieldTwo
				+ "\", fractional number = " + fieldThree;
	}

}
