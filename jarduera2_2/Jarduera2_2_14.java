package jarduera2_2;

import java.util.Scanner;

public class Jarduera2_2_14 {
	//Eskatu hiru zenbaki eta ikustarazi txikienetik handienera.
	public static void main(String[]args) {
		int zenb1, zenb2, zenb3;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Sar ezazu lehenengo zenbakia");
		zenb1 = sc.nextInt();
		
		System.out.println("Sar ezazu bigarren zenbakia");
		zenb2 = sc.nextInt();
		
		System.out.println("Sar ezazu hirugarren zenbakia");
		zenb3 = sc.nextInt();
		
		if((zenb1 < zenb2) && (zenb2 < zenb3)) {
			System.out.println(zenb1+" - "+zenb2+" - "+ zenb3);
		}else if((zenb2 < zenb1)&&(zenb1 < zenb3)) {
			System.out.println(zenb2+" - "+zenb1+" - "+ zenb3);
		}else if ((zenb3 < zenb1)&&(zenb1<zenb2)) {
			System.out.println(zenb3+" - "+zenb1+" - "+ zenb2);
		}else if((zenb2<zenb3)&&(zenb3<zenb1)) {
			System.out.println(zenb2+" - "+zenb3+" - "+ zenb1);
		}else if((zenb3 < zenb2)&&(zenb2<zenb1)) {
			System.out.println(zenb3+" - "+zenb2+" - "+ zenb1);
		}else if((zenb1 < zenb3)&&(zenb3<zenb2)) {
			System.out.println(zenb1+" - "+zenb3+" - "+ zenb2);
		}
	}

}
