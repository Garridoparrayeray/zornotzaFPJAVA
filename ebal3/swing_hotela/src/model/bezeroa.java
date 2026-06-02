package model;

public class bezeroa {
	private int id;
	private String izena;
	private String abizena;
	private String dni;
	private String telefonoa;
	public bezeroa() {
	}
	public bezeroa(int i, String iz, String ab, String nan, String tel) {
		this.id = i;
		this.izena = iz;
		this.abizena = ab;
		this.dni = nan;
		this.telefonoa = tel;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getTelefonoa() {
		return telefonoa;
	}
	public void setTelefonoa(String telefonoa) {
		this.telefonoa = telefonoa;
	}
	@Override
	public String toString() {
		return "bezeroa [id=" + id + ", izena=" + izena + ", abizena=" + abizena + ", dni=" + dni + ", telefonoa="
				+ telefonoa + "]";
	}
	
}

