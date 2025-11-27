package jarduera2_7;

import java.util.Scanner;

public class Jarduera2_7_YGarrido {
	//ENUNTZIATUA: ariketaren_enuntziatua.txt-en dago.
	public static void main(String[] args) {
		// Bariableak
		int aukerak, kant, i, hamburPos, temp;

		boolean dago;

		String HamburIzen;

		// Ematen dizutena:
		String[] izena = { "Mexicano", "Alioli", "Cheese Burger", "Barbacoa" };
		String[] ingredienteak = { "carne , tomate, picante, pimiento", "carne, lechuga, bacon, alioli",
				"carne,  cebolla, cheddar, lechuga, tomate, mahonesa",
				"carne, bacon, cebolla,cheddar, lechuga,tomate, mahonesa,barbacoa" };
		double[] prezioa = { 8.50, 11, 12.50, 14 };
		int[] stock = { 12, 8, 23, 15 };

		// Scanner
		Scanner sc = new Scanner(System.in);

		// Deklarazioak
		aukerak = 0;
		i = 0;
		dago = false;
		kant = 0;
		hamburPos = 0;
		temp = Integer.MAX_VALUE;

		// Funtzioak + menu
		do {
			System.out.println("1. ESKAERA");
			System.out.println("2. HANBURGESARIK MERKEENA");
			System.out.println("3. HANBURGESA BATEN INFORMAZIOA EMAN");
			System.out.println("4. INGREDIENTEAK BILATU");
			System.out.println("5. STOCK-A TXIKITU");
			System.out.println("6. HANBURGESAK PERTSONAKO");
			System.out.println("7. IRTEN");
			aukerak = sc.nextInt();
			switch (aukerak) {
			case 1:
				do {
					System.out.println("Sartu hanburgesaren izena: ");
					HamburIzen = sc.next();
					for (i = 0; i < izena.length; i++) {
						if (HamburIzen.equalsIgnoreCase(izena[i])) {
							hamburPos = i;
							dago = true;
						}
					}
					if (dago == false) {
						System.out.println("Idatzi berriro izena, hamburgesa hori ez da existitzen.");
					}

				} while (dago == false);
				while (true) {
					System.out.println("Sartu kantitatea: ");
					kant = sc.nextInt();
					if (kant > stock[hamburPos]) {
						System.out.println("Sartu berriro kantitatea, maximo stock-a " + stock[hamburPos] + " da.");
					} else {
						System.out.println("Prezio totala: " + (kant * stock[hamburPos]) + "-€ izango da.");
						break;
					}
				}
				break;
			case 2:
				for (i = 0; i < izena.length; i++) {
					if (temp > prezioa[i]) {
						temp = i;
					}
				}
				System.out.println("Hanburgesa merkeena: " + izena[temp] + " da, " + prezioa[temp] + " -€ prezioarekin.");
				break;
			case 3:
				do {
					System.out.println("Sartu hanburgesaren izena: ");
					HamburIzen = sc.next();
					for (i = 0; i < izena.length; i++) {
						if (HamburIzen.equalsIgnoreCase(izena[i])) {
							hamburPos = i;
							dago = true;
						}
					}
					if (dago == false) {
						System.out.println("Idatzi berriro izena, hanburgesa hori ez da existitzen.");
					}

				} while (dago == false);
				System.out.println(HamburIzen + ", " + prezioa[hamburPos] + "€-ko prezioa du.");
				System.out.println("Ingredienteak: " + ingredienteak[hamburPos]);
				break;

			case 4:
				do {
					System.out.println("Sartu hanburgesaren ingredientea: ");
					HamburIzen = sc.next();
					for (i = 0; i < izena.length; i++) {
						if (ingredienteak[i].contains(HamburIzen)) {
							hamburPos = i;
							dago = true;
							System.out.println(izena[i] + " DAUKA ingredientea.");
						} else {
							System.out.println(izena[i] + " ez dauka ingredientea.");
						}
					}
					if (dago == false) {
						System.out.println("Idatzi berriro ingredientea, ingrediente hori ez da existitzen.");
					}

				} while (dago == false);

				break;

			case 5:
				do {
					System.out.println("Sartu hanburgesaren izena: ");
					HamburIzen = sc.next();
					for (i = 0; i < izena.length; i++) {
						if (HamburIzen.equalsIgnoreCase(izena[i])) {
							hamburPos = i;
							dago = true;
						}
					}
					if (dago == false) {
						System.out.println("Idatzi berriro izena, ingrediente hori ez da existitzen.");
					}

				} while (dago == false);
				while (true) {
					System.out.println("Sartu kantitatea: ");
					kant = sc.nextInt();
					if (kant > stock[hamburPos]) {
						System.out.println("Sartu berriro kantitatea, maximo stock-a " + stock[hamburPos] + " da.");
					} else {
						stock[hamburPos] = kant;
						System.out.println(izena[hamburPos] + "-ren kantitate berria: " + stock[hamburPos] + " da.");
						break;
					}
				}
				break;

			case 6:
				System.out.println("Sartu bezero kopurua: ");
				kant = sc.nextInt();
				for (i = 0; i < izena.length; i++) {
					if (kant <= stock[i]) {
						temp = stock[i] / kant;
						System.out.println("Bezero bakoitza, jan dezake: " + izena[i] + " hanburgesa, 1 gutxienez.");
						System.out.println("Gehienez: " + temp);
					}
				}
				break;
			case 7:
				System.out.println("Eskerrik asko gure hanburgeserian erosteagatik!!!");
				break;

			default:
				System.out.println("ERROREA. Sartu zenbaki bat 1tik-7ra");
				break;
			}
		} while (aukerak != 7);
		sc.close();
	}
}
