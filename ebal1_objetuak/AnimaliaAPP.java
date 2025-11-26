package ebal1_objetuak;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AnimaliaAPP {
    private static ArrayList<animalia> animalienZerrenda = new ArrayList<>();
    private static final String FITXATEGIA = "./src/ebal1_objetuak/info.txt";
    private static Scanner teklatuIrakurlea = new Scanner(System.in);

    public static void main(String[] args) {
        irakurriFitxategia();
        menuNagusia();
    }

    private static void irakurriFitxategia() {
        try (Scanner fitxategiIrakurlea = new Scanner(new File(FITXATEGIA))) {
            while (fitxategiIrakurlea.hasNextLine()) {
                String linea = fitxategiIrakurlea.nextLine();
                String[] datuak = linea.split("::", 4);
                if (datuak.length == 4) {
                    String izena = datuak[0].trim();
                    String espeziea = datuak[1].trim();
                    int adina = Integer.parseInt(datuak[2].trim());
                    String[] habitatak = datuak[3].trim().split("::");
                    String[] habitatak2 = Arrays.copyOfRange(datuak, 3, datuak.length);
                    animalienZerrenda.add(new animalia(izena, espeziea, adina, habitatak));
                    
                }
            }
            for(animalia a : animalienZerrenda) {
            	System.out.println(a);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Errorea: " + FITXATEGIA + " fitxategia ez da aurkitu.");
            System.exit(1);
        } catch (NumberFormatException e) {
            System.out.println("Errorea: Adina zenbaki bat izan behar da fitxategian.");
            System.exit(1);
        }
    }

    private static void menuNagusia() {
        int aukera = 0;
        do {
            System.out.println("\nANIMALIAK MENU");
            System.out.println("1- 2 animalien datuak erakutsi");
            System.out.println("2- Gehien bizi den animalia bistaratu");
            System.out.println("3- Erabiltzaileak hautatzen duen animaliaren habitat-ak bistaratu");
            System.out.println("4- IRTEN");
            System.out.print("Aukeratu aukera bat: ");

            if (teklatuIrakurlea.hasNextInt()) {
                aukera = teklatuIrakurlea.nextInt();
                teklatuIrakurlea.nextLine(); //bada ezpada, buffer-a garbitzeko
                switch (aukera) {
                    case 1:
                        erakutsiBiAnimalia();
                        break;
                    case 2:
                        bistaratuZaharrena();
                        break;
                    case 3:
                        bistaratuHabitatak();
                        break;
                    case 4:
                        System.out.println("Irten...");
                        break;
                    default:
                        System.out.println("Aukera okerra. Mesedez, saiatu berriro.");
                }
            } else {
                System.out.println("Sarrera okerra. Mesedez, sartu zenbaki bat.");
                teklatuIrakurlea.next(); 
            }
        } while (aukera != 4);
    }

    // 1- 2 animalien datuak erakutsi
    private static void erakutsiBiAnimalia() {
        if (animalienZerrenda.size() >= 2) {
            System.out.println("\nLehenengo bi animaliak:");
            System.out.println(animalienZerrenda.get(0).toString());
            System.out.println(animalienZerrenda.get(1).toString());
        } else {
            System.out.println("\nEz dago nahikoa animalia daturik (gutxienez 2).");
        }
        /*opzio 2
        for(int i = 0; i < 2 && i < animalienZerrenda.size(); i++) {
        	System.out.println(animalienZerrenda.get(i));
        }*/
    }

    // 2- Gehien bizi den animalia bistaratu
    private static void bistaratuZaharrena() {
        if (animalienZerrenda.isEmpty()) {
            System.out.println("\nEz dago animalia daturik.");
            return;
        }

        animalia zaharrena = animalienZerrenda.get(0);
        for (animalia a : animalienZerrenda) {
            if (a.getAdina() > zaharrena.getAdina()) {
                zaharrena = a;
            }
        }
        System.out.println("\nGehien bizi den animalia: " + zaharrena.getIzena() + ", Adina: " + zaharrena.getAdina() + " urte");
    }

    // 3- Erabiltzaileak hautatzen duen animaliaren habitat-ak bistaratu
    private static void bistaratuHabitatak() {
        System.out.print("\nSartu animaliaren izena habitatak ikusteko: ");
        String bilatutakoIzena = teklatuIrakurlea.nextLine().trim();

        boolean aurkitua = false;
        for (animalia a : animalienZerrenda) {
            if (a.getIzena().equalsIgnoreCase(bilatutakoIzena)) {
                System.out.println(a.getIzena() + "-ren habitatak:");
                for (String h : a.getHabitat()) {
                    System.out.println("- " + h.trim());
                }
                aurkitua = true;
                break;
            }
        }

        if (!aurkitua) {
            System.out.println(bilatutakoIzena + " izeneko animalia ez da aurkitu.");
        }
    }
}
