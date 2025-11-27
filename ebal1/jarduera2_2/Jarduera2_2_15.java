package jarduera2_2;

import java.util.Scanner;

public class Jarduera2_2_15 {
	public static void main(String[]args) {
		int max, min, temp;
		temp = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Sar ezazu lehenengo zenbakia");
		temp = sc.nextInt();
		max = temp;
		min = temp;
		System.out.println("Sar ezazu bigarren zenbakia");
		temp = sc.nextInt();
		if(temp < min) {
			min = temp;
		}
		if(temp > max) {
			max = temp;
		}
		System.out.println("Sar ezazu hirugarren zenbakia");
		temp = sc.nextInt();
		if(temp < min) {
			min = temp;
		}
		if(temp > max) {
			max = temp;
		}
		System.out.println("Sar ezazu laugarren zenbakia");
		temp = sc.nextInt();
		if(temp < min) {
			min = temp;
		}
		if(temp > max) {
			max = temp;
		}
		System.out.println("Sar ezazu bostgarren zenbakia");
		temp = sc.nextInt();
		if(temp < min) {
			min = temp;
		}
		if(temp > max) {
			max = temp;
		}
		sc.close();
		System.out.println("Zenbaki txikiena "+min+" da.");
		System.out.println("Zenbaki handiena "+max+" da.");
//	    if (zenb1 > zenb2 && zenb1 > zenb3&& zenb1> zenb4&& zenb1> zenb5) {
//            System.out.println("Zenbaki handiena: " + zenb1);
//        } else if (zenb2 > zenb1 && zenb2 > zenb3 && zenb2 > zenb4 && zenb2 > zenb5) {
//            System.out.println("Zenbaki handiena: " + zenb2);
//        } else if (zenb3 > zenb1 && zenb3 > zenb2 && zenb3 > zenb4 && zenb3 > zenb5) {
//            System.out.println("Zenbaki handiena: " + zenb3);
//        } else if (zenb4 > zenb1 && zenb4 > zenb2 && zenb4 > zenb3 && zenb4 > zenb5) {
//            System.out.println("Zenbaki handiena: " + zenb4);
//        } else {
//            System.out.println("Zenbaki handiena: " + zenb5);
//        }
	}
}
