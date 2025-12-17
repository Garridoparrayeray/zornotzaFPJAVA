package ebal2_erronka_aurrekAZT;

import java.util.ArrayList;

public class VipHotela {
	protected String izena;
	protected ArrayList<Viplogela> logelak = new ArrayList<Viplogela>();

	
	public VipHotela() {
		this.izena = "";
		this.logelak = new ArrayList<>();//arraylist abiarazi
	}

	/**
	 * @return the izena
	 */
	public String getIzena() {
		return izena;
	}

	/**
	 * @param izena the izena to set
	 */
	public void setIzena(String izena) {
		this.izena = izena;
	}

	public void logelaGehitu(Viplogela logela) {
		logelak.add(logela);
	}

	@Override
	public String toString() {
		return "VipHotela [izena=" + izena + ", logelak=" + logelak + "]";
	}
	
}
