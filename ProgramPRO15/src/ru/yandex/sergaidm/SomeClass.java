package ru.yandex.sergaidm;

import java.io.Serializable;

public class SomeClass implements Serializable {

	private static final long serialVersionUID = 1L;
	private int parameterOne;
	private String parameterTwo;
	private double parameterThree;

	public SomeClass(int parameterOne, String parameterTwo, double parameterThree) {
		super();
		this.parameterOne = parameterOne;
		this.parameterTwo = parameterTwo;
		this.parameterThree = parameterThree;
	}

	public SomeClass() {
		super();
	}

	public int getParameterOne() {
		return parameterOne;
	}

	public void setParameterOne(int parameterOne) {
		this.parameterOne = parameterOne;
	}

	public String getParameterTwo() {
		return parameterTwo;
	}

	public void setParameterTwo(String parameterTwo) {
		this.parameterTwo = parameterTwo;
	}

	public double getParameterThree() {
		return parameterThree;
	}

	public void setParameterThree(double parameterThree) {
		this.parameterThree = parameterThree;
	}

	@Override
	public String toString() {
		return "SomeClass [parameterOne=" + parameterOne + ", parameterTwo=" + parameterTwo + ", parameterThree="
				+ parameterThree + "]";
	}

}
