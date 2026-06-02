package model;

public class Klaseak {
	public int idKlasea;
	public String izena;
	public String instruktorea;
	public String ordutegia;
	public Klaseak() {
	}
	public Klaseak(int idKlasea, String izena, String instruktorea, String ordutegia) {
		super();
		this.idKlasea = idKlasea;
		this.izena = izena;
		this.instruktorea = instruktorea;
		this.ordutegia = ordutegia;
	}
	public Klaseak(String izena, String instruktorea, String ordutegia) {
		this.izena = izena;
		this.instruktorea = instruktorea;
		this.ordutegia = ordutegia;
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
	/**
	 * @return the instruktorea
	 */
	public String getInstruktorea() {
		return instruktorea;
	}
	/**
	 * @param instruktorea the instruktorea to set
	 */
	public void setInstruktorea(String instruktorea) {
		this.instruktorea = instruktorea;
	}
	/**
	 * @return the ordutegia
	 */
	public String getOrdutegia() {
		return ordutegia;
	}
	/**
	 * @param ordutegia the ordutegia to set
	 */
	public void setOrdutegia(String ordutegia) {
		this.ordutegia = ordutegia;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(idKlasea);
		builder.append(" - ");
		builder.append(izena);
		return builder.toString();
	}
	
	
}
