package langileak_objektuak;

import java.util.ArrayList;

public class ProgramaLangileakAPP {
	public static void main(String[] args) {
		ArrayList<Soldatapekoa> SoldatapekoLista = new ArrayList<>();
		ArrayList<KanpoKontsultorea> KanpoKontsultoreaLista = new ArrayList<>();

		Soldatapekoa a1 = new Soldatapekoa("Yeray", 3000.00, new Data(13, 04, 2003));
		Soldatapekoa a2 = new Soldatapekoa("EDER", 2000.00, new Data(23, 11, 2006));
		Soldatapekoa a3 = new Soldatapekoa("PACO", 40000.0);
		SoldatapekoLista.add(a1);
		SoldatapekoLista.add(a2);
		SoldatapekoLista.add(a3);

		KanpoKontsultorea k1 = new KanpoKontsultorea("Pablo Iriondo", new Data(5, 11, 1978));
		KanpoKontsultorea k2 = new KanpoKontsultorea("Elena Zubiri", new Data(5, 11, 1978));
		KanpoKontsultoreaLista.add(k1);
		KanpoKontsultoreaLista.add(k2);

		System.out.println("Soldatapekoak: " + SoldatapekoLista);
		System.out.println("Kontsultoreak: " + KanpoKontsultoreaLista);
		SoldatapekoLista.get(0).setOrduExtrak(5); 
		SoldatapekoLista.get(1).setOrduExtrak(15);
		SoldatapekoLista.get(2).setOrduExtrak(2); 

		// Kanpo kontsultoreen egindako orduak esleitu
		KanpoKontsultoreaLista.get(0).setOrduak(180); 
		KanpoKontsultoreaLista.get(1).setOrduak(120); 


		final double ordu_extra_balioa = 40.0;
//		final double kontsultoria_ordaindeka = 100.0;

		// Soldatapekoen soldatak kalkulatu
		for (Soldatapekoa s : SoldatapekoLista) {
			s.soldataFinalaKalkulatu(ordu_extra_balioa);
		}

		// Kanpo kontsultoreen soldatak kalkulatu
		for (KanpoKontsultorea k : KanpoKontsultoreaLista) {
			k.soldataFinalaKalkulatu(ordu_extra_balioa);
		}

		System.out.println("Soldatapekoak:");
		for (Soldatapekoa s : SoldatapekoLista) {
			System.out.println(s);
		}
		System.out.println("Kanpo Kontsultoreak:");
		for (KanpoKontsultorea k : KanpoKontsultoreaLista) {
			System.out.println(k);
		}
	}
}
