package jarduera2_3;

public class Jarduera2_3_9 {
	//Programa bat idatzi, 1 eta 100 artean dauden zenbaki bikoitien batuketa ateratzen duena eta zenbat zenbaki diren esaten duena.
	public static void main(String[] args) {
		int i;
		int batuera;
		int kont;
		kont = 0;
		i = 1;
		batuera = i;
		
		while(i < 100) {
			batuera += i;
			if(i % 2 == 0) {
				System.out.println(batuera);
				kont ++;
			}
			i++;	
		}
		System.out.println("Zenbaki kopurua: "+kont);
	}
}
