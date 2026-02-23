package model;

public class Liburua {
	private String izenburua;
	private String egilea;
	private String isbn;
	private int orriKopurua;
	private boolean mailegatuta;
	
	//konstruktore hutsa
	public Liburua() {}
	
	//konstruktore beteta
	public Liburua(String i, String e, String isbn, int o, boolean m) {
		this.izenburua = i;
		this.egilea = e;
		this.isbn = isbn;
		this.orriKopurua = o;
		this.mailegatuta = m;
	}
	
	//getterrak eta setterrak


	/**
	 * @return the izenburua
	 */
	public String getIzenburua() {
		return izenburua;
	}

	/**
	 * @param izenburua the izenburua to set
	 */
	public void setIzenburua(String izenburua) {
		this.izenburua = izenburua;
	}

	/**
	 * @return the egilea
	 */
	public String getEgilea() {
		return egilea;
	}

	/**
	 * @param egilea the egilea to set
	 */
	public void setEgilea(String egilea) {
		this.egilea = egilea;
	}

	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * @return the orriKopurua
	 */
	public int getOrriKopurua() {
		return orriKopurua;
	}

	/**
	 * @param orriKopurua the orriKopurua to set
	 */
	public void setOrriKopurua(int orriKopurua) {
		this.orriKopurua = orriKopurua;
	}

	/**
	 * @return the mailegatuta
	 */
	public boolean isMailegatuta() {
		return mailegatuta;
	}

	/**
	 * @param mailegatuta the mailegatuta to set
	 */
	public void setMailegatuta(boolean mailegatuta) {
		this.mailegatuta = mailegatuta;
	}
	
	//funtzioak
	public boolean mailegatu() {
		return (this.mailegatuta = true);
	}
	
	public boolean itzuli() {
		return (this.mailegatuta = false);
	}
	
	//toString
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Liburua [izenburua=");
		builder.append(izenburua);
		builder.append("*egilea=");
		builder.append(egilea);
		builder.append("*isbn=");
		builder.append(isbn);
		builder.append("*orriKopurua=");
		builder.append(orriKopurua);
		builder.append("*mailegatuta=");
		builder.append(mailegatuta);
		builder.append("]");
		return builder.toString();
	}
	

	
}
