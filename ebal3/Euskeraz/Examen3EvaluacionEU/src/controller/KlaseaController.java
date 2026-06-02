package controller;

import dao.KlaseaDAO;
import model.Klasea;
import view.PantailaKlaseak;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class KlaseaController {

    private PantailaKlaseak vista;
    private KlaseaDAO dao;

    private boolean moduaEditatu = false;
    private int hautatutakoId = -1;

    public KlaseaController(PantailaKlaseak vista) {

        this.vista = vista;
        this.dao = new KlaseaDAO();

        kargatuTaula();
        ekitaldiakHasieratu();
    }

    // =========================
    // TAULA
    // =========================
    private void kargatuTaula() {

        DefaultTableModel modeloa = new DefaultTableModel(
                new Object[]{"ID", "Izena", "Instruktorea", "Ordutegia"}, 0
        );

        ArrayList<Klasea> lista = dao.lortuKlaseak();

        for (Klasea k : lista) {
            modeloa.addRow(new Object[]{
                    k.getIdKlasea(),
                    k.getIzena(),
                    k.getInstruktorea(),
                    k.getOrdutegia()
            });
        }

        vista.getTaula().setModel(modeloa);
    }

    // =========================
    // EKITALDIAK
    // =========================
    private void ekitaldiakHasieratu() {

        // SORTU
        vista.getBtnSortu().addActionListener(e -> {
            formularioaErakutsi(false);
        });

        // EDITATU
        vista.getBtnEditatu().addActionListener(e -> {

            int fila = vista.getTaula().getSelectedRow();

            if (fila == -1) return;

            hautatutakoId = (int) vista.getTaula().getValueAt(fila, 0);

            vista.getTxtIzena().setText(vista.getTaula().getValueAt(fila, 1).toString());
            vista.getTxtInstruktorea().setText(vista.getTaula().getValueAt(fila, 2).toString());
            vista.getTxtOrdutegia().setText(vista.getTaula().getValueAt(fila, 3).toString());

            formularioaErakutsi(true);
        });

        // IRten
        vista.getBtnIrten().addActionListener(e -> {
            vista.dispose();
        });

        // GORDE (SORTU EDO EDITATU)
        vista.getBtnGorde().addActionListener(e -> {

            Klasea k = new Klasea();
            k.setIzena(vista.getTxtIzena().getText());
            k.setInstruktorea(vista.getTxtInstruktorea().getText());
            k.setOrdutegia(vista.getTxtOrdutegia().getText());

            if (moduaEditatu) {
                k.setIdKlasea(hautatutakoId);
                dao.klaseaEguneratu(k);
            } else {
                dao.klaseaTxertatu(k);
            }

            formularioaEzkutatu();
            kargatuTaula();
        });

        // UTZI
        vista.getBtnUtzi().addActionListener(e -> {
            formularioaEzkutatu();
        });
    }

    // =========================
    // FORMULARIOA
    // =========================
    private void formularioaErakutsi(boolean editatzen) {

        moduaEditatu = editatzen;

        vista.getPanelFormularioa().setVisible(true);
    }

    private void formularioaEzkutatu() {

        vista.getPanelFormularioa().setVisible(false);

        vista.getTxtIzena().setText("");
        vista.getTxtInstruktorea().setText("");
        vista.getTxtOrdutegia().setText("");

        hautatutakoId = -1;
        moduaEditatu = false;
    }
}