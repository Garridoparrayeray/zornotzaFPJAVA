package jarduera2_3;

import java.util.Scanner;

public class Jarduera2_3_16 {
	//10 zenbaki eskatu eta pantailatik handiena atera.
	public static void main(String[] args) {
		int i;
		int temp;
		int zenb;
		
		i = 10;
		temp = 0;
		zenb = 0;
		Scanner sc = new Scanner(System.in);
		
		while(i >= 0) {
			System.out.println("Sartu zenbaki bat: ");
			zenb = sc.nextInt();
			if(zenb>= temp) {
				temp = zenb;
			}
			System.out.println(i + "zenbaki faltatzen dira sartzeko");
			i--;
		}
		System.out.println("Sartu duzun zenbaki handiena "+temp+" da");
	}
}
