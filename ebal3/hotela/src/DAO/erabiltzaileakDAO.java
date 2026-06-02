package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Erabiltzailea;
import utils.DbKonexioa;

public class erabiltzaileakDAO {
	public ArrayList<Erabiltzailea> getErabiltzaileak() {
		String sql = "SELECT * FROM erabiltzaileak";
		ArrayList<Erabiltzailea> eraList = new ArrayList<Erabiltzailea>();
		try (Connection conn = DbKonexioa.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while(rs.next()) {
				Erabiltzailea erab = new Erabiltzailea(rs.getInt("id"), rs.getString("izena"), rs.getString("pasahitza"),
						rs.getString("mota"));
						eraList.add(erab);
			}
		
			return eraList;

		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;

	}
}
