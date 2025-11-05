package jarduera2_4;

import java.util.Scanner;

public class Jarduera2_4_8 {
	//Web helbide bat hiru lerrotan idatzi
	//hint: puntuekin separatute hurrengo linea
	public static void main(String[] args) {
		int i;
		String str;
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Sartu webgune bat");
		str = sc.nextLine();
		//splitstr = str.split("\\.");
		/*for(String s:splitstr) {//sartu string-ean, array-ko substring-a "." arte
			System.out.println(s);
		}*/
		sc.close();
		for(i = 0; i < str.length(); i++) {
		
			if(str.charAt(i)== '.') {
				System.out.println();
			}else {
				System.out.print(str.charAt(i));
			}
		}
	}
}
