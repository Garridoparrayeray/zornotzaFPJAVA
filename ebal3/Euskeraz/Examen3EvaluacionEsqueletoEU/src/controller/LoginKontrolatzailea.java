package controller;

import javax.swing.JOptionPane;

import dao.ErabiltzaileaDAO;
import model.Erabiltzailea;
import view.PantailaErreserbak;
import view.PantailaKlaseak;
import view.PantailaLogin;

public class LoginKontrolatzailea {
	ErabiltzaileaDAO eraDAO = new ErabiltzaileaDAO();
	public LoginKontrolatzailea(PantailaLogin leihoa) {
		leihoa.getBtnSartu().addActionListener(e ->{
			boolean sartu = false;
			if(leihoa.getTxtErabiltzailea().getText().isEmpty() || leihoa.getTxtPasahitza().getText().isEmpty()) {
				JOptionPane.showMessageDialog(leihoa, "Hutsune guztiak bete");
				return;
			}
			
			
			for(Erabiltzailea erab : eraDAO.getErabiltzaileak()) {
				if(leihoa.getTxtErabiltzailea().getText().equals(erab.getIzena()) && leihoa.getTxtPasahitza().getText().equals(erab.getPasahitza())) {
					sartu = true;
					if(erab.getRola().equals("ADMIN")) {
						PantailaKlaseak lehioBerria = new PantailaKlaseak();
						new KlaseakKontrolatzailea(lehioBerria);
						lehioBerria.setVisible(true);
						leihoa.setVisible(false);
					}
					if(erab.getRola().equals("BEZEROA")) {
						PantailaErreserbak leihoBerria = new PantailaErreserbak();
						new ErreserbakKontrolatzailea(leihoBerria, erab);
						leihoBerria.setVisible(true);
						leihoa.setVisible(false);
					}
				}
				
			}
			if (sartu ==false) {
				JOptionPane.showMessageDialog(leihoa, "Saioa hasteko datuak okerrak dira");
				return;
			}
		
		});
		

	}
	
	
	
}
