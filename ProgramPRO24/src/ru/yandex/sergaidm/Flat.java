package ru.yandex.sergaidm;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Flat {

	private int roomsNumber;
	private String address;
	private int floor;
	private Price price;

	public Flat(int roomsNumber, String address, int floor, Price price) {
		super();
		this.roomsNumber = roomsNumber;
		this.address = address;
		this.floor = floor;
		this.price = price;
	}

	public Flat() {
		super();
	}

	@XmlElement
	public int getRoomsNumber() {
		return roomsNumber;
	}

	public void setRoomsNumber(int roomsNumber) {
		this.roomsNumber = roomsNumber;
	}

	@XmlElement
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@XmlElement
	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	@XmlElement
	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Flat with " + roomsNumber + " rooms at " + address + ", located on " + floor
				+ " floor for the price of " + price.getCost() + " " + price.getCurrency();
	}

}
