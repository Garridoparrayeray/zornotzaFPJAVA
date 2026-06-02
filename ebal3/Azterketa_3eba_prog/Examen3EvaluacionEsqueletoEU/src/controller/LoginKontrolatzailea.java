package controller;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.ErabiltzaileakDAO;
import model.Erabiltzaileak;
import view.*;
public class LoginKontrolatzailea {
	private ArrayList<Erabiltzaileak> erabList= new ArrayList<Erabiltzaileak>();
	private ErabiltzaileakDAO erabDAO = new ErabiltzaileakDAO();

	public LoginKontrolatzailea(PantailaLogin leihoa) {
		leihoa.getBtnSartu().addActionListener(e->{
			if (leihoa.getTxtPasahitza().getText().isEmpty() || leihoa.getTxtErabiltzailea().getText().isEmpty()) {
				JOptionPane.showMessageDialog(leihoa, "Hutsune guztiak bete");
				return;
			}
			String izena = leihoa.getTxtErabiltzailea().getText();
			String pasahitza = leihoa.getTxtPasahitza().getText();
			if(erabiltzaileak_egiaztatu (izena, pasahitza, leihoa) == true){
				JOptionPane.showMessageDialog(leihoa, "Login zuzena");

			}else {
				JOptionPane.showMessageDialog(leihoa, "Saioa hasteko datuak okerrak dira");

			}

		});
		

	};
	public boolean erabiltzaileak_egiaztatu(String izena, String pasahitza, PantailaLogin leihoa) {
		erabList = erabDAO.getErabiltzaileak();
		for(Erabiltzaileak e : erabList) {
			if(e.getIzena().equals(izena) && e.getPasahitza().equals(pasahitza) && e.getRol().equals("ADMIN")) {
				PantailaKlaseak leihoberria = new PantailaKlaseak();
				new PantailakKlaseakKontrolatzailea(leihoberria);
				leihoberria.setVisible(true);
				leihoa.setVisible(false);
				return true;
			}else if(e.getIzena().equals(izena) && e.getPasahitza().equals(pasahitza) && e.getRol().equals("BEZEROA")) {
				PantailaErreserbak leihoberria = new PantailaErreserbak();
				new PantailaErreserbakKontrolatzailea(leihoberria, e);
				leihoberria.setVisible(true);
				leihoa.setVisible(false);
				JOptionPane.showMessageDialog(leihoa, "Ongi etorri " + e.getIzena());
				return true;
			}
			
		}
		return false;
	}
}
