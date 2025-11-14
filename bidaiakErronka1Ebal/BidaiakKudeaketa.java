package bidaiakErronka1Ebal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BidaiakKudeaketa {
	public static void main(String[] args) {
		
		//var deklarazioak
		int TuristasAnuales[], kont;
		String Destino[], Continente[], Clima[], aux[];
		Double GastoMedio[], Seguridad[], Satisfaccion[], Transporte[], Alojamiento[];
		File fitxategi = new File("./src/bidaiakErronka1Ebal/fitxategiak/BidaietakoDatuak.csv");

		kont = 0;
		
		//inizializazioa
		kont = ArrayLuzeera(kont, fitxategi);
		Destino = new String[kont];
		Continente = new String[kont];
		Clima = new String[kont];
		TuristasAnuales = new int[kont];
		GastoMedio = new Double[kont];
		Seguridad = new Double[kont];
		Satisfaccion = new Double[kont];
		Transporte = new Double[kont];
		Alojamiento = new Double[kont];
		aux = new String[kont];
		
		//Arraya betetzen du datuekin
		ArrayBeteketa(fitxategi, Destino, Continente, Clima, TuristasAnuales, GastoMedio, Seguridad, Satisfaccion, Transporte, Alojamiento, aux, kont);
		
		IdatziFitxategia(fitxategi, Destino, Continente, Clima, TuristasAnuales, GastoMedio, Seguridad, Satisfaccion, Transporte, Alojamiento);
		
	}
	
	//Arrayaren luzeera kalkulatzen duen funtzioa
	private static int ArrayLuzeera(int kont, File fitxategi) {
		//beti try and catch ez du funtzionatuko hori barik
		try {
			Scanner scFile;
			scFile = new Scanner(fitxategi);
			scFile.nextLine();
			while(scFile.hasNext()) {
				kont++;
				scFile.nextLine();
			}
			System.out.println("Luzeera ondo kargatu da fitxategitik.");
			System.out.println("Kargatutako elementuen kopurua: " + kont);
			scFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return kont;
	}
	
	private static void ArrayBeteketa(File fitxategi, String Destino[], String Continente[], String Clima[], int TuristasAnuales[], Double GastoMedio[], Double Seguridad[], Double Satisfaccion[], Double Transporte[], Double Alojamiento[], String Aux[], int kont) {
		try {
			Scanner scFile = new Scanner(fitxategi);
			//Lehenengo ilara ekiditu
			scFile.nextLine();
			System.out.println("Destino - Continente - Clima - TuristasAnuales - GastoMedio - Seguridad - Satisfaccion - Transporte - Alojamiento");
			for(int i = 0; i < kont; i++) {
				Aux = scFile.nextLine().split(";");
				Destino[i] = Aux[0];
				Continente[i] = Aux[1];
				Clima[i] = Aux[2];
				TuristasAnuales[i] = Integer.parseInt(Aux[3]);
				GastoMedio[i] = Double.parseDouble(Aux[4]);
				Seguridad[i] = Double.parseDouble(Aux[5]);
				Satisfaccion[i] = Double.parseDouble(Aux[6]);
				Transporte[i] = Double.parseDouble(Aux[7]);
				Alojamiento[i] = Double.parseDouble(Aux[8]);
				System.out.println(Destino[i] + " - "+ Continente[i] + " - "+ Clima[i] + " - "+ TuristasAnuales[i] + GastoMedio[i] + " - "+ Seguridad[i] + " - "+ Satisfaccion[i] + " - "+ Transporte [i] + " - "+ Alojamiento[i]);
			}
			System.out.println("Datuak ondo kargatu dira fitxategitik.");
			scFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	
	private static void IdatziFitxategia(File fitxategi, String Destino[], String Continente[], String Clima[], int TuristasAnuales[], Double GastoMedio[], Double Seguridad[], Double Satisfaccion[], Double Transporte[], Double Alojamiento[]) {
		try {
			FileWriter fw = new FileWriter(fitxategi, false);
			
			fw.write("Destino;Continente;Clima;TuristasAnuales;GastoMedio;Seguridad;Satisfaccion;Transporte;Alojamiento");
			fw.write("\n");
			for(int i = 0; i < Destino.length ; i++) {
				fw.write(Destino[i] + ";"+ Continente[i] + ";"+ Clima[i] + ";"+ TuristasAnuales[i] + ";" +  GastoMedio[i] + ";"+ Seguridad[i] + ";"+ Satisfaccion[i] + ";"+ Transporte [i] + ";"+ Alojamiento[i]);
				fw.write("\n");
			}
			System.out.println("Fitxategia ondo idatzi da.");
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
