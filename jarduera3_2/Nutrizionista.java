package jarduera3_2;

import java.util.Arrays;
//imports
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Nutrizionista {
/*
 *janariak.txt fitxategiko datuak arraietan kargatu.
 *Datuak dira: izenak, egoerak, kaloriak, koipeak, proteinak, karbohidratoak eta motak.
 *Honako aukerak garatu eta puntu hauek dituen menua bistaratu:
 *Elikagaia emanda, mota horretako elikagaiak bistaratu.
 *Elikagaia emanda, mota horretako elikagaien kalorien batazbestekoa bistaratu.
 *Elikagaia emanda, elikagai mota horren kantitea bistaratu.
 *Elikagaia eta egoera emanda, bere balore nutrizionalak bistaratu.
 *Elikagaia emanda, egoeraren araberako balore nutrizionalak bistaratu.
 */
	public static void main(String[] args) {
		//bariableak
		String izenak[];
		String egoerak[];
		String motak[];
		String aux[];
		String aukeraIdatzia; 
		String motaMota;
		String egoeraIdatzia;
		Double kaloriak[];
		Double koipeak[];
		Double proteinak[];
		Double karbohidratoak[];
		Double batazbeste;
		
		int kont;
		int i;
		int aukerak;
		
		boolean dago;
		Scanner sc = new Scanner(System.in);
		
		//inizializazioa(kontadoreak + sarketa metodoa + dago ala ez)
		kont = 0;
		i = 0;
		aukerak = 0;
		dago = false;
		aukeraIdatzia = "";
		egoeraIdatzia = "";
		motaMota = "";
		aux = null;
		batazbeste = 0.0;
		
		//arrayaren tamaina eman
		kont = arrayIrakurri();
		System.out.println(kont);

		//inizializazioa(array-ak)
		izenak = new String[kont];
		egoerak = new String[kont];
		kaloriak = new Double[kont];
		koipeak = new Double[kont];
		proteinak = new Double[kont];
		karbohidratoak = new Double[kont];
		motak = new String[kont];
		
		//bete array-ak
		arrayen_beteketa(aux, izenak, egoerak, kaloriak, koipeak, proteinak, karbohidratoak, motak, i);
		
		
		do {
			System.out.println(" *Honako aukerak garatu eta puntu hauek dituen menua bistaratu:\r\n"
					+ " *0 - Irten. \r\n"
					+ " *1 - Elikagaia emanda, mota horretako elikagaiak bistaratu.\r\n"
					+ " *2 - Elikagaia emanda, mota horretako elikagaien kalorien batazbestekoa bistaratu.\r\n"
					+ " *3 - Elikagaia emanda, elakagai mota horren kantitea bistaratu.\r\n"
					+ " *4 - Elikagaia eta egoera emanda, bere balore nutrizionalak bistaratu.\r\n"
					+ " *5 - Elikagaia emanda, egoeraren araberako balore nutrizionalak bistaratu.\r\n");
			
			aukerak = sc.nextInt();
			switch(aukerak) {
			case 1:
				System.out.println("Sartu elikagaia: ");
				aukeraIdatzia = sc.next();
				motaMota = motaAurkitu(aukeraIdatzia, motak, izenak);
				if(motaMota != "") {
					System.out.println(motaMota + "-ko elikagaiak hauek dira: ");
					for (i = 0; i < izenak.length; i++) {
						if (motaMota.toLowerCase().contains(motak[i].toLowerCase())){
							System.out.println(izenak[i]);
						}
					}
				}else {
					System.out.println("ERROREA. Elikagaia ez da aurkitu.");
				}
				
				break;
			case 2:
				System.out.println("Sartu elikagaia: ");
				aukeraIdatzia = sc.next();
				motaMota = motaAurkitu(aukeraIdatzia, motak, izenak);
				if(motaMota != "") {
					System.out.println(motaMota + "-ko elikagaien kalorien batazbeste hau da: ");
					kont = 0;
						for (i = 0; i < izenak.length; i++) {
							if (motaMota.toLowerCase().contains(motak[i].toLowerCase())){
								batazbeste += kaloriak[i];
								kont++;
							}
					}
						batazbeste/=kont;
						System.out.println(String.format("%.2f", batazbeste)+ " kcal");
						
				}else {
					System.out.println("ERROREA. Elikagaia ez da aurkitu.");
				}
				
				break;
			case 3:
				System.out.println("Sartu elikagaia: ");
				aukeraIdatzia = sc.next();
				motaMota = motaAurkitu(aukeraIdatzia, motak, izenak);
				if(motaMota != "") {
					kont = 0;
					for (i = 0; i < izenak.length; i++) {
						if (motaMota.toLowerCase().contains(motak[i].toLowerCase())){
							kont++;
						}
					}
					System.out.println(motaMota + " daukan kantitatea: "+ kont + " da." );
				}else {
					System.out.println("ERROREA. Elikagaia ez da aurkitu.");
				}
				break;
			case 4:
				System.out.println("Sartu elikagaia: ");
				aukeraIdatzia = sc.next();
				System.out.println("Sartu egoera: ");
				egoeraIdatzia = sc.next();
					for (i = 0; i < izenak.length; i++) {
						if (aukeraIdatzia.equalsIgnoreCase(izenak[i]) && egoeraIdatzia.equalsIgnoreCase(egoerak[i])){
							System.out.println("Izena: "+ izenak[i] + " - Egoera: "+ egoerak[i] + " - Kaloriak: "+ kaloriak[i] + " - Koipeak: " + koipeak[i] + " - Proteinak: " + proteinak[i] + " - Karbohidratoak: "+ karbohidratoak[i]);
						}
						
					}
					
			
				break;
			case 5:
				System.out.println("Sartu elikagaia: ");
				aukeraIdatzia = sc.next();
					for (i = 0; i < izenak.length; i++) {
						if (aukeraIdatzia.equalsIgnoreCase(izenak[i])){
							System.out.println("Izena: "+ izenak[i] + " - Egoera: "+ egoerak[i] + " - Kaloriak: "+ kaloriak[i] + " - Koipeak: " + koipeak[i] + " - Proteinak: " + proteinak[i] + " - Karbohidratoak: "+ karbohidratoak[i]);
						}
						
					}
				break;
			default:
				System.out.println("ERROREA. 0-tik 5-etara idatzi behar duzu, saiatu berriro.");
			}
		}while(aukerak != 0);
		sc.close();
	}
	
	public static int arrayIrakurri() {
		int kont;
		kont = 0;
		//irakurketa1 (array-aren tamaina definitu)
				try {
					
					Scanner scFile = new Scanner(new File("./src/janariak.txt"));
					
					while(scFile.hasNextLine()) {
						scFile.nextLine();
						kont++;
					}
					scFile.close();
				}catch(FileNotFoundException e) {
					e.printStackTrace();
				}
				
		return kont;
	}
	
	//irakurketa2 (array-ak elementuekin bete)
	public static void arrayen_beteketa(String aux[], String izenak[], String egoerak[], Double kaloriak[], Double koipeak[], Double proteinak[], Double karbohidratoak[], String motak[], int i) {
				try {
					Scanner scFile = new Scanner(new File("./src/janariak.txt"));
					
					while(scFile.hasNextLine()) {
						aux = scFile.nextLine().split(";");
						izenak[i] = aux[0];
						egoerak[i] = aux[1];
						kaloriak[i] = Double.parseDouble(aux[2]);
						koipeak[i] = Double.parseDouble(aux[3]);
						proteinak[i] = Double.parseDouble(aux[4]);
						karbohidratoak[i] = Double.parseDouble(aux[5]);
						motak[i] = aux[6];
						i++;
					}
					scFile.close();
				}catch(FileNotFoundException e) {
					e.printStackTrace();
				}
	}
	
	public static String motaAurkitu(String izena, String motak[], String izenak[]) {
		
		String motaMota = "";
		for(int i = 0; i < izenak.length ; i++) {
			if(izena.equalsIgnoreCase(izenak[i])){
				System.out.println("Elikagaia " + izena + " aurkitu da datu basean, bere mota: "+ motak[i] + " da");
				motaMota = motak[i];
				break;
			}
		}
		return motaMota;
	}
}
