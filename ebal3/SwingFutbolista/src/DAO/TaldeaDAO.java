package DAO;

import java.sql.*;
import java.util.ArrayList;
import model.Taldea;

public class TaldeaDAO {

    public ArrayList<Taldea> getTaldeak() {
        ArrayList<Taldea> taldeaList = new ArrayList<>();
        try (Connection con = DbConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet resultSet = st.executeQuery("SELECT * FROM equipos;")) {
            while (resultSet.next()) {
                taldeaList.add(new Taldea(resultSet.getInt("idEquipo"), 
                               resultSet.getString("nombre"), resultSet.getString("ciudad")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return taldeaList;
    }

    public void addTaldea(Taldea t) {
        String sql = "INSERT INTO equipos (idEquipo, nombre, ciudad) VALUES (?, ?, ?)";
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, t.getIdTaldea());
            ps.setString(2, t.getIzena());
            ps.setString(3, t.getHerria());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Taldea getTaldeaById(int id) {
        String sql = "SELECT * FROM equipos WHERE idEquipo = ?";
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Taldea(rs.getInt("idEquipo"), rs.getString("nombre"), rs.getString("ciudad"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}