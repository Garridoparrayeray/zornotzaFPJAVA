package main;
import view.LoginPantaila;
import controller.loginKontrolatzailea;
public class Main {
	public static void main(String[] args) {
		LoginPantaila login = new LoginPantaila();
		new loginKontrolatzailea(login);
		login.setVisible(true);
	}
}
