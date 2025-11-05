package jarduera3_3_pokemon;

import java.io.BufferedWriter;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Pokemon {
	public static void main(String[] args) {
		// deklarazioak

		File file1 = new File("./src/jarduera3_3_pokemon/pokemons.csv");

		String izena[];
		String mota[];
		String scannerIrakurri;
		int maila[];
		int erasoa[];
		int babesa[];
		int abiadura[];
		String aux[];// array-ak betetzeko erabiliko dugun array auxiliarra
		int tamaina;
		int kont;
		int aukerak;
		boolean aurkitu;
		String pokemon1 = "";
		String pokemon2 = "";
		Double poke1bataz = 0.0;
		Double poke2bataz = 0.0;

		kont = 0;
		Scanner sc = new Scanner(System.in);

		// inizializazioa(baloreak eman)
		// lehenengo lerroa ekiditzen du:
		tamaina = ArrayaLuzeera(file1, kont);

		izena = new String[tamaina];
		mota = new String[tamaina];
		maila = new int[tamaina];
		erasoa = new int[tamaina];
		babesa = new int[tamaina];
		abiadura = new int[tamaina];
		aux = new String[tamaina];
		aukerak = 0;
		aurkitu = false;
		// arraya bete
		DatuakKargatu(izena, mota, maila, erasoa, babesa, abiadura, aux, file1, tamaina);

		do {
			MenuAtera();
			aukerak = sc.nextInt();
			switch (aukerak) {
			case 1:
				System.out.println("Nombre,Tipo,Nivel,Ataque,Defensa,Velocidad");
				for (int i = 0; i < izena.length; i++) {
					System.out.println(izena[i] + "," + mota[i] + "," + maila[i] + "," + erasoa[i] + "," + babesa[i]
							+ "," + abiadura[i]);
				}
				break;
			case 2:
				try {
					datuakGorde(file1, izena, mota, maila, erasoa, babesa, abiadura, aukerak, sc);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:
				System.out.println("Sartu nahi duzun izena ikusteko bere datuak: ");
				scannerIrakurri = sc.next().toLowerCase();

				for (int i = 0; i < izena.length; i++) {
					if (izena[i].toLowerCase().equals(scannerIrakurri)) {
						aurkitu = true;
						System.out.println(izena[i] + " - " + mota[i] + " - " + maila[i] + " - " + erasoa[i] + " - "
								+ babesa[i] + " - " + abiadura[i]);
					}

				}
				if (aurkitu == false) {
					System.out.println("ERROREA.Ez da aurkitu pokemonik izen horrekin, saiatu berriro");
				}
				break;
			case 4:
				try {
					DatuakModifikatu(file1, aukerak, izena, mota, maila, erasoa, babesa, abiadura, sc);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 5:
				for (int i = 0; i < abiadura.length; i++) {
					kont += abiadura[i];
				}
				kont /= abiadura.length;
				System.out.println("Pokemon azkarrenak hauek dira: ");
				for (int i = 0; i < abiadura.length; i++) {
					if (kont > abiadura[i]) {
						System.out.println(izena[i]);
					}
				}
				break;
			case 6:
				System.out.println("Sartu nahi duzun mota ikusteko bere pokemonak: ");
				scannerIrakurri = sc.next().toLowerCase();

				for (int i = 0; i < izena.length; i++) {
					if (mota[i].toLowerCase().contains(scannerIrakurri)) {
						aurkitu = true;
						System.out.println(izena[i] + " - " + mota[i] + " - " + maila[i] + " - " + erasoa[i] + " - "
								+ babesa[i] + " - " + abiadura[i]);
					}
				}
				if (aurkitu == false) {
					System.out.println("ERROREA.Ez da aurkitu motarik izen horrekin, saiatu berriro");
				}
				break;
			case 7:
				aurkitu = false;

				System.out.println("Eman Pokemon baten izena borrokarako:");

				do {

					pokemon1 = sc.nextLine();

					for (int j = 0; j < izena.length; j++) {

						if (pokemon1.equalsIgnoreCase(izena[j])) {

							aurkitu = true;

							poke1bataz += maila[j] + erasoa[j] + babesa[j] + abiadura[j];

							poke1bataz /= 4;

						}

					}

					if (aurkitu == false) {

						System.out.println("Ez da pokemon hori existitzen, Sartu beste izen bat:");

					}

				} while (aurkitu == false);

				aurkitu = false;

				System.out.println("Eman beste Pokemon baten izena bestearen kontra joan dadin:");

				do {

					pokemon2 = sc.nextLine();

					for (int j = 0; j < izena.length; j++) {

						if (pokemon2.equalsIgnoreCase(izena[j])) {

							aurkitu = true;

							poke2bataz += maila[j] + erasoa[j] + babesa[j] + abiadura[j];

							poke2bataz /= 4;

						}

					}

					if (aurkitu == false) {

						System.out.println("Ez da pokemon hori existitzen, Sartu beste izen bat:");

					}

				} while (aurkitu == false);

				if (poke1bataz > poke2bataz) {

					System.out.println(pokemon1 + " irabazi du");

				} else if (poke1bataz < poke2bataz) {

					System.out.println(pokemon2 + " irabazi du");

				} else {

					System.out.println("Berdinduta geratu dira");

				}

				break;

			case 8:
				aurkitu = false;
				int randomnum1;
				int randomnum2;
				int statmurriztu;
				randomnum1 = (int) (Math.random() * (izena.length - 0) + 0);

				System.out.println(randomnum1);

				pokemon1 = izena[randomnum1];

				randomnum2 = (int) (Math.random() * (izena.length - 0) + 0);

				System.out.println(randomnum2);

				pokemon2 = izena[randomnum2];

				System.out.println(pokemon1 + " VS " + pokemon2);

				for (int j = 0; j < izena.length; j++) {

					if (pokemon1.equalsIgnoreCase(izena[j])) {

						aurkitu = true;

						poke1bataz = poke1bataz + maila[j] + erasoa[j] + babesa[j] + abiadura[j];

						poke1bataz = poke1bataz / 4;

					}

				}

				for (int j = 0; j < izena.length; j++) {

					if (pokemon2.equalsIgnoreCase(izena[j])) {

						aurkitu = true;

						poke2bataz = poke2bataz + maila[j] + erasoa[j] + babesa[j] + abiadura[j];

						poke2bataz = poke2bataz / 4;

					}

				}

				// Irabaslea eman eta galtzaileari puntuak bajatu

				if (poke1bataz > poke2bataz) {

					System.out.println(pokemon1 + " irabazi du!");

					statmurriztu = (int) (Math.random() * (maila[randomnum2] - 0) + 0);

					maila[randomnum2] = maila[randomnum2] - statmurriztu;

					statmurriztu = (int) (Math.random() * (erasoa[randomnum2] - 0) + 0);

					erasoa[randomnum2] = erasoa[randomnum2] - statmurriztu;

					statmurriztu = (int) (Math.random() * (babesa[randomnum2] - 0) + 0);

					babesa[randomnum2] = babesa[randomnum2] - statmurriztu;

					statmurriztu = (int) (Math.random() * (abiadura[randomnum2] - 0) + 0);

					abiadura[randomnum2] = abiadura[randomnum2] - statmurriztu;

					System.out.println("Maila jaitsi zaio galtzaileari. Hauek dira bere estadistikak.");

					System.out.println(pokemon2 + " = maila: " + maila[randomnum2] + " Erasoa: " + erasoa[randomnum2]
							+ " babesa: " + babesa[randomnum2] + " eta Abiadura: " + abiadura[randomnum2]);

				} else if (poke1bataz < poke2bataz) {

					System.out.println(pokemon2 + " irabazi du!");

					statmurriztu = (int) (Math.random() * (maila[randomnum1] - 0) + 0);

					maila[randomnum1] = maila[randomnum1] - statmurriztu;

					statmurriztu = (int) (Math.random() * (erasoa[randomnum1] - 0) + 0);

					erasoa[randomnum1] = erasoa[randomnum1] - statmurriztu;

					statmurriztu = (int) (Math.random() * (babesa[randomnum1] - 0) + 0);

					babesa[randomnum1] = babesa[randomnum1] - statmurriztu;

					statmurriztu = (int) (Math.random() * (abiadura[randomnum1] - 0) + 0);

					abiadura[randomnum1] = abiadura[randomnum1] - statmurriztu;

					System.out.println("Maila jaitsi zaio galtzaileari");

					System.out.println(pokemon1 + " = maila:" + maila[randomnum1] + " Erasoa: " + erasoa[randomnum1]
							+ " babesa: " + babesa[randomnum1] + " eta Abiadura: " + abiadura[randomnum1]);

					// Berdinketa kasua

				} else if (poke1bataz == poke2bataz) {

					System.out.println("Berdinduta geratu dira!");

				}

				break;

			}

		} while (aukerak != 0);

		// Scanner scFile = new Scanner(new File("./src/janariak.txt"));

	}

	private static int ArrayaLuzeera(File file, int kont) {

		kont = 0;

		try {
			Scanner scFile = new Scanner(file);
			// lehenengo ilara ekiditu
			scFile.nextLine();
			while (scFile.hasNextLine()) {
				scFile.nextLine();
				kont++;
			}
			scFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("arrayaren luzeera ondo kargaut da");

		return kont;
	}

	private static void DatuakKargatu(String izena[], String mota[], int maila[], int erasoa[], int babesa[],
			int abiadura[], String aux[], File file, int tamaina) {

		try {
			Scanner scFile = new Scanner(file);
			// saltatzen dugu lehenengo lerroa
			scFile.nextLine();
			// edo while(scFile.HasNextLine()){}
			for (int i = 0; i < tamaina; i++) {
				aux = scFile.nextLine().split(",");
				izena[i] = aux[0];
				mota[i] = aux[1];
				maila[i] = Integer.parseInt(aux[2]);
				erasoa[i] = Integer.parseInt(aux[3]);
				babesa[i] = Integer.parseInt(aux[2]);
				abiadura[i] = Integer.parseInt(aux[2]);

			}
			scFile.close();
			System.out.println("Arrayak ondo kargatu dira.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void MenuAtera() {
		System.out.println("0- Irten. \n" +

				"1- Zerrendatu: POKEMON guztiak zerrendatuko ditu. \n"
				+ "2- Gorde: Arrai-ak fitxategian gordeko ditu. \n "
				+ "3- Pokemon_kontsultatu: Pokemon baten izena eskatu eta bere informazio guztia erakutsiko du. \n"
				+ "4- Izenaren arabera bilatu: Programak kate bat eskatu eta kate hori izenean duten Pokemon-en informazioaren zerrenda bistaratuko du. \n "
				+ "5- Azkarrenak: batazbesteko abiadura baino altuagoa duten Pokemon-en informazioa bistaratuko du. \n "
				+ "6- Motaren arabera zerrendatu: Mota bat eskatuko da eta mota horretako Pokemon-ak bistaratuko ditu. Mota ez bada existitzen, mezu bat erakutsiko da. \n "
				+ "7- Borroka1: Borroka egingo duten bi Pokemon-ak eskatuko dira. Maila, erasoa, defentsa eta abiaduraren batazbestekoa kalkulatuko da. Batazbesteko hobea izango duenak irabaziko du. Mezua bistaratuko da. \n "
				+ "8- Borroka2: Bigarren Pokemon borrokolaria ausaz aukeratuko da. Galtzaileari ausazko baloreak esleituko zaizkio, mailan, erasoan, defentsan eta abiaduran, 0 eta gehiengoaren artean.) \n");

	}

	private static void DatuakModifikatu(File file, int aukerak, String izena[], String mota[], int maila[],
			int erasoa[], int babesa[], int abiadura[], Scanner sc) throws IOException {

		Scanner scFile = new Scanner(file);
		String zaharra, aldaString, aldatuIzena;
		boolean aldaketaGehiago, aldatu, aurkituIzena;
		int posizioa, aldaZenbakia;

		aldaString = "";
		zaharra = "";

		posizioa = 0;
		aukerak = 0;
		aldaZenbakia = 0;

		aldatuIzena = "";
		aldaketaGehiago = false;
		aldatu = false;
		aurkituIzena = false;

		// izenaren aldaketa
		while (aldatu == false && aldaketaGehiago == false) {
			for (int i = 0; i < izena.length; i++) {
				System.out.println(izena[i]);
			}
			System.out.println("Sartu nahi duzun izena aldatzeko bere datuak: ");
			zaharra = sc.next().toLowerCase();

			for (int i = 0; i < izena.length; i++) {
				if (izena[i].toLowerCase().equals(zaharra)) {
					aurkituIzena = true;
					while (true) {
						System.out.println("Izena aurkitu da. Aldatu nahi duzu ezaugarriren bat? BAI/EZ");
						aldatuIzena = sc.next().toLowerCase();
						switch (aldatuIzena) {
						case "bai":
							aldatu = true;
							break;
						case "ez":
							aldaketaGehiago = true;
							// Code for not changing
							break;
						default:
							System.out.println("Invalid input.");
						}
						break;
					}

				}

			}
			if (aurkituIzena == false) {
				System.out.println("ERROREA.Ez da aurkitu pokemonik izen horrekin, saiatu berriro");
			}

		}
		// aldaketa gehiagoen sekuentzia kodea
		while (aldatu == true) {
			// aldaketa gehiagoko menua
			while (aukerak != 8) {
				System.out.println("0 - IZEN ALDAKETA" + "\n" + "1 - MOTA ALDAKETA" + "\n" + "2 - MAILA ALDAKETA" + "\n"
						+ "3 - ERASO ALDAKETA" + "\n" + "4 - BABESA ALDAKETA" + "5 - ABIADURA ALDAKETA" + "\n"
						+ "6 - Pokemon-a pantailatik atera" + "\n" + "7 - GORDE DATUAK" + "\n" + "8 - IRTEN"

				);
				aukerak = sc.nextInt();
				switch (aukerak) {
				case 0:
					System.out.println("Sartu esazu izen berria: ");
					aldaString = sc.next();
					izena[posizioa] = aldaString;
					System.out.println("Baloreak aldatu dira.");
					break;
				case 1:
					System.out.println("Sartu esazu mota berria: ");
					aldaString = sc.next();
					mota[posizioa] = aldaString;
					System.out.println("Baloreak aldatu dira.");
					break;
				case 2:
					System.out.println("Sartu esazu maila berria: ");
					aldaZenbakia = sc.nextInt();
					maila[posizioa] = aldaZenbakia;
					System.out.println("Baloreak aldatu dira.");
					break;
				case 3:
					System.out.println("Sartu esazu eraso berria: ");
					aldaZenbakia = sc.nextInt();
					erasoa[posizioa] = aldaZenbakia;
					System.out.println("Baloreak aldatu dira.");
					break;
				case 4:
					System.out.println("Sartu esazu babes berria: ");
					aldaZenbakia = sc.nextInt();
					babesa[posizioa] = aldaZenbakia;
					System.out.println("Baloreak aldatu dira.");
					break;
				case 5:
					System.out.println("Sartu esazu abiadura berria: ");
					aldaZenbakia = sc.nextInt();
					abiadura[posizioa] = aldaZenbakia;
					System.out.println("Baloreak aldatu dira.");
					break;
				case 6:
					System.out.println(izena[posizioa] + " - " + mota[posizioa] + " - " + maila[posizioa] + " - "
							+ erasoa[posizioa] + " - " + babesa[posizioa] + " - " + abiadura[posizioa]);
					break;
				case 7:
					datuakGorde(file, izena, mota, maila, erasoa, babesa, abiadura, aukerak, sc);
					break;
				case 8:
					aldatu = false;
					System.out.println("Irteten...");
					break;
				default:
					System.out.println("Sartu zenbaki bat 0tik - 8ra");
				}
			}

		}
		sc.close();
		scFile.close();

	}

//	
	private static void datuakGorde(File file, String izena[], String mota[], int maila[], int erasoa[], int babesa[],
			int abiadura[], int aukerak, Scanner sc) throws IOException {

		do {
			System.out.println("nola gorde nahi dituzu datuak?");
			System.out.println("1 - FITXATEGIAN");
			System.out.println("2 - EZ GORDE");
			aukerak = sc.nextInt();
			switch (aukerak) {
			case 1:
				FileWriter fw = new FileWriter(file, false);
				fw.write("Nombre, Tipo, Nivel, Ataque, Defensa, Velocidad");
				for (int i = 0; i < izena.length; i++) {
					fw.write("\n");
					fw.write(izena[i] + "," + mota[i] + "," + maila[i] + "," + erasoa[i] + "," + babesa[i] + ","
							+ abiadura[i]);
				}
				System.out.println("Aldaketak gorde dira.");
				fw.close();
				break;
			case 2:
				System.out.println("Ez dira gorde datuak.");
				break;

			default:
				System.out.println("Sartu 1 EDO 2");
				break;
			}
		} while (aukerak != 2);
		sc.close();
	}
}
//		private static void DatuakModifikatu(File file) throws IOException {
//		BufferedReader reader = new BufferedReader(new FileReader(file));
//		PrintWriter fwrite = new PrintWriter(new FileWriter("./src/jarduera3_3_pokemon/pokemons1.csv"));
//		String zaharra = "Pikachu,Eléctrico,25,55,40,90";
//		String berria = "PIKACHU,Eléctrico,25,55,40,90";
//		String line = null;
//		while((line = reader.readLine()) != null) {
//			fwrite.println(line.replaceAll(zaharra, berria));
//			
//		}
//		reader.close();
//		fwrite.close();
//		
//	}
