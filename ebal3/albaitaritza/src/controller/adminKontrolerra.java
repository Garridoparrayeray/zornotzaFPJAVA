package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

import DAO.animaliaDAO;
import model.animaliak;
import view.PantallaAdmin;
import view.PantallaLogin;

public class adminKontrolerra {
	animaliaDAO aDAO = new animaliaDAO();
	private String modoa = "";
	public adminKontrolerra(PantallaAdmin leihoa) {
		getAnimaliak(leihoa);
		leihoa.btnEditatu.addActionListener(e ->{
			int fila = leihoa.getTabla().getSelectedRow();
			if (fila == -1) {
				JOptionPane.showMessageDialog(leihoa, "Zutabea hautatu lehenengo");
			}
			leihoa.txtIzena.setText((String)leihoa.getTabla().getValueAt(fila, 1));
			String adina = String.valueOf(leihoa.getTabla().getValueAt(fila,2));
			leihoa.txtAdina.setText(adina);
			String jabeId = String.valueOf(leihoa.getTabla().getValueAt(fila,5));
			leihoa.txtExtra.setText((String)leihoa.getTabla().getValueAt(fila,4));
			leihoa.txtIdJabea.setText(jabeId);
			modoa = "EDITATU";
		});
		leihoa.btnEsportatu.addActionListener(e ->{
			try(FileOutputStream fo = new FileOutputStream("fitxategia.dat");
			         ObjectOutputStream oo = new ObjectOutputStream(fo)){
				oo.writeObject(aDAO.getAnimaliak());
				JOptionPane.showMessageDialog(leihoa, "Artxiboa idatzi da");
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		});
		leihoa.btnEzabatu.addActionListener(e ->{
			int fila = leihoa.getTabla().getSelectedRow();
			if (fila == -1) {
				JOptionPane.showMessageDialog(leihoa, "Zutabea hautatu lehenengo");
			}
			int id = (int) leihoa.getTabla().getValueAt(fila, 0);
			aDAO.deleteAnimalia(id);
			getAnimaliak(leihoa);
		});
		leihoa.btnGorde.addActionListener(e ->{
			if(leihoa.txtIzena.getText().isEmpty() || leihoa.txtAdina.getText().isEmpty() || leihoa.txtExtra.getText().isEmpty() || leihoa.txtIdJabea.getText().isEmpty()) {
				JOptionPane.showMessageDialog(leihoa, "Eremu guztiak bete behar dira");
				return;
			}
//			if(!(leihoa.txtIzena.getText().matches("^[a-zA-z]\\+$"))) {
//				JOptionPane.showMessageDialog(leihoa, "Izena letrak izan behar dira");
//				return;
//			}
			if(!leihoa.txtAdina.getText().matches("^\\d+$")) {
				JOptionPane.showMessageDialog(leihoa, "adina positiboa izan behar da");
				return;
			}
			int adina = Integer.parseInt( leihoa.txtAdina.getText());
			int idJabea = Integer.parseInt(leihoa.txtIdJabea.getText());
			if (modoa.equals("SORTU")) {
				aDAO.insertAnimalia(new animaliak(leihoa.txtIzena.getText(), adina,leihoa.cmbMota.getSelectedItem().toString(), leihoa.txtExtra.getText(), idJabea));
				getAnimaliak(leihoa);
			}
			if (modoa.equals("EDITATU")) {
				aDAO.animaliakUpdate(new animaliak(leihoa.txtIzena.getText(), adina,leihoa.cmbMota.getSelectedItem().toString(), leihoa.txtExtra.getText(), idJabea));
				getAnimaliak(leihoa);

			}
		});
		leihoa.btnIrten.addActionListener(e ->{
			PantallaLogin leihoBerria = new PantallaLogin();
			new loginKontrolerra(leihoBerria);
			leihoBerria.setVisible(true);
			leihoa.setVisible(false);
		});
		leihoa.btnSortu.addActionListener(e ->{
			modoa = "SORTU";
			leihoa.getPanelBehea().setVisible(true);
			
			
		});
		leihoa.btnUtzi.addActionListener(e ->{
			leihoa.getPanelBehea().setVisible(false);

		});
		
	}
	
	
	public void getAnimaliak(PantallaAdmin leihoa) {
		leihoa.dtm.setRowCount(0);
		for(animaliak a : aDAO.getAnimaliak()) {
			leihoa.dtm.addRow(new Object[] {a.getId(), a.getIzena(), a.getAdina(), a.getMota(), a.getExtra(), a.getIdJabea()});
		}
	}
}
