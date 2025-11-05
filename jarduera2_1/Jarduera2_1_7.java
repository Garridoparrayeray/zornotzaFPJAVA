package jarduera2_1;

import java.util.Scanner;

public class Jarduera2_1_7 {
	//Kalkulatu karratu baten azalera.
	public static void main(String[]args) {
		double aldea;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Sartu karratu aldearen neurria:");

		aldea = sc.nextDouble();
		
		sc.close();
		
		System.out.println("Karratuaren azalera: "+(aldea*aldea)+"m2-koa da.");
	}
}
