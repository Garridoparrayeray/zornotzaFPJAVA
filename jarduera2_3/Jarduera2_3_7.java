package jarduera2_3;

public class Jarduera2_3_7 {
	//Programa bat idatzi, 30 eta 50 zenbakien artean dauden zenbakien batuketa ateratzen duena.
	public static void main(String[] args) {
		int i;
		int batuera;
		i = 30;
		batuera = i;
		
		while(i <= 50) {
			System.out.println(batuera);
			batuera += i;
			i++;	
		}
	}
}
