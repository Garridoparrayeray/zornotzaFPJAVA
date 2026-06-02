package model;

import java.sql.Date;


public class Erreserbak {
	public int idErreserba;
	public int idBezeroa;
	public String klaseIzena;
	public Date data;
	public int idKlasea;
	public Erreserbak() {
	}
	public Erreserbak(int idErreserba, int idBezeroa, Date data, int idKlasea) {
		super();
		this.idErreserba = idErreserba;
		this.idBezeroa = idBezeroa;
		this.data = data;
		this.idKlasea = idKlasea;
	}
	public Erreserbak(int idErreserba, String klaseIzena, Date data) {
		this.idErreserba = idErreserba;
		this.klaseIzena = klaseIzena;
		this.data = data;

	}
	/**
	 * @return the klaseIzena
	 */
	public String getKlaseIzena() {
		return klaseIzena;
	}
	/**
	 * @param klaseIzena the klaseIzena to set
	 */
	public void setKlaseIzena(String klaseIzena) {
		this.klaseIzena = klaseIzena;
	}
	/**
	 * @return the idErreserba
	 */
	public int getIdErreserba() {
		return idErreserba;
	}
	/**
	 * @param idErreserba the idErreserba to set
	 */
	public void setIdErreserba(int idErreserba) {
		this.idErreserba = idErreserba;
	}
	/**
	 * @return the idBezeroa
	 */
	public int getIdBezeroa() {
		return idBezeroa;
	}
	/**
	 * @param idBezeroa the idBezeroa to set
	 */
	public void setIdBezeroa(int idBezeroa) {
		this.idBezeroa = idBezeroa;
	}
	/**
	 * @return the data
	 */
	public Date getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(Date data) {
		this.data = data;
	}
	/**
	 * @return the idKlasea
	 */
	public int getIdKlasea() {
		return idKlasea;
	}
	/**
	 * @param idKlasea the idKlasea to set
	 */
	public void setIdKlasea(int idKlasea) {
		this.idKlasea = idKlasea;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(idKlasea);
		builder.append(" - ");
		builder.append(klaseIzena);
		return builder.toString();
	}
	
	
}
