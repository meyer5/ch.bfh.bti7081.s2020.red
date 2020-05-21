package ch.bfh.btx8081.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.sqlite.SQLiteConfig;

/**
 * This class checks if the JDBC DriverDriver for the SQLite
 * Database can be found and if a connection to the 
 * Database can be made
 * @author Remo
 *
 */
public class TestJpaDriverAndConnection {
	
	public static final String DB_URL = "jdbc:sqlite:addictionDiary.db";  
	public static final String DRIVER = "org.sqlite.JDBC";  
	
	
	public static void checkConnection() {
		Connection conn = null;
		
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			throw new Error("Cannot find JDBC Driver", e);
		}
		try {
			Properties properties = new Properties();
			properties.setProperty("PRAGMA foreign_keys", "ON");
			conn = DriverManager.getConnection(DB_URL, properties);
			System.out.println("Connection established");
//			System.out.println(properties.toString());
		} catch (SQLException e) {
			throw new Error("Cannot establish database connection", e);
		}
		try {
	        SQLiteConfig config = new SQLiteConfig();  
	        config.enforceForeignKeys(true);  
	        conn = DriverManager.getConnection(DB_URL,config.toProperties());  
	    } catch (SQLException ex) {}


	}
}