package jarduera2_3;

import java.util.Scanner;

public class Jarduera2_3_12 {
	//Programa bat idatzi, zenbaki bat eskatzen duena eta bere biderketa taula ateratzen duena, 1etik 10era.
	public static void main(String[] args) {
		int a;
		int i;
		
		i = 0;
		a = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Sartu zenbaki bat: ");
		a = sc.nextInt();
		sc.close();
		while(i<=10) {
			System.out.println(a * i);
			i++;
		}
	}
}
