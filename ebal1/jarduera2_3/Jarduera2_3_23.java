package jarduera2_3;

import java.util.Scanner;

public class Jarduera2_3_23 {
	//Menu bat atera, 1,2,3 aukerekin. Erabiltzaileak 4 sartzen badu, AGUR atera pantailatik. Bestela, erabiltzaileak aukeratutakoa atera.
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
				case 1, 2, 3:
					System.out.println("OK.");
					break;	
				case 4:
					System.out.println("AGUR");
					break;		
				default:
					System.out.println("ERROREA");
				}
			}while(zenb1 != 4);
			sc.close();
		}
	}


