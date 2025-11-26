package ebal2_objektuen_kudeaketa;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class NutriscoreAPP {

	private static Scanner sc = new Scanner(System.in);
	private static ArrayList<Elikagaiak> ElikagaiaLista = new ArrayList<>();
	final static String fitxategia = "./src/ebal2_objektuen_kudeaketa/janariak.txt";
	private static boolean aukeratuta = false;
	private static String aukera = "";

	public static void main(String[] args) {
		DatuakKargatu();
		int aukerak;

		aukerak = 0;

		do {
			MenuErakutsi();
			try {
				System.out.println("Sartu aukera bat: ");
				aukerak = sc.nextInt();
				switch (aukerak) {
				case 1:
					ElikagaiBilatzaile();
					break;
				case 2:
					ElikagaiakErakutsi();
					break;
				case 3:
					break;
				case 4:
					System.out.println("Irteten...");
					break;
				default:
					System.out.println("Sartu zenbaki bat 1tik 4ra");
					break;
				}
			} catch (InputMismatchException e) {
				System.err.println("ERROREA. Zenbaki oso bat sartu behar duzu.");
				sc.next();// buffer garbiketa
			}

		} while (aukerak != 4);

	}

	private static void DatuakKargatu() {

		int LerroKontaketa, JanariKontaketa;
		LerroKontaketa = 0;
		JanariKontaketa = 0;

		File f = new File(fitxategia);
		if (!f.exists() || !f.isFile()) {
			System.err.println("ERROREA. Fitxategia ezin da aurkitu. " + f.getAbsolutePath());
			System.exit(-1);
		}

		try {
			Scanner scFile = new Scanner(f);

			String lerroa;

			while (scFile.hasNext()) {
				lerroa = scFile.nextLine().trim();// .next() erabiltzen badugu, delimitadore bezala hartzen du espazioa,
													// -, eta gehiago. Errore emango du
				LerroKontaketa++;

				if (lerroa.isEmpty()) {
					System.err.println("OHARRA. " + "Lerroa: " + LerroKontaketa + " hutsik dago.");
					continue;// hurrengo ilarara saltatuko dugu
				}

				String aux[] = lerroa.split(";");// split-a datuk hartzeko
				String elikagai_izena = aux[0];
				String egoera = aux[1];
				double kaloriak = Double.parseDouble(aux[2]);
				double karbohidratoak = Double.parseDouble(aux[3]);
				double koipeak = Double.parseDouble(aux[4]);
				double proteinak = Double.parseDouble(aux[5]);
				String elikagai_mota = aux[6];
				Elikagaiak e = new Elikagaiak(elikagai_izena, egoera, kaloriak, karbohidratoak, koipeak, proteinak,
						elikagai_mota);
				ElikagaiaLista.add(e);
				JanariKontaketa++;

			}

			System.out.println("Janari kopurua: " + JanariKontaketa);
			do {
				System.out.println("Listaren edukiera ikusi nahi duzu?(bai/ez)");
				aukera = sc.next().toLowerCase().trim();
				switch (aukera) {
				case "bai":
					aukeratuta = true;
					System.out.println("Listaren edukiera:");
					for (Elikagaiak e : ElikagaiaLista) {
						System.out.println(e);
					}
					break;
				case "ez":
					aukeratuta = true;
					break;

				default:
					System.out.println("Idatzi bai edo ez");
					break;

				}
			} while (aukeratuta == false);

			scFile.close();
		} catch (Exception e) {
			System.err.println("ERRORE EZEZAGUNA " + e.getMessage());
		}

	}

	private static void MenuErakutsi() {
		System.out.println("1 - Elikagaien bilatzailea\r\n" + "\r\n" + "2 - Elikagaiak erakutsi\r\n" + "\r\n"
				+ "3 - Kaloriak kalkulatu\r\n" + "4 - Irten.");
	}

	// CASE 1
	private static void ElikagaiBilatzaile() {
		boolean aurkituta;
		
		aurkituta = false;
		do {
			System.out.println("Sartu elikagai bat: ");
			aukera = sc.next().trim();
			for (Elikagaiak e : ElikagaiaLista) {
				if (aukera.equalsIgnoreCase(e.getElikagai_izena().toLowerCase().trim())) {
					aurkituta = true;
					System.out.println(e.JanariaNutriscore());
				}
			}
			if (aurkituta == false) {
				System.err.println("ERROREA. Elikagai hori ez da existitzen.");
			}
		} while (aurkituta == false);

	}

	private static void ElikagaiakErakutsi() {
		int elikagaiLehenengoPos, elikagaiAzkenPos, i;
		i = 0;
		elikagaiLehenengoPos = 0;
		elikagaiAzkenPos = 0;
		while (true) {
			try {
				System.out.println("Sartu lehenengo elikagaiaren posizioa: ");
				elikagaiLehenengoPos = sc.nextInt();
				System.out.println("Sartu azkenengo posizioa: ");
				elikagaiAzkenPos = sc.nextInt();
				if (elikagaiLehenengoPos < 0 || elikagaiLehenengoPos > ElikagaiaLista.size() || elikagaiAzkenPos <= 0
						|| elikagaiAzkenPos > ElikagaiaLista.size()) {
					System.err.println("ERROREA. Sartu zenbaki bat 0 eta " + ElikagaiaLista.size() + " artean.");
				} else {
					break;
				}

			} catch (InputMismatchException e) {
				System.err.println("ERROREA. Zenbaki oso bat sartu behar duzu.");
				sc.next();// buffer garbiketa
			}

		}

		for (Elikagaiak e : ElikagaiaLista) {
			if (ElikagaiaLista.indexOf(e) >= elikagaiLehenengoPos && i <= elikagaiAzkenPos - 1) {
				i++;
				System.out.println(e);
			}

		}

	}
	
	
	private static void KaloriakKalkulatu() {
		boolean aurkituta;
		String elikagaia;
		elikagaia = "";
		aurkituta = false; 
		String elikagaia[];
		do {
			System.out.println("Sartu elikagai bat: ");
			aukera = sc.next().trim();
			for (Elikagaiak e : ElikagaiaLista) {
				if (aukera.equalsIgnoreCase(e.getElikagai_izena().toLowerCase().trim())) {
					aurkituta = true;
					elikagaia = e.getElikagai_izena();
					}
			}
			if (aurkituta == false) {
				System.err.println("ERROREA. Elikagai hori ez da existitzen.");
			}
		} while (aurkituta == false);
		
		do {
			System.out.println("Sartu egoera bat: ");
			aukera = sc.next().trim();
			for (Elikagaiak e : ElikagaiaLista) {
				if (aukera.equalsIgnoreCase(e.getEgoera().toLowerCase().trim())) {
					aurkituta = true;
					elikagaia = e.getElikagai_izena();
					}
			}
			if (aurkituta == false) {
				System.err.println("ERROREA. Elikagai hori egoera horrekin ez da existitzen.");
			}
		} while (aurkituta == false);
		
		
	}

}