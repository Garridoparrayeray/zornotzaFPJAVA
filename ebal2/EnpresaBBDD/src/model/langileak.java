package model;

public class langileak {
	private int id;
	private String first_name;
	private String last_name;
	private String department;
	private double salario;
	
	//konstruktore hutsa
	public langileak() {}
	//konstruktore guztia
	public langileak(int id, String first_name, String last_name, String department, double salario) {
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.department = department;
		this.salario = salario;
	}
	//getterrak eta setterrak
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}
	/**
	 * @param first_name the first_name to set
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	/**
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}
	/**
	 * @param last_name the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}
	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	/**
	 * @return the salario
	 */
	public double getSalario() {
		return salario;
	}
	/**
	 * @param salario the salario to set
	 */
	public void setSalario(double salario) {
		this.salario = salario;
	}
	@Override
	public String toString() {
		return "langileak [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", department="
				+ department + ", salario=" + salario + "]";
	}

	
}
