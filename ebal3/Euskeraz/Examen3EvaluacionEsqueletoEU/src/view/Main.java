package view;

import controller.LoginKontrolatzailea;

public class Main {

    public static void main(String[] args) {
    		PantailaLogin leihoa = new PantailaLogin();
    		new LoginKontrolatzailea(leihoa);
    		leihoa.setVisible(true);
    }
}
