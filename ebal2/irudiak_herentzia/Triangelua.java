package irudiak_herentzia;

public class Triangelua extends Irudia2D{
	private estiloa mota;
	
	//konstruktore hutsa
	public Triangelua() {
		super();
	}
	
	//konstruktore beteta
	public Triangelua(estiloa mota, float zabalera, float altuera) {
		super(zabalera, altuera);
		this.mota = mota;
	}

	public void areaTriangelu(float altuera, float zabalera) {
		float area;
		
		area = 0.0f;
		area = (altuera*zabalera)/2;

		System.out.println(estiloaIkusi(mota) + " Eta bere area, " + area + " da.");
	}
	public String estiloaIkusi(estiloa mota) {
		return "Triangeluaren estiloa " + mota + " da.";
	}
}
enum estiloa{
	isoszele, eskaleno, aldekidea;
}