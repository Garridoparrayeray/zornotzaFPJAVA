package jarduera2_6;

import java.util.Scanner;

public class Jarduera2_6_5 {
//triangeluAreaKalkulatu funtzioa sortu, oinarria eta altura jasotzen dituena eta area bistaratzen duena.
	public static double triangeluAreaKalkulatu(int oinarri, int altura) {
		return((double)(oinarri*altura)/2);
	}
	
	public static void main(String[] args) {
		int oinarri, altura;
		Scanner sc = new Scanner(System.in);
		
		oinarri= 0;
		altura = 0;
		
		System.out.println("Sartu  triangeluaren oinarria: ");
		oinarri= sc.nextInt();
		
		System.out.println("Sartu  triangeluaren altura: ");
		altura= sc.nextInt();
		
		System.out.println("triangeluaren area: "+ triangeluAreaKalkulatu(oinarri, altura) + " da.");
		sc.close();
	}
}
