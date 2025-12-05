package kontuKorrontea;

public class MugikorPlus extends MugikorAurreordainketa{
	
	//konstruktore hutsa
	protected MugikorPlus(){
		super();
	}
	//konstruktore beteta
	protected MugikorPlus(long mZ, float dEK, float dMK, float mBK, float s) {
		//mugikorZenb, dei ezarri kostea, dei minutu kostea, mb kontsumo kostea, saldoa
		super(mZ, dEK, dMK, mBK, s);
	}
	
	protected void bideodeia(int segunduak) {
		int kontsumoa = segunduak * 2;//MB/s
		super.nabigatu(kontsumoa);
	}
	

}
