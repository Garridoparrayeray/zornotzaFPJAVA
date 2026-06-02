package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Erreserba;
import model.Klasea;

public class ErreserbakDAO {
	public ArrayList<Erreserba> getErreserbak(int id) {
		String SQL = "SELECT e.idErreserba, e.idBezeroa, e.data, e.idKlasea,k.izena  FROM erreserbak as e join klaseak as k on e.idKlasea = k.idKlasea WHERE e.idBezeroa = ?";
		ArrayList<Erreserba> ErreserbaList = new ArrayList<Erreserba>();
		try (Connection conn = DbConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(SQL);) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Erreserba e = new Erreserba(rs.getInt("e.idErreserba"), rs.getInt("e.idBezeroa"),
							rs.getDate("e.data"), rs.getInt("e.idKlasea"), rs.getString("k.izena"));

					ErreserbaList.add(e);
				}

				return ErreserbaList;
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errorea SQL-an");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Errorea sisteman");
		}

		return ErreserbaList;
	}

	public boolean setErreserba(Erreserba e) {
		String SQL = "INSERT INTO erreserbak set idBezeroa = ?, data = ?, idKlasea = ?";
		try (Connection conn = DbConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(SQL)) {
			ps.setInt(1, e.getIdBezeroa());
			ps.setDate(2, e.getData());
			ps.setInt(3, e.getIdKlasea());
			return ps.executeUpdate() > 0;

		} catch (SQLException e2) {
			JOptionPane.showMessageDialog(null, "Errorea SQL-an");

		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Errorea sisteman");
		}

		return false;
	}
	public void deleteErre(int id) {
		String SQL = "DELETE FROM erreserbak where idErreserba = ?";
		try (Connection conn = DbConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(SQL)) {
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e2) {
			JOptionPane.showMessageDialog(null, "Errorea SQL-an");

		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Errorea sisteman");
		}

	}
}
