package jarduera2_5;

import java.util.Scanner;

public class Jarduera2_5_5 {
	//5 luzerako arraia definitu eta izenekin bete. 
	//Gero, a letraz hasten diren izenak pantailatik atera.
	public static void main(String[] args) {
		
		String izena[] = new String[5];
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < izena.length; i++) {
			System.out.println("Sartu "+(i+1)+" izena: ");
			izena[i] = sc.nextLine();
		}
		System.out.println("a letraz hasten diren izenak hauek dira: ");
		for(int i = 0;i <izena.length; i++) {
			if(izena[i].startsWith("a")|| izena[i].startsWith("A")) {
				System.out.println(izena[i]);
			}
		}
		for(String izen:izena) {
			if(izen.startsWith("a")) {
				System.out.println(izen);
			}
		}
		sc.close();
		System.out.println();
	}

}
