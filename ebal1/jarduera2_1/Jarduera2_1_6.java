package jarduera2_1;
import java.util.Scanner;
public class Jarduera2_1_6 {
	//Sartu gelako tenperatura (C) datu bezala eta pasatu bere balorea Gradu F-etara (ºF=ºC*1,8 + 32).
	public static void main (String [] args) {
		double temp;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Sartu gelako temperatura: ");
		temp = sc.nextDouble();
		sc.close();
		
		System.out.println("Zure gelako temperatura gradutan: "+ temp +"ºC da");
		System.out.println("Zure gelako temperatura Farenheitetan: "+ (temp*1.8 +32) +"ºF da");
	}
}
