package controller;

import model.*;

import java.util.ArrayList;

import DAO.*;

public class ControllerBideoiokoak {
	ErabiltzaileDAO ErabDAO = new ErabiltzaileDAO();
	BideojokoakDAO BideoDao = new BideojokoakDAO();
	ErosketaDAO eroskDAO = new ErosketaDAO();
	public ArrayList<Erabiltzailea> getErabiltzaileak() {
		try {
			return ErabDAO.getErabiltzaileak();
		} catch (Exception e) {
			System.err.println("Zerbait gertatu da exekutatzerakoan" + e.getMessage());
			return new ArrayList<>();
		}
	}

	public ArrayList<Erabiltzailea> getErabiltzaileakAdinNagusia() {
		try {
			return ErabDAO.getErabiltzaileakAdinNagusia();
		} catch (Exception e) {
			System.err.println("Zerbait gertatu da exekutatzerakoan" + e.getMessage());
			return new ArrayList<>();
		}
	}

	public ArrayList<ErabiltzaileErosketa> getErabiltzaileakErosketaTotalak() {
		try {
			return ErabDAO.getErabiltzaileakErosketaTotalak();
		} catch (Exception e) {
			System.err.println("Zerbait gertatu da exekutatzerakoan" + e.getMessage());
			return new ArrayList<>();
		}
	}

	public ArrayList<Bideojokoa> getBideojokoak() {
		try {
			return BideoDao.getBideojokoak();
		} catch (Exception e) {
			System.err.println("Zerbait gertatu da exekutatzerakoan" + e.getMessage());
			return new ArrayList<>();
		}
	}

	public ArrayList<Bideojokoa> getBideojokoKonkretua(String generoa) {
		try {
			return BideoDao.getBideojokoKonkretua(generoa);
		} catch (Exception e) {
			System.err.println("Zerbait gertatu da exekutatzerakoan" + e.getMessage());
			return new ArrayList<>();
		}
	}
	
	
	public ArrayList<Erosketa> getErosketak() {
		try {
			return  eroskDAO.getErosketak();
		} catch (Exception e) {
			System.err.println("Zerbait gertatu da exekutatzerakoan" + e.getMessage());
			return new ArrayList<>();
		}
	}

	public Double getBideojokoBatazBez() {
		try {
			return BideoDao.getBideojokoBatazBez();
		}catch (Exception e) {
			System.err.println("Zerbait gertatu da exekutatzerakoan" + e.getMessage());
			return null;
		}
	}
}
