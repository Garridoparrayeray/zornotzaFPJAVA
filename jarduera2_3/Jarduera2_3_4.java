package jarduera2_3;

public class Jarduera2_3_4 {
	//Programa bat idatzi, lehenengo 20 zenbakien artean dauden zenbaki bikoitiak idatziko dituena, 0-tik hasita (for eta while erabili).
	public static void main(String[]args) {
		int i, a;
		i = 0;
		while(i <= 20) {
			if(i % 2 == 0) {
				System.out.println(i);
			}
			i++;
		}
		for(a = 0; a<=20 ;a++) {
			if(a % 2 == 0) {
				System.out.println(a);
			}
		}
	}
}
