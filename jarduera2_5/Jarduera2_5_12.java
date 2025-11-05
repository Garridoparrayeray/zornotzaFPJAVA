package jarduera2_5;

import java.util.Scanner;

public class Jarduera2_5_12 {
	//10eko arraia bete. Katea eskatu eta kate hori zenbat hitzetan agertzen den (bilaketa bat egin).
	public static void main(String[] args) {
		String izen;
		boolean dago;
		int temp;
		
		String izenak[] = {"paco", "patxi", "aaa", "uuu", "iii", "uuu", "uuu", "zzz", "qqq", "nnn"};//5-ko luzeera.

		temp = 0;
		dago = false;

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Sartu bilatu nahi dozun izena: ");
		izen = sc.nextLine();
		for(int i = 0; i < izenak.length ; i++) {
			if(izen.toLowerCase().equals(izenak[i])){
				temp++;
				dago = true;
				
			}else {
				dago = false;
			}
			
		}
		if(dago = false) {
			System.out.println(izen + " array barruen ez dago");
		}else {
			System.out.println(izen + " array barruen dago "+ temp +" alditan" );
		}
		sc.close();
	}
}
