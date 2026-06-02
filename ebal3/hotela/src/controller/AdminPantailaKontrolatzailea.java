package controller;

import javax.swing.JOptionPane;

import DAO.GelaDAO;
import model.Gela;
import view.AdminPantaila;

public class AdminPantailaKontrolatzailea {
	public String akzioa = "";
	public GelaDAO gDAO = new GelaDAO();
	public AdminPantailaKontrolatzailea(AdminPantaila leihoa) {
		leihoa.getPanelBotoiakBehea().setVisible(false);
		getGelak(leihoa);

		leihoa.btnSortu.addActionListener(e -> {
			akzioa = "SORTU";
			leihoa.getPanelBotoiakBehea().setVisible(true);
			
		});
		leihoa.btnGorde.addActionListener(e -> {
			if (leihoa.txtExtra.getText().isEmpty() || leihoa.txtPrezioa.getText().isEmpty() || leihoa.txtSolairua.getText().isEmpty()) {
				JOptionPane.showMessageDialog(leihoa, "Hutsune guztiak bete");
				return;
			}
			if(!leihoa.txtPrezioa.getText().matches("^\\d+(\\.\\d+)?$")) {
				JOptionPane.showMessageDialog(leihoa, "Zenbaki doble bat sartu");
				return;
			}
			
			double prezioa = Double.parseDouble(leihoa.txtPrezioa.getText());
			int solairua = Integer.parseInt(leihoa.txtSolairua.getText());
			Gela g = new Gela(solairua, prezioa , leihoa.cmbMota.getSelectedItem().toString() ,leihoa.txtExtra.getText());
			if ("SORTU".equals(akzioa)) {
			    gDAO.addGela(g);
			    getGelak(leihoa);
			} else if ("EDITATU".equals(akzioa)) {
			    gDAO.updateGela(g);
			    getGelak(leihoa);
			}
		});
		
		
		leihoa.btnEditatu.addActionListener(e ->{
			leihoa.getPanelBotoiakBehea().setVisible(true);

			int fila = leihoa.taula.getSelectedRow();
			if (fila == -1) {
				JOptionPane.showMessageDialog(leihoa, "Zutabea hautatu lehenengo");
			}
			leihoa.txtSolairua.setText(leihoa.taula.getValueAt(fila, 1).toString());
			leihoa.txtPrezioa.setText(leihoa.taula.getValueAt(fila, 2).toString());
			leihoa.txtExtra.setText(leihoa.taula.getValueAt(fila, 4).toString());
			 fila = -1;
		});
		leihoa.btnEzabatu.addActionListener(e -> {
			int fila = leihoa.taula.getSelectedRow();
			if (fila == -1) {
				JOptionPane.showMessageDialog(leihoa, "Zutabea hautatu lehenengo");
			}
			int id = (int) leihoa.taula.getValueAt(fila, 0);
			
			gDAO.deleteGela(id);
			getGelak(leihoa);
		});
		leihoa.btnUtzi.addActionListener(e ->{
			leihoa.getPanelBotoiakBehea().setVisible(false);

		});
		leihoa.btnEsportatu.addActionListener(e -> {
			
		});
	}
	public void getGelak(AdminPantaila leihoa) {
		leihoa.dtm.setRowCount(0);
		for(Gela g : gDAO.getGela()) {
			leihoa.dtm.addRow(new Object[] {g.getId(), g.getSolairua(), g.getPrezioa(), g.getMota(), g.getExtra()});;
		}
	}
}
