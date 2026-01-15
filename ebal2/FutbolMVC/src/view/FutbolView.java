package view;

import java.sql.SQLException;
import java.util.Scanner;

import controller.FutbolistaController;
import controller.TaldeaController;

public class FutbolView {

	// Atributuak
	private static Scanner scan;
	private static FutbolistaController futController;
	private static TaldeaController talController;

	// Aplikazioaren sarrera puntua
	public static void main(String[] args) {

		// Beharrezko objektuen hasieraketa
		scan = new Scanner(System.in);
		futController = new FutbolistaController();
		talController = new TaldeaController();

		try {
			hasieratu();
		} catch (SQLException e) {
			System.err.println("Errorea aplikazioa exekutatzean");
			e.printStackTrace();
		}
	}

	// Aplikazioaren exekuzio nagusia
	private static void hasieratu() throws SQLException {
		int aukera;

		do {
			menuaErakutsi();
			aukera = Integer.parseInt(scan.nextLine());

			switch (aukera) {

			case 1:
				futController.getGuztiak().forEach(System.out::println);
				break;

			case 2:
				talController.getGuztiak().forEach(System.out::println);
				break;

			case 3:
				futbolistaSortu();
				break;

			case 4:
				taldeaSortu();
				break;

			case 5:
				System.out.println("Sartu futbolistaren DNI-a:");
				System.out.println(
						futController.getById(scan.nextLine()));
				break;

			case 6:
				System.out.println("Sartu taldearen ID-a:");
				System.out.println(
						talController.getById(
								Integer.parseInt(scan.nextLine())));
				break;

			case 7:
				System.out.println("Ezabatu nahi den futbolistaren DNI-a:");
				futController.ezabatu(scan.nextLine());
				break;

			case 8:
				System.out.println("Ezabatu nahi den taldearen ID-a:");
				talController.ezabatu(
						Integer.parseInt(scan.nextLine()));
				break;

			case 9:
				System.out.println("Programa amaitzen...");
				break;

			default:
				System.out.println("Aukera okerra");
			}

		} while (aukera != 9);
	}

	// Futbolista sortzeko datuak irakurri
	private static void futbolistaSortu() throws SQLException {

		System.out.println("DNI:");
		String dni = scan.nextLine();

		System.out.println("Izena:");
		String izena = scan.nextLine();

		System.out.println("Abizena:");
		String abizena = scan.nextLine();

		System.out.println("Taldearen ID-a:");
		int idTaldea = Integer.parseInt(scan.nextLine());

		System.out.println("Soldata:");
		double soldata = Double.parseDouble(scan.nextLine());

		boolean ondo = futController.sortu(
				dni, izena, abizena, soldata, idTaldea);

		if (!ondo) {
			System.out.println("❌ Taldea ez da existitzen");
		}
	}

	// Talde berria sortzeko datuak
	private static void taldeaSortu() throws SQLException {

		System.out.println("ID:");
		int id = Integer.parseInt(scan.nextLine());

		System.out.println("Izena:");
		String izena = scan.nextLine();

		System.out.println("Herria:");
		String herria = scan.nextLine();

		talController.sortu(id, izena, herria);
	}

	// Menuaren bistaratzea
	private static void menuaErakutsi() {
		System.out.println("\n==== FUTBOL BBDD ====");
		System.out.println("1- Futbolistak ikusi");
		System.out.println("2- Taldeak ikusi");
		System.out.println("3- Futbolista gehitu");
		System.out.println("4- Taldea gehitu");
		System.out.println("5- Futbolista ID-tik ikusi");
		System.out.println("6- Taldea ID-tik ikusi");
		System.out.println("7- Futbolista ezabatu");
		System.out.println("8- Taldea ezabatu");
		System.out.println("9- Irten");
		System.out.print("Aukera: ");
	}
}