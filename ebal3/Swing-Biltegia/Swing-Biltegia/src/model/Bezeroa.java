package model;

/**
 * Bezeroaren eredua (Model geruza)
 */
public class Bezeroa {

    private String id;
    private String izena;
    private String helbidea;
    private String postaKodea;
    private String telefonoa;

    // Eraikitzaile hutsa
    public Bezeroa() {}

    // Eraikitzaile osoa
    public Bezeroa(String id, String izena, String helbidea, String postaKodea, String telefonoa) {
        this.id = id;
        this.izena = izena;
        this.helbidea = helbidea;
        this.postaKodea = postaKodea;
        this.telefonoa = telefonoa;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public String getHelbidea() {
		return helbidea;
	}

	public void setHelbidea(String helbidea) {
		this.helbidea = helbidea;
	}

	public String getPostaKodea() {
		return postaKodea;
	}

	public void setPostaKodea(String postaKodea) {
		this.postaKodea = postaKodea;
	}

	public String getTelefonoa() {
		return telefonoa;
	}

	public void setTelefonoa(String telefonoa) {
		this.telefonoa = telefonoa;
	}

    // Getter eta Setter metodoak

    
}