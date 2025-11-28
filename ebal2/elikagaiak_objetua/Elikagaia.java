package elikagaiak_objetua;

public class Elikagaiak {
	String elikagai_izena;
	String egoera;
	String elikagai_mota;
	double kaloriak;
	double karbohidratoak;
	double koipeak;
	double proteinak;

	//Konstruktore beteta
	public Elikagaiak(String elikagai_izena, String egoera, double kaloriak,
			double koipeak, double proteinak, double karbohidratoak, String elikagai_mota) {
		this.elikagai_izena = elikagai_izena;
		this.egoera = egoera;
		this.kaloriak = kaloriak;
		this.koipeak = koipeak;
		this.proteinak = proteinak;
		this.karbohidratoak = karbohidratoak;
		this.elikagai_mota = elikagai_mota;
	}
	
	//konstruktore hutsa
	public Elikagaiak() {
		this.elikagai_izena = "";
		this.egoera = "";
		this.kaloriak = 0.0;
		this.koipeak = 0.0;
		this.proteinak = 0.0;
		this.karbohidratoak = 0.0;
		this.elikagai_mota = "";

	}

	//getters and setters
	public String getElikagai_izena() {
		return elikagai_izena;
	}

	public void setElikagai_izena(String elikagai_izena) {
		this.elikagai_izena = elikagai_izena;
	}

	public String getEgoera() {
		return egoera;
	}

	public void setEgoera(String egoera) {
		this.egoera = egoera;
	}

	public String getElikagai_mota() {
		return elikagai_mota;
	}

	public void setElikagai_mota(String elikagai_mota) {
		this.elikagai_mota = elikagai_mota;
	}

	public double getKaloriak() {
		return kaloriak;
	}

	public void setKaloriak(double kaloriak) {
		this.kaloriak = kaloriak;
	}

	public double getKarbohidratoak() {
		return karbohidratoak;
	}

	public void setKarbohidratoak(double karbohidratoak) {
		this.karbohidratoak = karbohidratoak;
	}

	public double getKoipeak() {
		return koipeak;
	}

	public void setKoipeak(double koipeak) {
		this.koipeak = koipeak;
	}


	public double getProteinak() {
		return proteinak;
	}

	public void setProteinak(double proteinak) {
		this.proteinak = proteinak;
	}

	public String JanariaNutriscore() {
		return "Elikagai izena: " + elikagai_izena + "\n"
				+ "Egoera: " + egoera + "\n"
				+ "Kaloriak: " + kaloriak + "\n"
				+ "Karbohidratoak: " + karbohidratoak + "\n"
				+ "Koipeak: " + koipeak + "\n"
				+ "Proteinak: " + proteinak + "\n";
	}
	@Override
	public String toString() {
		return "Elikagaiak [elikagai_izena=" + elikagai_izena + ", egoera=" + egoera + ", elikagai_mota="
				+ elikagai_mota + ", kaloriak=" + kaloriak + ", karbohidratoak=" + karbohidratoak + ", koipeak="
				+ koipeak + ", proteinak=" + proteinak + "]";
	}
	
	
	
}
