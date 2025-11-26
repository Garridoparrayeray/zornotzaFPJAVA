package ebal1_objetuak;
//import ebal1_objetuak.Pertsona;

public class main_froga {
	public static void main(String[] args) {
		Pertsona perts1 = new Pertsona("Yeray", 22, "79364887Y");
		System.out.println(perts1);
		System.out.println(perts1.getIzena() + perts1.getAdina() + perts1.getDni());
		//otra formas
		perts1.setAdina(22);
	}
}
