package model; // Modelo karpetan dauden klaseak erabiltzeko

public class Futbolista {
	// Klasearen atributuak. DDBBko eremuak dira
	private String nan;
	private String izena;
	private String abizena;
	private double soldata;
	private int idTaldea;
	
	// Klasearen eraikitzaileak
	public Futbolista() {
	}
	public Futbolista(String nan, String izena, String abizena) {
		this.nan = nan;
		this.izena = izena;
		this.abizena = abizena;
	}
	public Futbolista(String nan, String izena, String abizena, double soldata) {
		this.nan = nan;
		this.izena = izena;
		this.abizena = abizena;
		this.soldata = soldata;
	}
	public Futbolista(String nan, String izena, String abizena, double soldata, int idTaldea) {
		this.nan = nan;
		this.izena = izena;
		this.abizena = abizena;
		this.soldata = soldata;
		this.idTaldea = idTaldea;
	}
	
	// DDBBko eremu guztien getterrak eta setterrak
	public String getNan() {
		return nan;
	}
	public void setNan(String nan) {
		this.nan = nan;
	}
	public String getIzena() {
		return izena;
	}
	public void setIzena(String izena) {
		this.izena = izena;
	}
	public String getAbizena() {
		return abizena;
	}
	public void setAbizena(String abizena) {
		this.abizena = abizena;
	}
	public double getSoldata() {
		return soldata;
	}
	public void setSoldata(double soldata) {
		this.soldata = soldata;
	}
	public int getIdTaldea() {
		return idTaldea;
	}
	public void setIdTaldea(int idTaldea) {
		this.idTaldea = idTaldea;
	}
	
	// toString
	@Override
	public String toString() {
	    return "Jokalaria:\n" +
	           "  DNI: " + nan + "\n" +
	           "  Izena: " + izena + "\n" +
	           "  Abizena: " + abizena + "\n" +
	           "  Soldata: " + soldata + "€\n" +
	           "  Taldea ID: " + idTaldea + "\n";
	}
}



