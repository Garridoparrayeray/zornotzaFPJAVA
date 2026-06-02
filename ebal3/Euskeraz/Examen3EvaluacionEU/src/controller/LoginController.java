package controller;

import dao.ErabiltzaileDAO;
import model.Erabiltzailea;
import view.PantailaLogin;
import view.PantailaKlaseak;
import view.PantailaErreserbak;

import javax.swing.*;

public class LoginController {

    private PantailaLogin vista;
    private ErabiltzaileDAO dao = new ErabiltzaileDAO();

    public LoginController(PantailaLogin vista) {
        this.vista = vista;
        hasieratu();
    }

    private void hasieratu() {

        vista.getBtnSartu().addActionListener(e -> {

            String izena = vista.getTxtErabiltzailea().getText();
            String pasahitza = new String(vista.getTxtPasahitza().getPassword());

            Erabiltzailea euser = dao.saioaHasi(izena, pasahitza);

            if (euser == null) {
                JOptionPane.showMessageDialog(null, "Saioa hasteko datuak okerrak dira");
                return;
            }

            vista.dispose();

            // =========================
            // ROLAREN ARABERAKO BISTARATZEA
            // =========================
            if (euser.getRola().equals("ADMIN")) {

                PantailaKlaseak pc = new PantailaKlaseak();
                new KlaseaController(pc);

                pc.setVisible(true);
            }

            if (euser.getRola().equals("BEZEROA")) {

                PantailaErreserbak pr = new PantailaErreserbak();
                new ErreserbaController(pr, euser);

                pr.setVisible(true);
            }
        });
    }
}