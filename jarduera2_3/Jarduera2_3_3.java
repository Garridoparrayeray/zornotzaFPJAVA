package jarduera2_3;

public class Jarduera2_3_3 {
	//Programa bat idatzi, lehenengo 10 zenbaki osoak ateratzen dituena, 5 izan ezik (for eta while erabilita).
	public static void main(String[]args) {
		int i, a;
		i = 10;
		while(i <= 0) {
			if(i != 5) {
				System.out.println(i);
			}
			i--;
		}
		for(a = 10; a<=0 ;a--) {
			if(a != 5) {
				System.out.println(a);
			}
		}
	}

}


