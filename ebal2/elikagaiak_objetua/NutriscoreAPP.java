package elikagaiak_objetua;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class NutriscoreAPP {
    private static final String FITXATEGIA = "./src/elikagaiak_objetua/janariak.txt";
    private ArrayList<Elikagaia> elikagaiLista = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        NutriscoreAPP app = new NutriscoreAPP();
        app.datuakKargatu();
        app.menua();
    }

    private void datuakKargatu() {
        File f = new File(FITXATEGIA);
        if (!f.exists()) {
            System.err.println("Fitxategia ez da aurkitu: " + f.getAbsolutePath());
            System.exit(-1);
        }

        try (Scanner scFile = new Scanner(f)) {
            while (scFile.hasNextLine()) {
                String lerroa = scFile.nextLine();
                String[] aux = lerroa.split(";");
                if (aux.length < 7) continue;

                String izena = aux[0];
                String egoera = aux[1];
                String mota = aux[2];
                double kaloriak = Double.parseDouble(aux[3]);
                double karbo = Double.parseDouble(aux[4]);
                double koipe = Double.parseDouble(aux[5]);
                double proteinak = Double.parseDouble(aux[6]);

                elikagaiLista.add(new Elikagaia(izena, egoera, proteinak, kaloriak, karbo, koipe, mota));
            }
            System.out.println("Datuak kargatu dira. Guztira: " + elikagaiLista.size());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void menua() {
        int aukera;
        do {
            System.out.println("\n--- MENUA ---");
            System.out.println("1. Elikagaien bilatzailea");
            System.out.println("2. Elikagaiak erakutsi");
            System.out.println("3. Kaloriak kalkulatu");
            System.out.println("0. Irten");
            System.out.print("Aukera: ");
            aukera = sc.nextInt();
            sc.nextLine(); // consumir salto de línea

            switch (aukera) {
                case 1:
                    bilatuElikagai();
                    break;
                case 2:
                    erakutsiElikagaiak();
                    break;
                case 3:
                    kalkulatuKaloriak();
                    break;
                case 0:
                    System.out.println("Agur!");
                    break;
                default:
                    System.out.println("Aukera okerra!");
            }

        } while (aukera != 0);
    }

    private void bilatuElikagai() {
        System.out.print("Sartu elikagaiaren izena: ");
        String izena = sc.nextLine();
        boolean aurkitu = false;
        for (Elikagaia e : elikagaiLista) {
            if (e.getElikagai_izena().equalsIgnoreCase(izena)) {
                System.out.println(e);
                aurkitu = true;
            }
        }
        if (!aurkitu) System.out.println("Elikagairik ez da aurkitu.");
    }

    private void erakutsiElikagaiak() {
        System.out.print("Lehen elikagaiaren indizea: ");
        int lehen = sc.nextInt();
        System.out.print("Erregistro kopurua: ");
        int kop = sc.nextInt();
        sc.nextLine();

        for (int i = lehen; i < lehen + kop && i < elikagaiLista.size(); i++) {
            System.out.println(elikagaiLista.get(i));
        }
    }

    private void kalkulatuKaloriak() {
        System.out.print("Sartu elikagaiaren izena: ");
        String izena = sc.nextLine();
        System.out.print("Sartu egoera: ");
        String egoera = sc.nextLine();
        System.out.print("Sartu pisua (gramotan): ");
        double pisua = sc.nextDouble();
        sc.nextLine();

        Elikagaia e = null;
        for (Elikagaia x : elikagaiLista) {
            if (x.getElikagai_izena().equalsIgnoreCase(izena) && x.getEgoera().equalsIgnoreCase(egoera)) {
                e = x;
                break;
            }
        }

        if (e != null) {
            double kaloriakTot = e.getKaloriak() * pisua / 100.0;
            System.out.println("Kaloria totala: " + kaloriakTot + " kcal");
        } else {
            System.out.println("Elikagairik ez da aurkitu.");
        }
    }
}
