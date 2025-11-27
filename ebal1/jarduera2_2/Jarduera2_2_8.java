package jarduera2_2;

import java.util.Scanner;

public class Jarduera2_2_8 {
	//Eskatu letra bat eta zehaztu bokala den ala ez.
	public static void main(String[]args) {
		char c;
		Scanner sc = new Scanner(System.in);
		String str = "aeiouAEIOU";
		System.out.println("Sartu karaktere bat");
		c = sc.nextLine().charAt(0);
		
		if(str.indexOf(c) == -1){//bulearra true or false, c string barruen badagoen, -1 ez dago barruan
			System.out.println(c + " Ez da bokala.");
		}else {
			System.out.println(c + " Bokala da.");
		}
		sc.close();
		
	}
	//string beti begiratzen da equalsrekin
	//METODO2
//		char c;
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("Sartu karaktere bat");
//		c = sc.next().charAt(0);
//		
//		if(c == 'a' || c == 'e' || c =='i' || c == 'o' || c == 'u') {
//			System.out.println(c + " bokala da.");
//		}else {
//			System.out.println("Ez da bokala");
//		}
//		sc.close();
//	}
//	
	
}

