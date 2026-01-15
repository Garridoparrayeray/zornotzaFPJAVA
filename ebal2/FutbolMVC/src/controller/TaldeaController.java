package controller;

import java.sql.SQLException;
import java.util.List;

import dao.TaldeaDAO;
import model.Taldea;

public class TaldeaController {

	private TaldeaDAO dao;

	public TaldeaController() {
		dao = new TaldeaDAO();
	}

	// Talde berria sortu (View-tik jasotako datu sinpleekin)
	public void sortu(int id, String izena, String herria) throws SQLException {
		Taldea t = new Taldea(id, izena, herria);
		dao.taldeaSortu(t);
	}

	// Talde guztiak lortu
	public List<Taldea> getGuztiak() throws SQLException {
		return dao.getTaldeak();
	}

	// Taldea ID bidez lortu
	public Taldea getById(int id) throws SQLException {
		return dao.getTaldeaIDtik(id);
	}

	// Taldea ezabatu ID bidez
	public void ezabatu(int id) throws SQLException {
		dao.taldeaEzabatu(id);
	}
}