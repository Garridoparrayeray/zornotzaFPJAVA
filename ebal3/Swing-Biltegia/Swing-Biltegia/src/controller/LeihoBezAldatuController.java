package controller;

import view.LeihoBezeroaAldatu;
import view.LeihoNagusia;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Bezeroa;
import DAO.BezeroDAO;

public class LeihoBezAldatuController {
	public LeihoBezAldatuController() {
	}

	public LeihoBezAldatuController(LeihoBezeroaAldatu leihoa) {

		leihoa.btnBilatu.addActionListener(e -> {
			Bezeroa aurkituta = bezBilatu(leihoa.txtId.getText());
			leihoa.txtId.setText(aurkituta.getId());
			leihoa.txtIzena.setText(aurkituta.getIzena());
			leihoa.txtHelbidea.setText(aurkituta.getHelbidea());
			leihoa.txtPostaKodea.setText(aurkituta.getPostaKodea());
			leihoa.txtTelefonoa.setText(aurkituta.getTelefonoa());
		});
		leihoa.btnAldatu.addActionListener(e -> {
				BezeroDAO.UpdateBezeroak(leihoa.txtId.getText(), leihoa.txtIzena.getText(), leihoa.txtHelbidea.getText(),
						leihoa.txtPostaKodea.getText(), leihoa.txtTelefonoa.getText());
		});
		leihoa.btnItzuli.addActionListener(e -> {
			leihoa.setVisible(false);
			new KontrolatzaileaNagusia(new LeihoNagusia());
			
		});
	}


	public Bezeroa bezBilatu(String id) {
		Bezeroa bez = new Bezeroa();
		boolean dago = false;
		ArrayList<Bezeroa> bezLista = new ArrayList<Bezeroa>();
		bezLista = BezeroDAO.getBezeroak(bezLista);
		for (Bezeroa e : bezLista) {
			if (e.getId().equals(id)) {
				dago = true;
				bez.setId(e.getId());
				bez.setIzena(e.getIzena());
				bez.setHelbidea(e.getHelbidea());
				bez.setPostaKodea(e.getPostaKodea());
				bez.setTelefonoa(e.getTelefonoa());
				JOptionPane.showMessageDialog(null, "Bezeroa aurkitu da");
				break;
			}
		}
		if (dago == false) {
			JOptionPane.showMessageDialog(null, "Bezeroa ez da aurkitu");
		}
		return bez;
	}
}
