package jarduera3_1;

//Scanner-a + Fitxategiak
import java.util.Scanner;
import java.io.File;
//ERRORE multzoa
import java.io.FileNotFoundException;
/*
 * java.nio.file.Files is a utility class that contains various useful methods.
 * The readAllLines() method can be used to read all the file lines into a list of strings.
 */
public class Jarduera3_1_1 {
	public static void main(String[] args) {
		//irakurri fitxategi bat scannerrekin
		try {
			Scanner sc = new Scanner(new File("src/kaixo-fitxategiak.txt"));
			//mientras contenga la siguiente linea....Imprimela
			while(sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
			
			sc.close();
		}catch(FileNotFoundException e) {
			   e.printStackTrace();
		}
		
	}
}
