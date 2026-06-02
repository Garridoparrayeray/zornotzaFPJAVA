package controller;

import java.awt.Component;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dao.ErreserbakDAO;
import dao.klaseakDAO;
import model.Erabiltzaileak;
import model.Erreserbak;
import model.Klaseak;
import view.PantailaErreserbak;
import view.PantailaKlaseak;
import view.PantailaLogin;

public class PantailaErreserbakKontrolatzailea {
	ErreserbakDAO errDAO = new ErreserbakDAO();
	klaseakDAO klaDAO = new klaseakDAO();
	DefaultTableModel dtm = new DefaultTableModel();
	public static String fitxategia = "./erreserba_txostena.txt";
	public PantailaErreserbakKontrolatzailea(PantailaErreserbak leihoa, Erabiltzaileak erab) {
		ErreserbakKargatu(leihoa, erab);
		leihoa.getBtnIrten().addActionListener(e -> {
			PantailaLogin leihoBerria = new PantailaLogin();
			new LoginKontrolatzailea(leihoBerria);
			leihoa.setVisible(false);
			leihoBerria.setVisible(true);
		});
		leihoa.getBtnSortu().addActionListener(e -> {
			leihoa.getPanelFormularioa().setVisible(true);
			leihoa.getComboKlaseak().removeAllItems();	
			for (Klaseak k : klaDAO.getKlaseak()) {
				leihoa.getComboKlaseak().addItem(k.toString());
			}

		});
		leihoa.getBtnIrten().addActionListener(e ->{
			PantailaLogin leihoBerria = new PantailaLogin();
			new LoginKontrolatzailea(leihoBerria);
			leihoa.setVisible(false);
			leihoBerria.setVisible(true);
		});
		leihoa.getBtnGorde().addActionListener(e -> {
			errDAO.setErreserbak(k);
		});
		leihoa.getBtnEzabatu().addActionListener(e -> {
			int fila = leihoa.getTaulaErreserbak().getSelectedRow();
			if (fila == -1) {
				JOptionPane.showMessageDialog(leihoa, "Zutabea hautatu lehenengo");
			}
			int id = (int) leihoa.getTaulaErreserbak().getValueAt(fila, 0);
			
			if (errDAO.deleteErreserbak(id)) {
				ErreserbakKargatu(leihoa, erab);
			}
		});
		leihoa.getBtnUtzi().addActionListener(e -> {
			leihoa.getPanelFormularioa().setVisible(false);

		});
		leihoa.getBtnTxostenak().addActionListener(e ->{
			try(FileWriter fw = new FileWriter(fitxategia);PrintWriter pw = new PrintWriter(fw)){
				pw.println("	Erabiltzailea: " + erab.getIzena());
				pw.println("Erreserba kopurua: " + dtm.getRowCount());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}

	public void ErreserbakKargatu(PantailaErreserbak leihoa, Erabiltzaileak erab) {
		dtm = leihoa.getDtm();
		ArrayList<Erreserbak> erreList = new ArrayList<Erreserbak>();
		erreList = errDAO.getErreserbak(erab.getId());
		for (Erreserbak b : erreList) {
			dtm.addRow(new Object[] { b.getIdErreserba(), b.getKlaseIzena(), b.getData()});
		}
	}
}
