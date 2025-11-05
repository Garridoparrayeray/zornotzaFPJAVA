package jarduera2_6;

public class Jarduera2_6_7 {
	//main batean, erabili lehenaDa 1-etik 500-erako zenbaki lehen guztiak lerro bakarrean bistaratzeko.
	public static void main(String[] args) {
		int i;
		i = 0;
		System.out.print(" ");
		for(i = 2; i <= 500 ; i++) {
			if(Jarduera2_6_6.lehenaDa(i) == true) {
				System.out.print(i + "  ");
			}
			 
		}
	}
	
}
