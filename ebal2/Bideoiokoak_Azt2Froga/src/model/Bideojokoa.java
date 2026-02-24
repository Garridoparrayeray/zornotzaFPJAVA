package model;

public class Bideojokoa {
	private int id_bideojokoa;//PK AUTOINCREMENT
	private String izena;
	private String generoa;
	private double prezioa;
	private int adin_muga;
	
	public Bideojokoa() {}//konstruktore hutsa
	
	//konstruktore guztia
	public Bideojokoa(int id_bideojokoa, String izena, String generoa, double prezioa, int adin_muga) {
		this.id_bideojokoa = id_bideojokoa;
		this.izena = izena;
		this.generoa = generoa;
		this.prezioa = prezioa;
		this.adin_muga = adin_muga;
	}

	//getter eta setterrak

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
	 * @return the generoa
	 */
	public String getGeneroa() {
		return generoa;
	}

	/**
	 * @param generoa the generoa to set
	 */
	public void setGeneroa(String generoa) {
		this.generoa = generoa;
	}

	/**
	 * @return the prezioa
	 */
	public double getPrezioa() {
		return prezioa;
	}

	/**
	 * @param prezioa the prezioa to set
	 */
	public void setPrezioa(double prezioa) {
		this.prezioa = prezioa;
	}

	/**
	 * @return the adin_muga
	 */
	public int getAdin_muga() {
		return adin_muga;
	}

	/**
	 * @param adin_muga the adin_muga to set
	 */
	public void setAdin_muga(int adin_muga) {
		this.adin_muga = adin_muga;
	}

	//personalizatua
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Bideojokoa [id_bideojokoa=");
		builder.append(id_bideojokoa);
		builder.append(", izena=");
		builder.append(izena);
		builder.append(", generoa=");
		builder.append(generoa);
		builder.append(", prezioa=");
		builder.append(prezioa);
		builder.append(", adin_muga=");
		builder.append(adin_muga);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
