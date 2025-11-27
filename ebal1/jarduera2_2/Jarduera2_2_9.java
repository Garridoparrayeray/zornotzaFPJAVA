package jarduera2_2;

import java.util.Scanner;

public class Jarduera2_2_9 {
	//Eskatu erabiltzailea eta pasahitza eta zehaztu login-a zuzena den (erabiltzailea: ikaslea eta pasahitza: ik23249.
	public static void main(String[]args) {
		String usr, inputpass, inputusr, pass;
		
		usr = "ik23249";
		pass = "ik23249";
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("Sartu erabiltzailea: ");
			inputusr = sc.nextLine();
			System.out.println("Sartu erabiltzailearen pasahitza: ");
			inputpass = sc.nextLine();
			if (inputusr.equals(usr) && inputpass.equals(pass)) {
				System.out.println("Ongi etorri, "+inputusr);
				break;
			}else {
				System.out.println("Erabiltzailea edo/eta pasahitzak, okerrak dira. Saiatu berriro");
			}
		}while(true);
		sc.close();
	}
}
