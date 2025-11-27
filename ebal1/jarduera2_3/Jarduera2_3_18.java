package jarduera2_3;

import java.util.Scanner;

public class Jarduera2_3_18 {
//Zenbakiak eskattu erabiltzaileak 0 sartu arte eta sartutako zenbakien batazbestekoa atera.

	public static void main(String[] args) {
		int i, temp, zenb;
		double batuera;
		batuera = 0;
		i = 0;
		temp = 0;
		zenb = 0;
		Scanner sc = new Scanner(System.in);
		
		do{
				System.out.println("Sartu zenbaki bat, sakatu 0 programa ixteko ");
				zenb = sc.nextInt();
				i++;
				temp = temp + zenb;
		}while(zenb != 0); 
		batuera = temp/i;
		System.out.println("Zenbakien batazbestekoa: "+batuera);
		sc.close();
		
	}

}



