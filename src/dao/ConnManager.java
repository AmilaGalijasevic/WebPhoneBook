package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnManager {

	private static ConnManager instance = null;
	// DB credentials
	private final String USERNAME = "root";
	private final String PASSWORD = "root";
	private final String CONN_STRING = "jdbc:mysql://localhost/got";
	private final String DRIVER = "com.mysql.jdbc.Driver";

	// connection object
	private Connection connection = null;

	// constructor
	private ConnManager() {

	}

	public static ConnManager getInstance() {
		
		if (instance == null) {
			instance = new ConnManager();
		}
		return instance;
	}

	private boolean openConnection() {
		try {
			Class.forName(DRIVER);
	
			connection = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
			return true;
		} catch (SQLException | ClassNotFoundException e) {
			System.err.println(e);
			return false;
		}
	}

	public Connection getConnection() {
		if (connection == null) {
			if (openConnection()) {
				System.out.println("Connected");
				return connection;
			} else {
				return null;
			}
		}
		return connection;
	}

	void close() {
		System.out.println("Closing connection");
		try {
			connection.close();
			connection = null;
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
