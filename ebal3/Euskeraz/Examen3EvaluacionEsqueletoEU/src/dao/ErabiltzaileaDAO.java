package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Erabiltzailea;

public class ErabiltzaileaDAO {
	public ArrayList<Erabiltzailea> getErabiltzaileak(){
		String SQL = "SELECT * FROM erabiltzaileak";
		ArrayList<Erabiltzailea> erabList = new ArrayList<Erabiltzailea>();
		try(Connection conn = DbConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(SQL); ResultSet rs = ps.executeQuery()){
			while(rs.next()) {
				Erabiltzailea erab = new Erabiltzailea(
						rs.getInt("idErabiltzailea"),
						rs.getString("izena"),
						rs.getString("pasahitza"),
						rs.getString("rola")
						);
				
				erabList.add(erab);
			}
			
			return erabList;
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errorea SQL-an");
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Errorea sisteman");
		}
		
		return erabList;
		
	}
}
