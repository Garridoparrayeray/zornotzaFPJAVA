package jarduera2_6;

import java.util.Scanner;

public class Jarduera2_6_6 {
	//lehenaDa izeneko funtzioa sortu, int bat jasotzen du eta boolean bat itzultzen du.
	public static boolean lehenaDa(int zenb) {
		boolean lehena;
		lehena = true;
		
		for(int i = 2; i <= Math.sqrt(zenb); i++) {
			if(zenb % i == 0) {
				lehena = false;
				
			}
		}
		return lehena;
		
	}
	public static void main(String[] args) {
		int zenb;
		Scanner sc = new Scanner(System.in);
		
		zenb= 0;
		
		while(true) {
			System.out.println("Sartu zenbaki bat: ");
			zenb= sc.nextInt();
			if(zenb < 2) {
				System.out.println("ERROREA. Sartu zenbaki bat 2-tik hasita");
			}else {
				break;
			}
		}
		if(lehenaDa(zenb) == true) {
			System.out.println(zenb + " zenbakia lehena da.");
		}else {
			System.out.println(zenb + " zenbakia ez da lehena.");
		}
		
		
	}

}
