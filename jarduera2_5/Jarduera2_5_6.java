package jarduera2_5;

import java.util.Scanner;

public class Jarduera2_5_6 {
	//5 luzerako arraia definitu eta izenez bete. 
	//Erabiltzaileari izen bat eskatu eta arraian dagoen edo ez adierazi.
	public static void main(String[] args) {
		String izen;
		boolean dago;
		
		dago = false;
		String izenak[] = new String[5];//5-ko luzeera.
		izenak[0]= "paco";
		izenak[1] = "patxi";
		izenak[2] = "alfonso";
		izenak[3] = "eder";
		izenak[4] = "yeray";
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Sartu bilatu nahi dozun izena: ");
		izen = sc.nextLine();
		for(int i = 0; i < izenak.length ; i++) {
			if(izen.toLowerCase().equals(izenak[i])){
				dago = true;
			}else {
				dago = false;
			}
			
		}
		if(dago = false) {
			System.out.println(izen + " array barruen ez dago");
		}else {
			System.out.println(izen + " array barruen dago");
		}
		
		
	}
}
