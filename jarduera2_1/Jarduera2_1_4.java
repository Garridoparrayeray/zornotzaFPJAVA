package jarduera2_1;
import java.util.Scanner;
public class Jarduera2_1_4 {
	public static void main(String[] args) {
		//Eskatu erabiltzaileari bi zenbaki eta erakutsi bien batura pantailatik.
		int zenb1;
		int zenb2;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Sartu lehenengo zenbakia:");
		zenb1 = sc.nextInt();
		
		System.out.println("Sartu bigarren zenbaki:");
		zenb2 = sc.nextInt();
		
		sc.close();
		
		System.out.println("Bien batuera: "+(zenb1+zenb2)+ " da");
		
	}
}
