package ebal2_erronka_aurrekAZT;

public class Viplogela extends Logela {
	private double vipGehigarria;

	public Viplogela() {
		super();
	}

	public Viplogela(int lZ, int oK, double pB, double vG) {
		super(lZ, oK, pB);
		this.vipGehigarria = vG;
	}

	/**
	 * @return the vipGehigarria
	 */
	public double getVipGehigarria() {
		return vipGehigarria;
	}

	/**
	 * @param vipGehigarria the vipGehigarria to set
	 */
	public void setVipGehigarria(double vipGehigarria) {
		this.vipGehigarria = vipGehigarria;
	}

	@Override
	public String toString() {
		return "Viplogela [vipGehigarria=" + vipGehigarria + "]" +" Logela zenbakia: " +  super.getLogelaZenbakia() + " Okupatzaile kopurua: "+ super.getOkupatzaileenKopurua() + " Pertsonako prezioa: "+  super.getPertsonakoPrezioa();
	}
	
	@Override
	public void logelarenPrezioaLortu(){
		System.out.println((getPertsonakoPrezioa() * getOkupatzaileenKopurua() + vipGehigarria) + "€");
	}
	
	
	
}
