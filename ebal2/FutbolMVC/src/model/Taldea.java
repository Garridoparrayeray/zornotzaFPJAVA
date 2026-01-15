package model;		// Modelo karpetan dauden klaseak erabiltzeko

public class Taldea {
	// Atributuak. DDBBko eremuen izenak kontuan izan
	private int idTaldea;
	private String izena;
	private String herria;
	
	// Eraikitzaileak
	public Taldea() {
	}
	public Taldea(int idTaldea, String izena, String herria) {
		this.idTaldea = idTaldea;
		this.izena = izena;
		this.herria = herria;
	}
	
	// Klaseko getterrak eta seterrak
	public int getIdTaldea() {
		return idTaldea;
	}
	public void setIdTaldea(int idTaldea) {
		this.idTaldea = idTaldea;
	}
	public String getIzena() {
		return izena;
	}
	public void setIzena(String izena) {
		this.izena = izena;
	}
	public String getHerria() {
		return herria;
	}
	public void setHerria(String herria) {
		this.herria = herria;
	}
	
	// toString
	@Override
	public String toString() {
		return "Taldea [idTaldea=" + idTaldea + ", izena=" + izena + ", herria=" + herria + "]";
	}
	
}



