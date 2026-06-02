package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Erreserbak;

public class ErreserbakDAO {

	public ArrayList<Erreserbak> getErreserbak(int id) {
		ArrayList<Erreserbak> ErreserbakList = new ArrayList<Erreserbak>();
		String sql = "SELECT e.idErreserba, e.data, k.izena FROM erreserbak as e JOIN klaseak as k on e.idKlasea = k.idKlasea WHERE idBezeroa = ?";
		try (Connection conn = DbConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, id);
			try(ResultSet rs = ps.executeQuery()){
				while (rs.next()) {
					Erreserbak e = new Erreserbak(rs.getInt("e.idErreserba"), rs.getString("k.izena"), rs.getDate("e.data"));
					ErreserbakList.add(e);
				}
				return ErreserbakList;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "errorea sql-an");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "errorea sisteman");
		}
		return null;
	}

	public boolean setErreserbak(Erreserbak k) {
		ArrayList<Erreserbak> ErreserbakList = getErreserbak(k.getIdBezeroa());
		String sql = "INSERT INTO erreserbak (data, idKlasea) VALUES(?, ?) WHERE idBezero = ?";
		try (Connection conn = DbConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setDate(1, k.getData());
			ps.setInt(2, k.getIdKlasea());
			ps.setInt(3, k.getIdBezeroa());

			int fila = ps.executeUpdate();
			if (fila > 0) {
				JOptionPane.showMessageDialog(null, "Erreserba gehitu da");
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "errorea sql-an");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "errorea sisteman");
		}

		return false;
	}

	public boolean deleteErreserbak(int id) {
		String SQL = "DELETE FROM erreserbak WHERE idErreserba = ?";
		try(Connection conn = DbConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(SQL)){
			ps.setInt(1, id);
			int fila = ps.executeUpdate();
			if (fila > 0) {
				JOptionPane.showMessageDialog(null, "Erreserba ezabatu da");
				return true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "errorea sql-an");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "errorea sisteman");
		}
		return false;
	}
}
