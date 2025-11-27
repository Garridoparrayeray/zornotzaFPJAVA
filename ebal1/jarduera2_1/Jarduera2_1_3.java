package jarduera2_1;

import java.util.Scanner;

public class Jarduera2_1_3 {
	public static void main(String[]args) {
		/*Eskatu erabiltzaileari bere izena eta erakutsi pantailatik "Zure izena" izena "da".*/
		String izena;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Sartu zure izena");
		izena = sc.nextLine();
		sc.close();
		System.out.println("Zure izena "+izena+" da.");
	}
}
