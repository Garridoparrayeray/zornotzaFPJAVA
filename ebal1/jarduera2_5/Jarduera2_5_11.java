package jarduera2_5;

public class Jarduera2_5_11 {
//		Sarrera datu bezala asteko egun guztietako tenperatura daukagu, gradu Cº-etan. Honako emaitza nahi dugu:
//		Asteko batazbesteko tenperatura F graduetan.
//		Egunik beroena.
//		Batazbestekotik gora dauden egunak.
	public static void main(String[] args) {
		
		//bariableak
		double temp;
		double batazbes;
		String egunBeroena;
		int i;
		
		//hasieratu
		batazbes = 0.0;
		temp = Integer.MIN_VALUE;
		egunBeroena = "";
		double[] temperaturak = {15.5, 18.2, 20.0, 19.5, 17.8, 16.3, 14.0};
		String[] astekoegunak = {"Astelehena", "Martitzena", "Eguaztena", "Eguena", "Barikua", "Zapatua", "Domeka"};
		
		//Batazbestekoa
		for(i = 0; i< temperaturak.length ; i++) {
			batazbes += temperaturak[i];			
		}
		batazbes = ((batazbes/temperaturak.length));
		
		//BatazbesteGorako temperatura + imprimaketa
		System.out.println("Batazbeste gorako temperaturak: ");
		for(i = 0; i< temperaturak.length ; i++) {
			if(temperaturak[i] > batazbes) {
				System.out.println(astekoegunak[i] + " - "+ temperaturak[i]);
			}
			//egun beroena atera
			if(temperaturak[i] > temp) {
				temp = temperaturak[i];
				egunBeroena = astekoegunak[i];
			}
		}
		
		//Imprimaketak
		System.out.println("------------------");
		System.out.println("Egun beroena "+egunBeroena+ ", "+temp + " temperatirarekin");
		System.out.println("----------------------------");
		batazbes = (batazbes*1.8) + 32;
		String batazbesAldatuta = String.format("%.2f", batazbes);
		
		System.out.println("Asteko batazbeste temperatura: "+ batazbesAldatuta+ "F da");
		System.out.println("--------------------------");
		
	}
}
