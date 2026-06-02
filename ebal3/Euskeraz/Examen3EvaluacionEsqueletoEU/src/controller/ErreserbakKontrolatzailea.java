package controller;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Date;

import javax.swing.JOptionPane;

import dao.ErreserbakDAO;
import dao.KlaseakDAO;
import model.Erabiltzailea;
import model.Erreserba;
import model.Klasea;
import view.PantailaErreserbak;
import view.PantailaKlaseak;
import view.PantailaLogin;

public class ErreserbakKontrolatzailea {
	ErreserbakDAO eDAO = new ErreserbakDAO();
	KlaseakDAO kDAO = new KlaseakDAO();

	public ErreserbakKontrolatzailea(PantailaErreserbak leihoa, Erabiltzailea erab) {
		getErreserbak(leihoa, erab);
		leihoa.getBtnSortu().addActionListener(e -> {
			leihoa.getPanelFormularioa().setVisible(true);
			getKlaseakCMB(leihoa);
		});
		leihoa.getBtnIrten().addActionListener(e -> {
			PantailaLogin leihoBerria = new PantailaLogin();
			new LoginKontrolatzailea(leihoBerria);
			leihoBerria.setVisible(true);
			leihoa.setVisible(false);
		});

		leihoa.getBtnGorde().addActionListener(e -> {
			if (leihoa.getTxtData().getText().isEmpty()) {
				JOptionPane.showMessageDialog(leihoa, "hutsune guztiak bete");
				return;
			}
			if (!(leihoa.getTxtData().getText().matches("^\\d{4}-\\d{2}-\\d{2}$"))) {
				JOptionPane.showMessageDialog(leihoa, "data formatu egoki batean ipini");
				return;
			}
			Date data;
			Klasea klaseaAukeratua = (Klasea) leihoa.getComboKlaseak().getSelectedItem();
			if (klaseaAukeratua == null) {
			    JOptionPane.showMessageDialog(leihoa, "Aukeratu klase bat");
			    return;
			}
			int klaseID = klaseaAukeratua.getIdKlasea(); 
			try {
			    data = Date.valueOf(leihoa.getTxtData().getText());
			} catch (Exception ex) {
			    JOptionPane.showMessageDialog(leihoa, "Data ez da existitzen");
			    return;
			}
			Erreserba erre = new Erreserba(erab.getIdErabiltzailea(), data, klaseID);
			if (eDAO.setErreserba(erre) == true) {
				JOptionPane.showMessageDialog(leihoa, "Erreserbatu da");
			}else {
				JOptionPane.showMessageDialog(leihoa, "Ez da erreserbatu");

			}
		});
		leihoa.getBtnUtzi().addActionListener(e -> {
			leihoa.getPanelFormularioa().setVisible(false);
		});
		leihoa.getBtnEzabatu().addActionListener(e ->{
			int fila = leihoa.getTaulaErreserbak().getSelectedRow();
			if (fila == -1) return;
			int id= (int) leihoa.getTaulaErreserbak().getValueAt(fila, 0);
			eDAO.deleteErre(id);
			getErreserbak(leihoa, erab);

		});
		leihoa.getBtnTxostenak().addActionListener(e -> {
			try(FileWriter fr = new FileWriter("txostena.txt"); BufferedWriter bw = new BufferedWriter(fr)){
				bw.write("==== ERRESERBEN TXOSTENA ====" + "\n");
				bw.write("Erabiltzailea " + erab.getIzena() + "\n");
				bw.write("Erreserba kopurua: " + leihoa.getTaulaErreserbak().getRowCount() + "\n");
				
				for(Erreserba e2 : eDAO.getErreserbak(erab.getIdErabiltzailea())) {
					
					bw.write(e2.toString() + "\n");
				}
				
				JOptionPane.showMessageDialog(leihoa, "Txostena sortu da.");
			}catch (Exception e2) {
				JOptionPane.showMessageDialog(leihoa, "Txostena ez da sortu.");
				e2.printStackTrace();
			}
		});
	}

	public void getErreserbak(PantailaErreserbak leihoa, Erabiltzailea erab) {
		leihoa.getModeloa().setRowCount(0);
		for (Erreserba e : eDAO.getErreserbak(erab.getIdErabiltzailea())) {
			leihoa.getModeloa().addRow(new Object[] { e.getIdErreserba(), e.getKlaseIzena(), e.getData() });
		}
	}

	public void getKlaseakCMB(PantailaErreserbak leihoa) {
		leihoa.getComboKlaseak().removeAllItems();
		for (Klasea k : kDAO.getKlaseak()) {
			leihoa.getComboKlaseak().addItem((k.getIdKlasea() + " - " + k.getIzena()));
		}
	}
}
