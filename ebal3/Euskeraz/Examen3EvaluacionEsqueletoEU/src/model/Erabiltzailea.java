package model;

public class Erabiltzailea {
	private int idErabiltzailea;
	private String izena;
	private String pasahitza;
	private String rola;
	public Erabiltzailea() {
		// TODO Auto-generated constructor stub
	}
	public Erabiltzailea(int idErabiltzailea, String izena, String pasahitza, String rola) {
		super();
		this.idErabiltzailea = idErabiltzailea;
		this.izena = izena;
		this.pasahitza = pasahitza;
		this.rola = rola;
	}
	public int getIdErabiltzailea() {
		return idErabiltzailea;
	}
	public void setIdErabiltzailea(int idErabiltzailea) {
		this.idErabiltzailea = idErabiltzailea;
	}
	public String getIzena() {
		return izena;
	}
	public void setIzena(String izena) {
		this.izena = izena;
	}
	public String getPasahitza() {
		return pasahitza;
	}
	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}
	public String getRola() {
		return rola;
	}
	public void setRola(String rola) {
		this.rola = rola;
	}
	
}
