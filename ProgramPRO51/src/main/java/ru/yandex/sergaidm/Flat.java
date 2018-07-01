package ru.yandex.sergaidm;

import java.io.Serializable;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Flat implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String address;
	private int roomsNumber;
	private int floor;
	private Price price;

	public Flat() {
		super();
	}

	public Flat(int id, String address, int roomsNumber, int floor, Price price) {
		super();
		this.id = id;
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

	public boolean isExist(int id) {
		FlatDAODatabaseImplementation flatDB = new FlatDAODatabaseImplementation();
		try (Connection connection = flatDB.connectToDatabase();
				PreparedStatement ps = connection.prepareStatement("SELECT * FROM flats WHERE id = ?")) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					if (flatDB.getFlatByID(id) != null) {
						return true;
					}
				}
			}
		} catch (SQLException | URISyntaxException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public String toString() {
		return "Flat " + id + ": " + address + ", " + roomsNumber + " rooms, " + floor + " floor, " + price.getCost()
				+ " " + price.getCurrency();
	}

}
