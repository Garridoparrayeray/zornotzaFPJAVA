package jarduera2_2;

import java.util.Scanner;

public class Jarduera2_2_11 {
	//Eskatu letra bat eta egiaztatu B edo E den. B edo E bada, atera ONDO, bestela ERROREA.
	public static void main(String[]args) {
		char c;
		Scanner sc = new Scanner(System.in);
		String str = "BE";
		System.out.println("Sartu karaktere bat");
		c = sc.next().charAt(0);
		
		if(str.indexOf(c) == -1){//bulearra true or false, c string barruen badagoen, -1 ez dago barruan
			System.out.println(" ERROREA.");
		}else {
			System.out.println(" ONDO.");
		}
		sc.close();
		
	}
}
