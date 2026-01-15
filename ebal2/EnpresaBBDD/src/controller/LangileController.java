package controller;

import java.util.ArrayList;
import dao.LangileaDAO;
import model.langileak;
/*DAO-ko eta model-eko datuak erabiliko ditugu*/
public class LangileController {
    private LangileaDAO dao;

    public LangileController() {
        this.dao = new LangileaDAO();
    }

    public ArrayList<langileak> lortuSoldataGorakoak(double soldata) {
        try {
            return dao.getLangileakSoldatagorako(soldata);
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public ArrayList<langileak> lortuSoldataTartekoak(double min, double max) {
        try {
            return dao.getLangileakSoldataTartekoa(min, max);
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public ArrayList<langileak> lortuDepartamentuka(String dept) {
        try {
            return dao.getLangileakDepartamentuka(dept);
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
    public void erakutsi(ArrayList<langileak> zerrenda) {
        if (zerrenda == null || zerrenda.isEmpty()) {
            System.out.println("Ez da langilerik aurkitu.");
        } else {
            System.out.println("AURKITUTAKO LANGILEAK:");
            for (langileak l : zerrenda) {
                System.out.println("- " + l.getFirst_name() + " " + l.getLast_name() + 
                                   " [" + l.getDepartment() + "]: " + l.getSalario() + "€");
            }
        }
    }
}