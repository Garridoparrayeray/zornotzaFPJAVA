package jarduera2_5;

import java.util.Scanner;

public class Jarduera2_5_7 {
	//n zenbakia irakurri eta luzera horretako arraia definitu. 
	//1etik 10erako ausazko zenbakiekin bete eta gero altuena kalkulatu
	public static void main(String[] args) {
		int n;
		
		int temp, postemp;
		
		temp = 0;
		postemp = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Sartu zenbaki bat:");
		n = Integer.parseInt(sc.nextLine());
		sc.close();
		int zenb[] = new int[n];		
		for(int i = 0;i<zenb.length;i++) {
			zenb[i] = (int) (Math.random() * (10 - 1) + 1);//random->max value->min value->minvalue 1tik 10era barne egon gabe
			// zenb[i] = (int) (Math.random() * (10 - 1 + 1) + 1);//random->max value->min value->a paso de 1->minvalue 1tik 10era barne
			if(zenb[i] > temp) {
				temp = zenb[i];
				postemp = i;
			}
		}
		System.out.println("Arrayaren zenbaki altuena " + temp + " da eta arrayaren " + postemp + " posizioan dago");
		
	}
}
