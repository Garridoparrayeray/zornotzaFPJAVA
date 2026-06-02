package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.taldea;

public class taldeakDAO {
	public ArrayList<taldea> getTaldeak() {
		ArrayList<taldea> taldeList = new ArrayList<taldea>();

		String sql = "SELECT * FROM equipos";
		try(Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()){
			while(rs.next()) {
				taldea tal = new taldea(
						rs.getInt("idEquipo"),
						rs.getString("nombre"),
						rs.getString("ciudad")
						);
				taldeList.add(tal);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return taldeList;
		
	}
	public boolean getTaldeakById(String idTaldea){
		ArrayList<taldea> taldeList = new ArrayList<taldea>();

		 taldeList = getTaldeak();
		for(taldea t : taldeList) {
			if(t.getIdEquipo() == Integer.parseInt(idTaldea)) {
				return true;
			}
		}
		return false;
	}
	public void setTaldea (taldea t) {
		String sql = "INSERT INTO equipos VALUES(?, ?, ?)";
		try(Connection conn = DbConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setInt(1, t.getIdEquipo());
			ps.setString(2, t.getNombre());
			ps.setString(3, t.getCiudad());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
