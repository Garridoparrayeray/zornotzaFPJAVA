package jarduera2_3;

import java.util.Scanner;

public class Jarduera2_3_17 {
	//10 zenbaki eskatu eta pantailatik handiena eta txikiena atera.
	public static void main(String[] args) {
		int i, temp, zenb, max, min;
		
		i = 10;
		temp = 0;
		zenb = 0;
		max = temp;
		min = temp;
		Scanner sc = new Scanner(System.in);
		
		while(i >= 0) {
			System.out.println("Sartu zenbaki bat: ");
			zenb = sc.nextInt();
			if(zenb>= temp) {
				temp = zenb;
				max = temp;
			}else if (zenb < temp) {
				temp = zenb;
				min = temp;
			}
			i--;
			System.out.println(i + "zenbaki faltatzen dira sartzeko");
			
		}
		sc.close();
		System.out.println("Sartu duzun zenbaki handiena "+max+" da");
		System.out.println("Sartu duzun zenbaki txikiena"+min+" da");
	}

}
