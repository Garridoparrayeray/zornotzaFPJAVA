package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAO.ErreserbakDAO;
import DAO.GelaDAO;
import model.Erabiltzailea;
import model.Erreserbak;
import model.Gela;
import view.BezeroaPantaila;
import view.LoginPantaila;

public class BezeroPantailaKontrolatzailea {
	public ErreserbakDAO erreDAO = new ErreserbakDAO();
	public GelaDAO gelaDAO = new GelaDAO();
	public ArrayList<Erreserbak> erreList = new ArrayList<Erreserbak>();

	public BezeroPantailaKontrolatzailea(BezeroaPantaila leihoa, Erabiltzailea erab) {
		getErreserbak(leihoa, erab);
		getComboBox(leihoa);
		leihoa.btnGorde.addActionListener(e -> {
			String data = leihoa.txtData.getText().trim();
			if (data.isEmpty()) {
				return;
			}
			
			if (!data.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
				JOptionPane.showMessageDialog(leihoa, "Data formatu okerra. YYYY-MM-DD eskatzen da.");
				return;
			}
			LocalDate dataParse = LocalDate.parse(data);
			if (KonprobatuErreserba(leihoa, (Gela) leihoa.cmbGela.getSelectedItem(), dataParse) == true) {
				JOptionPane.showMessageDialog(leihoa, "Gela hau erreserbatuta dago");
				return;
			}
			erreDAO.insertErreserba(erab.getId(), dataParse, (Gela) leihoa.cmbGela.getSelectedItem());
			getErreserbak(leihoa, erab);

		});
		leihoa.btnErreserbaEzabatu.addActionListener(e ->{
			int fila = leihoa.getTablaErreserbak().getSelectedRow();
			if (fila == -1) {
				JOptionPane.showMessageDialog(leihoa, "Zutabea hautatu lehenengo");
			}
			int id = (int) leihoa.getTablaErreserbak().getValueAt(fila, 0);
			if(erreDAO.deleteErreserba(id)) {
				getErreserbak(leihoa, erab);
			}
		});
		leihoa.btnTxostenaSortu.addActionListener(e -> {
			try(FileWriter fw = new FileWriter("fitxategia.txt"); BufferedWriter bw = new BufferedWriter(fw)){
					
				for(Erreserbak b: erreDAO.getErreserbakidGabe()) {
					bw.write(b.toString());
					bw.write("\n");
				}
				JOptionPane.showMessageDialog(leihoa, "fitxategia gorde da.");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
//			
//			try(FileReader fr = new FileReader("fitxategia.txt"); BufferedReader br = new BufferedReader(fr)){
//				
//				String lerroa = "";
//				while((lerroa = br.readLine() )!= null) {
//					String zatiak[] = lerroa.split(";");
//				}
//			}catch (Exception e2) {
//				// TODO: handle exception
//			}
		});
		leihoa.btnIrten.addActionListener(e -> {
			LoginPantaila leihoBerria = new LoginPantaila();
			new loginKontrolatzailea(leihoBerria);
			leihoa.setVisible(false);
			leihoBerria.setVisible(true);
			
		});

	}

	public void getErreserbak(BezeroaPantaila leihoa, Erabiltzailea erab) {
		leihoa.dtm.setRowCount(0);
		for (Erreserbak b : erreDAO.getErreserbak(erab.getId())) {
			leihoa.dtm.addRow(new Object[] { b.getId(), b.getIdGela(), b.getData() });
		}
	}

	public void getComboBox(BezeroaPantaila leihoa) {
		leihoa.cmbGela.removeAllItems();
		for (Gela g : gelaDAO.getGela()) {
			leihoa.cmbGela.addItem(g);
		}
	}

	public boolean KonprobatuErreserba(BezeroaPantaila leihoa, Gela gela, LocalDate data) {
		for (Erreserbak b : erreDAO.getErreserbakidGabe()) {
			if (b.getIdGela() == gela.getId() && b.getData().toLocalDate().equals(data)) {
				JOptionPane.showMessageDialog(leihoa, "Gela hori dagoeneko erreserbatuta dago " + data + " egunean");
				return true;
			}
		}
		return false;
	}

	

}
