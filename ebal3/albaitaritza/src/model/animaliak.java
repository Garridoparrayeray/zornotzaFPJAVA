package model;

import java.io.Serializable;

public class animaliak implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String izena;
	private int adina;
	private String mota;
	private String extra;
	private int idJabea;
	public animaliak() {
		// TODO Auto-generated constructor stub
	}
	public animaliak(int id, String izena, int adina, String mota, String extra, int idJabea) {
		this.id = id;
		this.izena = izena;
		this.adina = adina;
		this.mota = mota;
		this.extra = extra;
		this.idJabea = idJabea;
	}
	public animaliak(String text, int adina2, String extra, String text2, int idJabea2) {
		this.izena = text;
		this.adina = adina2;
		this.mota = text2;
		this.extra = extra;
		this.idJabea = idJabea2;
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
	public int getAdina() {
		return adina;
	}
	public void setAdina(int adina) {
		this.adina = adina;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public String getExtra() {
		return extra;
	}
	public void setExtra(String extra) {
		this.extra = extra;
	}
	public int getIdJabea() {
		return idJabea;
	}
	public void setIdJabea(int idJabea) {
		this.idJabea = idJabea;
	}
	@Override
	public String toString() {
		return "animaliak [izena=" + izena + ", mota=" + mota;
	}
	
}
