package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Erabiltzailea;
import model.Klasea;

public class KlaseakDAO {
	public ArrayList<Klasea> getKlaseak() {
		String SQL = "SELECT * FROM klaseak";
		ArrayList<Klasea> klaseList = new ArrayList<Klasea>();
		try (Connection conn = DbConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(SQL);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				Klasea k = new Klasea(rs.getInt("idKlasea"), rs.getString("izena"), rs.getString("instruktorea"),
						rs.getString("ordutegia"));

				klaseList.add(k);
			}

			return klaseList;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errorea SQL-an");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Errorea sisteman");
		}

		return klaseList;
	}

	public boolean setKlasea(Klasea k) {
		String SQL = "INSERT INTO klaseak (izena, instruktorea, ordutegia) VALUES (?,?,?)";
		try (Connection conn = DbConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(SQL)) {
			ps.setString(1, k.getIzena());
			ps.setString(2, k.getInstruktorea());
			ps.setString(3, k.getOrdutegia());
			return ps.executeUpdate() > 0;

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errorea SQL-an");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Errorea sisteman");
		}

		return false;
	}

	public boolean updateKlasea(Klasea k) {
		String SQL = "UPDATE klaseak SET izena = ?, instruktorea = ?, ordutegia = ? WHERE idKlasea = ?";
		try (Connection conn = DbConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(SQL)) {
			ps.setString(1, k.getIzena());
			ps.setString(2, k.getInstruktorea());
			ps.setString(3, k.getOrdutegia());
			ps.setInt(4, k.getIdKlasea());
			return ps.executeUpdate() > 0;

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errorea SQL-an");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Errorea sisteman");
		}
		return false;
	}
}
