package DDBB;		// DDBB karpetan dauden klaseak erabili ahal izateko

import java.sql.Connection;    // DDBB kudeatzeko behar diren liburutegiak
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Modelua.Taldea;

public class TaldeaConnect {
	
	// MySQL datu-basearekiko konexioa ezartzeaz arduratzen da. Eta egitura hau du:
	private static Connection conexion() {
		String url = "jdbc:mysql://localhost:3306/futbol";
        String username = "root";
        String password = "";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Datu basera konektatuta");
            
        } catch (SQLException e) {
            System.out.println("Errorea konektatzen: " + e.getMessage());
	        e.printStackTrace();
        }        
		return connection;
	}

	// Taldea taulan dauden futbolisten datuak ateratzen ditu.
	public ArrayList<Taldea> getTaldeak() throws SQLException {
		Connection kon = conexion();
		Statement st = kon.createStatement();
		String consulta= "SELECT * FROM equipos;";
        ResultSet resultSet = (ResultSet) st.executeQuery(consulta);
		ArrayList<Taldea> taldeaList=new ArrayList<Taldea>();
        
        try {
        while (resultSet.next()) {
        	Taldea talde =new Taldea();
        	talde.setIdTaldea(resultSet.getInt("idEquipo"));
            talde.setIzena(resultSet.getString("nombre"));
            talde.setHerria(resultSet.getString("ciudad"));
            
            taldeaList.add(talde);
            System.out.println(taldeaList.toString());   // konprobatzeko irakurtzen duen
        }
        }
        catch (Exception e) {
        	System.err.println("getTaldeak metodoan errorea."+ e.getMessage());
            e.printStackTrace();  // Muestra la traza del error);
        }        
		return taldeaList;
	}
	
	// Taldearen datuak bere NANaren baitan lortzeko klasea da. 
	// Erroreak egon ahal direnez throws SQLException jarri behar da.
	public Taldea getTaldeaIDtik(int id) throws SQLException {
		Connection con = conexion();
		Statement st = con.createStatement();
		String kontsulta= "SELECT * FROM equipos WHERE idEquipo="+id+";";
        ResultSet resultSet = (ResultSet) st.executeQuery(kontsulta);
        Taldea talde= new Taldea();
        while (resultSet.next()) {
            String izena = resultSet.getString("nombre");
            int idTaldea= resultSet.getInt("idEquipo");
            String hiria= resultSet.getString("ciudad");
            talde = new Taldea(idTaldea, izena, hiria);
        }
		return talde;
	}

	// DDBBan Talde berri baten datuak gordetzeko
	public void taldeaSortu(Taldea talde) throws SQLException {
		Connection kon = conexion();
		Statement st = kon.createStatement();
		String kontsulta= "INSERT INTO equipos "
				+ "(idEquipo, nombre, ciudad) VALUES ('"
				+talde.getIdTaldea()+"', '"
				+talde.getIzena()+"', '"
				+talde.getHerria()+"');";
        
		st.execute(kontsulta);
		
		System.out.println("Taldea ondo sortu da!!");
		kon.close();
	}
	
	// DDBBan Taldea baten datuak ezabatzeko
	public void taldeaEzabatu(int idTaldea) throws SQLException {
		Connection kon = conexion();
		Statement st = kon.createStatement();
		String kontsulta= "DELETE FROM Taldea WHERE id='"+idTaldea+"'";
	        
		st.execute(kontsulta);
		
		System.out.println("Taldea ondo ezabatu da!!");
		kon.close();

	}

}



