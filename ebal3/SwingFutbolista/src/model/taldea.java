package model;

public class taldea {
	public int idEquipo;
	public String nombre;
	public String ciudad;
	
	public taldea() {
	
	}
	public taldea(int idEquipo, String nombre, String ciudad) {
		this.idEquipo = idEquipo;
		this.nombre = nombre;
		this.ciudad = ciudad;
		
	}
	
	public int getIdEquipo() {
		return idEquipo;
	}
	public String getCiudad() {
		return ciudad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return super.toString();
	}
}
