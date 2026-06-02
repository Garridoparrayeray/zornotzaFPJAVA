package controller;
import javax.swing.JOptionPane;

import DAO.taldeakDAO;
import model.taldea;
import view.LeihoTaldeGehitu;
public class TaldeGehituController {
	taldeakDAO talDAO = new taldeakDAO();
	public TaldeGehituController(LeihoTaldeGehitu leihoa) {
		leihoa.btnUtzi.addActionListener(e ->{
			leihoa.setVisible(false);
		});
		leihoa.btnGorde.addActionListener(e -> {
			String nombre = leihoa.txtNombre.getText().trim();
			String ciudad = leihoa.txtCiudad.getText().trim();
			String idEquipo = leihoa.txtIdEquipo.getText().trim();
			if (nombre.isEmpty() || ciudad.isEmpty()|| idEquipo.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Bete kanpo guztiak gorde baino lehen.");
				return;
				
			}
			if (talDAO.getTaldeakById(idEquipo) == true) {
				 JOptionPane.showMessageDialog(null, "talde bat id honekin existitzen da");
				return;
			}
			
			taldea t = new taldea(
					Integer.parseInt(idEquipo),
					nombre,
					ciudad
					);
			talDAO.setTaldea(t);
			leihoa.setVisible(false);
			
		});
	}
}
