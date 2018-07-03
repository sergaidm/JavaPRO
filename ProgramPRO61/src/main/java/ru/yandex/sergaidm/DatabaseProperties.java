package ru.yandex.sergaidm;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseProperties {

	private String url;
	private String user;
	private String password;

	public DatabaseProperties() {
		InputStream is = getClass().getClassLoader().getResourceAsStream("database.properties");
		Properties properties = new Properties();
		try {
			properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		url = properties.getProperty("database.url");
		user = properties.getProperty("database.user");
		password = properties.getProperty("database.password");
	}

	public String getUrl() {
		return url;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}

}
