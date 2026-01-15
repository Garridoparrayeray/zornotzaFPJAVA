package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Konexioa {
    private static final String URL = "jdbc:mysql://localhost:3306/empresa";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection getKonexioa() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
/*BETI EGIN BEHARKO DUZU HAU*/