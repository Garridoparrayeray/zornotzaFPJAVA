package controller;
import view.LeihoBezeroakIkusi;
import view.LeihoNagusia;
import DAO.bezeroaDAO;
import model.*;

public class KontrolatzaileBezIkusi {
	public bezeroaDAO bezDAO = new bezeroaDAO();
	public KontrolatzaileBezIkusi(LeihoBezeroakIkusi leihoa) {
		leihoa.btnEguneratu.addActionListener(e -> TaulaEguneratu(leihoa));
		leihoa.btnItzuli.addActionListener(e -> {
			LeihoNagusia leihoberria = new LeihoNagusia();
			new KontrolatzaileNagusia(leihoberria);
			leihoa.setVisible(false);
			leihoberria.setVisible(true);
		});
	}
	public void TaulaEguneratu(LeihoBezeroakIkusi leihoa) {
		for (bezeroa bez : bezDAO.getBezeroak()) {
			leihoa.dtm.addRow(new Object[] {bez.getId(), bez.getIzena(), bez.getAbizena(), bez.getDni(), bez.getTelefonoa()});
		}
		
	}
}
	