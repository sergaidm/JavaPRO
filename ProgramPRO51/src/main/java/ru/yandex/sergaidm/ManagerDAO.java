package ru.yandex.sergaidm;

public class ManagerDAO {

	private FlatDAODatabaseImplementation flatsDB;

	public FlatDAODatabaseImplementation getFlatsDB() {
		return new FlatDAODatabaseImplementation();
	}

}
