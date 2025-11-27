package animalia_objetuak;

import java.util.Arrays;

public class Animalia {
	String izena;
	String espeziea;
	int adina;
	String habitata[];
	
	//konstruktore hutsa
	public Animalia() {
		this.izena = "";
		this.espeziea = "";
		this.adina = 0;
		this.habitata = null;
	}
	
	//Konstruktore hasieratuta
	public Animalia(String izena, String espeziea, int adina, String habitata[]) {
		this.izena = izena;
		this.espeziea = espeziea;
		this.adina = adina;
		this.habitata = habitata;
	}
	
	//KOnstruktore kopia
	public Animalia(Animalia a) {
		this.izena = a.izena;
		this.espeziea = a.espeziea;
		this.adina = a.adina;
		this.habitata = a.habitata;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public String getEspeziea() {
		return espeziea;
	}

	public void setEspeziea(String espeziea) {
		this.espeziea = espeziea;
	}

	public int getAdina() {
		return adina;
	}

	public void setAdina(int adina) {
		this.adina = adina;
	}

	public String[] getHabitata() {
		return habitata;
	}

	public void setHabitata(String[] habitata) {
		this.habitata = habitata;
	}

	@Override
	public String toString() {
		return "Animalia [izena=" + izena + ", espeziea=" + espeziea + ", adina=" + adina + ", habitata="
				+ Arrays.toString(habitata) + "]";
	}
	
	public String datuakErakutsi() {
		return "izena: "+ this.izena
				+ "\n" + "espeziea: " + this.espeziea +
				"\n " + "adina: " + this.adina +
				"\n" + "habitata: " + Arrays.toString(habitata);
	}
}
