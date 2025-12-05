package langileak_objektuak;

public class Data {
	private int eguna;
	private int hilabetea;
	private int urtea;

	public Data() {
		this.eguna = 1;
		this.hilabetea = 1;
		this.urtea = 2025;
	}

	// Eraikitzaile pertsonalizatua
	public Data(int e, int h, int u) {
		// erroreen kontrola
		if (e >= 1 && e <= 31) {
			this.eguna = e;
		}
		
		if (h >= 1 && h <= 12) {
			this.hilabetea = h;
		}
		if (u != 0 && u > 1900) {
			this.urtea = u;
		}
	}
	
	public Data(Data d) {
		this.eguna = d.eguna;
		this.hilabetea = d.hilabetea;
		this.urtea = d.urtea;
	}

	/**
	 * @return the eguna
	 */
	public int getEguna() {
		return eguna;
	}

	/**
	 * @param eguna the eguna to set
	 */
	public void setEguna(int eguna) {

		// erroreen kontrola (beharrezkoa da)//luego si uso set algo, no deja sino
		if (eguna >= 1 && eguna <= 31) {
			this.eguna = eguna;
		}
	}

	/**
	 * @return the hilabetea
	 */
	public int getHilabetea() {
		return hilabetea;
	}

	/**
	 * @param hilabetea the hilabetea to set
	 */
	public void setHilabetea(int hilabetea) {
		// erroreen kontrola
		if (hilabetea >= 1 && hilabetea <= 12) {
			this.hilabetea = hilabetea;
		}
	}

	/**
	 * @return the urtea
	 */
	public int getUrtea() {
		return urtea;
	}

	/**
	 * @param urtea the urtea to set
	 */
	public void setUrtea(int urtea) {
		// erroreen kontrola
		if (urtea != 0) {
			this.urtea = urtea;
		}
	}

	@Override
	public String toString() {
		return "Data:" + eguna + "/" + hilabetea + "/" + urtea;
	}

}
