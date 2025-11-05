package jarduera2_6;

import java.util.Scanner;

public class Jarduera2_6_4 {
 //zirkuloAreaKalkulatu izeneko metodoa sortu. diametroa (int) izeneko parametroa jasoko du eta area (double) itzuliko du.
	public static double zirkuloAreaKalkulatu(int diametro) {
		return((Math.PI * Math.pow((diametro/2), 2)));
	}
	
	public static void main(String[] args) {
		int diametro;
		Scanner sc = new Scanner(System.in);
		diametro = 0;
		System.out.println("Sartu zirkuluaren diametroa: ");
		diametro = sc.nextInt();
		
		System.out.println("zirkuluaren area: "+ zirkuloAreaKalkulatu(diametro) + " da.");
		sc.close();
	}
}
