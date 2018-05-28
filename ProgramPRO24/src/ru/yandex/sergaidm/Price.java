package ru.yandex.sergaidm;

import javax.xml.bind.annotation.XmlAttribute;

public class Price {

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

	@XmlAttribute
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "Price [cost=" + cost + ", currency=" + currency + "]";
	}

}
