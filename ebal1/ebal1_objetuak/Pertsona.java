package ebal1_objetuak;

public class Pertsona {
	//Atributoak
	private String izena;
	private int adina;
	private String dni;

	//Eraikitzaile hutsa
	public Pertsona() {
		this.izena = "";
		this.adina = 0;
		this.dni = "";
	}
	//Eraikitzaile lehenasia
	public Pertsona(String izena, int adina, String dni) {
		super();
		this.izena = izena;
		this.adina = adina;
		this.dni = dni;
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

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
	@Override
	public String toString() {
		return "Pertsona [izena=" + izena + ", adina=" + adina + ", dni=" + dni + "]";
	}
	
}
