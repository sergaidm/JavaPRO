package ru.yandex.sergaidm;

import java.io.Serializable;

public enum Currency implements Serializable {
	
	DOLLAR("$"), EURO("€"), UAH("₴");
	
	private static final long serialVersionUID = 1L;
	private String currencySymbol;

	private Currency(String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}

	public String getCurrencySymbol() {
		return currencySymbol;
	}

	public void setCurrencySymbol(String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}

}
