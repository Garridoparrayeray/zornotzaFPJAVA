package jarduera2_2;

import java.util.Scanner;

public class Jarduera_2_2_3 {
//Irakurri zenbaki bat eta zehaztu positiboa, negatiboa edo zero den.

	public static void main(String[]args) {
		int zenb1;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Sartu zenbakia:");
		zenb1 = sc.nextInt();
		
		sc.close();
		if(zenb1 > 0) {
			System.out.println("Zenbakia, "+zenb1+" positiboa da.");
		}else if(zenb1 < 0) {
			System.out.println("Zenbakia, "+zenb1+" negatiboa da.");
		}else {
			System.out.println("Zenbakia, "+zenb1+" da.");
		}
	}
}
