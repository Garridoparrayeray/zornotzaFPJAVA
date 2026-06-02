package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Date;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import DAO.animaliaDAO;
import DAO.bezeroDAO;
import model.animaliak;
import model.erabiltzailea;
import model.hitzorduak;
import view.PantallaBezeroa;
import view.PantallaLogin;

public class bezeroKontrolerra {
	bezeroDAO bDAO = new bezeroDAO();
	animaliaDAO aDAO = new animaliaDAO();
	public bezeroKontrolerra(PantallaBezeroa leihoa, erabiltzailea erab) {
		
		getBezeroAnimalia(leihoa, erab);
		leihoa.btnGorde.addActionListener(e -> {
			if(leihoa.txtData.getText().isEmpty() ||leihoa.txtOrdua.getText().isEmpty() ) {
				JOptionPane.showMessageDialog(leihoa, "hutsune guztiak bete");
				return;
				
			}
			if(!(leihoa.txtData.getText().matches("^\\d{4}-\\d{2}-\\d{2}"))){
				JOptionPane.showMessageDialog(leihoa, "data formatu egokian bete");
				return;
			}
			if(!(leihoa.txtOrdua.getText().matches("^\\d{2}:\\d{2}$"))) {
				JOptionPane.showMessageDialog(leihoa, "ordua formatu egokian bete");
				return;
			}
			Date data =Date.valueOf(leihoa.txtData.getText()) ;
			
			hitzorduak h = new hitzorduak(leihoa.txtOrdua.getText(), data, leihoa.cmbAnimalia.getSelectedItem().toString(), erab.getId());
			bDAO.setHitzordua(h);
		});
		leihoa.btnHitzorduBerria.addActionListener(e -> {
			leihoa.getPanelBehea().setVisible(true);
			setCMB(leihoa, erab);
		});

		leihoa.btnHitzorduEzabatu.addActionListener(e -> {
			int fila = leihoa.getTablaHitzorduak().getSelectedRow();
			if (fila == -1) {
				JOptionPane.showMessageDialog(leihoa, "Zutabea hautatu lehenengo");
			}
			int id = (int) leihoa.getTablaHitzorduak().getValueAt(fila, 0);
			bDAO.deleteHitzordua(id);
		});
		leihoa.btnTxostenaSortu.addActionListener(e -> {
			try(FileWriter fw = new FileWriter("fitxategia.txt"); BufferedWriter bw = new BufferedWriter(fw)){
				bw.write(erab.getIzena());
				bw.write("\n");
				bw.write("Hitzorduak: ");
				for(hitzorduak h : bDAO.getHitzorduak(erab.getId())) {
					bw.write(h.toString());
				}
				
				JOptionPane.showMessageDialog(leihoa, "fitxategia sortuta");
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		});
		leihoa.btnUtzi.addActionListener(e -> {
			leihoa.getPanelBehea().setVisible(false);

		});

		leihoa.btnIrten.addActionListener(e -> {
			PantallaLogin leihoBerria = new PantallaLogin();
			new loginKontrolerra(leihoBerria);
			leihoBerria.setVisible(true);
			leihoa.setVisible(false);
		});
		
	}

	public void getBezeroAnimalia(PantallaBezeroa leihoa, erabiltzailea erab) {
		leihoa.dtm.setRowCount(0);
		for (hitzorduak h : bDAO.getHitzorduak(erab.getId())) {
			leihoa.dtm.addRow(new Object[] { h.getId(), h.getAnimaliaIzena(), h.getData(), h.getOrdua() });
			
		}
	}
	
	@SuppressWarnings("unchecked")
	public void setCMB(PantallaBezeroa leihoa, erabiltzailea erab) {
		leihoa.cmbAnimalia.removeAllItems();
		for (animaliak a : aDAO.getAnimaliakById(erab.getId())) {
			leihoa.cmbAnimalia.addItem(a.toString());
		}
	}
}
