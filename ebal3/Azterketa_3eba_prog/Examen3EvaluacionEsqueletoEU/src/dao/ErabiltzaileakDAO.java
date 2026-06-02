package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Erabiltzaileak;
public class ErabiltzaileakDAO {
		public ArrayList<Erabiltzaileak> getErabiltzaileak(){
			ArrayList<Erabiltzaileak> erabList = new ArrayList<Erabiltzaileak>();
			String sql = "SELECT * FROM erabiltzaileak";
			try(Connection conn = DbConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					Erabiltzaileak e = new Erabiltzaileak(
							rs.getInt("idErabiltzailea"), 
							rs.getString("izena"),
							rs.getString("pasahitza"),
							rs.getString("rola")
							);
					erabList.add(e);
				}
				return erabList;
			}catch(SQLException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "errorea sql-an");
			}
			catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "errorea sisteman");
			}
			return null;
		}

}
