package jarduera2_5;

import java.util.Scanner;

public class Jarduera2_5_2 {
//5 luzerako arraia definitu, eta teklatutik sartutako hitzekin bete.

	public static void main(String[] args) {
		//5 luzerako arraia definitu eta hitzekin bete.
		String izenak[] = new String[5];//5-ko luzeera.
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0;i< izenak.length;i++) {
			System.out.println("Sartu "+i+" izena");
			izenak[i] = sc.nextLine();
			
		}
		sc.close();
	}
}
