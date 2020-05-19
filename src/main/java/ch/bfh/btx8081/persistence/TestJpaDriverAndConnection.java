package ch.bfh.btx8081.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class checks if the JDBC DriverDriver for the SQLite
 * Database can be found and if a connection to the 
 * Database can be made
 * @author Remo
 *
 */
public class TestJpaDriverAndConnection {

	public static void checkConnection() {

		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			throw new Error("Cannot find JDBC Driver", e);
		}
		try (Connection conn = DriverManager.getConnection("jdbc:sqlite:addictionDiary.db")) {
			System.out.println("Connection established");
		} catch (SQLException e) {
			throw new Error("Cannot establish database connection", e);
		}

	}
}