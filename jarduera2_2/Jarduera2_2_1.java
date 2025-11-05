package jarduera2_2;

import java.util.Scanner;

public class Jarduera2_2_1 {
	//Irakurri zenbaki bat eta zehaztu gainditua edo ez gainditua den.
	public static void main(String[]args) {
		double zenb;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Sartu zure nota: ");
		zenb = sc.nextDouble();
		
		if(zenb >= 5) {
			System.out.println("Zure nota, "+zenb+" da, ordun gainditu duzu");
		}else {
			System.out.println("Zure nota, "+zenb+" da, ordun ez duzu gaindituta");
		}
	}
}
