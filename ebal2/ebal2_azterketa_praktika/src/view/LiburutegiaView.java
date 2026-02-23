package view;

import java.util.Scanner;
import controller.*;

public class LiburutegiaView {
	private LiburutegiController controller = new LiburutegiController();
	private int aukerak = 0;
	Scanner sc = new Scanner(System.in);

	public void ErakutsiMenua() {
		System.out.println("\n---MENUA----");
		System.out.println("1. Erakutsi liburuak ");
		System.out.println("2. Sartu liburuak");
		System.out.println("3. Ezabatu liburuak");
		System.out.println("4. Aldatu liburu datuak");
		System.out.println("5. Liburua Mailegatu");
		System.out.println("6. Liburua Itzuli");
		System.out.println("7. Irten");
	}

	public void AplikazioHasiera() {
		while (aukerak != 7) {
			ErakutsiMenua();
			System.out.print("Sartu aukera bat: ");
			aukerak = Integer.parseInt(sc.nextLine());

			switch (aukerak) {
			case 1:
				controller.ikusiLiburuak().forEach(System.out::println);
				break;
			case 2:
				System.out.print("Liburuaren ISBN-a: ");
				String isbn = sc.nextLine();
				System.out.print("Liburuaren izena: ");
				String izen = sc.nextLine();
				System.out.print("Egilea: ");
				String egile = sc.nextLine();
				System.out.print("Orrialde kopurua: ");
				int orriak = Integer.parseInt(sc.nextLine());

				controller.sartuLiburua(isbn, izen, egile, orriak);
				break;
			case 3:
				System.out.println("Ze liburu ezabatu nahi duzu?");
				controller.ikusiLiburuak().forEach(System.out::println);
				System.out.print("Sartu ISBNa: ");
				String isbnEzabatu = sc.nextLine();
				controller.ezabatuLiburua(isbnEzabatu);
				break;
			case 4:
				System.out.print("Sartu aldatu nahi duzun liburuaren ISBNa: ");
				String isbnAldatu = sc.nextLine();
				System.out.print("Sartu orrialde kopuru berria: ");
				int orriakBerria = Integer.parseInt(sc.nextLine());
				System.out.print("Mailegatuta dago orain?: ");
				boolean mailegatutaBerria = Boolean.parseBoolean(sc.nextLine());

				controller.aldatuLiburua(isbnAldatu, orriakBerria, mailegatutaBerria);
				break;
			case 5:
				System.out.print("Sartu mailegatu nahi duzun liburuaren ISBNa: ");
				String isbnMailegatu = sc.nextLine();
				controller.liburuaMailegatu(isbnMailegatu);
				break;
			case 6:
				System.out.print("Sartu itzuli nahi duzun liburuaren ISBNa: ");
				String isbnItzuli = sc.nextLine();
				controller.liburuaItzuli(isbnItzuli);
				break;
			case 7:
				System.out.println("Sistematik irten da. ");
				System.exit(0);
				break;
			case 8:

				/*
				 * System.out.
				 * print("Sartu sortu nahi duzun fitxategiaren izena extensioarekin(.txt): ");
				 * String fitxategi = sc.nextLine();
				 */ String fitxategi = "liburuak.txt";

				controller.datuakDeskargatuTxt(fitxategi);
				break;
			case 9:
				String fitxategiirakur = "liburuak.txt";

				controller.datuakKargatuTxt(fitxategiirakur);
				break;
			default:
				System.err.println("Aukera okerra.");
			}
		}
	}
}