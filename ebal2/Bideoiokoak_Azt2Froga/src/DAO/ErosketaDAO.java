package DAO;

import java.sql.*;

import java.util.ArrayList;

import model.Erosketa;
import utils.DBKonexioa;

public class ErosketaDAO {
	DBKonexioa konexioa = new DBKonexioa();

	public ArrayList<Erosketa> getErosketak() {
		ArrayList<Erosketa> ErosketaLista = new ArrayList<Erosketa>();

		try (Connection kon = konexioa.Konexioa(); Statement st = kon.createStatement();) {
			String sql = "select id_erosketa, e.izena, bi.izena from erabiltzaileak as e join erosketak on e.id_erabiltzailea = erosketak.id_erabiltzailea join bideojokoak as bi on erosketak.id_bideojokoa = bi.id_bideojokoa;";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Erosketa erosketa = new Erosketa(rs.getInt("id_erosketa"), rs.getString("e.izena"), rs.getString("bi.izena")); 
				ErosketaLista.add(erosketa);
			}
			System.out.println("Erosketak sartu dira.");

		} catch (SQLException e) {
			System.err.println("SQL ERROREA: " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Errore ezezaguna" + e.getMessage());
		}

		return ErosketaLista;

	}
}
