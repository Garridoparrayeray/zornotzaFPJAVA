package ebal2_objektuen_kudeaketa;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Ikastaro_kudeaketa {
	private static ArrayList<Ikastaro> ikastaroLista = new ArrayList<>();
	private static ArrayList<Ikasle> ikasleLista = new ArrayList<>();
	private static Scanner sc = new Scanner(System.in);
	private static int aukerak = 0;
	private static boolean aurkitu = false;

	public static void main(String[] args) {
		Ikastaro_kudeaketa app = new Ikastaro_kudeaketa();
		app.IkastaroKonprobaketa();
		app.menua();

	}

	public void menua() {

		do {
			System.out.println("1. Ikasle berria sortu.\r\n" + "\r\n" + "2. Ikastaro berria sortu.\r\n" + "\r\n"
					+ "3. Ikaslearen informazioa erakutsi.\r\n" + "\r\n" + "4. Ikastaroaren informazioa erakutsi.\r\n"
					+ "\r\n" + "5. Informazioa gorde.\r\n" + "\r\n" + "6. Irten.");
			System.out.println("Sartu zure aukera: ");
			aukerak = sc.nextInt();
			switch (aukerak) {
			case 1:
				IkasleaSortu();
				break;
			case 2:
				IkastaroaSortu();
				break;
			case 3:
				ikasleInformazioaErakutsi();
				break;
			case 4:
				ikastaroInformazioaErakutsi(true);

				break;
			case 5:
				ikasleInformazioaErakutsi();
				break;
			case 6:
				informazioaGorde();
				break;
			}
		} while (aukerak != 6);

	}

	public void IkastaroKonprobaketa() {
		if (ikastaroLista.isEmpty()) {
			IkastaroaSortu();
		}
	}

	public void ikastaroInformazioaErakutsi(boolean hartu) {
		String ikastaroHautaketa;
		if(hartu == false) {
			for (Ikastaro i : ikastaroLista) {
				System.out.println(i.getIkastaro());
			}
		}
		if(hartu == true) {
			do {
				System.out.println("Ikastaro bat hautatu: ");
				ikastaroInformazioaErakutsi(false);
				ikastaroHautaketa = sc.next();
				for (Ikastaro i : ikastaroLista) {
					if (i.getIkastaro().equalsIgnoreCase(ikastaroHautaketa)) {
						System.out.println(i);
						aurkitu = true;
						break;
					}
				}
				if (aurkitu == false) {
					System.out.println("Ikastaro hau ez da existitzen");
				}

			} while (aurkitu == false);
		}
	}
	public void ikasleInformazioaErakutsi() {
		String ikasleHautaketa;
		do {
			for(Ikasle i : ikasleLista) {
				System.out.println(i);
			}
			System.out.println("ikasle bat hautatu: ");
			
			ikasleHautaketa = sc.next();
			for (Ikasle i : ikasleLista) {
				if (i.getIzena().equalsIgnoreCase(ikasleHautaketa)) {
					System.out.println(i);
					aurkitu = true;
					break;
				}
			}
			if (aurkitu == false) {
				System.out.println("Ikasle hau ez da existitzen");
			}

		} while (aurkitu == false);
	}

	public void IkastaroaSortu() {
		String ikastaroIzena, ikastaro_deskribapena, irakaslea;
		aurkitu = false;
		ikastaroIzena = "";
		ikastaro_deskribapena = "";
		irakaslea = "";
		do {
			aurkitu = false;
			System.out.println("Sartu ikastaro izen berria: ");
			ikastaroIzena = sc.next();
			for (Ikastaro i : ikastaroLista) {
				if (i.getIkastaro().equalsIgnoreCase(ikastaroIzena)) {
					System.out.println("Ikastaro hau existitzen da jadanik.");
					aurkitu = true;
					break;
				}
			}
			

		} while (aurkitu == true);
		System.out.println("Sartu ikastaroaren deskribapena: ");
		ikastaro_deskribapena = sc.next();

		System.out.println("Sartu irakaslearen izena");
		irakaslea = sc.next();

		Ikastaro i = new Ikastaro(ikastaroIzena, ikastaro_deskribapena, irakaslea);
		ikastaroLista.add(i);
		System.out.println("Ikastaroa sortuta.");
	}

	public void IkasleaSortu() {
		String ikastaroHautaketa;
		Ikastaro ikastaroAurkituta = new Ikastaro();
		boolean dago;
		dago =false;
		aurkitu = false;
		ikastaroHautaketa = "";
		
		do {
			System.out.println("Ikastaro bat hautatu: ");
			ikastaroInformazioaErakutsi(false);
			ikastaroHautaketa = sc.next();
			for (Ikastaro i : ikastaroLista) {
				if (i.getIkastaro().equalsIgnoreCase(ikastaroHautaketa)) {
					ikastaroAurkituta = i;
					aurkitu = true;
					break;
				}
			}
			if (aurkitu == false) {
				System.out.println("Ikastaro hau ez da existitzen");
			}

		} while (aurkitu == false);
		
		aurkitu = false;
		
		System.out.println("Sartu ikasle berriaren izena: ");
		String izena = sc.next();
		
		Ikasle ikasleListan = new Ikasle();
		for(Ikasle e : ikasleLista) {
			if(e.getIzena().equals(izena)) {
				aurkitu = true;
				ikasleListan = e;
			}
		}
		
		if(aurkitu == true) {
			for(int i = 0; i < ikastaroAurkituta.IkasleLista.size(); i++) {
				if(ikasleLista.contains(ikasleListan)) {
					dago = true;
					System.out.println("ikaslea " + izena +  " jadanik dago ikastaroan " + ikastaroAurkituta + ".");
				}
			}
			if(dago == false) {
				ikastaroAurkituta.IkasleaGehitu(ikasleListan);
				System.out.println("Ikaslea (" + izena + ") gehitu da " + ikastaroAurkituta.getIkastaro() + " ikastarora.");
			}
			
		}
		System.out.println("Sartu ikaslearen adina: ");
		int adina = sc.nextInt();

		Ikasle IkasleBerria = new Ikasle(izena, adina);
		ikastaroAurkituta.IkasleaGehitu(IkasleBerria);
		IkasleBerria.ikastaroLista.add(ikastaroAurkituta);
		System.out.println("Ikaslea (" + izena + ") gehitu da " + ikastaroAurkituta.getIkastaro() + " ikastarora.");
		ikasleLista.add(IkasleBerria);

		do {
			System.out.println("Beste ikastaro batean sartu nahi duzu?(bai = 1, ez = 0)");
			aukerak = sc.nextInt();
			switch (aukerak) {
			case 1:
				IkasleaSortu();
				break;
			case 0:
				break;
			default:
				System.out.println("(Sartu 1 edo 0)");
				break;
			}
		} while (aukerak != 0);
	}
		
	public void informazioaGorde() {
		try {
			gordeIkasleakFitxategian("ikasleak.txt");
			gordeIkastaroakFitxategian("ikastaroak.txt");
			System.out.println("Informazio guztia ondo gorde da fitxategietan (ikasleak.txt eta ikastaroak.txt).");
		} catch (IOException e) {
			System.out.println("Errore bat gertatu da informazioa gordetzean.");
			e.printStackTrace();
		}
	}

	private void gordeIkasleakFitxategian(String fitxategiIzena) throws IOException {
		try (PrintWriter pw = new PrintWriter(new FileWriter(fitxategiIzena))) {
			pw.println("Izena|Adina|Matrikulatutako_Ikastaroen_Izenak"); 

			for (Ikasle ikasle : ikasleLista) {
				StringBuilder ikastaroIzenakSB = new StringBuilder();
				for (Ikastaro ikastaro : ikasle.getIkastaroLista()) {
					ikastaroIzenakSB.append(ikastaro.getIkastaro()).append(",");
				}
				String ikastaroIzenak = ikastaroIzenakSB.length() > 0 ? ikastaroIzenakSB.substring(0, ikastaroIzenakSB.length() - 1) : "Bat ere ez";

				pw.printf("%s|%d|%s%n", 
					ikasle.getIzena(), 
					ikasle.getAdina(), 
					ikastaroIzenak
				);
			}
		}
	}

	private void gordeIkastaroakFitxategian(String fitxategiIzena) throws IOException {
		try (PrintWriter pw = new PrintWriter(new FileWriter(fitxategiIzena))) {
			pw.println("Ikastaro Izena|Deskribapena|Irakaslea|Ikasleen_Izenak");

			for (Ikastaro ikastaro : ikastaroLista) {
				StringBuilder ikasleIzenakSB = new StringBuilder();
				for (Ikasle ikasle : ikastaro.getIkasleLista()) {
					ikasleIzenakSB.append(ikasle.getIzena()).append(",");
				}
				String ikasleIzenak = ikasleIzenakSB.length() > 0 ? ikasleIzenakSB.substring(0, ikasleIzenakSB.length() - 1) : "Bat ere ez";

				pw.printf("%s|%s|%s|%s%n",
					ikastaro.getIkastaro(),
					ikastaro.getIkastaro_deskribapena(),
					ikastaro.getIrakaslea(),
					ikasleIzenak
				);
			}
		}
	}
}