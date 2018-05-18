package ru.yandex.sergaidm;

import java.lang.reflect.Field;

public class SomeClass {

	private int fieldOne;
	@Sort
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

	public void checkAnnotation (SomeClass[] array) {
		Class<?> cl = this.getClass();
		Field[] fields = cl.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			if(fields[0].isAnnotationPresent(Sort.class)) {
				Sorting.sortingByFieldOne(array);
			} 
			if(fields[1].isAnnotationPresent(Sort.class)) {
				Sorting.sortingByFieldTwo(array);
			} 
			if(fields[2].isAnnotationPresent(Sort.class)) {
				Sorting.sortingByFieldThree(array);
			} 
		}
	}
	
	@Override
	public String toString() {
		return "SomeClass: integer number = " + fieldOne + ", String value = \"" + fieldTwo
				+ "\", fractional number = " + fieldThree;
	}

}
