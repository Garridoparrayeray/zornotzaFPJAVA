package langileak_objektuak;

public class KanpoKontsultorea extends Langilea {
	private double soldataFinala;
	private int orduak;

	public KanpoKontsultorea() {
		super();
		soldataFinala = 0.0;
		orduak = 0;
	}

	public KanpoKontsultorea(String izena, Data jaiotzeData) {
		// Kanpo kontsultoreek oinarrizko soldata 0 dute, superklaseari 0 pasatzen diogu
		super(izena, 0.0, jaiotzeData);
		// Hasierako baldintzak:
		this.orduak = 0;
		this.soldataFinala = 0.0;
	}

	public KanpoKontsultorea(double soldataFinala, int orduak) {
		this.soldataFinala = soldataFinala;
		this.orduak = orduak;
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
	public int getOrduak() {
		return orduak;
	}

	/**
	 * @param orduExtrak the orduExtrak to set
	 */
	public void setOrduak(int orduak) {
		this.orduak = orduak;
	}

	public void soldataFinalaKalkulatu(double ordainketa) {
		ordainketa *= this.orduak;
		this.soldataFinala = ordainketa;

	}
    @Override
    public String toString() {
        // Hemen super.toString() erabil dezakegu, nahiz eta oinarrizko soldata 0 izan
        return "KanpoKontsultorea [" + super.toString() + ", egindakoOrduak=" + orduak + ", soldataFinala=" + soldataFinala + "]";
    }


}
