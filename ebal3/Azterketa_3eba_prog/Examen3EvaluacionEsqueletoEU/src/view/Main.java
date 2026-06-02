package view;
import controller.*;
public class Main {

    public static void main(String[] args) {
    	PantailaLogin pantailaBerria = new PantailaLogin();
    	new LoginKontrolatzailea(pantailaBerria);
    	pantailaBerria.setVisible(true);
    }
}
