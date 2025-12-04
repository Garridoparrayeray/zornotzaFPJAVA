package irudiak_herentzia;

import java.util.Scanner;

public class TriangeluaAPP {
	private Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
			TriangeluaAPP app = new TriangeluaAPP();
			app.dimentsioak();
	}
	
	private void dimentsioak() {
		String motak;
		System.out.println("Triangeluaren azalaera sartu: ");
		float azalera = sc.nextFloat();
		System.out.println("Triangeluaren altuera sartu: ");
		float altuera = sc.nextFloat();
		System.out.println("Triangelu mota sartu: ");
		motak = sc.next();
		switch(motak) {
		case "isoszele":
			Triangelua isoszele = new Triangelua(estiloa.isoszele, azalera, altuera);
			isoszele.dimIkusi();
			System.out.println();
			isoszele.areaTriangelu(altuera, azalera);
			break;
		case "eskaleno":
			Triangelua eskaleno = new Triangelua(estiloa.eskaleno, azalera, altuera);
			eskaleno.dimIkusi();
			System.out.println();
			eskaleno.areaTriangelu(altuera, azalera);
			break;
		case "aldekidea":
			Triangelua aldekidea = new Triangelua(estiloa.aldekidea, azalera, altuera);
			aldekidea.dimIkusi();
			System.out.println();
			aldekidea.areaTriangelu(altuera, azalera);
			break;
		default:
			System.out.println("sartu motaren bat.");
			break;
			
		}
		
		sc.close();
	}
}
