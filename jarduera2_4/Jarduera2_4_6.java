package jarduera2_4;

import java.util.Scanner;

public class Jarduera2_4_6 {

	public static void main(String[] args) {
		//Idatzitako esaldia zuriunerik gabe idatzi.
		String str, strNoBlank;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Sartu esaldi bat: ");
		str = sc.nextLine();
		strNoBlank = str.replaceAll("\\s", "");
		sc.close();
		System.out.println(strNoBlank);
	}

}
