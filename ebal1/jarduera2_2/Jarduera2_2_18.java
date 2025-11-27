package jarduera2_2;

import java.util.Scanner;

public class Jarduera2_2_18 {
	//Erakutsi menu bat eta menuko aukera bat hautatu ezkero, erakutsi dagokion esaldia, 
	//bestela erakutsi ERROREA.
	public static void main(String[]args) {
		int zenb1;
			
			Scanner sc = new Scanner(System.in);
			do{
				System.out.println("---Sartu zenbaki bat---");
				System.out.println("---MENUA---");
				System.out.println("---1. Zerrenda ikusi---");
				System.out.println("---2. Elementuak sartu---");
				System.out.println("---3. Elementuak ezabatu---");
				System.out.println("---4. Irten---");
				zenb1 = sc.nextInt();
					
				switch(zenb1) {
				case 1:
					System.out.println("---1. Zerrenda ikusi---");
				case 2:
					System.out.println("---2. Elementuak sartu---");
				case 3:
					System.out.println("---3. Elementuak ezabatu---");
					break;	
				case 4:
					System.out.println("---4. Irten---");
					System.out.println("Programatik ateratzen....");
					break;		
				default:
					System.out.println("ERROREA");
				}
			}while(zenb1 != 4);
			sc.close();
		}
}
