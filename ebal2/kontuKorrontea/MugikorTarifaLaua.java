package kontuKorrontea;

public class MugikorTarifaLaua extends MugikorAurreordainketa{

	public MugikorTarifaLaua() {
		super();
	}

	public MugikorTarifaLaua(long mZ, float dEK, float dMK, float mBK, float s) {
		super(mZ, dEK, dMK, mBK, s);
	}
	
	@Override
	public void nabigatu(int mb){
		//ez du aldatzen saldoa ordun ez duzu hartu behar
		System.out.println("Kostoa ez du aldatzen, 0 da. Tarifa laua dekozu.");
	}
	
}
