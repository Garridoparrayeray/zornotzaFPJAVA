package jarduera2_3;

import java.util.Scanner;

public class Jarduera2_3_15 {
	//Programa bat idatzi, erabiltzaileak zehaztutako baloaren biderkatzaileak ateratzen dituena 0 eta 100 artean.
	public static void main(String[] args) {
		int a;
		int i;
		
		i = 0;
		a = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Sartu zenbaki bat: ");
		a = sc.nextInt();
		sc.close();
		while(i<=100) {
			if(i % a==0) {
				System.out.println(i);
			}
			i++;
		}
	}
}
