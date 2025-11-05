package jarduera2_3;

public class Jarduera2_3_14 {
	//Programa bat idatzi, 0 eta 20 artean dauden 3ren biderkatzaileak ateratzen dituena.
	public static void main(String[] args) {
		int a;
		int i;
		
		i = 1;
		a = 20;
		while(i <= a) {
			if(i % 3==0) {
				System.out.println(i);
			}
			i++;
		}
	}
}
