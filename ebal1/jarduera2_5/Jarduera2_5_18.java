package jarduera2_5;

public class Jarduera2_5_18 {
	//Primitiba. 1etik 49ra arteko ausazko 6 zenbaki bistaratu.
	public static void main(String[] args) {
		int zenb;
		for (int i = 0 ; i < 6; i++) {
			zenb = (int) ((Math.random() * 49) + 1);
			System.out.println(zenb);
		}
	}
}
