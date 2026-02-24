package view;

import java.util.Scanner;

import controller.*;

public class MainView {
	private ControllerBideoiokoak CB = new ControllerBideoiokoak();
	private Scanner sc = new Scanner(System.in);

	public void MenuNagusiaBistaratu() {
		System.out.println("===== MENU NAGUSIA =====");
		System.out.println("1.Erabiltzaileak bistaratu");
		System.out.println("2.Bideojokoak bistaratu");
		System.out.println("3.Erosketak bistaratu");
		System.out.println("4. Bideojokoen batez besteko prezioa kalkulatu eta erakutsi");
		System.out.println("5.Irten");
	}

	public void ErabiltzaileMenua() {
		System.out.println("====== ERABILTZAILE MENUA ====");
		System.out.println("1. Erabiltzaile guztiak bistaratu\n"
				+ "2. Adin jakin bat baino handiagoak diren erabiltzaileak bistaratu\n"
				+ "3. Erabiltzaile bakoitzak egindako erosketa kopurua erakutsi\n" + "4. Atzera");
	}

	public void BideojokoMenua() {
		System.out.println("===== BIDEOJOKO MENUA =====");
		System.out.println("1 Bideojoko guztiak bistaratu\n" + "2 Genero jakin bateko bideojokoak bistaratu\n"
				+ "3 Prezio jakin bat baino merkeagoak diren bideojokoak bistaratu\n"
				+ "4 Gehien erosi den bideojokoa erakutsi\n" + "5. Atzera");
	}

	public void AplikazioaHasi() {
		int aukeraNagusia = 0; 

		while (aukeraNagusia != 5) {
			MenuNagusiaBistaratu();
			System.out.println("Sartu zure aukera: ");
			aukeraNagusia = Integer.parseInt(sc.nextLine());
			
			switch (aukeraNagusia) {
			case 1:
				int aukeraErab = 0; 
				while (aukeraErab != 4) {
					ErabiltzaileMenua();
					System.out.println("Sartu zure aukera: ");
					aukeraErab = Integer.parseInt(sc.nextLine());
					
					switch (aukeraErab) {
					case 1:
						CB.getErabiltzaileak().forEach(System.out::println);
						break;
					case 2:
						CB.getErabiltzaileakAdinNagusia().forEach(System.out::println);
						break;
					case 3:
						CB.getErabiltzaileakErosketaTotalak().forEach(System.out::println);
						break;
					case 4:
						System.out.println("Atzera bota da.");
						break;
					default:
						System.err.println("Sartu zenbaki bat, 1etik - 4ra");
					}
				}
				break;
				
			case 2:
				int aukeraBideo = 0; 
				while (aukeraBideo != 5) {
					BideojokoMenua();
					System.out.println("Sartu zure aukera: ");
					aukeraBideo = Integer.parseInt(sc.nextLine());
					
					switch (aukeraBideo) {
					case 1:
						CB.getBideojokoak().forEach(System.out::println);
						break;
					case 2:
						System.out.println("Sartu ezazu generoa:");
						String generoa = sc.nextLine();
						CB.getBideojokoKonkretua(generoa).forEach(System.out::println);
						break;
					case 3:
						
						break;
					case 4:

						break;
					case 5:
						System.out.println("Atzera bota da.");
						break;
					default:
						System.err.println("Sartu zenbaki bat, 1etik - 5era");
					}
				}
				break;
				
			case 3:
				System.out.println("Erosketa lista: ");
				CB.getErosketak().forEach(System.out::println);
				break;
			case 4:
				System.out.println("Bideojokoen batazbesteko prezioa: "+ CB.getBideojokoBatazBez() + "€-koa da."); 
				break;
			case 5:
				System.out.println("Sistematik irten zara. Eskerrik asko!");
				System.exit(0); 
				break;
			default:
				System.err.println("Sartu zenbaki bat, 1etik - 5era");
			}
		}
	}
}
