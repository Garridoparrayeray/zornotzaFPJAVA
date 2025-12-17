package ebal2_erronka_aurrekAZT;

public class Logela {
	private int logelaZenbakia;
	private int okupatzaileenKopurua;
	private double pertsonakoPrezioa;
	
	protected Logela() {
		this.logelaZenbakia = 0;
		this.okupatzaileenKopurua = 0;
		this.pertsonakoPrezioa = 0.0;
	}
	
	
	protected Logela (int lZ, int oK, double pB) {
		this.logelaZenbakia = lZ;
		this.okupatzaileenKopurua = oK;
		this.pertsonakoPrezioa = pB;
	}
	
	/**
	 * @return the logelaZenbakia
	 */
	public int getLogelaZenbakia() {
		return logelaZenbakia;
	}
	/**
	 * @param logelaZenbakia the logelaZenbakia to set
	 */
	public void setLogelaZenbakia(int logelaZenbakia) {
		this.logelaZenbakia = logelaZenbakia;
	}
	/**
	 * @return the okupatzaileenKopurua
	 */
	public int getOkupatzaileenKopurua() {
		return okupatzaileenKopurua;
	}
	/**
	 * @param okupatzaileenKopurua the okupatzaileenKopurua to set
	 */
	public void setOkupatzaileenKopurua(int okupatzaileenKopurua) {
		this.okupatzaileenKopurua = okupatzaileenKopurua;
	}
	/**
	 * @return the pertsonakoPrezioa
	 */
	public double getPertsonakoPrezioa() {
		return pertsonakoPrezioa;
	}
	/**
	 * @param pertsonakoPrezioa the pertsonakoPrezioa to set
	 */
	public void setPertsonakoPrezioa(double pertsonakoPrezioa) {
		this.pertsonakoPrezioa = pertsonakoPrezioa;
	}
	@Override
	public String toString() {
		return "logelaZenbakia : " + logelaZenbakia + ", okupatzaileenKopurua : " + okupatzaileenKopurua
				+ ", pertsonakoPrezioa=" + pertsonakoPrezioa ;
	}
	
	
	public void logelarenPrezioaLortu(){
		System.out.println(this.pertsonakoPrezioa * this.okupatzaileenKopurua + "€");
	}
	
	
	
}
