package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Erabiltzailea;
import model.Erreserbak;
import model.Gela;
import utils.DbKonexioa;

public class ErreserbakDAO {
	public ArrayList<Erreserbak> getErreserbak(int bezID) {
		String sql = "SELECT * FROM erreserbak where idBezeroa = ?";
		ArrayList<Erreserbak> erreList = new ArrayList<Erreserbak>();
		try (Connection conn = DbKonexioa.getConnection(); PreparedStatement ps = conn.prepareStatement(sql);) {

			ps.setInt(1, bezID);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Erreserbak erre = new Erreserbak(rs.getInt("id"), rs.getInt("idBezeroa"), rs.getInt("idGela"),
							rs.getDate("data"));
					erreList.add(erre);
				}
			}
			return erreList;

		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;

	}

	public ArrayList<Erreserbak> getErreserbakidGabe() {
		String sql = "SELECT * FROM erreserbak";
		ArrayList<Erreserbak> erreList = new ArrayList<Erreserbak>();
		try (Connection conn = DbKonexioa.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				Erreserbak erre = new Erreserbak(rs.getInt("id"), rs.getInt("idBezeroa"), rs.getInt("idGela"),
						rs.getDate("data"));
				erreList.add(erre);
			}
			return erreList;

		} catch (

		Exception e) {
			// TODO: handle exception
		}

		return null;

	}

	public void insertErreserba(int bezID, LocalDate data, Gela g) {
		String sql = "INSERT INTO erreserbak (idBezeroa, idGela, data) VALUES (?, ?, ?)";
		try (Connection conn = DbKonexioa.getConnection(); PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, bezID);
			ps.setInt(2, g.getId());
			ps.setDate(3, Date.valueOf(data));

			if (ps.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "sartu da");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public boolean deleteErreserba(int reservaID) {
		String sql = "DELETE FROM erreserbak WHERE id = ?";
		
		try(Connection conn = DbKonexioa.getConnection();PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setInt(1, reservaID);
			
			if(ps.executeUpdate()> 0) {
				JOptionPane.showMessageDialog(null, "ezabatu da.");
				return true;
			}else {
				JOptionPane.showMessageDialog(null, "ez da ezabatu.");
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
}
