package jarduera2_5;

import java.util.Iterator;

public class Jarduera2_5_9 {
	// Bi arrai sortu arrHile eta arrLitr. Lehenengoan urtarrilatik maiatzararteko
	// hilabeteak gorde behar dira. Bigarrenean egindako euri litroak (123,
	// 333,180,211,90).
	// Adibidez:
	//arrHile[0] -- urtarrila
	//arrLitr[0] -- 123
	//Hilabete bakoitzean egin duen euri litro kopurua bistaratu.

	//Kalkulatu zein izan den hilabeterik euritsuena. Bistaratu hilabetea eta litroak.
	public static void main(String[] args) {
		String arrHile[] = new String[5];
		int arrLitr[] = new int[5];
		int temp;
		String hil;
		
		hil = "";
		temp = 0;
		
		arrHile[0] = "urtarrila";
		arrHile[1] = "otsaila";
		arrHile[2] = "martxoa";
		arrHile[3] = "apirila";
		arrHile[4] = "maiatza";
		arrLitr[0] = 123;
		arrLitr[1] = 333;
		arrLitr[2] = 180;
		arrLitr[3] = 211;
		arrLitr[4] = 90;
		
		for(int i = 0; i< arrHile.length ; i++) {
			System.out.print(arrHile[i] + " - ");
			System.out.println(arrLitr[i]);
			if(arrLitr[i] > temp) {
				temp = arrLitr[i];
				hil = arrHile[i];
			}
		}
		System.out.println(hil + " hilabetea, "+ temp + " litroekin izan da euritsuena");
		
	}
}
