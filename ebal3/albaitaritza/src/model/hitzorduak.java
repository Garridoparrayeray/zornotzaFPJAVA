package model;

import java.sql.Date;

public class hitzorduak {
	private int id;
	private int idJabea;
	private int idAnimalia;
	private String animaliaIzena;
	private Date data;
	private String ordua;
	public hitzorduak() {
		// TODO Auto-generated constructor stub
	}
	public hitzorduak(int id, int idJabea, int idAnimalia, String animaliaIzena, Date data, String ordua) {
		super();
		this.id = id;
		this.idJabea = idJabea;
		this.idAnimalia = idAnimalia;
		this.animaliaIzena = animaliaIzena;
		this.data = data;
		this.ordua = ordua;
	}
	public hitzorduak(String animaliaIzena, Date data, String ordua, int i) {
		this.animaliaIzena = animaliaIzena;
		this.data = data;
		this.ordua = ordua;
		this.idJabea = i;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdJabea() {
		return idJabea;
	}
	public void setIdJabea(int idJabea) {
		this.idJabea = idJabea;
	}
	public int getIdAnimalia() {
		return idAnimalia;
	}
	public void setIdAnimalia(int idAnimalia) {
		this.idAnimalia = idAnimalia;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getOrdua() {
		return ordua;
	}
	public void setOrdua(String ordua) {
		this.ordua = ordua;
	}
	public String getAnimaliaIzena() {
		return animaliaIzena;
	}
	public void setAnimaliaIzena(String animaliaIzena) {
		this.animaliaIzena = animaliaIzena;
	}
	@Override
	public String toString() {
		return "hitzorduak [id=" + id +", animaliaIzena="
				+ animaliaIzena + ", data=" + data + ", ordua=" + ordua + "]";
	}
	
}
