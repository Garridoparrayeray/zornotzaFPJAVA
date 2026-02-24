package model;

public class Erosketa {
	private int id_erosketa;//autoincrement pk
	private int id_erabiltzailea;
	private int id_bideojokoa;
	private String date;
	private int orduak_jokatuta;
	private String erab_izena;
	private String bideojoko_izena;
	public Erosketa() {}

	public Erosketa(int id_erosketa, int id_erabiltzailea, int id_bideojokoa, String date, int orduak_jokatuta) {
		this.id_erosketa = id_erosketa;
		this.id_erabiltzailea = id_erabiltzailea;
		this.id_bideojokoa = id_bideojokoa;
		this.date = date;
		this.orduak_jokatuta = orduak_jokatuta;
	}
	public Erosketa(int id_erosketa, String erab_izena, String bideojoko_izena) {
		this.id_erosketa = id_erosketa;
		this.erab_izena = erab_izena;
		this.bideojoko_izena = bideojoko_izena;
	}
	
	/**
	 * @return the id_erosketa
	 */
	public int getId_erosketa() {
		return id_erosketa;
	}

	/**
	 * @param id_erosketa the id_erosketa to set
	 */
	public void setId_erosketa(int id_erosketa) {
		this.id_erosketa = id_erosketa;
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
	 * @return the id_bideojokoa
	 */
	public int getId_bideojokoa() {
		return id_bideojokoa;
	}

	/**
	 * @param id_bideojokoa the id_bideojokoa to set
	 */
	public void setId_bideojokoa(int id_bideojokoa) {
		this.id_bideojokoa = id_bideojokoa;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the orduak_jokatuta
	 */
	public int getOrduak_jokatuta() {
		return orduak_jokatuta;
	}

	/**
	 * @param orduak_jokatuta the orduak_jokatuta to set
	 */
	public void setOrduak_jokatuta(int orduak_jokatuta) {
		this.orduak_jokatuta = orduak_jokatuta;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Erosketa [id_erosketa=");
		builder.append(id_erosketa);
		builder.append(", id_erabiltzailea=");
		builder.append(id_erabiltzailea);
		builder.append(", id_bideojokoa=");
		builder.append(id_bideojokoa);
		builder.append(", date=");
		builder.append(date);
		if(orduak_jokatuta == 0) {
			System.out.println("Ez du jokatu jokoan");
		}else {
			builder.append(", orduak_jokatuta=");
			builder.append(orduak_jokatuta);
		}
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
