package controller;

import java.sql.SQLException;
import java.util.List;

import dao.FutbolistaDAO;
import dao.TaldeaDAO;
import model.Futbolista;
import model.Taldea;

public class FutbolistaController {

	private FutbolistaDAO futDao;
	private TaldeaDAO talDao;

	public FutbolistaController() {
		futDao = new FutbolistaDAO();
		talDao = new TaldeaDAO();
	}

	// Futbolista berria sortu (taldea existitzen bada)

	public boolean sortu(String dni, String izena, String abizena,
            double soldata, int idTaldea) throws SQLException {

	for (Taldea t : talDao.getTaldeak()) {
		if (t.getIdTaldea() == idTaldea) {
			Futbolista f = new Futbolista(
					dni, izena, abizena, soldata, idTaldea);
			futDao.futbolistaSortu(f);
			return true;
		}
	}
	return false;
}

	public List<Futbolista> getGuztiak() throws SQLException {
		return futDao.getFutbolistak();
	}

	public Futbolista getById(String dni) throws SQLException {
		return futDao.getFutbolistaIDtik(dni);
	}

	public void ezabatu(String dni) throws SQLException {
		futDao.futbolistaEzabatu(dni);
	}
}