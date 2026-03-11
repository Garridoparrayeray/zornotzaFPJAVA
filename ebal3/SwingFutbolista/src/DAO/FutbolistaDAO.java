package DAO;

import java.sql.*;
import java.util.ArrayList;
import model.Futbolista;

public class FutbolistaDAO {

    public ArrayList<Futbolista> getFutbolistak() {
        ArrayList<Futbolista> futbolistaList = new ArrayList<>();
        try (Connection con = DbConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet resultSet = st.executeQuery("SELECT * FROM futbolistas;")) {
            while (resultSet.next()) {
                Futbolista fut = new Futbolista(
                    resultSet.getString("dni"),
                    resultSet.getString("nombre"),
                    resultSet.getString("apellido"),
                    resultSet.getDouble("salario"),
                    resultSet.getInt("idEquipo")
                );
                futbolistaList.add(fut);
            }
        } catch (SQLException e) {
            System.err.println("Errorea: " + e.getMessage());
        }
        return futbolistaList;
    }

    // 3. Jokalari bat gehitu
    public void addFutbolista(Futbolista f) {
        String sql = "INSERT INTO futbolistas (dni, nombre, apellido, salario, idEquipo) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, f.getNan());
            ps.setString(2, f.getIzena());
            ps.setString(3, f.getAbizena());
            ps.setDouble(4, f.getSoldata());
            ps.setInt(5, f.getIdTaldea());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Futbolista getFutbolistaByDni(String dni) {
        String sql = "SELECT * FROM futbolistas WHERE dni = ?";
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Futbolista(rs.getString("dni"), rs.getString("nombre"), 
                                     rs.getString("apellido"), rs.getDouble("salario"), 
                                     rs.getInt("idEquipo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}