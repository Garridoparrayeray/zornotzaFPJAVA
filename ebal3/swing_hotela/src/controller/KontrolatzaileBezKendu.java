package controller;

import javax.swing.JOptionPane;

import DAO.bezeroaDAO;
import model.bezeroa;
import view.LeihoBezeroaEzabatu;

public class KontrolatzaileBezKendu {
	bezeroaDAO bezDAO = new bezeroaDAO();
	public KontrolatzaileBezKendu(LeihoBezeroaEzabatu leihoa) {
		leihoa.btnBilatu.addActionListener(e ->{
			if ((bilatuBez(Integer.parseInt(leihoa.txtId.getText())).toString()) != null) {
				leihoa.txtFeedback.setText(bilatuBez(Integer.parseInt(leihoa.txtId.getText())).toString());
			}else {
		        JOptionPane.showMessageDialog(null, "Bezeroa ez da aurkitu");
				leihoa.txtFeedback.setText("");

			}
			
		});
		leihoa.btnEzabatu.addActionListener(e ->{
			bezeroa b = bilatuBez(Integer.parseInt(leihoa.txtId.getText()));
			bezDAO.deleteBez(b);
		});
	}
	
	public bezeroa bilatuBez(int id) {
		bezeroa b = bezDAO.getBezByd(id);
        if (b != null) {
        		return b;
        }
        JOptionPane.showMessageDialog(null, "Bezeroa ez da aurkitu");
        return null;
    }
}
