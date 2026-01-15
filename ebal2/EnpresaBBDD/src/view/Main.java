package view;

import java.util.ArrayList;
import java.util.Scanner;
import controller.LangileController;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LangileController controller = new LangileController();
        int aukera = -1;

        while (aukera != 0) {
            System.out.println("\n--- LANGILEEN KUDEAKETA ---");
            System.out.println("1. Soldata kopuru batetik gorako langileak");
            System.out.println("2. Soldata tarte bateko langileak");
            System.out.println("3. Departamentu baten araberako langileak");
            System.out.println("0. Irten");
            System.out.print("Aukeratu: ");
            aukera = sc.nextInt();

            switch (aukera) {
                case 1:
                    System.out.print("Sartu soldata: ");
                    double s = sc.nextDouble();
                    controller.erakutsi(controller.lortuSoldataGorakoak(s));//opcion B syso en vez de erakutsi
                    break;
                case 2:
                    System.out.print("Sartu gutxieneko soldata: ");
                    double min = sc.nextDouble();
                    System.out.print("Sartu gehieneko soldata: ");
                    double max = sc.nextDouble();
                    controller.erakutsi(controller.lortuSoldataTartekoak(min, max));
                    break;
                case 3:
                    System.out.print("Sartu departamentua: ");
                    String dept = sc.next();
                    controller.erakutsi(controller.lortuDepartamentuka(dept));
                    break;
                case 0:
                    System.out.println("Irteten...");
                    break;
                default:
                    System.out.println("Aukera okerra.");
            }
        }
        sc.close();
    }

}