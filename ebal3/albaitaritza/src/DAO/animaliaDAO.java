package DAO;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.animaliak;
import model.erabiltzailea;
import utils.DbKonexioa;

public class animaliaDAO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ArrayList<animaliak> getAnimaliak() {
		ArrayList<animaliak> animaliakList = new ArrayList<animaliak>();
		String sql = "SELECT * FROM animaliak";
		try (Connection conn = DbKonexioa.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				animaliak a = new animaliak(rs.getInt("id"), rs.getString("izena"), rs.getInt("adina"),
						rs.getString("mota"), rs.getString("extra"), rs.getInt("idJabea")

				);
				animaliakList.add(a);

			}
			return animaliakList;
		} catch (Exception e) {

		}

		return animaliakList;
	}

	public ArrayList<animaliak> getAnimaliakById(int id) {
		ArrayList<animaliak> animaliakList = new ArrayList<animaliak>();
		String sql = "SELECT * FROM animaliak where idJabea = ?";
		try (Connection conn = DbKonexioa.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {
					animaliak a = new animaliak(rs.getInt("id"), rs.getString("izena"), rs.getInt("adina"),
							rs.getString("mota"), rs.getString("extra"), rs.getInt("idJabea")

					);
					animaliakList.add(a);

				}
			}
			return animaliakList;
		} catch (Exception e) {

		}
		
			

		return animaliakList;
		
	}

	public boolean animaliakUpdate(animaliak a) {
		String sql = "UPDATE animaliak SET izena = ?, adina = ?, mota = ?, extra= ?, idJabea = ? WHERE id = ?";
		try (Connection conn = DbKonexioa.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, a.getIzena());
			ps.setInt(2, a.getAdina());
			ps.setString(3, a.getMota());
			ps.setString(4, a.getExtra());
			ps.setInt(5, a.getIdJabea());
			ps.setInt(6, a.getId());
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteAnimalia(int id) {
		String sql = "DELETE FROM animaliak WHERE id = ?";
		try (Connection conn = DbKonexioa.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, id);
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	public boolean insertAnimalia(animaliak a) {
		String sql = "INSERT INTO animaliak(izena, adina, mota, extra, idJabea) VALUES(?,?,?,?,?)";
		try (Connection conn = DbKonexioa.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, a.getIzena());
			ps.setInt(2, a.getAdina());
			ps.setString(3, a.getMota());
			ps.setString(4, a.getExtra());
			ps.setInt(5, a.getIdJabea());
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
