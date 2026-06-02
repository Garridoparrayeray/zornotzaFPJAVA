package controller;
import view.LeihoBezeroaGehitu;
import view.LeihoNagusia;
import view.LeihoBezeroakIkusi;
import controller.LeihoBezeroakIkusiController;
import model.Bezeroa;


import javax.swing.JOptionPane;

import DAO.*;
public class LeihoBezeroaGehituController {
	
	public LeihoBezeroaGehituController(LeihoBezeroaGehitu Leihoa) {
		Leihoa.btnItzuli.addActionListener(e ->{
				new KontrolatzaileaNagusia(new LeihoNagusia());
				Leihoa.setVisible(false);
		});
		Leihoa.btnGehitu.addActionListener(e ->{
			GehituBez(Leihoa.txtId.getText(), Leihoa.txtIzena.getText(), Leihoa.txtHelbidea.getText(), Leihoa.txtPostaKodea.getText(), Leihoa.txtTelefonoa.getText());
		});
		
	}	
	public void GehituBez (String id, String izena, String helbidea, String postakodea, String telefonoa) {
		boolean dago = false;
		LeihoBezeroakIkusi LeihoBezIkusi = new LeihoBezeroakIkusi();
		new LeihoBezeroakIkusiController(LeihoBezIkusi);
		for(int i = 0; LeihoBezIkusi.dtm.getRowCount() - 1 >= i; i++) {
			if (LeihoBezIkusi.dtm.getValueAt(i, 1) == (id)) {
				dago = true;
			}
		}
		if (dago == false) {
			LeihoBezIkusi.dtm.addRow(new Object[] {id, izena, helbidea, postakodea, telefonoa});
			JOptionPane.showMessageDialog(LeihoBezIkusi, "Bezeroa sartu da.");

		} else {
			JOptionPane.showMessageDialog(LeihoBezIkusi, "Bezeroa sartuta dago jadanik");

		}

	}
	
}
