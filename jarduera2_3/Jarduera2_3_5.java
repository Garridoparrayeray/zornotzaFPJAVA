package jarduera2_3;

public class Jarduera2_3_5 {
	//Programa bat idatzi 20 edo 20 baino txikiagoak diren zenbaki bikoiti positiboak idazten dituena handienetik txikienera (for eta while erabilita)
	public static void main(String[]args) {
		int i, a;
		i = 20;
		while(i <= 0) {
			if(i % 2 == 0) {
				System.out.println(i);
			}
			i--;
		}
		for(a = 20; a<=0 ;a--) {
			if(a % 2 == 0) {
				System.out.println(a);
			}
		}

	}
}
