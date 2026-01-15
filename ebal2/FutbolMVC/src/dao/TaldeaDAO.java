package dao; // DDBB karpetan dauden klaseak erabili ahal izateko

import java.sql.Connection;    // DDBB kudeatzeko behar diren liburutegiak
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Taldea;

public class TaldeaDAO {

    // MySQL datu-basearekiko konexioa ezartzeaz arduratzen da. Eta egitura hau du:
    private static Connection conexion() {
        String url = "jdbc:mysql://localhost:3306/futbol?useSSL=false&serverTimezone=UTC";
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

    // 2. Taldeak ikusi
    // Taldea taulan dauden futbolisten datuak ateratzen ditu.
    public ArrayList<Taldea> getTaldeak() throws SQLException {
        ArrayList<Taldea> taldeaList = new ArrayList<>();

        // Try-with-resources automatikoki itxi egiten du Connection, Statement eta ResultSet
        try (Connection con = conexion();
             Statement st = con.createStatement();
             ResultSet resultSet = st.executeQuery("SELECT * FROM equipos;")) {

            while (resultSet.next()) {
                Taldea talde = new Taldea();
                talde.setIdTaldea(resultSet.getInt("idEquipo"));
                talde.setIzena(resultSet.getString("nombre"));
                talde.setHerria(resultSet.getString("ciudad"));
                taldeaList.add(talde);
            }

        } catch (SQLException e) {
            System.err.println("getTaldeak metodoan errorea: " + e.getMessage());
            e.printStackTrace(); // Errorea gertatu dela adierazten du
        }

        return taldeaList;
    }

    // 4. Taldea gehitu
    // DDBBan Talde berri baten datuak gordetzeko
    public void taldeaSortu(Taldea talde) throws SQLException {
        String kontsulta = "INSERT INTO equipos "
                + "(idEquipo, nombre, ciudad) VALUES ('"
                + talde.getIdTaldea() + "', '"
                + talde.getIzena() + "', '"
                + talde.getHerria() + "');";

        try (Connection con = conexion();
             Statement st = con.createStatement()) {

            int emaitza = st.executeUpdate(kontsulta);
            if (emaitza > 0) {
                System.out.println("Taldea ondo sortu da!!");
            } else {
                System.out.println("Taldea ezin izan da sortu!!");
            }

        } catch (SQLException e) {
            System.err.println("taldeaSortu metodoan errorea: " + e.getMessage());
        }
    }

    // 6. Taldea bilatu ID bidez
    // Taldearen datuak bere IDaren baitan lortzeko klasea da. 
    public Taldea getTaldeaIDtik(int id) throws SQLException {
        Taldea talde = null;
        String kontsulta = "SELECT * FROM equipos WHERE idEquipo=" + id + ";";

        try (Connection con = conexion();
             Statement st = con.createStatement();
             ResultSet resultSet = st.executeQuery(kontsulta)) {

            while (resultSet.next()) {
                String izena = resultSet.getString("nombre");
                int idTaldea = resultSet.getInt("idEquipo");
                String hiria = resultSet.getString("ciudad");
                talde = new Taldea(idTaldea, izena, hiria);
            }

        } catch (SQLException e) {
            System.err.println("getTaldeaIDtik metodoan errorea: " + e.getMessage());
        }

        return talde;
    }

    // 8. Taldea ezabatu id-aren bidez
    // DDBBan Taldea baten datuak ezabatzeko
    public void taldeaEzabatu(int idTaldea) throws SQLException {
        String kontsulta = "DELETE FROM equipos WHERE idEquipo='" + idTaldea + "'";

        try (Connection con = conexion();
             Statement st = con.createStatement()) {

            st.execute(kontsulta);
            System.out.println("Taldea ondo ezabatu da!!");

        } catch (SQLException e) {
            System.err.println("taldeaEzabatu metodoan errorea: " + e.getMessage());
        }
    }
}
