package main;
import controller.loginKontrolerra;
import view.PantallaLogin;

public class main {
	public static void main(String[] args) {
		PantallaLogin leihoa = new PantallaLogin();
		new loginKontrolerra(leihoa);
		leihoa.setVisible(true);
	}
}
