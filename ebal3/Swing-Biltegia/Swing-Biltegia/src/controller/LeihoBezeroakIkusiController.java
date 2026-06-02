package controller;
import model.Bezeroa;
import DAO.BezeroDAO;
import view.LeihoBezeroakIkusi;

import java.sql.SQLException;
import java.util.ArrayList;
public class LeihoBezeroakIkusiController {
	
	public ArrayList<Bezeroa> BezeroBez = new ArrayList<Bezeroa>();
	
	public LeihoBezeroakIkusiController(LeihoBezeroakIkusi leihoBezeroakIkusi) {
			BezeroBez = BezeroDAO.getBezeroak(BezeroBez);
			for (Bezeroa b : BezeroBez) {
				leihoBezeroakIkusi.dtm.addRow(new Object[] {b.getId(), b.getIzena(), b.getHelbidea(), b.getPostaKodea(), b.getTelefonoa()});
			}
		

	}
}
