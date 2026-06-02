package dao;

import model.Erreserba;

import java.sql.*;
import java.util.ArrayList;

public class ErreserbaDAO {

    // =========================
    // ERABILTZAILEAREN ERRESERBAK (ID)
    // =========================
    public ArrayList<Erreserba> lortuErreserbakErabiltzailearenarabera(int idBezeroa) {

        ArrayList<Erreserba> lista = new ArrayList<>();

        String sql = """
                SELECT r.idErreserba,
                       r.idBezeroa,
                       c.izena AS klasea,
                       r.data,
                       r.idKlasea
                FROM erreserbak r
                JOIN klaseak c ON r.idKlasea = c.idKlasea
                WHERE r.idBezeroa = ?
                """;

        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idBezeroa);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Erreserba r = new Erreserba();

                r.setIdErreserba(rs.getInt("idErreserba"));
                r.setIdBezeroa(rs.getInt("idBezeroa"));
                r.setKlaseIzena(rs.getString("klasea"));
                r.setData(rs.getDate("data").toLocalDate());
                r.setIdKlasea(rs.getInt("idKlasea"));

                lista.add(r);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // =========================
    // ERRESERBA TXERTATU
    // =========================
    public void erreserbaTxertatu(Erreserba r) {

        String sql = "INSERT INTO erreserbak (idBezeroa, data, idKlasea) VALUES (?, ?, ?)";

        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, r.getIdBezeroa());
            ps.setDate(2, Date.valueOf(r.getData()));
            ps.setInt(3, r.getIdKlasea());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // =========================
    // ERRESERBA EZABATU
    // =========================
    public void erreserbaEzabatu(int idErreserba) {

        String sql = "DELETE FROM erreserbak WHERE idErreserba=?";

        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idErreserba);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}