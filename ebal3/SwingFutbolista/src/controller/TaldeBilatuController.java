package controller;

import javax.swing.JOptionPane;

import DAO.jokalariakDAO;
import DAO.taldeakDAO;
import model.futbolaria;
import model.taldea;
import view.LeihoJokalariBilatu;
import view.LeihoTaldeBilatu;

public class TaldeBilatuController {
	public taldeakDAO talDAO = new taldeakDAO();

	public TaldeBilatuController(LeihoTaldeBilatu lehioa) {
			lehioa.btnBilatu.addActionListener(e -> {
				String idTaldea= lehioa.txtBilatuId.getText().trim();
				if (!idTaldea.isEmpty() && talDAO.getTaldeakById(idTaldea) == true) {
					for (taldea t : talDAO.getTaldeak()) {
						if (String.valueOf(t.getIdEquipo()).equals(idTaldea)) {
							lehioa.lblNombre.setText(t.getNombre());
							lehioa.lblCiudad.setText(t.getCiudad());
						}
					}

				}else {
					JOptionPane.showMessageDialog(null, "Talde hori ez da aurkitu");
				}

			});
		}
	}

