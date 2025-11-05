package jarduera2_5;

import java.util.Arrays;
import java.util.Scanner;

public class Jarduera2_5_17 {
	//10eko arraia definitu eta 10 zenbaki eskatu. 
	//Arraia txikienetik handienera ordenatuta gelditu behar da.
	public static void main(String[] args) {
		int zenbArray[];
		
		zenbArray = new int[10];
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Sartu 10 zenbaki: ");
		for(int i = 0 ; i < zenbArray.length ; i++) {
			System.out.println("Sartu "+ (i+1) + " zenbakia:");
			zenbArray[i] = sc.nextInt();
		}
		Arrays.sort(zenbArray);
		for(int i = 0; i < zenbArray.length; i++) {
			System.out.println(zenbArray[i]);
		}
	}
}
