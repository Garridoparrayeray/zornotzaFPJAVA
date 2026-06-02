package view;

import controller.LoginController;

public class Main {

    public static void main(String[] args) {

    	PantailaLogin login = new PantailaLogin();

        new LoginController(login);

        login.setVisible(true);
    }
}