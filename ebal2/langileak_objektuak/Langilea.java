package langileak_objektuak;

import java.util.Date;

public class Langilea {
	int id;
	String izena;
	double oinarrizkoSoldata;
	Data jaiotzeData;
	int hurrengoId = 1;//automatikoki sortzen du id
	public Langilea() {
		this.id = 0;
		this.izena = "";
		this.oinarrizkoSoldata = 0.0;
		Data jaiotzeData = new Data();//lehenetsia 1/1/2025
	}
	
	public Langilea(String izena, double oinarrizkoSoldata) {
		this.id = hurrengoId++;
		this.izena = izena;
		this.oinarrizkoSoldata = oinarrizkoSoldata;
		this.jaiotzeData = new Data();
	}
	
	public Langilea(int id, String izena, double oinarrizkoSoldata, Data d) {
		this.id = id;
		this.izena = izena;
		this.oinarrizkoSoldata = oinarrizkoSoldata;
		
		this.jaiotzeData = new Data(d);//horrela datuak ez dira accesible publiko modun
		//BIGARREN MODUN: behartzen digu public egotea getterrak eta setterrak
		 // Usamos los getters del objeto 'd' para extraer los INTs
        // y usamos el constructor personalizado (int, int, int) de Data.
        //this.jaiotzeData = new Data(d.getEguna(), d.getHilabetea(), d.getUrtea());
	}

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
	 * @return the izena
	 */
	public String getIzena() {
		return izena;
	}

	/**
	 * @param izena the izena to set
	 */
	public void setIzena(String izena) {
		this.izena = izena;
	}

	/**
	 * @return the oinarrizkoSoldata
	 */
	public double getOinarrizkoSoldata() {
		return oinarrizkoSoldata;
	}

	/**
	 * @param oinarrizkoSoldata the oinarrizkoSoldata to set
	 */
	public void setOinarrizkoSoldata(double oinarrizkoSoldata) {
		this.oinarrizkoSoldata = oinarrizkoSoldata;
	}

	/**
	 * @return the jaiotzeData
	 */
	public Data getJaiotzeData() {
		return jaiotzeData;
	}

	/**
	 * @param jaiotzeData the jaiotzeData to set
	 */
	public void setJaiotzeData(Data jaiotzeData) {
		this.jaiotzeData = new Data(jaiotzeData);
	}

	@Override
	public String toString() {
		return "Langilea [id=" + id + ", izena=" + izena + ", oinarrizkoSoldata=" + oinarrizkoSoldata + ", jaiotzeData="
				+ jaiotzeData + "]";
	}
	
	
	
}
