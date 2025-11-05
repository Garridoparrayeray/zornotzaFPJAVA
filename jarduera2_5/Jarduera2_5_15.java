package jarduera2_5;

import java.util.Scanner;

public class Jarduera2_5_15 {
	//10 luzerako arraia bete behar da zenbaki osoekin.
	//Zenbaki positiboen batazbesteko eta zenbaki nebatiboen batazbestekoa kalkulatu behar da.
	public static void main(String[] args) {
		int zenb[] = new int[10];
		int positibo, negatibo, zero;
		double bbez_positibo, bbez_negatibo;

		Scanner sc = new Scanner(System.in);

		bbez_negatibo = 0;
		bbez_positibo = 0;
		positibo = 0;
		negatibo = 0;
		zero = 0;
		System.out.println("Sar ezazu 10 zenbaki");
		for(int i = 0; i < zenb.length; i++) {
			System.out.println("zenbaki "+ (i+1)+ ":");
			zenb[i] = sc.nextInt();
			if(zenb[i] > 0) {
				positibo++;
				bbez_positibo += zenb[i];
			}else if(zenb[i] < 0) {
				bbez_negatibo += zenb[i];
				negatibo++;
			}else {
				zero++;
			}
		}
		sc.close();
		bbez_positibo /= positibo;
		bbez_negatibo = bbez_negatibo/negatibo;
		System.out.println(positibo + " zenbaki positiboak daude");
		System.out.println(negatibo + " zenbaki negatibo daude");
		System.out.println(zero + " zero sartu dira");
		System.out.println("Positibo batazbes: "+ bbez_positibo);
		System.out.println("Negatibo batazbes: "+ bbez_negatibo);
	}
}