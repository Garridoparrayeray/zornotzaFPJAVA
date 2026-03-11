package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
   
	private static final String URL = "jdbc:mysql://localhost:3306/futbol";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection getConnection() throws SQLException {
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Datu Basera konektatua");
        } catch (SQLException e) {
            System.err.println("Ez da Dat: " + e.getMessage());
        }
        return con;
    }
}

