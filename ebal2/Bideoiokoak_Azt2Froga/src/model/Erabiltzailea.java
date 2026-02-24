package model;

public class Erabiltzailea {
	private int id_erabiltzailea;//autoincremetn pk
	private String izena;
	private String emaila;
	private int adina;
	
	public Erabiltzailea() {};
	
	public Erabiltzailea(int id_erabiltzailea, String izena, String emaila, int adina) {
		super();
		this.id_erabiltzailea = id_erabiltzailea;
		this.izena = izena;
		this.emaila = emaila;
		this.adina = adina;
	}

	/**
	 * @return the id_erabiltzailea
	 */
	public int getId_erabiltzailea() {
		return id_erabiltzailea;
	}

	/**
	 * @param id_erabiltzailea the id_erabiltzailea to set
	 */
	public void setId_erabiltzailea(int id_erabiltzailea) {
		this.id_erabiltzailea = id_erabiltzailea;
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
	 * @return the emaila
	 */
	public String getEmaila() {
		return emaila;
	}

	/**
	 * @param emaila the emaila to set
	 */
	public void setEmaila(String emaila) {
		this.emaila = emaila;
	}

	/**
	 * @return the adina
	 */
	public int getAdina() {
		return adina;
	}

	/**
	 * @param adina the adina to set
	 */
	public void setAdina(int adina) {
		this.adina = adina;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Erabiltzailea [id_erabiltzailea=");
		builder.append(id_erabiltzailea);
		builder.append(", izena=");
		builder.append(izena);
		builder.append(", emaila=");
		builder.append(emaila);
		builder.append(", adina=");
		builder.append(adina);
		builder.append("]");
		return builder.toString();
	}
	
	
}
