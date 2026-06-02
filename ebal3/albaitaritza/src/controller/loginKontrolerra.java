package controller;
import view.PantallaAdmin;
import view.PantallaBezeroa;
import view.PantallaLogin;

import javax.swing.JOptionPane;

import DAO.erabiltzaileakDAO;
import model.erabiltzailea;
public class loginKontrolerra {
	erabiltzaileakDAO erabDAO = new erabiltzaileakDAO();
	public loginKontrolerra(PantallaLogin leihoa) {
		leihoa.btnSaioaHasi.addActionListener(e ->{
			if(leihoa.txtIzena.getText().isEmpty() || leihoa.txtPasahitza.getText().isEmpty()) {
				JOptionPane.showMessageDialog(leihoa, "Eremu guztiak bete behar dira");
				return;
			}
			for(erabiltzailea erab : erabDAO.getErabiltzaileak()) {
				if(leihoa.txtIzena.getText().equals(erab.getIzena()) && leihoa.txtPasahitza.getText().equals(erab.getPasahitza())) {
					if("ADMIN".equals(erab.getMota())) {
						PantallaAdmin leihoBerria = new PantallaAdmin();
						new adminKontrolerra(leihoBerria);
						leihoa.setVisible(false);
						leihoBerria.setVisible(true);
					} 
					if("BEZEROA".equals(erab.getMota())) {
						PantallaBezeroa leihoBerria = new PantallaBezeroa();
						new bezeroKontrolerra(leihoBerria, erab);
						leihoa.setVisible(false);
						leihoBerria.setVisible(true);
					}
				}
			}
			
		});
		
	}
}
