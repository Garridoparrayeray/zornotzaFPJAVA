package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DDBBKonexioa {
	private static final String URL = "jdbc:mysql://localhost:3306/Biblioteca";
	private static final String USER = "root";
	private static final String PASS = "";
	public Connection Konexioa() {
		Connection konexioa = null;
		try {
			konexioa = DriverManager.getConnection(URL, USER, PASS);
			System.out.println("Datu basera konektatu da.");
		}catch (SQLException e) {
			System.err.println("Errorea konektatzeran " + e.getMessage());
		}
		return konexioa;
		
	}

}
