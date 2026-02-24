package DAO;

import java.sql.*;

import java.util.ArrayList;

import model.Bideojokoa;

import utils.DBKonexioa;

public class BideojokoakDAO {
	DBKonexioa konexioa = new DBKonexioa();

	public ArrayList<Bideojokoa> getBideojokoak() {
		ArrayList<Bideojokoa> BideojokoLista = new ArrayList<Bideojokoa>();

		try (Connection kon = konexioa.Konexioa(); Statement st = kon.createStatement();) {
			String sql = "SELECT * FROM bideojokoak;";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Bideojokoa bid = new Bideojokoa(rs.getInt("id_bideojokoa"), rs.getString("izena"),
						rs.getString("generoa"), rs.getDouble("prezioa"), rs.getInt("adin_muga"));
				BideojokoLista.add(bid);
			}
			System.out.println("Erabiltzaileak sartu dira.");

		} catch (SQLException e) {
			System.err.println("SQL ERROREA: " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Errore ezezaguna" + e.getMessage());
		}

		return BideojokoLista;

	}

	public ArrayList<Bideojokoa> getBideojokoKonkretua(String generoa) {
		ArrayList<Bideojokoa> BideojokoLista = new ArrayList<Bideojokoa>();
		String sql = "SELECT * FROM bideojokoak WHERE generoa = ?;";
		boolean aurkitu = false;
		try (Connection kon = konexioa.Konexioa(); PreparedStatement ps = kon.prepareStatement(sql)) {
			ps.setString(1, generoa);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {

					Bideojokoa bid = new Bideojokoa(rs.getInt("id_bideojokoa"), rs.getString("izena"),
							rs.getString("generoa"), rs.getDouble("prezioa"), rs.getInt("adin_muga"));
					BideojokoLista.add(bid);
					if (generoa.equals(rs.getString("generoa"))) {
						aurkitu = true;
					}
				}

			}

		} catch (SQLException e) {
			System.err.println("SQL ERROREA: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Zerbait gertatu da." + e.getMessage());

		}
		if (aurkitu == false) {
			System.out.println("Ez dago generorik izen horrekin");
		}
		return BideojokoLista;

	}
	public double getBideojokoBatazBez() {
		double BBez = 0;
		try(Connection kon = konexioa.Konexioa(); Statement st = kon.createStatement()){
			String sql = "select AVG(prezioa) as Batazbesteko_prezioa from bideojokoak;";
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			BBez =  rs.getDouble("Batazbesteko_prezioa");
		}catch(Exception e) {
			System.err.println("Errore ezezaguna" + e.getMessage());
		}
		return BBez;
	}

}
