package jarduera2_2;

import java.util.Scanner;
public class Jarduera2_2_7 {
//Eskatu zenbaki bat 1 eta 7ren artean eta zehaztu horri dagokion asteko eguna zein den.
	public static void main(String[]args) {
		int zenb1;
		
		Scanner sc = new Scanner(System.in);
		do{
			System.out.println("Idatzi asteko zenbaki bat 1etik 7ra, ateratzeko programatik sakatu 0");
			zenb1 = sc.nextInt();
				
			switch(zenb1) {
			case 0:
				System.out.println("Programatik ateratzen....");
				break;
			case 1:
				System.out.println("Astelehena.");
				break;
			case 2:
				System.out.println("Asteartea.");
				break;
			case 3:
				System.out.println("Asteazkena");
				break;
			case 4:
				System.out.println("Osteguna");
				break;
			case 5:
				System.out.println("Ostirala");
				break;
			case 6:
				System.out.println("Larunbata");
				break;
			case 7:
				System.out.println("Igandea");
				break;
			default:
				System.out.println("Sartu zenbaki bat 0tik-7ra");
			}
		}while(zenb1 != 0);
		sc.close();
	}
}
