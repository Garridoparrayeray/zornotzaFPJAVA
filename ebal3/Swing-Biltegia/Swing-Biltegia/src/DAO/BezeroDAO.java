package DAO;
import model.Bezeroa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class BezeroDAO {
	public static ArrayList<Bezeroa> bezArrayList = new ArrayList<Bezeroa>();
	public static ArrayList<Bezeroa> getBezeroak(ArrayList<Bezeroa> bezArrayList) {
		String sql = "SELECT * FROM bezeroak";
		try(Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql);ResultSet rs = ps.executeQuery();){
			while(rs.next()) {
				Bezeroa bez = new Bezeroa(rs.getString("id"),
						rs.getString("izena"),
						rs.getString("helbidea"),
						rs.getString("postaKodea"),
						rs.getString("telefonoa"));
				bezArrayList.add(bez);
			}
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Errorea bezeroak gehitzerakoan");
		}
		return bezArrayList;
	}
	public static void UpdateBezeroak(String id, String izena, String helbidea, String postakodea, String telefonoa){
		String sql = "UPDATE bezeroak SET izena =  ?, helbidea = ?, postakodea = ?, telefonoa =  ? WHERE id = ?";
		try (Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql);){
			ps.setString(1, izena);
			ps.setString(2, helbidea);
			ps.setString( 3, postakodea);
			ps.setString(4, telefonoa);
			ps.setString(5, id);
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Bezeroa Aldatuta");
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Errorea bezeroa aldatzerakoan");
		}
		getBezeroak(bezArrayList);
	}
	
	public static void DeleteBezeroak(String id) {
		String sql = "DELETE from bezeroak where id = ?";
		try (Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1, id);
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Bezeroa ezabatua");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Bezeroa ezabatzerakoan errorea");
		}
	}
}
