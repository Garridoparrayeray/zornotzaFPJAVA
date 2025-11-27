package ebal1_Erronka;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Erronka1 {

	public static void main(String[] args) {

		File fitxategi = new File("./src/ebal1_Erronka/fitxategiak/BerdintasunDatuak.csv");
		Scanner sc = new Scanner(System.in);
		String herrialdea[], kokapena[], aux[];
		double lana[], dirua[], ezagupenak[], denbora[], boterea[], osasuna[];

		int kont, aukerak;

		kont = 0;
		aukerak = 0;

		// luzeera kalkulatu
		kont = ArrayLuzeera(kont, fitxategi);
		// luzeera bat emon
		herrialdea = new String[kont];
		kokapena = new String[kont];
		aux = new String[kont];
		lana = new double[kont];
		dirua = new double[kont];
		ezagupenak = new double[kont];
		denbora = new double[kont];
		boterea = new double[kont];
		osasuna = new double[kont];
		// array guztietan sartzeko informazioaren funtzioa
		ArrayanSartu(fitxategi, herrialdea, kokapena, lana, dirua, ezagupenak, denbora, boterea, osasuna, aux, kont);

		// menu printzipala akzio handienekin
		// errepikatzen da 1tik 6ra aukerak ipintzen badituzu, 7garrena irtetzen da
		do {
			//menu aukera baikoitzak
			System.out
					.println("1. Datuen bistaratzea herrialdeka" + "\n" + "2. DIRUA parametroaren datuen batazbestekoa"
							+ "\n" + "3. DENBORA parametroan batazbestekotik gora dauden herrialdeak" + "\n"
							+ "4. Herrialdearen balioak aldatu" + "\n" + "5. Datuak gorde" + "\n"
							+ "6. Berdintasun gutxien  duten herrialdeak" + "\n" + "7. Irten");
			aukerak = sc.nextInt();
			switch (aukerak) {
			case 1:
				DatuakBistaratuHerrialdeeka(herrialdea, kokapena, lana, dirua, ezagupenak, denbora, boterea, osasuna,
						sc);
				break;
			case 2:
				DiruaBatazbeste(kont, dirua);
				break;
			case 3:
				DenboraBatazbeste(kont, herrialdea, denbora);
				break;
			case 4:
				BalioakAldatu(herrialdea, kokapena, lana, dirua, ezagupenak, denbora, boterea, osasuna, sc);
				break;
			case 5:
				DatuakGordeFitxategian(fitxategi, herrialdea, kokapena, lana, dirua, ezagupenak, denbora, boterea,
						osasuna);
				break;
			case 6:
				BerdintasunMailaTxikiena(herrialdea, kokapena, lana, dirua, ezagupenak, denbora, boterea, osasuna);
				break;
			case 7:
				System.out.println("sistematik irteten...");
				break;
			default:
				System.out.println("Menu aukera hori ez da existitzen");
				break;
			}
		} while (aukerak != 7);
	}

	private static int ArrayLuzeera(int kont, File fitxategi) {
		try {
			Scanner scFile = new Scanner(fitxategi);
			kont = 0;
			// kentzen dugu lehenengo ilara
			scFile.nextLine();
			while (scFile.hasNextLine()) {
				kont++;
				scFile.nextLine();
			}
			scFile.close();

		} catch (FileNotFoundException e) {
			//artxiboa ez badu aurkitzen catch-eko erroeak aurkeztuko du
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Arrayaren luzeera ondo kargatu da.");
		return kont;
	}

	private static void ArrayanSartu(File fitxategi, String herrialdea[], String kokapena[], double lana[],
			double dirua[], double ezagupenak[], double denbora[], double boterea[], double osasuna[], String aux[],
			int kont) {
		//arrayan informazioa bete array auxiliar batekin
		try {
			Scanner scFile = new Scanner(fitxategi);
			scFile.nextLine();
			for (int i = 0; i < kont; i++) {
				aux = scFile.nextLine().split(";");
				herrialdea[i] = aux[0];
				kokapena[i] = aux[1];
				lana[i] = Double.parseDouble(aux[2]);
				dirua[i] = Double.parseDouble(aux[3]);
				ezagupenak[i] = Double.parseDouble(aux[4]);
				denbora[i] = Double.parseDouble(aux[5]);
				boterea[i] = Double.parseDouble(aux[6]);
				osasuna[i] = Double.parseDouble(aux[7]);
				// konprobaketa
				// System.out.println(herrialdea[i]+ kokapena[i] +lana[i]);
			}
			scFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Datuak ondo kargatu dira.");

	}

	// CASE 1
	private static int DatuakBistaratuHerrialdeeka(String herrialdea[], String kokapena[], double lana[],
			double dirua[], double ezagupenak[], double denbora[], double boterea[], double osasuna[], Scanner sc) {

		boolean ondo;
		String aurkitu;
		int pos = 0;
		ondo = false;
		aurkitu = "";
		while (ondo == false) {
			System.out.println("Sartu ikusi nahi duzun herrialdea: ");
			aurkitu = sc.next();
			for (int i = 0; i < herrialdea.length; i++) {
				if (aurkitu.equalsIgnoreCase(herrialdea[i])) {
					ondo = true;
					System.out.println("HERRIALDEA  KOKAPENA  LANA  DIRUA  EZAGUPENAK  DENBORA  OSASUNA");
					System.out.println(herrialdea[i] + " - " + kokapena[i] + " - " + lana[i] + " - " + dirua[i] + " - "
							+ ezagupenak[i] + " - " + denbora[i] + " - " + osasuna[i]);
					pos = i;
				}
			}
			if (ondo == false) {
				System.out.println("ERROREA. Ez da aurkitu herrialdea.");
			}
		}
		return pos;

	}

	// CASE 2
	private static void DiruaBatazbeste(int kont, double dirua[]) {

		double batazbeste;

		batazbeste = 0;

		for (int i = 0; i < dirua.length; i++) {
			batazbeste += dirua[i];
		}
		batazbeste /= kont;
		System.out.println("DIRUA parametroaren batazbestekoa " + kont + " herrialdeentzat " + batazbeste + " da.");
	}

	// CASE 3
	// bi opzioekin, arraylist bat gero imprimaketa egokia egiteko edo arraylist
	// gabe, nahasten println eta print
	private static void DenboraBatazbeste(int kont, String herrialdea[], double denbora[]) {

		double batazbeste;
//		ArrayList <String>erantzunak = new ArrayList<>();
		// String errenkada;
		batazbeste = 0;

		for (int i = 0; i < denbora.length; i++) {
			batazbeste += denbora[i];
		}
		batazbeste /= kont;
		System.out.println("Denbora parametroaren batazbestekoa " + kont + " herrialdeentzat " + batazbeste + " da.");
		System.out.print("Eta batazbesteko gorako herrialdeak: ");
		for (int i = 0; i < herrialdea.length; i++) {
			if (denbora[i] > batazbeste) {
				System.out.print(herrialdea[i] + ": " + denbora[i] + "  ");
//				errenkada = herrialdea[i] + ":" + denbora[i];
//				erantzunak.add(errenkada);
			}
		}
		System.out.println();
//		for(String datuak : erantzunak) {
//			System.out.print(datuak + " ");
//		}
	}

	//CASE 4
	private static void BalioakAldatu(String herrialdea[], String kokapena[], double lana[], double dirua[],
			double ezagupenak[], double denbora[], double boterea[], double osasuna[], Scanner sc) {

		int aukerak;
		int pos;
		String aldatuAukerak;
		boolean aldatu;
		double aldatuDouble;

		aldatu = false;
		aukerak = 0;
		aldatuDouble = 0.0;
		//Errekurtsibitatea erabiliz, hautatzen dugu ze herrialdean aldaketak egin nahi ditugu
		pos = DatuakBistaratuHerrialdeeka(herrialdea, kokapena, lana, dirua, ezagupenak, denbora, boterea, osasuna, sc);
		System.out.println("Herrialde " + herrialdea[pos] + " aukeratu duzu. Aldatu nahi duzu daturen bat? (bai/ez): ");
		aldatuAukerak = sc.next();
		//konprobazioa herrialdea txarto idatzi bada, ez sartzeko menuan
		switch (aldatuAukerak) {
		case "bai":
			aldatu = true;
			break;
		case "ez":
			break;
		default:
			System.out.println("hautatu bai edo ez.");
			break;
		}
		
		//datu guztietako menua + aldaketa bakoitzeko aukera (errore erabilerekin)
		if (aldatu == true) {
			do {
				System.out.println("Ze dato aldatu nahi duzu?");
				System.out.println("1 - LANA");
				System.out.println("2 - DIRUA");
				System.out.println("3 - EZAGUPENAK");
				System.out.println("4 - DENBORA");
				System.out.println("5 - BOTEREA");
				System.out.println("6 - OSASUNA");
				//konprobazioa egiteko zure datu berriekin.
				System.out.println("7 - BISTARATU HERRIALDE HORREN DATUAK");
				System.out.println("0 - IRTEN");
				aukerak = sc.nextInt();
				switch (aukerak) {
				case 1:
					do {
						System.out.println("Sartu lan balio berriak:");
						aldatuDouble = sc.nextDouble();
						if (aldatuDouble > 100 || aldatuDouble < 0) {
							System.out.println("ERROREA. 0 baino gehiago eta 100 baino gutxiago izan behar da.");
						} else {
							lana[pos] = aldatuDouble;
						}
					} while (aldatuDouble > 100 || aldatuDouble < 0);
					break;
				case 2:
					do {
						System.out.println("Sartu diru balio berriak:");
						aldatuDouble = sc.nextDouble();
						if (aldatuDouble > 100 || aldatuDouble < 0) {
							System.out.println("ERROREA. 0 baino gehiago eta 100 baino gutxiago izan behar da.");
						} else {
							dirua[pos] = aldatuDouble;
						}
					} while (aldatuDouble > 100 || aldatuDouble < 0);
					break;
				case 3:
					do {
						System.out.println("Sartu ezagupenak balio berriak:");
						aldatuDouble = sc.nextDouble();
						if (aldatuDouble > 100 || aldatuDouble < 0) {
							System.out.println("ERROREA. 0 baino gehiago eta 100 baino gutxiago izan behar da.");
						} else {
							ezagupenak[pos] = aldatuDouble;
						}
					} while (aldatuDouble > 100 || aldatuDouble < 0);
					break;
				case 4:
					do {
						System.out.println("Sartu denbora balio berriak:");
						aldatuDouble = sc.nextDouble();
						if (aldatuDouble > 100 || aldatuDouble < 0) {
							System.out.println("ERROREA. 0 baino gehiago eta 100 baino gutxiago izan behar da.");
						} else {
							denbora[pos] = aldatuDouble;
						}
					} while (aldatuDouble > 100 || aldatuDouble < 0);
					break;
				case 5:
					do {
						System.out.println("Sartu botere balio berriak:");
						aldatuDouble = sc.nextDouble();
						if (aldatuDouble > 100 || aldatuDouble < 0) {
							System.out.println("ERROREA. 0 baino gehiago eta 100 baino gutxiago izan behar da.");
						} else {
							boterea[pos] = aldatuDouble;
						}
					} while (aldatuDouble > 100 || aldatuDouble < 0);
					break;
				case 6:
					do {
						System.out.println("Sartu osasun balio berriak:");
						aldatuDouble = sc.nextDouble();
						if (aldatuDouble > 100 || aldatuDouble < 0) {
							System.out.println("ERROREA. 0 baino gehiago eta 100 baino gutxiago izan behar da.");
						} else {
							osasuna[pos] = aldatuDouble;
						}
					} while (aldatuDouble > 100 || aldatuDouble < 0);
					break;
				case 7:
					System.out.println(herrialdea[pos] + " - " + kokapena[pos] + " - " + lana[pos] + " - " + dirua[pos]
							+ " - " + ezagupenak[pos] + " - " + denbora[pos] + " - " + boterea[pos] + " - "
							+ osasuna[pos]);

					break;
				case 0:
					System.out.println("Sistematik irteten...");
					break;
				default:
					System.out.println("Hautatu 0tik - 7garren aukerararte");
					break;
				}
			} while (aukerak != 0);

		}
	}

	//CASE 5
	private static void DatuakGordeFitxategian(File file, String herrialdea[], String kokapena[], double lana[],
			double dirua[], double ezagupenak[], double denbora[], double boterea[], double osasuna[]) {
		try {
			//false ipintzen dugu artxibo berria ez sortzeko
			FileWriter fw = new FileWriter(file, false);
			//lehenengo ilara idazten dugu
			fw.write("Herrialdea;Kokapena;Lana;Dirua;Ezagupenak;Denbora;Boterea;Osasuna");
			fw.write("\n");
			//guztia idatzi
			for (int i = 0; i < herrialdea.length; i++) {
				fw.write(herrialdea[i] + ";" + kokapena[i] + ";" + lana[i] + ";" + dirua[i] + ";"
						+ ezagupenak[i] + ";" + denbora[i] + ";" + osasuna[i]);
				fw.write("\n");
			}
			System.out.println("Aldaketak ondo gorde dira.");
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//CASE 6
	private static void BerdintasunMailaTxikiena(String herrialdea[], String kokapena[], double lana[], double dirua[],
			double ezagupenak[], double denbora[], double boterea[], double osasuna[]) {
		
		double temp;
		Double herrialdeBatura[];

		herrialdeBatura = new Double[herrialdea.length];
		temp = 0;

		for (int i = 0; i < herrialdea.length; i++) {
			temp += (lana[i] + dirua[i] + ezagupenak[i] + denbora[i] + osasuna[i]) / 6;
			herrialdeBatura[i] = temp;
		}
		Arrays.sort(herrialdeBatura);
		System.out.println("Berdintasun mailarik gutxien dituen herrialdeak: " + herrialdea[0] + ", " + herrialdea[1]
				+ " eta " + herrialdea[2] + " dira.");

	}
}
