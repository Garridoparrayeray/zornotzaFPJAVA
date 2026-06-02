package model;

public class Gela {
	private int id;
	private int Solairua;
	private double prezioa;
	private String mota;
	private String extra;

	public Gela() {
		// TODO Auto-generated constructor stub
	}

	public Gela(int id, int solairua, double prezioa, String mota, String extra) {
		super();
		this.id = id;
		Solairua = solairua;
		this.prezioa = prezioa;
		this.mota = mota;
		this.extra = extra;
	}

	public Gela(int solairua2, double prezioa2, String mota, String text) {
		this.Solairua = solairua2;
		this.prezioa = prezioa2;
		this.mota = mota;
		this.extra = text;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSolairua() {
		return Solairua;
	}

	public void setSolairua(int solairua) {
		Solairua = solairua;
	}

	public double getPrezioa() {
		return prezioa;
	}

	public void setPrezioa(double prezioa) {
		this.prezioa = prezioa;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	@Override
	public String toString() {
		return "Gela [id=" + id + ", Solairua=" + Solairua + ", prezioa=" + prezioa + ", mota=" + mota + ", extra="
				+ extra + "]";
	}
	
}
