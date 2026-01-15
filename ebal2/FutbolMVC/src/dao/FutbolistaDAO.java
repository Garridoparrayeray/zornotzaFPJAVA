package dao;

// BBDD karpetan dauden klaseak erabili ahal izateko

import java.sql.Connection; // DDBB kudeatzeko behar diren liburutegiak
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Futbolista;
import model.Taldea;

public class FutbolistaDAO {
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

    // 1. Jokalariak ikusi
    // Futbolista taulan dauden futbolisten datuak ateratzen ditu.
    public ArrayList<Futbolista> getFutbolistak() throws SQLException {
        ArrayList<Futbolista> futbolistaList = new ArrayList<>();

        // Try-with-resources automatikoki itxi egiten du Connection, Statement eta ResultSet
        try (Connection con = conexion();
             Statement st = con.createStatement();
             ResultSet resultSet = st.executeQuery("SELECT * FROM futbolistas;")) {

            // DDBB erregistroak dauden bitartean datuak Futbolista arraiListera esleitzen dizkio.
            // Kontuaz urdinez dauden izenak ezin dira aldatu (DDBBko eremuak direlako)
            while (resultSet.next()) {
                Futbolista fut = new Futbolista();
                fut.setNan(resultSet.getString("dni"));
                fut.setIzena(resultSet.getString("nombre"));
                fut.setAbizena(resultSet.getString("apellido"));
                fut.setSoldata(resultSet.getInt("salario"));
                fut.setIdTaldea(resultSet.getInt("idEquipo"));
                futbolistaList.add(fut);
            }

        } catch (SQLException e) { // errorerik agertzekotan horien informazioa jasotzenko da
            System.err.println("getFutbolistak metodoan errorea: " + e.getMessage()); // Errorea gertatu dela adierazten du
        }

        return futbolistaList; // Kontsultaren datuak pasatzen dira programara
    }

    // 3. Jokalaria gehitu
    // DDBBan Futbolista berri baten datuak gordetzeko
    public void futbolistaSortu(Futbolista fut) throws SQLException {
        String kontsulta = "INSERT INTO futbolistas "
                + "(dni, nombre, apellido, salario, idEquipo) VALUES ('"
                + fut.getNan() + "', '"
                + fut.getIzena() + "', '"
                + fut.getAbizena() + "', '"
                + fut.getSoldata() + "', '"
                + fut.getIdTaldea() + "');";

        try (Connection con = conexion();
             Statement st = con.createStatement()) {

            int emaitza = st.executeUpdate(kontsulta);  
            // Kontsulta exekutatzen da eta horren emaitza jasotzen da
            if (emaitza > 0 ) {
                System.out.println("Futbolista ondo sortu da.");
            } else {
                System.out.println("Futbolista ezin izan da sortu.");
            }

        } catch (SQLException e) {
            System.err.println("futbolistaSortu metodoan errorea: " + e.getMessage());
        }
    }

    // 5. Jokalaria bilatu ID (DNI) bidez
    // Futbolistaren datuak bere NANaren baitan lortzeko klasea da. 
    // Erroreak egon ahal direnez throws SQLException jarri behar da.
    public Futbolista getFutbolistaIDtik(String id) throws SQLException {
        Futbolista fut = null;
        String kontsulta = "SELECT * FROM futbolistas WHERE dni='" + id + "';";

        try (Connection con = conexion();
             Statement st = con.createStatement();
             ResultSet resultSet = st.executeQuery(kontsulta)) {

            // DDBB erregistroak dauden bitartean datuak Futbolista klasera esleitzen dizkiogu. 
            while (resultSet.next()) {
                String izena = resultSet.getString("nombre");
                String abizenak = resultSet.getString("apellido");
                Double soldata = resultSet.getDouble("salario");
                int taldea = resultSet.getInt("idEquipo");
                fut = new Futbolista(id, izena, abizenak, soldata, taldea);
            }

        } catch (SQLException e) {
            System.err.println("getFutbolistaIDtik metodoan errorea: " + e.getMessage());
        }

        return fut; // kontrola programara itzultzen da irakurritako datuekin
    }

    // 7. Jokalaria ezabatu id-aren bidez
    // DDBBan Futbolista baten datuak ezabatzeko
    public void futbolistaEzabatu(String NANFut) throws SQLException {
        String kontsulta = "DELETE FROM futbolistas WHERE dni='" + NANFut + "'";

        try (Connection con = conexion();
             Statement st = con.createStatement()) {

            st.execute(kontsulta); // Kontsulta egiten da kontsulta parametroa pasatuz
            System.out.println("Futbolista ondo ezabatu da!!");

        } catch (SQLException e) {
            System.err.println("futbolistaEzabatu metodoan errorea: " + e.getMessage());
        }
    }
}
