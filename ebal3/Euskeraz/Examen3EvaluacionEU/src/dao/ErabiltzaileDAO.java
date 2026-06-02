package dao;

import model.Erabiltzailea;

import java.sql.*;

public class ErabiltzaileDAO {

    // =========================
    // SAIO HASIERA (LOGIN)
    // =========================
    public Erabiltzailea saioaHasi(String izena, String pasahitza) {

        String sql = "SELECT * FROM erabiltzaileak WHERE izena=? AND pasahitza=?";

        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, izena);
            ps.setString(2, pasahitza);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return new Erabiltzailea(
                        rs.getInt("idErabiltzailea"),
                        rs.getString("izena"),
                        rs.getString("pasahitza"),
                        rs.getString("rola")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}