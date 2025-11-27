package jarduera2_2;

import java.util.Scanner;

public class Jarduera2_2_10 {
	//Eskatu hiru zenbaki, bata aurrekoa baino handiagoa. Horrela ez bada, atera ERROREA mezua.
	public static void main(String[]args) {
		int zenb1, zenb2, zenb3;
	
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Sartu lehenengo zenbakia:");
		zenb1 = sc.nextInt();
		
		System.out.println("Sartu bigarren zenbakia:");
		zenb2 = sc.nextInt();
		
		System.out.println("Sartu hirugarren zenbakia:");
		zenb3 = sc.nextInt();
		
		if((zenb1 < zenb2) && (zenb2 < zenb3)) {//bakarrik bi eta gero beste bi konparatzeko, ezin da beste moduan egin 
			System.out.println("Seguida egokia, "+zenb1 +" - " + zenb2 + " - " +zenb3);
		}else {
			System.out.println("ERROREA");
		}
		
	}
}
