package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.langileak;

public class LangileaDAO {
	/*METODO OROKORRA*/
//	
//	public ArrayList<langileak> getLangileak() throws SQLException{
//		ArrayList<langileak> langileakList = new ArrayList<>();
//		try(Connection con = konexioa();
//			Statement st = con.createStatement();
//	        ResultSet resultSet = st.executeQuery("SELECT * FROM empleados;")){
//			while(resultSet.next()) {
//				langileak langilea = new langileak();
//				langilea.setId(resultSet.getInt("id"));
//				langilea.setFirst_name(resultSet.getString("first_name"));
//				langilea.setLast_name(resultSet.getString("last_name"));
//				langilea.setDepartment(resultSet.getString("department"));
//				langilea.setSalario(resultSet.getDouble("salario"));
//				langileakList.add(langilea);
//			}
//		}catch(SQLException e) {
//            System.out.println("metodoan errorea:" + e.getMessage());
//        }
//		return langileakList;
//	}
	
	
	
	
	/* eskatzen den metodoa: "Pantailatik erakutsi eskatzen den kopurutik gorako soldata duten langileak."
	 
	 */
	public ArrayList<langileak> getLangileakSoldatagorako(double gutxienekoSoldata) throws SQLException{
		ArrayList<langileak> langileakList = new ArrayList<>();
		String sql = "Select * FROM empleados WHERE salario > ?";
		try(Connection conn  = utils.Konexioa.getKonexioa();
		PreparedStatement pst = conn.prepareStatement(sql);){
			
			pst.setDouble(1, gutxienekoSoldata);//parametro ?, lehenengoa dela, aldatu gutxieneko soldatagaz
			
			try (ResultSet resultSet = pst.executeQuery()) {//exekutatzen du pst-a non dekogu sql-a SENTENTZIAREKIN
	            while (resultSet.next()) {
	                langileak l = new langileak(); // sortzen dugu objektua exekutatzerakoan
	                l.setId(resultSet.getInt("id"));
	                l.setFirst_name(resultSet.getString("first_name"));
	                l.setLast_name(resultSet.getString("last_name"));
	                l.setDepartment(resultSet.getString("department"));
	                l.setSalario(resultSet.getDouble("salario"));
	                langileakList.add(l); 
	            }
	        }
		}catch(SQLException e) {
			System.err.println("EZ DU FUNTZIONATZEN " + e.getMessage());
		}
		return langileakList;
	}
	
	//eskatzen den metodoa:"Pantailatik eskatzen den gutxieneko eta gehieneko soldata kontutan hartuta, ArrayList batean sartu baldintza horiek betetzen dituzten langileak. ArrayList hori bistaratuko da."
	public ArrayList<langileak> getLangileakSoldataTartekoa(double gutxienekoSoldata, double gehienekoSoldata) throws SQLException{
		ArrayList<langileak> langileakList = new ArrayList<>();
		String sql = "Select * FROM empleados WHERE salario BETWEEN ? AND ?";
		try (Connection conn = utils.Konexioa.getKonexioa();
			PreparedStatement pst = conn.prepareStatement(sql);){
			
				pst.setDouble(1, gutxienekoSoldata);
				pst.setDouble(2, gehienekoSoldata);
				try(ResultSet rs = pst.executeQuery()){
					while(rs.next()) {
					    langileak l = new langileak(); // sortzen dugu objektua exekutatzerakoan
		                l.setId(rs.getInt("id"));
		                l.setFirst_name(rs.getString("first_name"));
		                l.setLast_name(rs.getString("last_name"));
		                l.setDepartment(rs.getString("department"));
		                l.setSalario(rs.getDouble("salario"));
		                langileakList.add(l); 					
		            }
					
					
				}
		}catch(SQLException e) {
			System.err.println("EZ DU FUNTZIONATZEN " + e.getMessage());
		}
		return langileakList;
		
	}
	//eskatzen den metodoa: "Pantailatik eskatzen den departamentuko langileekin gauza bera egin."
	public ArrayList<langileak> getLangileakDepartamentuka(String departamentua){
		ArrayList<langileak> langileakList = new ArrayList<>();
		String sql = "Select * FROM empleados WHERE department = ?";
		try (Connection conn = utils.Konexioa.getKonexioa();
			PreparedStatement pst = conn.prepareStatement(sql);){
			
				pst.setString(1, departamentua);
				try(ResultSet rs = pst.executeQuery()){
					while(rs.next()) {
					    langileak l = new langileak(); // sortzen dugu objektua exekutatzerakoan
		                l.setId(rs.getInt("id"));
		                l.setFirst_name(rs.getString("first_name"));
		                l.setLast_name(rs.getString("last_name"));
		                l.setDepartment(rs.getString("department"));
		                l.setSalario(rs.getDouble("salario"));
		                langileakList.add(l); 					
		            }
					
					
				}
		}catch(SQLException e) {
			System.err.println("EZ DU FUNTZIONATZEN " + e.getMessage());
		}
		return langileakList;
	}
}
