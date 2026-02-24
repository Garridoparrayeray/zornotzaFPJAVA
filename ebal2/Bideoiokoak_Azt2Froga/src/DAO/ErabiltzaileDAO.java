package DAO;

import java.sql.*;

import java.util.ArrayList;

import model.ErabiltzaileErosketa;
import model.Erabiltzailea;
import utils.DBKonexioa;

public class ErabiltzaileDAO {
	private ArrayList<Erabiltzailea> erabiltzaileLista = new ArrayList<Erabiltzailea>();
	private ArrayList<ErabiltzaileErosketa> erabiltzaileErosketaLista = new ArrayList<ErabiltzaileErosketa>();
	DBKonexioa konexioa = new DBKonexioa();

	public ArrayList<Erabiltzailea> getErabiltzaileak() {
		try (Connection kon = konexioa.Konexioa(); Statement st = kon.createStatement();) {
			String sql = "SELECT * FROM erabiltzaileak;";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Erabiltzailea erab = new Erabiltzailea(rs.getInt("id_erabiltzailea"), rs.getString("izena"),
						rs.getString("emaila"), rs.getInt("adina"));
				erabiltzaileLista.add(erab);
			}
			System.out.println("Erabiltzaileak sartu dira.");

		} catch (SQLException e) {
			System.err.println("SQL ERROREA: " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Errore ezezaguna" + e.getMessage());
		}

		return erabiltzaileLista;

	}

	public ArrayList<Erabiltzailea> getErabiltzaileakAdinNagusia() {
		try (Connection kon = konexioa.Konexioa(); Statement st = kon.createStatement();) {
			String sql = "SELECT * FROM erabiltzaileak WHERE adina >= 18;";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Erabiltzailea erab = new Erabiltzailea(rs.getInt("id_erabiltzailea"), rs.getString("izena"),
						rs.getString("emaila"), rs.getInt("adina"));
				erabiltzaileLista.add(erab);
			}
			System.out.println("Erabiltzaileak sartu dira.");

		} catch (SQLException e) {
			System.err.println("SQL ERROREA: " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Errore ezezaguna" + e.getMessage());
		}

		return erabiltzaileLista;

	}

	public ArrayList<ErabiltzaileErosketa> getErabiltzaileakErosketaTotalak() {
		try (Connection kon = konexioa.Konexioa(); Statement st = kon.createStatement();) {
			String sql = "select e.id_erabiltzailea, e.izena, e.emaila, e.adina, COUNT(er.id_erosketa) AS erosketa_kopurua from erabiltzaileak as e left join erosketak as er on e.id_erabiltzailea = er.id_erabiltzailea group by id_erabiltzailea;";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {

				Erabiltzailea erab = new Erabiltzailea(rs.getInt("e.id_erabiltzailea"), rs.getString("e.izena"),
						rs.getString("e.emaila"), rs.getInt("e.adina"));
				int erosketaKop = rs.getInt("erosketa_kopurua");
				ErabiltzaileErosketa ee = new ErabiltzaileErosketa(erab, erosketaKop);
				erabiltzaileErosketaLista.add(ee);
			}
			System.out.println("Erabiltzaileak sartu dira.");

		} catch (SQLException e) {
			System.err.println("SQL ERROREA: " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Errore ezezaguna" + e.getMessage());
		}

		return erabiltzaileErosketaLista;
	}
	
}
