package jarduera2_4;

import java.util.Scanner;

public class Jarduera2_4_9 {
    public static void main(String[] args) {
        // Teklatutik esaldi bat sartu adb.: "Ondo etorri Zornotzara”,
        // gero, ordeztu nahi den hitza idatzi (adb.: Zornotza) 
        // eta gero zerekin ordeztuko den (adb.: Amorebieta).
        // Pantailatik atera esaldi berria.

        Scanner sc = new Scanner(System.in);

        System.out.println("Sartu kate bat: ");
        String str = sc.nextLine();

        System.out.println("Sartu ordezkatu nahi duzun hitza: ");
        String hitza = sc.nextLine();
       
        if (str.contains(hitza)) {
            System.out.println("Sartu hitz berria ordezkatzeko: ");
            String berria = sc.nextLine();

            str = str.replace(hitza, berria);
            System.out.println("Esaldi berria: " + str);
        } else {
            System.out.println("Ez dago '" + hitza + "' kate barruan.");
        }

        sc.close();
    }
}