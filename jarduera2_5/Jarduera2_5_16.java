package jarduera2_5;

public class Jarduera2_5_16 {
	//20 langileren izena eta soldata irakurtzen duen arraia sortu 
	//eta soldatarik handiena duen langilearen izena eta soldata bistaratu.
	//(arrai bat beharko da izenentzako eta beste bat soldatentzako)
	public static void main(String[] args) {
		int tempSold;
		String tempLangi;
		
		tempLangi = "";
		tempSold = 0;
		String langileak[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "m", "n", "o", "p", "q", "r", "s", "t", "u"};
		int soldatak[] = {45921, 18003, 78156, 3245, 60739, 92108, 11875, 53620, 88491, 27506, 15918, 71042, 39337, 84680, 6254, 99871, 22509, 47713, 58065, 30458};
		
		for(int i = 0; i < soldatak.length ; i++) {
			if(soldatak[i] > tempSold) {
				tempSold = soldatak[i];
				tempLangi = langileak[i];
			}
		}
		System.out.println("Langile aberatsena: "+ tempLangi + " da, "+ tempSold + " soldatarekin.");
	}
}
