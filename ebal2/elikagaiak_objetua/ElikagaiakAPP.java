package elikagaiak_objetua;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class ElikagaiakAPP {
	
	private Scanner sc = new Scanner(System.in);
	private ArrayList<Elikagaiak>ElikagaiaLista;
	final static String fitxategia = "./src/elikagaiak_objetua/janariak.txt";
	
	public static void main(String[] args) {
		
	}
	
	public static void DatuakKargatu() {
		
		int LerroKontaketa, JanariKontaketa;
		
		LerroKontaketa = 0;
		JanariKontaketa = 0;
		
		File f = new File(fitxategia);
		if (!f.exists() || !f.isFile()) {
			System.err.println("ERROREA. Fitxategia ezin da aurkitu. " + f.getAbsolutePath());
			System.exit(-1);
		}
		
		try {
			Scanner scFile = new Scanner(f);
			String lerroa = scFile.next();
			while(scFile.hasNext()) {
				String aux[] = lerroa.split(";");
				String elikagai_izena = aux[0];
				String egoera = aux[1];
				String elikagai_mota = aux[2];
				double kaloriak = Double.parseDouble(aux[3]);
				double karbohidratoak = Double.parseDouble(aux[4]);
				double koipeak = Double.parseDouble(aux[5]);
				double proteinak = Double.parseDouble(aux[6]);
				
				}
			scFile.close();
		}catch(Exception e) {
			
		}
	}
}
