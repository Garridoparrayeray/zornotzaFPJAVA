package controller;

import javax.swing.JOptionPane;

import DAO.erabiltzaileakDAO;
import model.Erabiltzailea;
import view.AdminPantaila;
import view.BezeroaPantaila;
import view.LoginPantaila;

public class loginKontrolatzailea {
	private erabiltzaileakDAO erabDAO = new erabiltzaileakDAO();

	public loginKontrolatzailea(LoginPantaila leihoa) {
		
		leihoa.btnSaioaHasi.addActionListener(e ->{
			for (Erabiltzailea erab : erabDAO.getErabiltzaileak()) {
				if (leihoa.txtIzena.getText().equals(erab.getIzena())
						&& leihoa.txtPasahitza.getText().equals(erab.getPasahitza())) {
					if( erab.getMota().equals("ADMIN")) {
						JOptionPane.showMessageDialog(null, "Login zuzena");
						AdminPantaila leihoberria = new AdminPantaila();
						new AdminPantailaKontrolatzailea(
								leihoberria);
						leihoberria.setVisible(true);
						leihoa.setVisible(false);
					}
					else if(erab.getMota().equals("BEZEROA")) {
						BezeroaPantaila leihoberria = new BezeroaPantaila();
						new BezeroPantailaKontrolatzailea(
								leihoberria, erab);
						leihoberria.setVisible(true);
						leihoa.setVisible(false);
						JOptionPane.showMessageDialog(null, "Login zuzena");
					}else {
						JOptionPane.showMessageDialog(null, "Login ez zuzena, konprobatu zure kredentzialak");

					}
				}
			}
		
		});
	
	}
		
	}


