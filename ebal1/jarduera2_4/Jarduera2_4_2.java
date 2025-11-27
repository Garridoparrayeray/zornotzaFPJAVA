package jarduera2_4;
import java.util.Scanner;

public class Jarduera2_4_2 {
//Teklatutik esaldi bat sartu eta pantailatik hitz bakoitzeko karaktere bat atera.
	public static void main(String[] args) {
		String str;
		Scanner sc = new Scanner(System.in);
		System.out.println("Sartu esaldi bat: ");
		str = sc.nextLine();
		System.out.println(str.charAt(0));
		for(int i = 0; i < str.length() - 1;i++) {
			if(str.charAt(i) == ' ') {
				System.out.println(str.charAt(i + 1));
			}
		}
		sc.close();
	}
}
