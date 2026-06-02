package model;

import java.sql.Date;

public class Erreserba {
	private int idErreserba;
	private int idBezeroa;
	private Date data;
	private int idKlasea;
	private String klaseIzena;
	public Erreserba() {
		// TODO Auto-generated constructor stub
	}
	public Erreserba(int idErreserba, int idBezeroa, Date data, int idKlasea, String klaseIzena) {
		super();
		this.idErreserba = idErreserba;
		this.idBezeroa = idBezeroa;
		this.data = data;
		this.idKlasea = idKlasea;
		this.klaseIzena = klaseIzena;
	}
	
	public Erreserba(int idBezeroa, Date data, int idKlasea) {
		this.idBezeroa = idBezeroa;
		this.data = data;
		this.idKlasea = idKlasea;
	}
	public int getIdErreserba() {
		return idErreserba;
	}
	public void setIdErreserba(int idErreserba) {
		this.idErreserba = idErreserba;
	}
	public int getIdBezeroa() {
		return idBezeroa;
	}
	public void setIdBezeroa(int idBezeroa) {
		this.idBezeroa = idBezeroa;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public int getIdKlasea() {
		return idKlasea;
	}
	public void setIdKlasea(int idKlasea) {
		this.idKlasea = idKlasea;
	}
	public String getKlaseIzena() {
		return klaseIzena;
	}
	public void setKlaseIzena(String klaseIzena) {
		this.klaseIzena = klaseIzena;
	}
	
}
