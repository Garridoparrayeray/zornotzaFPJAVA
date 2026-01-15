package DDBB;               // BBDD karpetan dauden klaseak erabili ahal izateko

import java.sql.Connection;// DDBB kudeatzeko behar diren liburutegiak
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Modelua.Futbolista;


public class FutbolistaConnect {
	// MySQL datu-basearekiko konexioa ezartzeaz arduratzen da. Eta egitura hau du:
	private Connection conexion() {
		String url = "jdbc:mysql://localhost:3306/futbol";   // DDBBa gordeta dagoen URLa
        String username = "root";            				 // DDBBra konektatzeko erabiltzailea
        String password = "";								 // DDBBra konektatzeko gakoa
        Connection konexioa = null;
        try {
        	// Kontrolatzaileari 3 parametro pasa behar zaizkio: 
        	// DDBBko URLa jakiteko nora konektatu behar duen, konexioa egiteko erabiltzailea eta horren gakoa
        	konexioa = DriverManager.getConnection(url, username, password);
        	
        	// Konexioa ondo egin bada (OK) hurrengo mezua aterako dugu.
            System.out.println("Datu basera konektatuta");
            
        } catch (SQLException e) {   // lerro honek errorerik dagoenean horren informazioa hartzen du
        	// Konexioa ondo ez bada egin(KO) hurrengo mezua aterako dugu.        	
            System.out.println("Errorea konektatzen " + e.getMessage());
        }
 
		return konexioa; //Kontrola bueltatzen dio programari Konexioaren emaitzarekin
	}
	
	// Futbolistaren datuak bere NANaren baitan lortzeko klasea da. 
	// Erroreak egon ahal direnez throws SQLException jarri behar da.
	public Futbolista getFutbolistaIDtik(String id) throws SQLException {
		Connection con = conexion(); 			// con izeneko Connection motako objektua sortzen dugu.
		Statement st = con.createStatement();   // st izeneko Statement motako objektua sortzen dugu.
												// Eta SQL kontsulta egiteko con objektua erabiltzen dugu.
		// DDBBan kontsulta egiteko kontsulta aldagaia erabiltzen dugu
		String kontsulta= "SELECT * FROM futbolistas WHERE dni='"+id+"';";  
		// kontsultaren emaitza resultSet aldagaian jasotzen dugu eta kontsulta aldagaia pasatzen diogu
        ResultSet resultSet = (ResultSet) st.executeQuery(kontsulta);
        Futbolista fut=new Futbolista();
        // DDBB erregistroak dauden bitartean datuak Futbolista klasera esleitzen dizkiogu. 
        // Kontuaz urdinez dauden izenak ezin dira aldatu (DDBBko eremuak direlako)
        while (resultSet.next()) {
            String izena = resultSet.getString("nombre");
            String abizenak= resultSet.getString("apellido");
            Double soldata = resultSet.getDouble("salario");
            int taldea= resultSet.getInt("idEquipo");
            fut = new Futbolista(id, izena, abizenak, soldata, taldea);
        }
		return fut; // kontrola programara itzultzen da irakurritako datuekin
	}
	
	// DDBBan Futbolista berri baten datuak gordetzeko
	public void futbolistaSortu(Futbolista fut) throws SQLException {
		Connection kon = conexion();
		Statement st = kon.createStatement();
		// Oraingoan SQL kontsulta datuak txertatzeko denez INSERT hitzarekin hasten da.
		String kontsulta= "INSERT INTO futbolistas "
				+ "(dni, nombre, apellido, salario, idEquipo) VALUES ('"
				+fut.getNan()+"', '"
				+fut.getIzena()+"', '"
				+fut.getAbizena()+"', '"
				+fut.getSoldata()+"', '"
				+fut.getIdTaldea()+"');";
		int emaitza = st.executeUpdate(kontsulta);  
		// Kontsulta exekutatzen da eta horren emaitza jasotzen da
		if (emaitza > 0 ) {
			System.out.println("Futbolista ondo sortu da.");
		} else {
			System.out.println("Futbolista ezin izan da sortu.");
		}
		kon.close();   // Konexioa itxi egiten da.
	}
	
	// DDBBan Futbolista baten datuak ezabatzeko
	public void futbolistaEzabatu(String NANFut) throws SQLException {
		Connection con = conexion(); 			// Connection motako objektua sortzen da
		Statement st = con.createStatement();	// Konexioa egiteko
		// datuak ezabatu behar direnean SQL agindua DELETE hitzarekin hasten da
		String kontsulta= "DELETE FROM usuarios WHERE id='"+NANFut+"'";

		st.execute(kontsulta);     // Kontsulta egiten da kontsulta parametroa pasatuz		
		
	}
	
	// Futbolista taulan dauden futbolisten datuak ateratzen ditu.
	public ArrayList<Futbolista> getFutbolistak() throws SQLException {
		Connection con = conexion();
		Statement st = con.createStatement();
		String consulta= "SELECT * FROM futbolistas;";
        ResultSet resultSet = (ResultSet) st.executeQuery(consulta);
		ArrayList<Futbolista> futbolistaList=new ArrayList<Futbolista>();
		try {
	        // DDBB erregistroak dauden bitartean datuak Futbolista arraiListera esleitzen dizkio. 
	        // Kontuaz urdinez dauden izenak ezin dira aldatu (DDBBko eremuak direlako)
        while (resultSet.next()) {
        	Futbolista fut =new Futbolista(); 
            fut.setNan(resultSet.getString("dni"));
            fut.setIzena(resultSet.getString("nombre"));
            fut.setAbizena(resultSet.getString("apellido"));
            fut.setSoldata(resultSet.getInt("salario"));
            fut.setIdTaldea(resultSet.getInt("idEquipo"));
            futbolistaList.add(fut);    
        	}
        } catch (Exception e) {    // errorerik agertzekotan horien intformazioa jasotzenko da
        	System.err.println("getFutbolistak metodoan errorea");		//Errorea gertatu dela adierazten du
        }
		return futbolistaList;    // Kontsultaren datuak pasatzen dira programara
	}
}
	

