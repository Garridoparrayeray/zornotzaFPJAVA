package ebal2_erronka_aurrekAZT;

public class Viplogela extends Logela {
	private double vipGehigarria;

	public Viplogela() {
		super();
		this.vipGehigarria = 0.0;
		
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
		return "Viplogela [vipGehigarria=" + vipGehigarria + "]" + super.getLogelaZenbakia() + super.getOkupatzaileenKopurua() + super.getPertsonakoPrezioa();
	}
	
	public void logelarenPrezioaLortu(){
		System.out.println((super.pertsonakoPrezioa * super.okupatzaileenKopurua + vipGehigarria) + "€");
	}
	
	
	
}
