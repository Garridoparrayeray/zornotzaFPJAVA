package erabiltzaileKudeaketa;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Erabiltzailea {
	int id;
	String izena;
	String abizena;
	String erabiltzaileIzena;
	String pasahitza;
	boolean aktibo;

	
	public Erabiltzailea(int id, String izena, String abizena, String erabiltzaileIzena, String pasahitza,
			boolean aktibo) {
		this.id = id;
		this.izena = izena;
		this.abizena = abizena;
		this.erabiltzaileIzena = erabiltzaileIzena;
		this.pasahitza = pasahitza;
		this.aktibo = aktibo;
	}
	public Erabiltzailea() {
		this.id = 0;
		this.izena = "";
		this.abizena = "";
		this.erabiltzaileIzena = "";
		this.pasahitza = "";
		this.aktibo = false;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the izena
	 */
	public String getIzena() {
		return izena;
	}
	/**
	 * @param izena the izena to set
	 */
	public void setIzena(String izena) {
		this.izena = izena;
	}
	/**
	 * @return the abizena
	 */
	public String getAbizena() {
		return abizena;
	}
	/**
	 * @param abizena the abizena to set
	 */
	public void setAbizena(String abizena) {
		this.abizena = abizena;
	}
	/**
	 * @return the erabiltzaileIzena
	 */
	public String getErabiltzaileIzena() {
		return erabiltzaileIzena;
	}
	/**
	 * @param erabiltzaileIzena the erabiltzaileIzena to set
	 */
	public void setErabiltzaileIzena(String erabiltzaileIzena) {
		this.erabiltzaileIzena = erabiltzaileIzena;
	}
	/**
	 * @return the pasahitza
	 */
	public String getPasahitza() {
		return pasahitza;
	}
	/**
	 * @param pasahitza the pasahitza to set
	 */
	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}
	/**
	 * @return the aktibo
	 */
	public boolean isAktibo() {
		return aktibo;
	}
	/**
	 * @param aktibo the aktibo to set
	 */
	public void setAktibo(boolean aktibo) {
		this.aktibo = aktibo;
	}
	@Override
	public String toString() {
		return id + ":" + izena + ":" + abizena + ":" + erabiltzaileIzena + ":" + pasahitza + ":" + aktibo;
	}
	
	
	public static ArrayList<Erabiltzailea> datuakKargatu (String fitxategiIzena){
		ArrayList<Erabiltzailea> ErabiltzaileLista= new ArrayList<>();
		int LerroKontaketa;
		String lerroa;
		File f = new File(fitxategiIzena);
		
		LerroKontaketa = 0;
		lerroa = "";
		

		if(!f.exists() || !f.isFile()) {
			System.err.println("ERROREA. Fitxategia ez da aurkitu" + f.getAbsolutePath());
			System.exit(-1);
		}
		
		try {
			Scanner scFile = new Scanner(f);
			while(scFile.hasNextLine()) {
				lerroa = scFile.nextLine().trim();
				if(lerroa.isEmpty()) {
					System.err.println("OHARRA. " + "Lerroa: " + LerroKontaketa + " hutsik dago.");
					continue;
				}
				String aux[] = lerroa.split(":");
				int id = Integer.parseInt(aux[0]);
				String izena = aux[1];
				String erabiltzaileIzena = "";//hutsik pasatzen diogu, ez dauka parametrorik sartute
				String abizena = aux[2];
				String pasahitza = aux[3];
				boolean aktibo = aux[4].equals("1");
				Erabiltzailea e = new Erabiltzailea(id, izena, abizena,erabiltzaileIzena, pasahitza, aktibo);
				ErabiltzaileLista.add(e);
				
			}
			scFile.close();
		}catch(Exception e) {
			System.err.println("ERRORE EZEZAGUNA " + e.getMessage());
			System.exit(-1);
		}
		return ErabiltzaileLista;//return ErabiltzaileLista -> ArrayLista<Erabiltzailea> esaten dugulako hartzen du
	}

	private static void datuakGorde(ArrayList<Erabiltzailea> erabiltzaileList, String fitxategiIzena) {
		try {
			FileWriter fw = new FileWriter(fitxategiIzena, false);
			for(Erabiltzailea e : erabiltzaileList) {
				fw.write(e.toString());
				fw.write("\n");
			}
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
