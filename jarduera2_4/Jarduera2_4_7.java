package jarduera2_4;

import java.util.Scanner;

public class Jarduera2_4_7 {
	//Esaldi baten bokal kopuru eta kontsonante kopurua zenbatu. Zuriuneek ez dute kontatzen.
	public static void main(String[] args) {
		int i, counterBok, counterKon;
		String bokalak, str;
		
		counterBok = 0;
		counterKon = 0;
		bokalak = "aeiouAEIOU";
		Scanner sc= new Scanner(System.in);
		System.out.println("Sartu esaldi bat");
		str = sc.nextLine();
		sc.close();
		  for (i = 0; i < str.length(); i++) {
			//alfabetikoki ordenatute, espazioak eta karaktere espezialak kontuan artu gabe
	            if ((str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') || (str.charAt(i) >= 'a' && str.charAt(i) <= 'z')) {
	                if (bokalak.indexOf(str.charAt(i)) != -1)
	                    counterBok++;
	                else
	                    counterKon++;
	            }
	        }
		System.out.println("Bokalen kontaketa: "+ counterBok);
		System.out.println("Kontsonanteen kontaketa: "+counterKon);
	}
}
