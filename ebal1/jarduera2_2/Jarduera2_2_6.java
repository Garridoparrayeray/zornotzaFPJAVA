package jarduera2_2;

import java.util.Scanner;

public class Jarduera2_2_6 {
	//Irakurri hiru zenbaki eta erakutsi pantailatik batuketa eta batazbestekoa.
	public static void main(String[] args) {
		int zenb1, zenb2, zenb3;
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Sartu lehenengo zenbakia:");
		zenb1 = sc.nextInt();
		
		System.out.println("Sartu bigarren zenbakia:");
		zenb2 = sc.nextInt();
		
		System.out.println("Sartu hirugarren zenbakia:");
		zenb3 = sc.nextInt();
		
		System.out.println("Hiru zenbakien batuera: "+(zenb1+zenb2+zenb3)+" da.");
		System.out.println("Hiru zenbakien batazbezte: "+((zenb1+zenb2+zenb3)/3)+" da.");
		sc.close();
	}
}
