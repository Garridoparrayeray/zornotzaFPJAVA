package ebal1_objetuak;

public class Auricular {
	private String modelo;
	private String marca;
	private double precio;
	private int stock;
	
	//konstruktore hutsa
	public Auricular() {
		this.modelo = "";
		this.marca = "";
		this.precio = 0.0;
		this.stock = 0;
	}
	//konstruktore lehenatsia
	public Auricular(String modelo, String marca, double precio, int stock) {
		this.modelo = modelo;
		this.marca = marca;
		this.precio = precio;
		this.stock = stock;	
	}
	//konstruktore arraylist(sartzeko berdina arrayak eta azterketa modukoa) OPZIO 1-KO
	public Auricular(String split) {
		String[]aux = split.split(";");
		this.modelo = aux[0];
		this.marca = aux[1];
		this.precio = Double.parseDouble(aux[2]);
		this.stock = Integer.parseInt(aux[3]);
				
	}
	/**
	 * @return the modelo
	 */
	public String getModelo() {
		return modelo;
	}
	/**
	 * @param modelo the modelo to set
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	/**
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}
	/**
	 * @param marca the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}
	/**
	 * @return the precio
	 */
	public double getPrecio() {
		return precio;
	}
	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	/**
	 * @return the stock
	 */
	public int getStock() {
		return stock;
	}
	/**
	 * @param stock the stock to set
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "Auricular [modelo=" + modelo + ", marca=" + marca + ", precio=" + precio + ", stock=" + stock + "]";
	}
	
}
