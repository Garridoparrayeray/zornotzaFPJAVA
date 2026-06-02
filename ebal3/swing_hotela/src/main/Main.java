package main;
import view.LeihoLogin;
import controller.KontrolatzaileLogin;
public class Main {
	public static void main(String[] args) {
		LeihoLogin leihoPrintzipala = new LeihoLogin();
		new KontrolatzaileLogin(leihoPrintzipala);
		leihoPrintzipala.setVisible(true);
		
	}
}
