package jarduera2_2;

import java.util.Scanner;
public class Jarduera2_2_12 {
//Kalkulatu kotxearen potentzia, KWtan ematen bada, atera CVak eta CVetan bada,  
//atera kWak (1kW = 1,35 CV). Eskatu K edo C baloreak, 
//jakiteko sartutako balorea kWetan edo CVetan den.
	public static void main(String[]args) {
		String balorea;
		double potentzia;
		Scanner sc = new Scanner(System.in);
		
		do {

			System.out.println("Sartu kotxearen potentzia");
			potentzia = sc.nextDouble();
			System.out.println(potentzia);
			System.out.println("Kotxearen potentzia, KW edo CVtan eman duzu? Idatzi 'CV' edo 'KW' den mezedez, programatik ateratzeko sakatu edozein botoi");
			balorea = sc.next();
			
			switch(balorea) {
			case "CV":
				System.out.println("Zure kotxea, "+ (potentzia*1.35)+ "KW-koa da.");
				break;
			case "cv":
				System.out.println("Zure kotxea, "+ (potentzia*1.35)+ "KW-koa da.");
				break;
			case "KW":
				System.out.println("Zure kotxea, "+ (potentzia/1.35)+ "CV-koa da.");
				break;
			case "kw":
				System.out.println("Zure kotxea, "+ (potentzia/1.35)+ "CV-koa da.");
				break;
			}
		}while(balorea != "KW" || balorea != "CV");
		sc.close();
		

	}
}
