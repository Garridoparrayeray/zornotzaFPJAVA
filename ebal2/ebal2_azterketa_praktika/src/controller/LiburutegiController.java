package controller;

import java.util.ArrayList;
import liburutegiDAO.*;
import model.*;

public class LiburutegiController {
	private liburutegiDAO dao = new liburutegiDAO();
	
	// 1. IKUSI LIBURUAK 
	public ArrayList<Liburua> ikusiLiburuak() {
        try {
        	return dao.getLiburuak();
        } catch (Exception e) {
            System.err.println("Errorea datuak kargatzerakoan: " + e.getMessage());
            return new ArrayList<>();
        }
    }
	
	// 2. SARTU LIBURUA 
	public void sartuLiburua(String isbn, String izenburua, String egilea, int orriKopurua) {
		try {
			Liburua liburua = new Liburua(izenburua, egilea, isbn, orriKopurua, false);
			dao.setLiburuak(liburua);
			System.out.println("Liburua ondo sartu da datu-basean.");
		} catch (Exception e) {
            System.err.println("Errorea datuak ipintzerakoan: " + e.getMessage());
        }
	}
	
	// 3. EZABATU LIBURUA 
	public void ezabatuLiburua(String isbn) {
	    try {
	        dao.ezabatuLiburua(isbn); 
	        System.out.println("Liburua ondo ezabatu da datu-basetik.");
	    } catch (Exception e) {
	        System.err.println("Errorea liburua ezabatzean: " + e.getMessage());
	    }
	}
	
	// 4. ALDATU LIBURU DATUAK 
	public void aldatuLiburua(String isbn, int orriak, boolean mailegatuta) {
	    try {
	        dao.aldatuLiburua(isbn, orriak, mailegatuta);
	        System.out.println("Liburuaren datuak ondo eguneratu dira.");
	    } catch (Exception e) {
	        System.err.println("Errorea datuak aldatzean: " + e.getMessage());
	    }
	}
	
	// 5. BILATU LIBURUA 
	public void bilatuLiburua(String isbn) {
	    try {
	        Liburua liburua = dao.bilatuLiburuaByIsbn(isbn);
	        System.out.println("Aurkitutako liburua: " + liburua.toString());
	    } catch (Exception e) {
	        System.err.println("Errorea bilatzerakoan: " + e.getMessage());
	    }
	}

	// 6. LIBURUA MAILEGATU 
	public void liburuaMailegatu(String isbn) {
	    try {
	        Liburua liburua = dao.bilatuLiburuaByIsbn(isbn); 
	        
	        if (liburua.isMailegatuta()) {
	            System.err.println("Kontuz: Liburu hori jadanik mailegatuta dago!");
	        } else {
	            liburua.mailegatu(); 
	            dao.aldatuLiburua(liburua.getIsbn(), liburua.getOrriKopurua(), liburua.isMailegatuta());
	            System.out.println("Liburua ondo mailegatu da.");
	        }
	    } catch (Exception e) {
	        System.err.println("Errorea mailegatzerakoan: " + e.getMessage());
	    }
	}
	
	// 7. LIBURUA ITZULI 
	public void liburuaItzuli(String isbn) {
	    try {
	        Liburua liburua = dao.bilatuLiburuaByIsbn(isbn); 
	        
	        if (!liburua.isMailegatuta()) {
	            System.err.println("Kontuz: Liburu hori ez dago mailegatuta (Ezin da itzuli)");
	        } else {
	            liburua.itzuli(); 
	            dao.aldatuLiburua(liburua.getIsbn(), liburua.getOrriKopurua(), liburua.isMailegatuta());
	            System.out.println("Liburua ondo itzuli da.");
	        }
	    } catch (Exception e) {
	        System.err.println("Errorea liburua itzultzerakoan: " + e.getMessage());
	    }
	}
	//8.datuak deskargatu
	public void datuakDeskargatuTxt(String fitxategiIzena) {
		try {
			dao.deskargatuTxt(fitxategiIzena);
			System.out.println("Datuak ondo esportatu dira '" + fitxategiIzena + "' fitxategian.");
		} catch (Exception e) {
			System.err.println("Errorea deskargatzerakoan: " + e.getMessage());
		}
	}
	
	//9.datuak kargatu
	public void datuakKargatuTxt(String fitxategiIzena) {
		try {
			dao.kargatuTxt(fitxategiIzena);
			System.out.println("Datuak ondo kargatu dira.");
		} catch (Exception e) {
			System.err.println("Errorea fitxategia kargatzerakoan: " + e.getMessage());
		}
	}
}