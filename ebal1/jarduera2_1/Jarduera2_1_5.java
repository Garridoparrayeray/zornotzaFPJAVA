package jarduera2_1;

import java.util.Scanner;

public class Jarduera2_1_5 {
	//Eskatu erabiltzaileari hiru zenbaki eta erakutsi hiruren biderketa pantailatik.
	public static void main(String[]args) {
		int zenb1, zenb2, zenb3;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Sartu lehenengo zenbakia:");
		zenb1 = sc.nextInt();
		
		System.out.println("Sartu bigarren zenbaki:");
		zenb2 = sc.nextInt();
		
		System.out.println("Sartu hirugarren zenbaki:");
		zenb3 = sc.nextInt();
		
		sc.close();
		
		System.out.println("Hiru zenbakien biderketa: "+ (zenb1*zenb2*zenb3) + " da.");
	}
}
