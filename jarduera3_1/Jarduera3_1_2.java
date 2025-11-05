package jarduera3_1;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Jarduera3_1_2 {
/*pertsonak-koma.txt fitxategiko datuak irakurri eta eremu bakoitzeko arrai bat sortu. 
 * Arrai hauetan fitxategiko pertsonen datuak sartu behar dira. 
 * Gero, pantailatik eskatzen den pertsona (ordenaren arabera) inprimatu.. */
	public static void main(String[] args) {
		//variable declaration
		int kont;
		int[] id;
		String[] firstname;
		String lastname[];
		String email[];
		String email2[];
		String profession[];
		int[] age;
		Double[] salary;
		kont = 0;
		String pertsona;
		boolean dago;
		try {
			Scanner scFile = new Scanner(new File("src/pertsonak-koma.txt"));
			//Nos saltamos el titulo
			scFile.nextLine();
			while(scFile.hasNextLine()) {
				//Leer toda la tabla y decir numero de lineas
				scFile.nextLine();
				kont++;
			}
			scFile.close();
			System.out.println(kont);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		//init
		id = new int [kont];
		firstname = new String [kont];
		lastname = new String [kont];
		email = new String [kont];
		email2 = new String [kont];
		profession = new String [kont];
		age = new int [kont];
		salary = new Double [kont];
		String aux[];
		pertsona = null;
		dago = false;
		try {
			Scanner scFile = new Scanner(new File("src/pertsonak-koma.txt"));
			//we pass the titles and start printing
			kont = 0;
			scFile.nextLine();
			while(scFile.hasNextLine()) {
				aux = scFile.nextLine().split(",");
				id[kont] =Integer.parseInt(aux[0]);
				firstname[kont] = aux[1];
				lastname[kont] = aux[2];
				email[kont] = aux[3];
				email2[kont] = aux[4];
				profession[kont] = aux[5];
				age[kont] = Integer.parseInt(aux[6]);
				salary[kont] =Double.parseDouble(aux[7]);									
				kont++;
			}
			//test
			//System.out.println(id[0] + firstname[0] + lastname[0]+email[0]+email2[0]+profession[0]+age[0]+salary[0]);
			scFile.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//SECOND PART: 
		Scanner sc = new Scanner(System.in);
		
		while(dago == false) {
			System.out.println("Sartu pertsona bat: ");
			pertsona = sc.nextLine();
			for(int i = 0; i < firstname.length; i++) {
				if(pertsona.equalsIgnoreCase(firstname[i])) {
					System.out.println(id[i] + firstname[i] + lastname[i]+email[i]+email2[i]+profession[i]+age[i]+salary[i]);
					dago = true;
				}
			}
			if(dago == false) {
				System.out.println("ERROREA. Pertsona hori ez da existitzen, saiatu berriro");
				
			}
			
		}
		sc.close();
		
		
	}
}
