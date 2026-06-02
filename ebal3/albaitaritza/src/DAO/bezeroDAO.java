package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.hitzorduak;
import utils.DbKonexioa;

public class bezeroDAO {
	public ArrayList<hitzorduak> getHitzorduak (int id){
		String sql = "SELECT h.id, h.idJabea, h.idAnimalia, h.data, h.ordua, a.izena FROM hitzorduak as h join animaliak as a on h.idJabea = a.idJabea where h.idJabea = ?";
		ArrayList<hitzorduak> hiList = new ArrayList<hitzorduak>();
		try(Connection conn = DbKonexioa.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setInt(1, id);
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					hitzorduak hitz = new hitzorduak(
						rs.getInt("h.id"),
						rs.getInt("h.idJabea"),
						rs.getInt("h.idAnimalia"),
						rs.getString("a.izena"),
						rs.getDate("h.data"),
						rs.getString("h.ordua")
					);
					hiList.add(hitz);
				}
			}
			
			
			return hiList;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		return hiList;
	}
	
	public boolean setHitzordua(hitzorduak h) {
		String sql = "INSERT INTO hitzorduak(idJabea, idAnimalia, data, ordua) VALUES(?,?,?,?)";
		try (Connection conn = DbKonexioa.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, h.getIdJabea());
			ps.setInt(2, h.getIdAnimalia());
			ps.setDate(3, h.getData());
			ps.setString(4, h.getOrdua());
			return ps.executeUpdate() > 0;

		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	public boolean deleteHitzordua(int id) {
		String sql = "DELETE FROM hitzorduak WHERE id = ?";
		try (Connection conn = DbKonexioa.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, id);
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	
}
