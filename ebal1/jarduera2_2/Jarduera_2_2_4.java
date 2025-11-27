package jarduera2_2;

import java.util.Scanner;

public class Jarduera_2_2_4 {
	//Irakurri zenbaki bat eta zehaztu bakoitia edo bikoitia den.
	public static void main(String[]args) {
		int zenb1;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Sartu zenbakia:");
		zenb1 = sc.nextInt();
		if(zenb1%2==0) {
			System.out.println(zenb1+" bikoitia da.");
		}else {
			System.out.println(zenb1+" bakoitia da.");
		}
		sc.close();
	}
}
