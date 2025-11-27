package jarduera2_5;


public class Jarduera2_5_10 {
//Gelako ikasleen izena eta adina datutzat hartuta, honako informazioa bistaratu nahi da:

//20 urte edo gutxiago duten ikasleen kopurua.
//
//Gelako batazbesteko adina.
//
//Gelako ikaslerik gazteena eta bere izena
	public static void main(String[] args) {
		
		//bariableak
		int temp;
		int batazbes;
		String ikasleGazte;
		//array-ak
		String ikasle[] = new String[]{"a", "b", "c", "d", "e", "f", "g", "h","i"} ;
		int adina[] = new int[]{10, 23, 45, 6, 22, 12, 11, 80, 32};
		int adinaberri[] = new int[adina.length];
		String strtemp[] = new String[ikasle.length];
		
		//hasieratu
		batazbes = 0;
		temp = 20;
		ikasleGazte = "";
		//funtzioak
		System.out.println("20 urte baino gutxiago dutenak: ");
		for(int i = 0; i< ikasle.length ; i++) {
			if(adina[i] < temp) {
				adinaberri[i] = adina[i];
				strtemp[i] = ikasle[i];
				System.out.print("Ikasle "+ strtemp[i]+ " - ");
				System.out.println(adinaberri[i]);
			}
			batazbes += adina[i];	
		}
		batazbes = batazbes/adina.length;
		
		for(int i = 0; i< ikasle.length ; i++) {
			if(adina[i] < temp) {
				temp = adina[i];
				ikasleGazte = ikasle[i];
			}
		}
		System.out.println("--------------------------");
		System.out.println("Klaseko adinaren batazbestekoa: "+ batazbes);
		System.out.println("--------------------------");
		System.out.println("Gelako ikasle gazteena: " + ikasleGazte + " da " + temp + " urteekin.");
	}
}
