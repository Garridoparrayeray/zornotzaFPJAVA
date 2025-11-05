package jarduera2_2;

import java.util.Scanner;

public class Jarduera2_2_2 {
	public static void main(String[] args) {
		//Eskatu erabiltzaileari bi zenbaki eta erakutsi bien batura pantailatik.
		int zenb1;
		int zenb2;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Sartu lehenengo zenbakia:");
		zenb1 = sc.nextInt();
		
		System.out.println("Sartu bigarren zenbaki:");
		zenb2 = sc.nextInt();
		
		sc.close();
		if(zenb1>zenb2) {
			System.out.println("Lehengo zenbakia, "+zenb1+ ", handiagoa da");
		}else if(zenb1<zenb2){
			System.out.println("Bigarren zenbakia, "+zenb1+ ", handiagoa da");
		}else {
			System.out.println("Zenbakiak berdinak dira");
		}
				
	}
}
