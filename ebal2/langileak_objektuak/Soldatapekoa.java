package langileak_objektuak;

public class Soldatapekoa extends Langilea {
	private double soldataFinala;
	private int orduExtrak;

	public Soldatapekoa() {
		super();
		soldataFinala = super.getOinarrizkoSoldata();
		this.orduExtrak = 0;
	}

	// sartzeko langile normalaren konstruktorea(id automatikoa)
	public Soldatapekoa(String izena, double oinarrizkoSoldata) {
		super(izena, oinarrizkoSoldata, new Data());
		this.soldataFinala = oinarrizkoSoldata;
		this.orduExtrak = 0;
	}

	public Soldatapekoa(String izena, double oinarrizkoSoldata, Data d) {
		super(izena, oinarrizkoSoldata, d);
		this.orduExtrak = 0;
		this.soldataFinala = super.getOinarrizkoSoldata();
	}

	/**
	 * @return the soldataFinala
	 */
	public double getSoldataFinala() {
		return soldataFinala;
	}

	/**
	 * @param soldataFinala the soldataFinala to set
	 */
	public void setSoldataFinala(double soldataFinala) {
		this.soldataFinala = soldataFinala;
	}

	/**
	 * @return the orduExtrak
	 */
	public int getOrduExtrak() {
		return orduExtrak;
	}

	/**
	 * @param orduExtrak the orduExtrak to set
	 */
	public void setOrduExtrak(int orduExtrak) {
		if (orduExtrak >= 0) {
			this.orduExtrak = orduExtrak;
		} else {
			System.out.println("Errorea: Ordu extra kopurua ezin da negatiboa izan.");
		}
	}

	public void soldataFinalaKalkulatu(double orduExtraOrdainketa) {
		double extraOrdainketaTotala = this.orduExtrak * orduExtraOrdainketa;
		this.soldataFinala = this.getOinarrizkoSoldata() + extraOrdainketaTotala;
	}

}
