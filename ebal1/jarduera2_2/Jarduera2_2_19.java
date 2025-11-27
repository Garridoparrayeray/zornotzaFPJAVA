package jarduera2_2;

import java.util.Scanner;

public class Jarduera2_2_19 {
	//Sartu zenbaki bat eta esleitu dagokion nota:
	public static void main(String[]args) {
		double nota;
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Sartu zenbaki bat eta esleitu dagokion nota:");
		nota = sc.nextDouble();
		if(nota >= 9 && nota <= 10) {
				System.out.println("Bikain.");
		}else if(nota < 9 && nota >= 7) {
			System.out.println("Oso Ondo.");
		}else if(nota < 7 && nota >= 6) {
			System.out.println("Ondo.");
		}else if (nota < 6 && nota >= 5) {
			System.out.println("Nahiko");
		}else {
			System.out.println("Gutxi");
		}
		sc.close();


	}
	}
