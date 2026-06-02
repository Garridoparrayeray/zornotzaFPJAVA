package dao;

import model.Klasea;

import java.sql.*;
import java.util.ArrayList;

public class KlaseaDAO {

    // =========================
    // KLASE GUZTIAK LORTU
    // =========================
    public ArrayList<Klasea> lortuKlaseak() {

        ArrayList<Klasea> lista = new ArrayList<>();

        String sql = "SELECT idKlasea, izena, instruktorea, ordutegia FROM klaseak";

        try (Connection con = DbConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {

                Klasea klasea = new Klasea();

                klasea.setIdKlasea(rs.getInt("idKlasea"));
                klasea.setIzena(rs.getString("izena"));
                klasea.setInstruktorea(rs.getString("instruktorea"));
                klasea.setOrdutegia(rs.getString("ordutegia"));

                lista.add(klasea);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // =========================
    // KLASEA TXERTATU
    // =========================
    public void klaseaTxertatu(Klasea k) {

        String sql = "INSERT INTO klaseak (izena, instruktorea, ordutegia) VALUES (?, ?, ?)";

        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, k.getIzena());
            ps.setString(2, k.getInstruktorea());
            ps.setString(3, k.getOrdutegia());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // =========================
    // KLASEA EGUNERATU
    // =========================
    public void klaseaEguneratu(Klasea k) {

        String sql = "UPDATE klaseak SET izena=?, instruktorea=?, ordutegia=? WHERE idKlasea=?";

        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, k.getIzena());
            ps.setString(2, k.getInstruktorea());
            ps.setString(3, k.getOrdutegia());
            ps.setInt(4, k.getIdKlasea());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
