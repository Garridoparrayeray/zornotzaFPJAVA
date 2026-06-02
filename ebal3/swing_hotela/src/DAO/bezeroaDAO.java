package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.bezeroa;
import utils.DbKonexioa;

public class bezeroaDAO {
	public ArrayList<bezeroa> getBezeroak() {
		ArrayList<bezeroa> bezLista = new ArrayList<bezeroa>();
		String sql = "SELECT * FROM bezeroak";
		boolean guztiak = false;
		try (Connection conn = DbKonexioa.lortuKonexioa();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				bezeroa bez = new bezeroa(rs.getInt("id"), rs.getString("izena"), rs.getString("abizena"),
						rs.getString("dni"), rs.getString("telefonoa"));
				bezLista.add(bez);
				guztiak = true;
			}
			if (guztiak == true) {
				JOptionPane.showMessageDialog(null, "Guztiak sartu dira");
			} else if (guztiak == false) {
				JOptionPane.showMessageDialog(null, "Errorea sartzerakoan, ez dira guztiak sartu");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errorea SQL-an");
			e.printStackTrace();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Errorea sisteman");
			e.printStackTrace();
		}
		return bezLista;
	}

	public boolean editBez(bezeroa b) {
		String sql = "UPDATE bezeroak SET izena = ?, abizena = ?, dni = ?, telefonoa = ? WHERE id = ?";
		try(Connection conn = DbKonexioa.lortuKonexioa(); PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, b.getIzena());
			ps.setString(2, b.getAbizena());
			ps.setString(3, b.getDni());
			ps.setString(4, b.getTelefonoa());
			ps.setInt(5, b.getId());
			if (ps.executeUpdate() > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errorea SQL-an");
			e.printStackTrace();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Errorea sisteman");
			e.printStackTrace();
		}
		return false;
	}
	public boolean addBez(bezeroa b) {
		String sql = "INSERT INTO bezeroak VALUES (?,?,?,?,?)";
		try (Connection conn = DbKonexioa.lortuKonexioa(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, b.getId());
			ps.setString(2, b.getIzena());
			ps.setString(3, b.getAbizena());
			ps.setString(4, b.getDni());
			ps.setString(5, b.getTelefonoa());
			ps.executeUpdate();
			int query = ps.getUpdateCount();

			if (query > -1) {
				JOptionPane.showMessageDialog(null, "Gehitu da");
				return true;
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errorea SQL-an");
			e.printStackTrace();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Errorea sisteman");
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteBez(bezeroa b) {
		String sql = "DELETE FROM bezeroak where id = ?";
		try (Connection conn = DbKonexioa.lortuKonexioa(); PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, b.getId());
			ps.executeUpdate();
			int query = ps.getUpdateCount();

			if (query > -1) {
				JOptionPane.showMessageDialog(null, "Ezabatu da");
				return true;
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errorea SQL-an");
			e.printStackTrace();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Errorea sisteman");
			e.printStackTrace();
		}
		return false;
	}

	/*REPASAR*/
	public bezeroa getBezByd(int id) {
	    String sql = "SELECT * FROM bezeroak WHERE id = ?";
	    
	    try (Connection conn = DbKonexioa.lortuKonexioa(); 
	         PreparedStatement ps = conn.prepareStatement(sql)) {
	        
	        ps.setInt(1, id);
	        
	        try (ResultSet rs = ps.executeQuery()) {
	            
	            if (rs.next()) {
	                return new bezeroa(
	                    rs.getInt("id"),
	                    rs.getString("izena"),
	                    rs.getString("abizena"),
	                    rs.getString("dni"),
	                    rs.getString("telefonoa")
	                );
	            }
	        }
	        
	    } catch (SQLException e) {
	        JOptionPane.showMessageDialog(null, "Errorea SQL-an: " + e.getMessage());
	        e.printStackTrace();
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "Errorea sisteman: " + e.getMessage());
	        e.printStackTrace();
	    }
	    
	    return null; 
	}
	
	
}
