package model;

public class Erabiltzaileak {
	public int id;
	public String izena;
	public String pasahitza;
	public String rol;
	
	public Erabiltzaileak() {
	}
	public Erabiltzaileak(int id, String izena, String pasahitza, String rol) {
		super();
		this.id = id;
		this.izena = izena;
		this.pasahitza = pasahitza;
		this.rol = rol;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	 * @return the pasahitza
	 */
	public String getPasahitza() {
		return pasahitza;
	}
	/**
	 * @param pasahitza the pasahitza to set
	 */
	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}
	/**
	 * @return the rol
	 */
	public String getRol() {
		return rol;
	}
	/**
	 * @param rol the rol to set
	 */
	public void setRol(String rol) {
		this.rol = rol;
	}

	

}
