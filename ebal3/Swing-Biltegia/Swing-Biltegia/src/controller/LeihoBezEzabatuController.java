package controller;
import view.LeihoBezeroaEzabatu;
import view.LeihoNagusia;
import DAO.BezeroDAO;
import model.Bezeroa;

public class LeihoBezEzabatuController {
	public LeihoBezEzabatuController(LeihoBezeroaEzabatu leihoBezEzaba) {
		LeihoBezAldatuController bezalda = new LeihoBezAldatuController();
		leihoBezEzaba.btnItzuli.addActionListener(e -> {
			leihoBezEzaba.setVisible(false);
			new KontrolatzaileaNagusia(new LeihoNagusia());
			
		});
		leihoBezEzaba.btnBilatu.addActionListener(e->{
			bezalda.bezBilatu(leihoBezEzaba.txtId.getText());
			
		});
		leihoBezEzaba.btnEzabatu.addActionListener(e ->{
			BezeroDAO.DeleteBezeroak(leihoBezEzaba.txtId.getText());
		});
	}
}
