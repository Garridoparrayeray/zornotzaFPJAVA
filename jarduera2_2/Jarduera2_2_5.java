package jarduera2_2;

import java.util.Scanner;

public class Jarduera2_2_5 {
	//Irakurri zenbaki bat eta zehaztu 0 eta 10 artean dagoen (biak barne).
	public static void main(String[]args) {
		int zenb1;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Sartu zenbakia:");
		zenb1 = sc.nextInt();
		if(zenb1>=0 && zenb1<=10) {
			System.out.println(zenb1+", 0 eta 10 tartean dago.");
		}else {
			System.out.println(zenb1+", ez dago 0 eta 10 tartean.");
		}
		sc.close();
	}
}
