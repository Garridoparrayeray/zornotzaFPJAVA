package jarduera2_3;

import java.util.Scanner;

public class Jarduera2_3_11 {
	//Programa bat idatzi, zenbaki bat eskatzen duena eta pantailatik zenbakiaren kopuru bereko asteriskoak ateratzen dituena, lerro berean.
	public static void main(String[] args) {
		int a;
		
		a = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Sartu zenbaki bat: ");
		a = sc.nextInt();
		sc.close();
		while(a > 0) {
			System.out.print("*");
			a --;
		}
	}
}



