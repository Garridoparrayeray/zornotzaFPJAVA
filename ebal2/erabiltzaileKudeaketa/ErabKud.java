package ebal2_objektuen_kudeaketa;

import java.nio.file.spi.FileSystemProvider;
import java.util.ArrayList;
import java.util.Scanner;

public class ErabKud {
	final static String fitxategiIzena = "./src/ebal2_objektuen_kudeaketa/erabiltzaileak.txt";
	ArrayList<Erabiltzailea> ErabiltzaileLista = Erabiltzailea.datuakKargatu(fitxategiIzena);
	Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		ErabKud app = new ErabKud();
		app.Menua();
	}
	
	private void Menua() {
		int aukera;
		aukera = 0;
		do {
			System.out.println("0 - Irten. \r\n"
					+ "1 - Erabiltzaileak erakutsi.\r\n"
					+ "2 - Erabiltzailea ezabatu.\r\n"
					+ "3 - Erabiltzailea sortu.\r\n"
					+ "4 - Erabiltzailea modifikatu.");
			try {
				System.out.println("Sartu zure aukera: ");
				aukera = sc.nextInt();
				switch (aukera) {
				case 1:
					ListaBistaratu();
					break;
				case 2:
					ErabiltzaileaEzabatu();
					break;
				case 3:
					ErabiltzaileaSortu();
					break;
				case 4:
					ErabiltzaileaModifikatu();
					break;
				case 0:
					System.exit(-1);
					break;
				default:
					System.out.println("Sartu zenbaki bat 0tik - 4ra");
					break;				
				}
			}catch(NumberFormatException e) {
				System.err.println("ERROREA. SARTU ZENBAKI BAT.");
				sc.next();//buffer garbitutte
			}
		}while(aukera != 0);
		
	}
	
	private void ListaBistaratu() {
		//ErabiltzaileLista.forEach(System.out::println); -> berdine
		for(Erabiltzailea e : ErabiltzaileLista) {
			System.out.println(e);
		}
		
	}
	
	private Erabiltzailea AurkituErabiltzaileIzenaBidez(String erabiltzailea) {
        for (Erabiltzailea e : ErabiltzaileLista) {
            if (e.getErabiltzaileIzena().equalsIgnoreCase(erabiltzailea)) {
                return e;
            }
        }
        return null; // Return null if not found
    }
	private Erabiltzailea AurkituErabiltzaileIdBidez(int id) {
        for (Erabiltzailea e : ErabiltzaileLista) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null; // Return null if not found
    }
	
    private void ErabiltzaileaSortu() {
        System.out.println("\n--- Erabiltzailea Sortu ---");
        int id, kont;
        String izena;
        
        izena = "";
        kont = 0;
        Erabiltzailea ErabExistentzian;
        id = -1;
        do {
            System.out.print("Sartu erabiltzaile id berria: ");
            id = sc.nextInt();

            ErabExistentzian = AurkituErabiltzaileIdBidez(id);

            if (ErabExistentzian != null) {
                System.out.println("ERROREA: Erabiltzaile id hori (" + id + ") existitzen da dagoeneko.");
                ListaBistaratu();
            } else if (id == 0) {
                System.out.println("ERROREA: ID ezin da hutsa izan.");
            }

        } while (ErabExistentzian != null || id == -1);
        System.out.println("Sartu erabiltzailearen izena: ");
        izena = sc.next();
        
        System.out.println("Sartu erabiltzailearen abizena: ");
        String abizena = sc.next();
       
        
        System.out.println("Sartu erabiltzailaren erabiltzailea izena: ");
        String ErabIzena = sc.next();
      
        
        System.out.println("Sartu erabiltzailearen pasahitza: ");
        String pass = sc.next();
      
        
        
        Erabiltzailea ErabiltzaileBerria = new Erabiltzailea((ErabiltzaileLista.size()), izena, abizena, ErabIzena, pass, true);
        
        ErabiltzaileLista.add(ErabiltzaileBerria);
        System.out.println("Erabiltzailea (" + ErabIzena + ") sortu da eta zerrendara gehitu da.");
    }
    
    
    private void ErabiltzaileaEzabatu() {
    	boolean aurkitu;
    	aurkitu = false;
        System.out.println("\n--- Erabiltzailea Ezabatu ---");
        if (ErabiltzaileLista.isEmpty()) {
            System.out.println("Ez dago erabiltzailerik ezabatzeko.");
            return;
        }
        
        ListaBistaratu();
        System.out.print("Sartu ezabatu nahi duzun erabiltzailearen id: ");
        int Erabiltzailea = sc.nextInt();
        for(Erabiltzailea e : ErabiltzaileLista) {
        	if(Erabiltzailea == e.getId()) {
        		ErabiltzaileLista.remove(e);
        		aurkitu = true;
        		
        	}
        }
        if(aurkitu == true) {
        	System.out.println("Erabiltzailea ezabatu da");
        }else {
        	System.out.println("Erabiltzailea ez da existitzen");
        }
        

     
    }

    private void ErabiltzaileaModifikatu() {
        System.out.println("\n--- Erabiltzailea Modifikatu ---");
        if (ErabiltzaileLista.isEmpty()) {
            System.out.println("Ez dago erabiltzailerik modifikatzeko.");
            return;
        }

        ListaBistaratu();
        System.out.print("Sartu modifikatu nahi duzun erabiltzailearen id: ");
        String erabIzena = sc.nextLine().trim();

        Erabiltzailea erabEditatu = AurkituErabiltzaileIzenaBidez(erabIzena);

        if (erabEditatu == null) {
            System.out.println("Ez da aurkitu '" + erabIzena + "' izeneko erabiltzailerik.");
        } else {
            System.out.println("Oraingo datuak: " + erabEditatu);
            
            
            System.out.println("Erabiltzailea modifikatu da.");
            System.out.println("Datu berriak: " + erabEditatu);
        }
    }
}

