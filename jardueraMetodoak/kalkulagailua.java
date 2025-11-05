package jardueraMetodoak;

import java.util.Scanner;
public class kalkulagailua {		

	public static void main(String[]args) {
		int z1, z2, aukerak;
		Scanner sc = new Scanner(System.in);
		
		z1 = 0;
		z2 = 0;
		aukerak = 0;
		
		System.out.println("Sartu zenbaki 1: ");
		z1 = sc.nextInt();
		System.out.println("Sartu zenbaki 2: ");
		z2 = sc.nextInt();
		do {
			System.out.println("Ze operazio egin nahi duzu?");
			System.out.println("1-BATUKETA");
			System.out.println("2-KENKETA");
			System.out.println("3-BIDERKETA");
			System.out.println("4-ZATIKETA");
			System.out.println("5-IRTEN");
			switch(aukerak) {
				case 1:
					System.out.println("Zure zenbakien batuketa: "+batuketa(z1, z2) + " da.");
					
					break;
				case 2:
					System.out.println("Zure zenbakien kenketa: "+kenketa(z1, z2)+ " da.");
					
					break;
				case 3:
					System.out.println("Zure zenbakien biderketa: "+biderketa(z1, z2)+ " da.");
					break;
				case 4:
					System.out.println("Zure zenbakien zatiketa: "+zatiketa(z1, z2)+ " da.");
					break;
				case 0:
					System.out.println("Irteten....");
				default:
					System.out.println("Sartu zenbaki bat 0tik 4-ra. Sakatu 0 programatik irteteko.");
			}
		}while(aukerak != 0);
		sc.close();
	}
	
	
	
	public static int batuketa(int z1,int z2) {
		return(z1+z2);
	}
	public static int kenketa(int z1,int z2) {
		return(z1-z2);
	}
	public static int biderketa(int z1,int z2) {
		return(z1*z2);
	}
	public static double zatiketa(int z1,int z2) {
		
		return(z1/z2);
	}
	
}
