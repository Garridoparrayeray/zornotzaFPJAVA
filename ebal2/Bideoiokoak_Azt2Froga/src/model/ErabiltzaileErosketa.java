package model;

public class ErabiltzaileErosketa {
	private Erabiltzailea erabiltzaile;
	private int erosketa_kop;
	
	public ErabiltzaileErosketa(Erabiltzailea erabiltzaile, int erosketa_kop) {
		this.erabiltzaile = erabiltzaile;
		this.erosketa_kop = erosketa_kop;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Erabiltzaile: ").append(erabiltzaile.getIzena());
		
		if(erosketa_kop == 0) {
			builder.append(" -> Ez dauka erosketarik oraindik."); // Lo metemos en el builder
		} else {
			builder.append(" -> Erosketa kopurua: ").append(erosketa_kop);
		}
		
		return builder.toString();
	}
	
}
