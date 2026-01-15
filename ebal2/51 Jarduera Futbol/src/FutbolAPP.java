import java.sql.SQLException; // DDBB kudeaketan errore eta abisuen inguruko informazioa adierazteko
import java.util.Scanner;	  // Erabiltzaileari datuak eskatzeko

import DDBB.FutbolistaConnect;
import DDBB.TaldeaConnect;
import Modelua.Futbolista;
import Modelua.Taldea;

public class FutbolAPP {
	// main metodoa
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		int aukera = 0;        // erabiltzaileak kontsolatik sartuko duen menu aukera jasotzeko
		FutbolistaConnect futkon = new FutbolistaConnect();
		TaldeaConnect talkon = new TaldeaConnect();
		Scanner scan = new Scanner(System.in);      // erabiltzaileari menu aukera sartzen duen zain 
		do {
			aukera = 0;
			menuaErakutsi();         // programaren bukaeran definitzen den metodoa menu aukerak bistaratzeko
			aukera = Integer.parseInt(scan.nextLine());    // kontsolatik jaso den menu aukera string motakoa denez int motara bihurtzeko
			switch (aukera) {        // sartutako aukera zein den jakiteko
			case 1:					 // aukera 1 bada
				// FutbolistaConnect.java-n sortu dugun futbolariGuztiak metodoa deitzeko non futbolista taulara konektatzeko parametroa pasatzen diogu
				futbolariGuztiak(futkon);   
				break;
			case 2:					// aukera 2 bada
				// FutbolistaConnect.java-n sortu dugun taldeGuztiak metodoa deitzeko non futbolista taulara konektatzeko parametroa pasatzen diogu
				taldeGuztiak(talkon);
				break;
			case 3:					// aukera 3 bada
				futbolistaBerria(futkon, talkon);
				break;
			case 4:					// aukera 4 bada
				taldeBerria(talkon);
				break;
			case 5:					// aukera 5 bada
				System.out.println("Bistaratu nahi den futbolistaren ID-a sartu");
				Scanner scanIdfut = new Scanner(System.in);
				String idFut = scanIdfut.nextLine();
				System.out.println(futkon.getFutbolistaIDtik(idFut));
			//	scanIdfut.close();
				break;
			case 6:
				System.out.println("Bistaratu nahi den taldearen ID-a sartu");
				Scanner scanIdTal = new Scanner(System.in);
				int idTal = Integer.parseInt(scanIdTal.nextLine());
				System.out.println(talkon.getTaldeaIDtik(idTal));
		//		scanIdTal.close();
				break;
/*			case 7:
				System.out.println("Ezabatu nahi den taldearen ID-a sartu");
				Scanner scanIdEzaTal = new Scanner(System.in);
				int idTalEza = Integer.parseInt(scanIdEzaTal.nextLine());
				taldeaEzabatu(idTalEza);
				System.out.println(talkon.getTaldeaIDtik(idTalEza));
				scanIdEzaTal.close();
				break;
				*/
			case 7:
				System.out.println("Fin programa");
				break;
			default:
				break;
			}
		} while (aukera != 7);
	}
	

	// Talde berria sortzekometodos. Konexiorako Taldeko Controller pasa beharzaio
	// erroreak egon daitezkeenez throws SQLException atala jarri behar da
	private static void taldeBerria(TaldeaConnect talkon) throws SQLException {
		// Erabiltzaileari taldeko datuak eskatzen zaizkio
		Scanner scanIdTal = new Scanner(System.in);
		System.out.println("Talde berriaren ID-a sortu:");
		//Jasoko den datua string motakoa izango da baina idTaldea int denez 
		// string motatik int motara bihurtu behar da 
		int idTaldea = Integer.parseInt(scanIdTal.nextLine());
		System.out.println("Talde berriaren izena sortu:");
		String izenTaldea = scanIdTal.nextLine();
		System.out.println("Talde berriaren herria sortu:");
		String hiria = scanIdTal.nextLine();
		
		Taldea taldeSortu = new Taldea(); //taldeSortu izeneko Taldea klaseko objektu bat sortuko da
		taldeSortu.setIdTaldea(idTaldea); // dagokion balioa idTaldea eremuan esleituko da
		taldeSortu.setIzena(izenTaldea);  // dagokion balioa izenTaldea eremuan esleituko da
		taldeSortu.setHerria(hiria);      // dagokion balioa hiria eremuan esleituko da
		talkon.taldeaSortu(taldeSortu);   // dagokion balioa taldeSortu eremuan esleituko da
	//	scanIdTal.close();
	}

	private static void futbolistaBerria(FutbolistaConnect futkon, TaldeaConnect talkon) throws SQLException {
		Scanner scanFutBer = new Scanner(System.in);
		boolean existe=false;
		System.out.println("Jokalari berriaren IDa sartu:");
		String idJokalari = scanFutBer.nextLine();
		System.out.println("Jokalari berriaren izena sartu:");
		String izenJokalari = scanFutBer.nextLine();
		System.out.println("Jokalari berriaren abizena sartu:");
		String abizenJokalari = scanFutBer.nextLine();
		System.out.println("Jokalari berriaren taldeko IDa sartu:");
		int taldeaJokalari = Integer.parseInt(scanFutBer.nextLine());
		System.out.println("Jokalari berriaren prezioa sartu:");
		double soldata = Double.parseDouble(scanFutBer.nextLine());
		
		for (int i = 0; i < talkon.getTaldeak().size(); i++) {
			if (taldeaJokalari == talkon.getTaldeak().get(i).getIdTaldea()) {
				Futbolista futSortu = new Futbolista();
				futSortu.setIdTaldea(taldeaJokalari);
				futSortu.setNan(idJokalari);
				futSortu.setIzena(izenJokalari);
				futSortu.setAbizena(abizenJokalari);
				futSortu.setSoldata(soldata);
				System.out.println(futSortu.toString());
				futkon.futbolistaSortu(futSortu);
				existe=true;
				break;
			} 
		}
		if (existe==false) {
			System.out.println("Taldea ez da existitzen");
		}
		// scanFutBer.close();
	} 
	// Talde guztiak bistaratzeko metodoa da. Taldea 
	// BBDDarekin konektatzeko Controler-ra pasatzen diogu.
	// erroreak egon daitezkeenez throws SQLException atala jarri behar da
	private static void taldeGuztiak(TaldeaConnect talcon) throws SQLException {
		System.out.println("Listado de equipos:");
		// DDBBan dagoen talde bakoitzeko datuak atera eta datuak bistaratzen dira.
		for (int i = 0; i < talcon.getTaldeak().size(); i++) {
			System.out.println(talcon.getTaldeak().get(i).toString());
		}
	}
   
	// Futbolista guztiak bistaratzeko metodoa da. Futbolista 
	// BBDDarekin konektatzeko Controler-ra pasatzen diogu.
	// erroreak egon daitezkeenez throws SQLException atala jarri behar da
	private static void futbolariGuztiak(FutbolistaConnect futcon) throws SQLException {
		System.out.println("Listado de futbolistas:");
		// DDBBan dagoen futbolista bakoitzeko datuak atera eta datuak bistaratzen dira.
		for (int i = 0; i < futcon.getFutbolistak().size(); i++) {
			System.out.println(futcon.getFutbolistak().get(i).toString());
		}
	}

	private static void menuaErakutsi() {
		// lerro honetan menuaren izenburua bistaratzen da
		System.out.println("BBDD de futbol");
		// Hurrengo lerro bakoitzean menu aukeraren testua bistaratzen da		
		System.out.println("            Menu aukerak");
		System.out.println("            ============");
		System.out.println("1- Futbolariak bistaratu.");
		System.out.println("2- Taldeak ikusi.");
		System.out.println("3- Futbolaria gehitu.");
		System.out.println("4- Taldea gehitu.");
		System.out.println("5- Futbolaria ID-tik bistaratu.");
		System.out.println("6- Taldea ID-tik bistaratu.");
		// System.out.println("7- Taldea ID-tik ezabatu.");
		System.out.println("7- Irten.");
		System.out.println("   Zer egin nahi duzu?");		
	}

	}

