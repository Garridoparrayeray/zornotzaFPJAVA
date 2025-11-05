package jarduera2_4;

import java.util.Scanner;

public class Jarduera2_4_4 {
	//Hitz bat sartuta, atzetik aurrera atera pantailatik.	
	public static void main(String[] args) {
		String str;
		int i;
		Scanner sc = new Scanner(System.in);
		System.out.println("Sartu esaldi bat: ");
		str = sc.nextLine();
		sc.close();
		for(i = str.length() - 1;i >= 0;i--) {
			System.out.println(str.charAt(i));
		}
	}
}
