package controller;

import javax.swing.JOptionPane;

import DAO.jokalariakDAO;
import model.futbolaria;
import view.LeihoJokalariBilatu;

public class LeihoJokalariBilatuFController {
	jokalariakDAO jokDAO = new jokalariakDAO();

	public LeihoJokalariBilatuFController(LeihoJokalariBilatu leihoa) {
		leihoa.btnBilatu.addActionListener(e -> {
			String DNI = leihoa.txtBilatuDni.getText().trim();
			if (!DNI.isEmpty() && jokDAO.getFutbolariaById(DNI) == true) {
				for (futbolaria f : jokDAO.getFutbolaria()) {
					if (f.getDni().equals(DNI)) {
						leihoa.lblNombre.setText(f.getNombre());
						leihoa.lblApellido.setText(f.getApellido());
						leihoa.lblSalario.setText(String.valueOf(f.getSalario()));
						leihoa.lblIdEquipo.setText(String.valueOf(f.getIdEquipo()));
					}
				}

			}else {
				JOptionPane.showMessageDialog(null, "jokalari hori ez da aurkitu");
			}

		});
	}
}
