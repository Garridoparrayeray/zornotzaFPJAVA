package ebal1_objetuak;

import java.util.Arrays;

public class animalia {
	String izena;
	String espeziea;
	int adina;
	String habitat[];
	//konstruktore beteta
	public animalia(String izena, String espeziea, int adina, String[] habitat) {
		this.izena = izena;
		this.espeziea = espeziea;
		this.adina = adina;
		this.habitat = habitat;
	}
	
	//konstruktore hutsa
	public animalia() {
		this.izena = "";
		this.espeziea = "";
		this.adina = 0;
		this.habitat = null;
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
	 * @return the espeziea
	 */
	public String getEspeziea() {
		return espeziea;
	}

	/**
	 * @param espeziea the espeziea to set
	 */
	public void setEspeziea(String espeziea) {
		this.espeziea = espeziea;
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
	 * @return the habitat
	 */
	public String[] getHabitat() {
		return habitat;
	}

	/**
	 * @param habitat the habitat to set
	 */
	public void setHabitat(String[] habitat) {
		this.habitat = habitat;
	}

	@Override
	public String toString() {
		return "animalia [izena=" + izena + ", espeziea=" + espeziea + ", adina=" + adina + ", habitat="
				+ Arrays.toString(habitat) + "]";
	}
	
}
