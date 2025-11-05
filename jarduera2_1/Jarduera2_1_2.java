package jarduera2_1;
import java.util.Scanner;

public class Jarduera2_1_2 {
	//Eskatu erabiltzaileari bere izena eta erakutsi pantailatik.
	public static void main(String[]args) {
		String izena;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Sartu zure izena");
		izena = sc.nextLine();
		sc.close();
		System.out.println(izena);
	}
}
