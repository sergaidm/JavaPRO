package ru.yandex.sergaidm;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "flats")
public class Flat implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	@Column(nullable = false)
	private String address;
	@Column(name = "number_of_rooms", nullable = false)
	private int roomsNumber;
	@Column(nullable = false)
	private int floor;
	@Type(type = "ru.yandex.sergaidm.PriceDescriptor")
	@Embedded
	private Price price;

	public Flat() {
		super();
	}

	public Flat(String address, int roomsNumber, int floor, Price price) {
		super();
		this.address = address;
		this.roomsNumber = roomsNumber;
		this.floor = floor;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getRoomsNumber() {
		return roomsNumber;
	}

	public void setRoomsNumber(int roomsNumber) {
		this.roomsNumber = roomsNumber;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Flat " + id + ": " + address + ", " + roomsNumber + " rooms, " + floor + " floor, " + price.getCost()
				+ " " + price.getCurrency();
	}

}
