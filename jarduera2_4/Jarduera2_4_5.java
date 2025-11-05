package jarduera2_4;

import java.util.Scanner;

public class Jarduera2_4_5 {
	//Hitz bat palindromoa den edo ez esan.
	public static void main(String[] args) {
		String str, strNoBlank, strRever;
		int i;
		i = 0;
		strRever = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("Sartu esaldi bat: ");
		str = sc.nextLine();
		strNoBlank = str.replaceAll("\\s", "");
		sc.close();
		for(i = strNoBlank.length() - 1;i >= 0;i--) {
			strRever += strNoBlank.charAt(i);
		}
		if(strNoBlank.equals(strRever)) {
			System.out.println("Palindromoa da");
		}else {
			System.out.println("Ez da palindromoa");
		}
		
	}
	
	
}
