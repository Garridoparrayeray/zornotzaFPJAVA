package controller;

import javax.swing.JOptionPane;

import DAO.bezeroaDAO;
import model.bezeroa;
import view.LeihoBezeroaGehitu;

public class KontrolatzaileBezGehitu {
	public bezeroaDAO bezDAO = new bezeroaDAO();
	public KontrolatzaileBezGehitu(LeihoBezeroaGehitu leihoa) {
		leihoa.btnGehitu.addActionListener(e -> {
			gehituBezeroa(leihoa);
		});
	}

	public void gehituBezeroa(LeihoBezeroaGehitu leihoa) {

		if (leihoa.txtId.getText().isEmpty() || leihoa.txtIzena.getText().isEmpty()
				|| leihoa.txtAbizena.getText().isEmpty() || leihoa.txtDni.getText().isEmpty()
				|| leihoa.txtTelefonoa.getText().isEmpty()) {
			JOptionPane.showMessageDialog(leihoa, "Bete hutsune guztiak");
			return;
		}

		bezeroa b = new bezeroa(Integer.parseInt(leihoa.txtId.getText()), leihoa.txtIzena.getText(), leihoa.txtAbizena.getText(),
				leihoa.txtDni.getText(), leihoa.txtTelefonoa.getText());
		bezDAO.addBez(b);
	}
}
