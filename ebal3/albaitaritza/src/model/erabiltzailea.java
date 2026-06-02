package model;

import java.io.Serializable;

public class erabiltzailea implements Serializable{
	private int id;
	private String izena;
	private String pasahitza;
	private String mota;
	public erabiltzailea() {
		// TODO Auto-generated constructor stub
	}
	
	public erabiltzailea(int id, String izena, String pasahitza, String mota) {
		super();
		this.id = id;
		this.izena = izena;
		this.pasahitza = pasahitza;
		this.mota = mota;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	
}
