package jarduera2_5;
import java.util.Scanner;
import java.math.*;
public class Jarduera2_5_3 {
	//n zenbaki bat irakurri eta arrai bat definitu, n luzerakoa eta 1etik 10era 
	//dauden ausaz sortutako zenbakiekin bete.
	public static void main(String[] args) {
		int n;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Sartu zenbaki bat:");
		n = Integer.parseInt(sc.nextLine());
		sc.close();
		int zenb[] = new int[n];		
		for(int i = 0;i<zenb.length;i++) {
			zenb[i] = (int) (Math.random() * (10 - 1) + 1);//random->max value->min value->minvalue 1tik 10era barne egon gabe
			// zenb[i] = (int) (Math.random() * (10 - 1 + 1) + 1);//random->max value->min value->a paso de 1->minvalue 1tik 10era barne
			System.out.println(zenb[i]);
		}
		
	}

}
