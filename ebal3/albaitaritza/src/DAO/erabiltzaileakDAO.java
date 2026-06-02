package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.erabiltzailea;
import utils.DbKonexioa;
public class erabiltzaileakDAO {
	public ArrayList<erabiltzailea> getErabiltzaileak(){
		ArrayList<erabiltzailea> erabList = new ArrayList<erabiltzailea>();
		String sql = "SELECT * FROM erabiltzaileak";
		try(Connection conn = DbKonexioa.getConnection(); PreparedStatement ps = conn.prepareStatement(sql);ResultSet rs =  ps.executeQuery()){
			while(rs.next()) {
				erabiltzailea erab = new erabiltzailea(
						rs.getInt("id"),
						rs.getString( "izena"),
						rs.getString("pasahitza"),
						rs.getString("mota")
						
						);
				erabList.add(erab);
				
			}
			return erabList;
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return erabList;
	}
}
