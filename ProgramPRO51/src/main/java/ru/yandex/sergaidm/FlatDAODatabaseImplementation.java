package ru.yandex.sergaidm;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.postgresql.util.PGobject;

public class FlatDAODatabaseImplementation implements FlatDAO {

	private DatabaseProperties properties = new DatabaseProperties();

	public FlatDAODatabaseImplementation() {
		super();
	}

	/*
	 * Method for a local database:
	 * 
	 * public Connection connectToDatabase() throws SQLException { try {
	 * Class.forName("org.postgresql.Driver"); } catch (ClassNotFoundException e) {
	 * e.printStackTrace(); } return
	 * DriverManager.getConnection(properties.getUrl(), properties.getUser(),
	 * properties.getPassword()); }
	 */

	/*
	 * Method for Heroku database:
	 */

	public Connection connectToDatabase() throws URISyntaxException, SQLException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		URI databaseURI = new URI(System.getenv(
				"postgres://cjrefezsvsitiw:6afb556db9e4283f79f71343cd03a2cf76fce586f0c56fb4cdb27990c073c9a4@ec2-54-217-250-0.eu-west-1.compute.amazonaws.com:5432/deukamiotu7ksk"));
		String user = databaseURI.getUserInfo().split(":")[0];
		String password = databaseURI.getUserInfo().split(":")[1];
		String databasebURL = "jdbc:postgresql://" + databaseURI.getHost() + ':' + databaseURI.getPort()
				+ databaseURI.getPath() + "?sslmode=require";
		return DriverManager.getConnection(databasebURL, user, password);
	}

	@Override
	public void createTable() {
		try (Connection connection = connectToDatabase()) {
			try (Statement statement = connection.createStatement()) {
				statement.addBatch("DROP TABLE IF EXISTS flats");
				statement.addBatch("DROP TYPE IF EXISTS price");
				statement.addBatch("CREATE TYPE PRICE AS (cost NUMERIC, currency CHAR(1));");
				statement.addBatch(
						"CREATE TABLE flats (id SERIAL, address VARCHAR(30) NOT NULL, number_of_rooms INTEGER NOT NULL, "
								+ "floor INTEGER NOT NULL, price PRICE NOT NULL, PRIMARY KEY (id));");
				statement.executeBatch();
			}
		} catch (SQLException | URISyntaxException e) {
			e.printStackTrace();
		}
	}

	public void initializationDatabase() {
		createTable();
		try (Connection connection = connectToDatabase()) {
			try (Statement statement = connection.createStatement()) {
				statement.addBatch("INSERT INTO flats VALUES (1, 'USA, Fort Lauderdale', 2, 3, '(10000,$)')");
				statement.addBatch("INSERT INTO flats VALUES (2, 'USA, Miami', 4, 5, '(20000,$)')");
				statement.addBatch("INSERT INTO flats VALUES (3, 'USA, Los Angeles', 8, 28, '(30000,$)')");
				statement.addBatch("INSERT INTO flats VALUES (4, 'USA, Miami', 13, 1, '(40000,$)')");
				statement.addBatch("INSERT INTO flats VALUES (5, 'Germany, Berlin', 3, 4, '(10000,€)')");
				statement.addBatch("INSERT INTO flats VALUES (6, 'UK, London', 9, 2, '(20000,€)')");
				statement.addBatch("INSERT INTO flats VALUES (7, 'France, Paris', 4, 6, '(30000,€)')");
				statement.addBatch("INSERT INTO flats VALUES (8, 'Ukraine, Kiev', 1, 8, '(10000,₴)')");
				statement.addBatch("INSERT INTO flats VALUES (9, 'Ukraine, Kiev', 2, 9, '(20000,₴)')");
				statement.addBatch("INSERT INTO flats VALUES (10, 'Ukraine, Kiev', 3, 10, '(30000,₴)')");
				statement.executeBatch();
			}
		} catch (SQLException | URISyntaxException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(Flat flat) {
		try (Connection connection = connectToDatabase();
				PreparedStatement ps = connection.prepareStatement("INSERT INTO flats VALUES (?, ?, ?, ?, ?)")) {
			ps.setInt(1, flat.getId());
			ps.setString(2, flat.getAddress());
			ps.setInt(3, flat.getRoomsNumber());
			ps.setInt(4, flat.getFloor());
			PGobject price = new PGobject();
			price.setType("price");
			price.setValue(new Price(flat.getPrice().getCost(), flat.getPrice().getCurrency()).toString());
			ps.setObject(5, price);
			ps.executeUpdate();
		} catch (SQLException | URISyntaxException e) {
			e.printStackTrace();
		}
	}

	public Price priceParser(Object object) {
		String textPrice = object.toString().substring(1, object.toString().length() - 1);
		String[] arrayPrice = textPrice.split(",");
		Double cost = Double.valueOf(arrayPrice[0]);
		Price price = new Price(cost, arrayPrice[1]);
		return price;
	}

	@Override
	public List<Flat> getFlatsList() {
		List<Flat> flats = new ArrayList<>();
		try (Connection connection = connectToDatabase();
				PreparedStatement ps = connection.prepareStatement("SELECT * FROM flats");
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				Flat flat = new Flat();
				flat.setId(rs.getInt(("id")));
				flat.setAddress(rs.getString("address"));
				flat.setRoomsNumber(rs.getInt("Number_of_rooms"));
				flat.setFloor(rs.getInt("floor"));
				flat.setPrice(priceParser(rs.getObject("price")));
				flats.add(flat);
			}
		} catch (SQLException | URISyntaxException e) {
			e.printStackTrace();
		}
		return flats;
	}

	@Override
	public Flat getFlatByID(int id) {
		Flat flat = new Flat();
		try (Connection connection = connectToDatabase();
				PreparedStatement ps = connection.prepareStatement("SELECT * FROM flats WHERE id = ?")) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					flat = new Flat(rs.getInt(("id")), rs.getString("address"), rs.getInt("Number_of_rooms"),
							rs.getInt("floor"), priceParser(rs.getObject("price")));
				}
			}
		} catch (SQLException | URISyntaxException e) {
			e.printStackTrace();
		}
		return flat;
	}

	@Override
	public List<Flat> getFlatsByRoomsNumber(int roomsNumber) {
		List<Flat> flatsByRoomsNumber = new ArrayList<>();
		try (Connection connection = connectToDatabase();
				PreparedStatement ps = connection.prepareStatement("SELECT * FROM flats WHERE Number_of_rooms = ?")) {
			ps.setInt(1, roomsNumber);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					flatsByRoomsNumber.add(new Flat(rs.getInt(("id")), rs.getString("address"),
							rs.getInt("Number_of_rooms"), rs.getInt("floor"), priceParser(rs.getObject("price"))));
				}
			}
		} catch (SQLException | URISyntaxException e) {
			e.printStackTrace();
		}
		return flatsByRoomsNumber;
	}

	@Override
	public List<Flat> getFlatsByAddress(String address) {
		List<Flat> flatsByAddress = new ArrayList<>();
		try (Connection connection = connectToDatabase();
				PreparedStatement ps = connection.prepareStatement("SELECT * FROM flats WHERE LOWER(address) LIKE ?")) {
			ps.setString(1, "%" + address + "%");
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					flatsByAddress.add(new Flat(rs.getInt(("id")), rs.getString("address"),
							rs.getInt("Number_of_rooms"), rs.getInt("floor"), priceParser(rs.getObject("price"))));
				}
			}
		} catch (SQLException | URISyntaxException e) {
			e.printStackTrace();
		}
		return flatsByAddress;
	}

	@Override
	public List<Flat> getFlatsByFloor(int floor) {
		List<Flat> flatsByFloor = new ArrayList<>();
		try (Connection connection = connectToDatabase();
				PreparedStatement ps = connection.prepareStatement("SELECT * FROM flats WHERE floor = ?")) {
			ps.setInt(1, floor);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					flatsByFloor.add(new Flat(rs.getInt(("id")), rs.getString("address"), rs.getInt("Number_of_rooms"),
							rs.getInt("floor"), priceParser(rs.getObject("price"))));
				}
			}
		} catch (SQLException | URISyntaxException e) {
			e.printStackTrace();
		}
		return flatsByFloor;
	}

	@Override
	public List<Flat> getFlatsByPrice(double begin, double end, String currency) {
		List<Flat> flatsByPrice = new ArrayList<>();
		try (Connection connection = connectToDatabase();
				PreparedStatement ps = connection.prepareStatement(
						"SELECT * FROM flats WHERE (price).cost BETWEEN ? AND ? AND (price).currency = ?")) {
			ps.setDouble(1, begin);
			ps.setDouble(2, end);
			ps.setString(3, currency);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					flatsByPrice.add(new Flat(rs.getInt(("id")), rs.getString("address"), rs.getInt("Number_of_rooms"),
							rs.getInt("floor"), priceParser(rs.getObject("price"))));
				}
			}
		} catch (SQLException | URISyntaxException e) {
			e.printStackTrace();
		}
		return flatsByPrice;
	}

	@Override
	public void update(Flat flat) {
		try (Connection connection = connectToDatabase();
				PreparedStatement ps = connection.prepareStatement(
						"UPDATE flats SET address = ?, Number_of_rooms = ?, floor = ?, price = ? WHERE id = ?")) {
			ps.setString(1, flat.getAddress());
			ps.setInt(2, flat.getRoomsNumber());
			ps.setInt(3, flat.getFloor());
			PGobject price = new PGobject();
			price.setType("price");
			price.setValue(new Price(flat.getPrice().getCost(), flat.getPrice().getCurrency()).toString());
			ps.setObject(4, price);
			ps.setObject(5, flat.getId());
			ps.executeUpdate();
		} catch (SQLException | URISyntaxException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		try (Connection connection = connectToDatabase();
				PreparedStatement ps = connection.prepareStatement("DELETE FROM flats WHERE id = ?")) {
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException | URISyntaxException e) {
			e.printStackTrace();
		}
	}

}
