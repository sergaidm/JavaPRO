package ru.yandex.sergaidm;

import java.net.URL;
import java.util.Arrays;

public class BusinessCard {

	private String name;
	private String surname;
	private String[] phones;
	private URL[] sites;
	private Address address;

	public BusinessCard(String name, String surname, String[] phones, URL[] sites, Address address) {
		super();
		this.name = name;
		this.surname = surname;
		this.phones = phones;
		this.sites = sites;
		this.address = address;
	}

	public BusinessCard() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String[] getPhones() {
		return phones;
	}

	public void setPhones(String[] phones) {
		this.phones = phones;
	}

	public URL[] getSites() {
		return sites;
	}

	public void setSites(URL[] sites) {
		this.sites = sites;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "BusinessCard: name = " + name + ", surname = " + surname + ", phones: " + Arrays.toString(phones)
				+ ", sites: " + Arrays.toString(sites) + ", address: " + address;
	}

}
