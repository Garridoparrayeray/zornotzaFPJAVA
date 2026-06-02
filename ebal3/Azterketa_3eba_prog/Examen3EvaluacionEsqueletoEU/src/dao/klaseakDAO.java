package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Klaseak;

public class klaseakDAO {

	public ArrayList<Klaseak> getKlaseak() {
		ArrayList<Klaseak> KlaseakList = new ArrayList<Klaseak>();
		String sql = "SELECT * FROM klaseak";
		try (Connection conn = DbConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				Klaseak e = new Klaseak(rs.getInt("idKlasea"), rs.getString("izena"), rs.getString("instruktorea"),
						rs.getString("ordutegia"));
				KlaseakList.add(e);
			}
			return KlaseakList;
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "errorea sql-an");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "errorea sisteman");
		}
		return null;
	}

	public boolean setKlaseak(Klaseak k) {
		String sql = "INSERT INTO klaseak (izena, instruktorea, ordutegia) VALUES(?, ?, ?)";
		try(Connection conn = DbConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, k.getIzena());
			ps.setString(2, k.getInstruktorea());
			ps.setString(3, k.getOrdutegia());
			int fila = ps.executeUpdate();
			if(fila > 0) {
				JOptionPane.showMessageDialog(null, "Klasea gehitu da");
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
	
	public boolean updateKlaseak(Klaseak k, int id) {
		String sql = "UPDATE klaseak SET izena = ?, instruktorea = ?, ordutegia = ? WHERE idKlasea = ?";
		try (Connection conn = DbConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, k.getIzena());
			ps.setString(2, k.getInstruktorea());
			ps.setString(3, k.getOrdutegia());
			ps.setInt(4, id);
			int fila = ps.executeUpdate();
			if (fila > 0) {
				JOptionPane.showMessageDialog(null, "ondo sartu da");
			}
			return true;
		} catch(SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "errorea sql-an");

		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "errorea sisteman");
			
		}
	
	
		return false;
	}

}
