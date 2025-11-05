package jarduera2_8;

import java.util.Scanner;

public class Jarduera2_8_1 {
	public static void main(String[] args) {
		int aukerak, batuera, i, temp;	
		
		Scanner sc = new Scanner(System.in);
		int zenb[] = {2, 23, 43, 12, 6, 77, 80, 111, 56, 5, 80, 235, 55, 69, 9, 0, 71, 24, 124, 88, 67};
		aukerak = 0;
		i = 0;
		batuera = 0;
		temp = 0;
		
		do {
			System.out.println("-------MENU--------");
			System.out.println("1.Arraian dauden zenbaki guztien batuketa kalkulatu.");
			System.out.println("2.Arraian dauden zenbaki bakoiti guztien batuketa kalkulatu.");
			System.out.println("3.Arraian dauden zenbaki bikoiti guztien batuketa kalkulatu.");
			System.out.println("4.Arraian dauden zenbaki guztien batazbestekoa kalkulatu.");
			System.out.println("5.Arraian dauden zenbaki bakoiti guztien batazbestekoa kalkulatu.");
			System.out.println("6.Arraian dauden zenbaki bikoiti guztien batazbestekoa kalkulatu.");
			System.out.println("7.Bistaratu 45 eta 60 artean dauden zenbakiak.");
			System.out.println("8.Kalkulatu azken 10 zenbakien biderketa.");
			System.out.println("9.Kalkulatu 10 eta 20 posizioen artean dauden zenbakien biderketa.");
			System.out.println("10.IRTEN");
			aukerak = sc.nextInt();

			switch(aukerak) {
			case 1:
				batuera = 0;
				for(i = 0; i < zenb.length; i++) {
					batuera += zenb[i];
				}
				System.out.println("Arrayaren zenbakien batuketa "+ batuera+ " da.");
				break;
			case 2:
				batuera = 0;
				for(i = 0; i < zenb.length; i++) {
					if(zenb[i]%2 !=0) {
						batuera += zenb[i];
					}
				}
				System.out.println("Arrayaren zenbaki bakoitien batuketa "+ batuera+ " da.");
				break;
			case 3:
				batuera = 0;
				for(i = 0; i < zenb.length; i++) {
					if(zenb[i]%2 == 0) {
						batuera += zenb[i];
					}
				}
				System.out.println("Arrayaren zenbaki bikoitien batuketa "+ batuera+ " da.");
				break;
			case 4:
				batuera = 0;
				for(i = 0; i < zenb.length; i++) {
					batuera += zenb[i];
				}
				batuera /= zenb.length;
				System.out.println("Arrayaren zenbaki guztien bataz bestekoa"+ batuera+ " da.");
				break;
			case 5:
				batuera = 0;
				temp = 0;
				for(i = 0; i < zenb.length; i++) {
					if(zenb[i]%2 !=0) {
						batuera += zenb[i];
						temp++;
					}
				}
				batuera/=temp;
				System.out.println("Arrayaren zenbaki bakoiti bataz bestekoa"+ batuera+ " da.");
				break;
			case 6:
				batuera = 0;
				temp = 0;
				for(i = 0; i < zenb.length; i++) {
					if(zenb[i]%2 == 0) {
						batuera += zenb[i];
						temp++;
					}
				}
				batuera/=temp;
				System.out.println("Arrayaren zenbaki bikoiti bataz bestekoa"+ batuera+ " da.");
				break;
			case 7:
				batuera = 0;
				System.out.println("45-60 artean dauden zenbakiak: ");
					for(i = 0; i < zenb.length; i++) {
						if(zenb[i] > 45 && zenb[i] < 60) {
							System.out.println(zenb[i]);
						}
					}
				break;
			case 8:
				batuera = 0;
				for(i = zenb.length; i > (zenb.length - 10); i--) {
					batuera *= zenb[i];
				}
				System.out.println("Azken 10 zenbakien biderketa: "+ batuera + " da.");
				break;
			case 9:
				batuera = 0;
				for(i = 10; i < 20; i++) {
					batuera *= zenb[i];
				}
				System.out.println("10 eta 20 posizioen arteko zenbakien biderketa: "+ batuera + " da.");
				break;
			case 10:
				
				System.out.println("Irteten...");
				break;
			}
		}while(aukerak != 10);
		sc.close();
	}
}
