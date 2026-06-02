package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Erreserbak;
import model.Gela;
import utils.DbKonexioa;

public class GelaDAO {
	public ArrayList<Gela> getGela() {
		String sql = "SELECT * FROM gelak";
		ArrayList<Gela> gelaList = new ArrayList<Gela>();
		try (Connection conn = DbKonexioa.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				Gela g = new Gela(rs.getInt("id"), rs.getInt("solairua"), rs.getDouble("prezioa"), rs.getString("mota"), rs.getString("extra"));
				gelaList.add(g);
			}
			return gelaList;

		} catch (Exception e) {
			// TODO: handle exception
		}

		return gelaList;

	}
	
	public void addGela(Gela g) {
		String sql = "INSERT INTO gelak (solairua, prezioa, mota, extra) VALUES(?,?,?,?)";
		try(Connection conn = DbKonexioa.getConnection();PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setInt(1, g.getSolairua());
			ps.setDouble(2, g.getPrezioa());
			ps.setString(3, g.getMota());
			ps.setString(4, g.getExtra());
			if(ps.executeUpdate() > 0) {
				JOptionPane.showConfirmDialog(null, "Gela sartu da");
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void deleteGela(int id) {
		
	}
	
	public void updateGela(Gela g) {
		
	}
}