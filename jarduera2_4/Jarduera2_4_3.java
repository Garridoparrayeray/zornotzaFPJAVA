package jarduera2_4;
import java.util.Scanner;

public class Jarduera2_4_3 {
	//Teklatutik esaldi bat sartu eta karaktereak lerroz lerro atera, sartutako karaktere bakoitza lerro berri batean.
	public static void main(String[] args) {
		String str;
		int i;
		Scanner sc = new Scanner(System.in);
		System.out.println("Sartu esaldi bat: ");
		str = sc.nextLine();
		sc.close();
		for(i = 0;i<str.length();i++) {
			System.out.println(str.charAt(i));
		}
	}
}
