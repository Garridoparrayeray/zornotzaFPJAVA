package jarduera2_5;

import java.util.Scanner;

public class Jarduera2_5_13 {
//	Gela bateko ikasleen notak teklatutik irakurtzen dituen arraia sortu. 
//	Gelako ikasleen batazbesteko nota kalkula behar da.
//	Horrez gain, batazbestetik gora dauden ikasleen notak era erakutsi behar dira. 
//	Ikasle kopurua teklatutik irakurtzen da. 
//	(arraia hiru bider irakurri behar da, notak esleitzeko, batuketa eta batazbestekoa egiteko 
//			eta batazbestekotik gora dauden ikasleak erakusteko).
	public static void main(String[] args) {
		int notak, i;
		double notakJarri[], batazbeste;
		
		i = 0;
		notak  = 0;
		batazbeste = 0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Sar ezazu zenbat notak jarri nahi duzun: ");
		notak = sc.nextInt();
		notakJarri = new double[notak];
		System.out.println(notak + " klaseko kideak daude");
		
		for(i = 0; i < notakJarri.length; i++) {
			System.out.println("Sar esazu "+(i + 1)+ " nota: ");
			notakJarri[i] = sc.nextDouble();
			if(notakJarri[i] > 10 || notakJarri[i] < 0) {
				System.out.println("Sar ezazu ondo nota");
				i--;
			}
			
		}
		for(i = 0; i < notakJarri.length; i++) {
			batazbeste += notakJarri[i];
		}
		batazbeste /= notak;
		System.out.println("Batazbesteko nota, "+ notak + " artean, "+ batazbeste + " da.");
		System.out.println("Batazbeste gorako notak: ");
		for(i = 0; i < notakJarri.length; i++) {
			if(notakJarri[i] > batazbeste) {
				System.out.println(notakJarri[i]);
			}
		}
		
	}
}
