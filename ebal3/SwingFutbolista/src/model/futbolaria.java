package model;

public class futbolaria {
	public String dni;
	public String nombre;
	public String apellido;
	public int salario;
	public int idEquipo;
	public futbolaria() {
	}
	public futbolaria(String dni, String nombre, String apellido, int salario, int idEquipo) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.salario = salario;
		this.idEquipo = idEquipo;
	}
	public String getApellido() {
		return apellido;
	}
	public String getDni() {
		return dni;
	}
	public int getIdEquipo() {
		return idEquipo;
	}
	public String getNombre() {
		return nombre;
	}
	public int getSalario() {
		return salario;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setSalario(int salario) {
		this.salario = salario;
	}
	@Override
	public String toString() {
	
		return super.toString();
	}
}
