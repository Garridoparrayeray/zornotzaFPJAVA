package liburutegiDAO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;//se  ha intentado jajaja
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.*;
import utils.*;

public class liburutegiDAO {
	public DDBBKonexioa con = new DDBBKonexioa();
	public ArrayList<Liburua> liburutegia = new ArrayList<>();

	public ArrayList<Liburua> getLiburuak() {
		liburutegia.clear(); // daturen bat badeko kendu
		String sql = "SELECT * FROM Liburuak";
		try {
			Connection kon = con.Konexioa();
			Statement st = kon.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				String isbn = rs.getString("isbn");
				String izenburua = rs.getString("izenburua");
				String egilea = rs.getString("egilea");
				int OrriKopurua = rs.getInt("orriKopurua");
				boolean mailegatuta = rs.getBoolean("mailegatuta");
				Liburua lib = new Liburua(izenburua, egilea, isbn, OrriKopurua, mailegatuta);
				liburutegia.add(lib);

			}
			System.out.println("Liburuak gehitu dira.");
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return liburutegia;
	}

	public void setLiburuak(Liburua liburua) throws Exception {
		getLiburuak();
		for (Liburua l : liburutegia) {
			if (l.getIsbn().equals(liburua.getIsbn())) {
				throw new Exception("Liburu hori (ISBN: " + liburua.getIsbn() + ") jadanik BBDD-an dago.");
			}
		}
		Connection kon = con.Konexioa();
		String sql = "INSERT INTO Liburuak(isbn, izenburua, egilea, orriKopurua, mailegatuta) VALUES(?, ?, ?, ?, ?)";
		PreparedStatement ps = kon.prepareStatement(sql);
		ps.setString(1, liburua.getIsbn());
		ps.setString(2, liburua.getIzenburua());
		ps.setString(3, liburua.getEgilea());
		ps.setInt(4, liburua.getOrriKopurua());
		ps.setBoolean(5, liburua.isMailegatuta());
		ps.executeUpdate();
		ps.close();
		kon.close();
	}

	public void ezabatuLiburua(String isbn) throws Exception {
		String sql = "DELETE FROM Liburuak WHERE isbn = ?";

		try (Connection kon = con.Konexioa(); PreparedStatement ps = kon.prepareStatement(sql)) {

			ps.setString(1, isbn);

			int ezabatutakoErrenkadak = ps.executeUpdate();

			if (ezabatutakoErrenkadak == 0) {
				throw new Exception("Ez da aurkitu libururik ISBN horrekin.");
			}
		}
	}

	public Liburua bilatuLiburuaByIsbn(String isbn) throws Exception {
		String sql = "SELECT * FROM Liburuak WHERE isbn = ?";

		try (Connection kon = con.Konexioa(); PreparedStatement ps = kon.prepareStatement(sql)) {

			ps.setString(1, isbn);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					String izenburua = rs.getString("izenburua");
					String egilea = rs.getString("egilea");
					int orriKopurua = rs.getInt("orriKopurua");
					boolean mailegatuta = rs.getBoolean("mailegatuta");

					return new Liburua(izenburua, egilea, isbn, orriKopurua, mailegatuta);
				} else {
					throw new Exception("Ez da aurkitu liburua (" + isbn + ") ISBN horrekin.");
				}
			}
		}
	}

	public void aldatuLiburua(String isbn, int orriBerriak, boolean mailegatutaBerria) throws Exception {
		String sql = "UPDATE Liburuak SET orriKopurua = ?, mailegatuta = ? WHERE isbn = ?";

			Connection kon = con.Konexioa(); 
			PreparedStatement ps = kon.prepareStatement(sql);
			ps.setInt(1, orriBerriak);
			ps.setBoolean(2, mailegatutaBerria);
			ps.setString(3, isbn);

			int aldatutakoErrenkadak = ps.executeUpdate();

			if (aldatutakoErrenkadak == 0) {
				throw new Exception("Ezin izan da eguneratu: Ez da aurkitu libururik ISBN horrekin.");
			}
			ps.close();
			kon.close();
	}
	public void deskargatuTxt(String fitxategiIzena) throws Exception {
		ArrayList<Liburua> lista = getLiburuak();
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fitxategiIzena))) {
			
			for (Liburua l : lista) {
				bw.write(l.toString() + "\n");
			}
			
		} catch (IOException e) {
			throw new Exception("Errorea idaztean: " + e.getMessage());
		}
	}
	public void kargatuTxt(String fitxategiIzena) throws Exception {
		try (BufferedReader br = new BufferedReader(new FileReader(fitxategiIzena))) {
			
			String linea;
			int kargatutakoak = 0;
			
			while ((linea = br.readLine()) != null) {
				
				String[] datuak = linea.split(";");
				
				if (datuak.length == 5) {
					String isbn = datuak[0];
					String izenburua = datuak[1];
					String egilea = datuak[2];
					int orriak = Integer.parseInt(datuak[3]);
					boolean mailegatuta = Boolean.parseBoolean(datuak[4]);
					
					Liburua liburuaTXT = new Liburua(izenburua, egilea, isbn, orriak, mailegatuta);
					
					try {
						setLiburuak(liburuaTXT); 
						kargatutakoak++;
					} catch (Exception e) {
					
					}
				}
			}
			
			if (kargatutakoak == 0) {
				throw new Exception("Ez da libururik kargatu. Fitxategia hutsik dago edo liburu guztiak jadanik BBDD-an daude.");
			}
			
		} catch (IOException e) {
			throw new Exception("Fitxategia ez da aurkitu edo ezin da irakurri: " + e.getMessage());
		}
	}

}
