package jarduera2_5;

import java.util.Scanner;

public class Jarduera2_5_14 {
	//Programa batean 10 luzerako arraia sortu behar da, 
	//teklatutik irakurritako zenbakiekin bete behar da. 
	//Kalkulatu behar da zenbat zenbaki diren positiboak, 
	//zenbat negatiboak eta zenbat 0.
	public static void main(String[] args) {
		int zenb[] = new int[10];
		int positibo, negatibo, zero;
		
		Scanner sc = new Scanner(System.in);
		positibo = 0;
		negatibo = 0;
		zero = 0;
		System.out.println("Sar ezazu 10 zenbaki");
		for(int i = 0; i < zenb.length; i++) {
			System.out.println("zenbaki "+ (i+1)+ ":");
			zenb[i] = sc.nextInt();
			if(zenb[i] > 0) {
				positibo++;
			}else if(zenb[i] < 0) {
				negatibo++;
			}else {
				zero++;
			}
		}
		sc.close();
		System.out.println(positibo + " zenbaki positiboak daude");
		System.out.println(negatibo + " zenbaki negatibo daude");
		System.out.println(zero + " zero sartu dira");
	}
}
