package jarduera2_5;

import java.util.Scanner;

public class Jarduera2_5_8 {
//10 luzerako arraia teklatutik sartutako zenbakiekin bete. Gero honako menua atera, dagozkion aukerak garatuz:
//Batuketa kalkulatu eta bistaratu.
//Zenbakirik altuena bistaratu.
//Zenbakirik txikiena bistaratu.
//Zenbaki bat eskatu eta arraian zenbat bider agertzen den bistaratu.
	public static void main(String[] args) {
		
		int menuzenb, i, batuketa, max, min, case4, temp;
		int zenbakiak[] = new int[10];
		boolean aurkitu;
		
		aurkitu = false;
		i = 0;
		max = 0;
		min = Integer.MAX_VALUE;
		batuketa = 0;
		temp = 0;
 		Scanner sc = new Scanner(System.in);
 		
 		System.out.println("----Sartu 10 zenbaki-----");
 		
 		for(i = 0;i< zenbakiak.length;i++) {
			System.out.println("Sartu "+(i+1)+" zenbakia: ");
			zenbakiak[i] = sc.nextInt();	
		}
 		
 		//switch(menua)
 		do {
 			System.out.println("---Sartu zenbaki bat---");
			System.out.println("---MENUA---");
			System.out.println("---1. Batuketa kalkulatu---");
			System.out.println("---2. Zenbaki altuena bistaratu---");
			System.out.println("---3. Zenbaki baxuena bistaratu---");
			System.out.println("---4. Zenbakiaren bilakaera---");
			System.out.println("---5. Irten---");		
			
			menuzenb = sc.nextInt();
 			switch(menuzenb) {
 				case 1:
 					//KALKULUAK
 					for(i = 0; i < zenbakiak.length ; i++) {
 						//batuketa egin	
 						batuketa += zenbakiak[i];
 					}
 					System.out.println("Zenbakien batuera: "+ batuketa+ " da");
 					break;
 				case 2:
 					for(i = 0; i < zenbakiak.length ; i++) {
 						if(zenbakiak[i] > max) {
							max  = zenbakiak[i];
						}
 					}
 					System.out.println("Zenbaki maximoa " + max + " da");
 					break;
 				case 3:
 					for(i = 0; i < zenbakiak.length ; i++) {
 						if(zenbakiak[i] < min) {
							min = zenbakiak[i];
						}
					}
 					System.out.println("Zenbaki minimoa " + min + " da");
 					break;
 				case 4: 
 					System.out.println("Sartu bilatu nahi duzun zenbakia: ");
 					case4 = sc.nextInt();
 					for(i = 0; i < zenbakiak.length ; i++) {
 						if(zenbakiak[i] == case4) {
 							aurkitu = true;
 							temp++;
						}
					}
 					if(aurkitu = true) {
 						System.out.println("Zenbaki " + case4 + " aurkitu da, "+ temp + " aldiz.");
 					}else {
 						System.out.println("Zenbaki "+ case4 + " ez da aurkitu");
 					}
 					break;
 				case 5:
 					System.out.println("Programatik irteten...");
 					break;
 				default: 
 					System.out.println("Sartu zenbaki bat 1 eta 5 artean");
 					break;
 					
 			}
 			
 		}while(menuzenb != 5);
 		sc.close();
	}
}
