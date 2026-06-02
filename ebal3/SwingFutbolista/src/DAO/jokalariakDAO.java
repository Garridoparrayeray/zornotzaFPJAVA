package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.futbolaria;

public class jokalariakDAO {
	public ArrayList<futbolaria> getFutbolaria() {
		ArrayList<futbolaria> futLista = new ArrayList<futbolaria>();
		taldeakDAO DAO = new taldeakDAO();
		String sql = "SELECT * FROM futbolistas";
		try (Connection conn = DbConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				futbolaria fut = new futbolaria(rs.getString("dni"), rs.getString("nombre"), rs.getString("apellido"),
						rs.getInt("salario"), rs.getInt("idEquipo"));
				futLista.add(fut);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return futLista;

	}


	public boolean getFutbolariaById (String nan) {
		ArrayList<futbolaria> futLista = getFutbolaria();
		for(futbolaria f : futLista) {
			if(f.getDni().equals(nan)) {
				return true;
			}
		}
		
		return false;
	}

	public boolean setFutbolaria(String dni, String nombre, String apellido, String Salario, String idEquipo) {
		boolean ondo = false;
		String sql = "INSERT INTO futbolistas VALUES (?, ?, ?, ?, ?)";
		if (dni != "" && nombre != "" && apellido != "" && Salario != "" && idEquipo != "") {
			try (Connection conn = DbConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql);) {
				ps.setString(1, dni);
				ps.setString(2, nombre);
				ps.setString(3, apellido);
				ps.setInt(4, Integer.parseInt(Salario));
				ps.setInt(5, Integer.parseInt(idEquipo));
				ps.executeUpdate();
				ondo = true;
				return ondo;
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		JOptionPane.showMessageDialog(null, "Kanpo guztiak sartu behar dira.");

		return ondo;
	}
}
