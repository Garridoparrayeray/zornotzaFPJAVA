package animalia_objetuak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.File;
public class AnimaliaAPP {
	private static List<Animalia> AnimaliaLista = new ArrayList<>();
	private static Scanner sc = new Scanner(System.in);
	final static String fitxategia = "./src/animalia_objetuak/info.txt";
	static int aukerak = 0;

	public static void main(String[] args) {
		ArrayanSartu();
		do {
			System.out.println("1- 2 animalien datuak erakutsi"
					+"\n"
					+ " 2- Gehien bizi den animalia bistaratu"
					+"\n"
					+ "3- Erabiltzaileak hautatzen duen animaliaren habitat-ak bistaratu"
					+"\n"
					+"4- IRTEN");
			System.out.println("Sartu aukera bat: ");
			
			aukerak = Integer.parseInt(sc.next());
			switch(aukerak) {
			case 1:
				BiAnimaliDatuak();
				break;
			case 2:
				GehienBiziAnimalia();
				break;
			case 3:
				AnimaliHabitataBistarapena();
				break;
			case 4:
				System.out.println("Sistematik irteten...");
				System.exit(-1);
				break;
			}
			
		}while(aukerak != 4);
		sc.close();
	}
	
	public static void ArrayanSartu() {
		Scanner scFile;
		
		File f = new File(fitxategia);
		if(!f.exists() || !f.isFile()) {
	        System.err.println("ERROREA: Ezin da fitxategia aurkitu " + f.getAbsolutePath());
	        System.exit(-1);//fitxategia ez badu aurkitzen edo ez bada existitzen, erroera eta irten
		}
		try {
			scFile = new Scanner(f);
			int lerroaKontaketa = 0;
			int animaliKontaketa;
			animaliKontaketa = 0;
			while(scFile.hasNextLine()) {
				int adina;
				String lerroa;
				
				lerroa = scFile.nextLine().trim();
				adina = 0;
				lerroaKontaketa++;
				
				//lerro hutsen konprobaketa
				if(lerroa.isEmpty()) {
					System.err.println("OHARRA. "+ "Lerroa: " +lerroaKontaketa + " hutsik dago.");
					continue;//saltatu lerro hau eta joan hurrengora
				}
				
				String aux[] = lerroa.split("::", 4);//zatitu lau zatitan. Azkena, arraya delako
				if(aux.length < 4) {
					System.err.println("ERROREA. Lerroa: " + lerroaKontaketa+ " ez dago ondo zatituta. Bere edukia: " + lerroa + " da.");
					continue;
				}
				
				String izena = aux[0];
				String espeziea = aux[1];
				
				try {
					adina = Integer.parseInt(aux[2]);
				}catch(NumberFormatException e) {
					System.err.println("ERROREA. Lerroa: " + lerroaKontaketa + " adina ez da baliaduna: "+ aux[2]);
					continue;
				}
				
				
				String habitata[] = aux[3].split("::");
				if (habitata.length == 0) {
		                System.err.println("Oharra (Linea " + lerroaKontaketa + "): animalia honek ez du habitatik.");
		        }
				
				AnimaliaLista.add(new Animalia(izena, espeziea, adina, habitata));
				animaliKontaketa++;
			}

			System.out.println("Animali kopurua: " + animaliKontaketa);
			lerroaKontaketa = 0;
			System.out.println("Listaren edukiera: ");
			for(Animalia a : AnimaliaLista) {
				System.out.println(a.datuakErakutsi());
			}
			
		}catch (Exception e) {
			System.err.println("ERRORE EZEZAGUNA " + e.getMessage());
		}
		
	}
	
	public static void BiAnimaliDatuak() {
		if(AnimaliaLista.size() < 2) {
			System.err.println("KONTUZ! Kontuan izan animalien kopurua: " + AnimaliaLista.size() + " da.");
		}
		for(int i = 0; i < AnimaliaLista.size() && i < 2; i++) {
			System.out.println(AnimaliaLista.get(i).datuakErakutsi());
		}	
	}
	
	public static void AnimaliHabitataBistarapena() {
		String animalia;
		boolean aurkituta;
		
		aurkituta = false;
		animalia = "";
		System.out.println("Sartu ikusi nahi duzun animalia izena: ");
		animalia = sc.next();
		do{
			for(Animalia a: AnimaliaLista) {
				if(animalia.trim().toLowerCase().equals(a.getIzena().toLowerCase().trim())) {
					System.out.println("Animalia aurkitu da.");
					aurkituta = true;
					System.out.println("Bere habitata: " + Arrays.toString(a.getHabitata())+ " da.");
				}
			}
			if(!aurkituta) {
				System.err.println("ERROREA. Animali hori ez da existitzen, saiatu berriro.");
			}
		}while(aurkituta == false);
	
	}
	public static void GehienBiziAnimalia() {
		int temp = 0;
		String animaliaIzena;
		animaliaIzena = "";
		for(Animalia a : AnimaliaLista) {
			if(a.getAdina() > temp) {
				temp = a.getAdina();
				animaliaIzena = a.getIzena();
			}
		}
		System.out.println("Gehien bizi den animalia: " + animaliaIzena + " da");
	}
}
