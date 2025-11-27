package jarduera2_3;

import java.util.Scanner;

public class Jarduera2_3_13 {
	//Programa bat idatzi 0-tik erabiltzaileak sartutako zenbakirarteko zenbakiak ateratzen dituena.
	public static void main(String[] args) {
		int a;
		int i;
		
		i = 0;
		a = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Sartu zenbaki bat: ");
		a = sc.nextInt();
		sc.close();
		while(i <= a) {
			System.out.println(i);
			i++;
		}
	}

}
