package ebal1_objetuak;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AuricularAPP {
	//funtzioetan erabili ahal izateko(main kanpoan daude eta)
	private static List<Auricular> AurikularLista = new ArrayList<>();
	
	public static void main(String[] args) {
//		File file = new File();
		String aurikularAukera = "";
		Scanner sc = new Scanner(System.in);
		String aukeraBaiEz = "";
		int aukera = 0;
		Auricular aurikularAurkituta = null;
		boolean aldaketak = false;
		
		//arraylista sortu eta datuak sartu
		ArrayListSortu();
		
		while(aldaketak == false) {
			System.out.println("Sartu aurikular izen bat:");
			aurikularAukera = sc.next();
			for(Auricular a: AurikularLista) {
				if(aurikularAukera.trim().equalsIgnoreCase(a.getModelo())) {
					System.out.println("Aurikularra aurkitu da. Zerbait aldatu nahi duzu? (bai/ez)");
					aukeraBaiEz = sc.next();
					switch(aukeraBaiEz.toLowerCase()) {
					case "bai":
						aurikularAurkituta = a;
						aldaketak = true;
						break;
					case "ez":
						break;
					default:
						System.out.println("Idatzi bai edo ez.");
					}
				}
			}
		}
		if(aldaketak == true) {
			do {
				System.out.println("1. Erabiltzaileak zehazten duen aurikularrari 10 € igo prezioan.");
				System.out.println("2. Erakutsi lista");
				System.out.println("3. Gorde aldaketak fitxategian");
				aukera = sc.nextInt();
				switch(aukera){
				case 1:
					aurikularAurkituta.setPrecio(aurikularAurkituta.getPrecio() + 10);
					break;
				case 2:
					for(Auricular a : AurikularLista) {
						System.out.println(a);
					}
//					//FORMA 2:
//					for(int i = 0; i < AurikularLista.size() ; i++) {
//						System.out.println(AurikularLista.get(i));
//					}
					break;
				case 3:
					ArrayaFitxategianSartu();
					break;
				default:
					System.out.println("Sartu balio bat 1-tik 4ra.");
				}
			
			}while(aukera != 4);
			sc.close();
		}
		
	}
	public static void ArrayaFitxategianSartu() {
		try {
			FileWriter fw = new FileWriter(new File("./src/ebal1_Objetuak/auriculares.txt"));
			for(Auricular a : AurikularLista) {
				fw.write(a.getModelo() + ";" + a.getMarca()+ ";" + a.getPrecio() + ";" + a.getStock());
				fw.write("\n");
			}
			System.out.println("Fitxategia gorde da.");
			fw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}

	}
	public static void ArrayListSortu() {
		try {
			Scanner scFile = new Scanner(new File("./src/ebal1_Objetuak/auriculares.txt"));
			while(scFile.hasNext()){
				//OPZIO 1:
				AurikularLista.add(new Auricular(scFile.nextLine()));
			}
			
			//OPZIO 2: ERABILI GABE KONSTRUKTORE BAT Auricular.java -an
			/*
			 	while(scFile.hasNext()){
			 		String aux[] = aux.nextLine().split(";");
			 		Auricular a = new Auricular();
			 		a.setModelo(aux[0]);
                    a.setMarca(aux[1]);
                    a.setPrecio(Double.parseDouble(aux[2]));
                    a.setStock(Integer.parseInt(aux[3]));
                    AurikularLista.add(a);
                    EDO
                    String kodea = aux[0];
                    String Marka= aux[1];
					double prezioa= Double.parseDouble(aux[2]);
                    int Stock = Integer.parseInt(aux[3]);
                    AurikularLista.add(kodea, Marka, prezioa, Stock);
			 	}
			 */
			for(Auricular a : AurikularLista) {
				System.out.println(a);
			}
            System.out.println("Aurikular totalak: " + AurikularLista.size());
			scFile.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
