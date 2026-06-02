package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbKonexioa {
    private static final String URL = "jdbc:mysql://localhost:3306/hotela?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "root";

    public static Connection lortuKonexioa() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            System.err.println("Konexio errorea: " + e.getMessage());
            return null;
        }
    }
}