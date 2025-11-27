package jarduera2_2;

import java.util.Scanner;

public class Jarduera2_2_16 {
	//Eskatu 3 zenbaki eskatu eta adierazi hirugarrena aurreko bien batuketa den edo ez.
	public static void main(String[]args) {
		int zenb1, zenb2, zenb3, batuera;
	
		Scanner sc = new Scanner(System.in);
		batuera = 0;
		System.out.println("Sartu lehenengo zenbakia:");
		zenb1 = sc.nextInt();
		
		System.out.println("Sartu bigarren zenbakia:");
		zenb2 = sc.nextInt();
		
		System.out.println("Sartu hirugarren zenbakia:");
		zenb3 = sc.nextInt();
		batuera  = zenb1+zenb2;
		sc.close();
		if(zenb3 == batuera) {
			System.out.println(zenb3 + " eta "+ batuera+ " berdinak dira.");
		}else {
			System.out.println(zenb3 + " eta "+ batuera+ " ezberdinak dira.");
		}
	}
}
