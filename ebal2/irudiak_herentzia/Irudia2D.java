package irudiak_herentzia;

public class Irudia2D {
	float zabalera, altuera;

	//konstruktore lehenetsia
	public Irudia2D() {
		this.zabalera = 0.0f;
		this.altuera = 0.0f;
	}
	
	//konstruktore beteta
	public Irudia2D(float zabalera, float altuera) {
		this.zabalera = zabalera;
		this.altuera = altuera;
	}
	public float getZabalera() {
		return zabalera;
	}

	public void setZabalera(float zabalera) {
		this.zabalera = zabalera;
	}

	public float getAltuera() {
		return altuera;
	}

	public void setAltuera(float altuera) {
		this.altuera = altuera;
	}

	public void dimIkusi() {
		 System.out.print("zabalera : ");
		 System.out.printf("%.2f", zabalera);
		 System.out.print(" altuera: ");
		 System.out.printf("%.2f", altuera);
		 
	}
	
}
