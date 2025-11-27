package jarduera2_3;

public class Jarduera2_3_8 {
	//30 eta 50 artean dauden zenbaki bakoitien batuketa ateratzen duen programa idatzi.
	public static void main(String[] args) {
		int i;
		int batuera;
		i = 30;
		batuera = i;
		
		while(i <= 50) {
			if(i % 2 != 0) {
				System.out.println(batuera);
				batuera += i;
			}
			i++;	
		}
	}
}
