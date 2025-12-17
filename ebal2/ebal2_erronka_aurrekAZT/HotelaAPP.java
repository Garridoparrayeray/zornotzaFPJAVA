package ebal2_erronka_aurrekAZT;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class HotelaAPP {

	final static String fitxategia = "./src/ebal2_erronka_aurrekAzt/Logela.txt";
	public Scanner sc = new Scanner(System.in);
	public ArrayList<Logela> logelaLista = new ArrayList<>();
	public ArrayList<Viplogela> vipLogelaLista = new ArrayList<>();

	public static void main(String[] args) {
		HotelaAPP APP = new HotelaAPP();
		APP.FitxategiIrakurri();
		APP.kudeatuInterakzioa();
		
		
	}

	public void FitxategiIrakurri() {

		int LerroKontaketa, logelaKontaketa;
		LerroKontaketa = 0;
		logelaKontaketa = 0;

		File f = new File(fitxategia);
		if (!f.exists() || !f.isFile()) {
			System.err.println("ERROREA. Fitxategia ezin da aurkitu. " + f.getAbsolutePath());
			System.exit(-1);
		}

		try {
			Scanner scFile = new Scanner(f);

			String lerroa;
			scFile.nextLine();
			while (scFile.hasNext()) {
				lerroa = scFile.nextLine().trim();
				LerroKontaketa++;
				if (lerroa.isEmpty()) {
					System.err.println("OHARRA. " + "Lerroa: " + LerroKontaketa + " hutsik dago.");
					continue;// hurrengo ilarara saltatuko dugu
				}
				String aux[] = lerroa.split(":");
				int logelaZenbakia = Integer.parseInt(aux[0]);
				int okupatzaileenKopurua = Integer.parseInt(aux[1]);
				int pertsonakoPrezioa = Integer.parseInt(aux[2]);
				
				Logela logela = new Logela(logelaZenbakia, okupatzaileenKopurua, pertsonakoPrezioa);
				Viplogela vipLogela = new Viplogela(logelaZenbakia, okupatzaileenKopurua, pertsonakoPrezioa, 20);

				logelaLista.add(logela);
				vipLogelaLista.add(vipLogela);
				logelaKontaketa++;
			}
			System.out.println("Lerro kopurua: " + LerroKontaketa);
			System.out.println("Logela kopurua: " + logelaKontaketa);
			
			System.out.println("Logelak ondo kargatu dira. Hemen daukazu lista:");
			for(Logela l: logelaLista) {
				System.out.println(l);
				l.logelarenPrezioaLortu();
			}
			
			
			System.out.println("VipLogela kopurua: " + logelaKontaketa);
			
			System.out.println("VipLogelak ondo kargatu dira. Hemen daukazu lista:");
			for(Viplogela l: vipLogelaLista) {
				System.out.println(l);
				l.logelarenPrezioaLortu();
			}
			scFile.close();

		} catch (Exception e) {
			System.err.println("ERRORE EZEZAGUNA " + e.getMessage());

		}
		
		VipHotela h1 = new VipHotela();
		VipHotela h2 = new VipHotela();
		
		h1.logelak.add(vipLogelaLista.get(0));
		h1.logelak.add(vipLogelaLista.get(1));
		h2.logelak.add(vipLogelaLista.get(2));
		for(Viplogela l : h1.logelak) {
			System.out.println(l);
		}
	}

public void kudeatuInterakzioa() {
    // 5.1 Logela zenbakia eskatu
    System.out.print("Sartu aldatu nahi duzun logela-zenbakia: ");
    int zenbakia = sc.nextInt();

    Viplogela aurkitutakoa = null;
    // Logela ArrayList-en badagoen egiaztatu
    for (Viplogela v : vipLogelaLista) {
        if (v.getLogelaZenbakia() == zenbakia) {
            aurkitutakoa = v;
            break;
        }
    }

    if (aurkitutakoa == null) {
        System.err.println("Sartutako logela-zenbakia ez da existitzen.");
        System.exit(0); // Programa amaitu
    }

    // 5.2 Okupatzaile kopuru berria eskatu
    System.out.print("Sartu okupatzaile kopuru berria: ");
    int kopuruBerria = sc.nextInt();

    // Balioa 1 eta 4 artean dagoela egiaztatu
    if (kopuruBerria < 1 || kopuruBerria > 4) {
        System.err.println("Sartutako bidaiari-kopurua ez da zuzena.");
        System.exit(0); // Programa amaitu
    }

    // Logelako atributua aldatu
    aurkitutakoa.setOkupatzaileenKopurua(kopuruBerria);

    // Logelaren prezio berria kalkulatu eta inprimatu
    System.out.print("Logelaren prezio berria: ");
    aurkitutakoa.logelarenPrezioaLortu(); // Zure klaseko metodoa erabili

    // Logelen ArrayList osoa berriro inprimatu
    System.out.println("\n--- Zerrenda Eguneratua ---");
    for (Viplogela v : vipLogelaLista) {
        System.out.println(v.toString());
    }

    // ArrayList-eko datuak fitxategira gorde
    gordeFitxategian();
    
    System.out.println("Programa ondo amaitu da.");
    System.exit(0);
}

public void gordeFitxategian() {
    try (PrintWriter writer = new PrintWriter(new File(fitxategia))) {
        for (Viplogela v : vipLogelaLista) {
            // Formatu bera erabili: zenbakia:okupatzaileak:prezioa:vipgehigarria
            writer.println(v.getLogelaZenbakia() + ":" + 
                           v.getOkupatzaileenKopurua() + ":" + 
                           (int)v.getPertsonakoPrezioa() + ":" + 
                           (int)v.getVipGehigarria());
        }
        System.out.println("\nDatuak fitxategian gorde dira.");
    } catch (Exception e) {
        System.err.println("Errorea gordetzean: " + e.getMessage());
    }
}
	
}
