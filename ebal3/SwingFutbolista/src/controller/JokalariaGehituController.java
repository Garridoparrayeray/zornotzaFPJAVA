package controller;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import DAO.*;
import model.futbolaria;
import view.LeihoJokalariGehitu;
import view.LeihoNagusia;

public class JokalariaGehituController {
	jokalariakDAO jokDAO = new jokalariakDAO();
	taldeakDAO talDAO = new taldeakDAO();

	public JokalariaGehituController(LeihoJokalariGehitu leihoa) {
		leihoa.btnUtzi.addActionListener(e -> {
			leihoa.setVisible(false);
		});
		leihoa.btnGorde.addActionListener(e -> {
			LeihoNagusia leihoNagusia = new LeihoNagusia();
			String dni = leihoa.txtDni.getText().trim();
			String nombre = leihoa.txtNombre.getText().trim();
			String apellido = leihoa.txtApellido.getText().trim();
			String salarioStr = leihoa.txtSalario.getText().trim();
			String idEquipoStr = leihoa.txtIdEquipo.getText().trim();

			if (dni.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || salarioStr.isEmpty()
					|| idEquipoStr.isEmpty()) {
				JOptionPane.showMessageDialog(leihoa, "Eremu guztiak bete behar dira.", "Errorea",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (jokDAO.getFutbolariaById(dni) == true) {
				JOptionPane.showMessageDialog(leihoa, "Errorea, futbolaria existitzen da.");
				return;
			}
			if (!talDAO.getTaldeakById(idEquipoStr)) {
				JOptionPane.showMessageDialog(leihoa, "Sartutako taldearen ID-a ez da existitzen. Sartu benetako bat.",
						"Errorea", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			boolean ondoGordeDa = jokDAO.setFutbolaria(dni, nombre, apellido, salarioStr, idEquipoStr);

			if (ondoGordeDa) {
				JOptionPane.showMessageDialog(leihoa, "Jokalaria ongi gorde da.", "Informazioa",
						JOptionPane.INFORMATION_MESSAGE);

				leihoNagusia.dtm1.setRowCount(0);
				for (futbolaria f : jokDAO.getFutbolaria()) {
					leihoNagusia.dtm1.addRow(new Object[] { f.getDni(), f.getNombre(), f.getApellido(), f.getSalario(),
							f.getIdEquipo() });
				}
			}
		});
	}
}
