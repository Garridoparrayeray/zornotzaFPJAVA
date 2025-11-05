package jarduera2_6;

import java.util.Scanner;

public class Jarduera2_6_1_2_3 {
	
	static Scanner sc = new Scanner(System.in);
	 
	public static void main(String[] args) {
		
		int aukerak;
		int BaiEzAukera;
		
		BaiEzAukera = 0;
		aukerak = 0;
		
		do {
			System.out.println("Ze operazio egin nahi duzu?");
			System.out.println("1-Dirua sartzea");
			System.out.println("2-Aldaketa txanpona");
			System.out.println("3-Aldaketa txanpona 2.0(trasferentzia gehiago");
			System.out.println("0-IRTEN");
			
			aukerak = sc.nextInt();
			
			switch(aukerak) {
				case 1:
					System.out.println("Sartuko duzu aldaketak egiteko diru kopurua.");
					euroAldaketa();
					break;
				case 2:
					System.out.println("\"D\" jasotzen badu, kopurua eurotan dago eta dolarretara pasatu behar da. \"E\" jasotzen badu €-tara");
					aldaketaTxanpona();
					break;
				case 3:
					System.out.println("WARNING! Bitcoin-ekin transakzioa egin dezakezu, sartu duzu diru egokia?");
					System.out.println("Sartutako diru kopurua: ");
					System.out.println(euroAldaketa());
					System.out.println("Jarraitu nahi duzu edo diru kopurua aldatu nahi duzu?");
					System.out.println("1 - JARRAITU");
					System.out.println("2 - Berriro sartu dirua");
					BaiEzAukera = sc.nextInt();
					if (BaiEzAukera == 1) {
						aldaketaTxanponaBerritua();
					} else if(BaiEzAukera == 2) {
						euroAldaketa();
					}else {
						System.out.println("ERROREA. Sartu behar duzu 1 edo 2.");
						break;
					}
					break;
				case 0:
					System.out.println("Irteten....");
				default:
					System.out.println("Sartu zenbaki bat 0tik 3-ra. Sakatu 0 programatik irteteko.");
			}
		}while(aukerak != 0);
		
	}
		public static double euroAldaketa(){
			double zenb;
			
			zenb = 0;
			System.out.println("Sartu diru kopurua: ");
			
			zenb = sc.nextDouble();
			return(zenb);
		}
		
		public static void aldaketaTxanpona() {
			double diruKopurua = euroAldaketa();
			char aldaketaTxanpona;
			
			aldaketaTxanpona = ' ';
			System.out.println("Sartu txanpona: ");
			System.out.println("D sartzerakoan, €-tan dago.");
			System.out.println("E sartzerakoan $-etan dago.");
			while(true) {
				aldaketaTxanpona = sc.next().toUpperCase().charAt(0);
				if(aldaketaTxanpona != 'E' || aldaketaTxanpona != 'D') {
					System.out.println("Errorea. Sartu ezazu egoki txanponaren letra");
				}else {
					break;
				}
			}
			if(aldaketaTxanpona == 'E') {
				System.out.println("Zure dirua €-etan: "+ ((diruKopurua/1.17))+ " da");
			}else if(aldaketaTxanpona == 'D') {
				System.out.println("Zure dirua $-etan: "+ ((diruKopurua*1.17))+ " da");
			}
		}
		
		public static void aldaketaTxanponaBerritua() {
			double diruKopurua = euroAldaketa();
			char TxanponIn;
			char TxanponOut;
			TxanponIn= ' ';
			TxanponOut = ' ';
			System.out.println("Sartu zure diruaren txanpona: ");
			System.out.println("D sartzerakoan, €-tan dago.");
			System.out.println("E sartzerakoan $-etan dago.");
			System.out.println("B sartzerakoan Bitcoin-etan dago.");
			
			while(true) {
				TxanponIn = sc.next().toUpperCase().charAt(0);
				if(TxanponIn != 'E' || TxanponIn != 'D' || TxanponIn != 'B') {
					System.out.println("Errorea. Sartu ezazu egoki txanponaren letra");
				}else {
					break;
				}
			}
			if(TxanponIn == 'E') {
				System.out.println("Zure dirua: " + diruKopurua + "€");
			}else if(TxanponIn == 'D') {
				System.out.println("Zure dirua: " + diruKopurua + "$");
			} else if(TxanponIn == 'B') {
				System.out.println("Zure dirua: " + diruKopurua + " BITCOIN");
			}
			System.out.println("Sartu aldaketaren txanpona(txanpon finala): ");
			
			while(true) {
				TxanponOut = sc.next().toUpperCase().charAt(0);
				if(TxanponOut != 'E' || TxanponOut != 'D' || TxanponOut != 'B') {
					System.out.println("Errorea. Sartu ezazu egoki txanponaren letra");
				}else {
					break;
				}
			}
			if(TxanponIn == 'E') {
				if(TxanponOut == 'E') {
					System.out.println("Zure dirua: " + diruKopurua + "€");
				}else if(TxanponIn == 'D') {
					System.out.println("Zure dirua: " + diruKopurua*1.17 + "$");
				} else if(TxanponIn == 'B') {
					System.out.println("Zure dirua: " + (diruKopurua*0.000011) + " BITCOIN");
				} 
				
			}else if(TxanponIn == 'D') {
				if(TxanponOut == 'E') {
					System.out.println("Zure dirua: " + (diruKopurua/1.17) + "€");
				}else if(TxanponIn == 'D') {
					System.out.println("Zure dirua: " + diruKopurua + "$");
				} else if(TxanponIn == 'B') {
					System.out.println("Zure dirua: " + (diruKopurua*0.0000095) + " BITCOIN");
				} 
				
			} else if(TxanponIn == 'B') {
				if(TxanponOut == 'E') {
					System.out.println("Zure dirua: " + (diruKopurua*90207.67) + "€");
				}else if(TxanponIn == 'D') {
					System.out.println("Zure dirua: " + (diruKopurua*105663) + "$");
				} else if(TxanponIn == 'B') {
					System.out.println("Zure dirua: " + diruKopurua + " BITCOIN");
				} 
				
			}
			
		}
		
		
		
}
