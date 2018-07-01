package ru.yandex.sergaidm;

import java.io.Serializable;

public class Price implements Serializable {

	private static final long serialVersionUID = 1L;
	private double cost;
	private String currency;

	public Price(double price, String currency) {
		super();
		this.cost = price;
		this.currency = currency;
	}

	public Price() {
		super();
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "(" + cost + "," + currency + ")";
	}

}