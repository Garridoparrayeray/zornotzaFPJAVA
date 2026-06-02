package model;

import java.io.Serializable;
import java.sql.Date;

public class Erreserbak implements Serializable{
    @Override
	public String toString() {
		return "Erreserbak [id=" + id + ", idBezeroa=" + idBezeroa + ", idGela=" + idGela + ", data=" + data + "]";
	}
	private static final long serialVersionUID = 1L;  
	private int id;
	private int idBezeroa;
	private int idGela;
	private Date data;
	public Erreserbak() {
		// TODO Auto-generated constructor stub
	}
	public Erreserbak(int id, int idBezeroa, int idGela, Date data) {
		super();
		this.id = id;
		this.idBezeroa = idBezeroa;
		this.idGela = idGela;
		this.data = data;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdBezeroa() {
		return idBezeroa;
	}
	public void setIdBezeroa(int idBezeroa) {
		this.idBezeroa = idBezeroa;
	}
	public int getIdGela() {
		return idGela;
	}
	public void setIdGela(int idGela) {
		this.idGela = idGela;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
}
