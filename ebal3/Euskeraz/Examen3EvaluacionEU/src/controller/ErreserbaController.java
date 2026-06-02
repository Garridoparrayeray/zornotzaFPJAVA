package controller;

import dao.KlaseaDAO;
import dao.ErreserbaDAO;
import model.Klasea;
import model.Erreserba;
import model.Erabiltzailea;
import view.PantailaErreserbak;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

public class ErreserbaController {

    private PantailaErreserbak vista;
    private ErreserbaDAO dao = new ErreserbaDAO();
    private KlaseaDAO klaseaDAO = new KlaseaDAO();
    private Erabiltzailea erabiltzailea;

    public ErreserbaController(PantailaErreserbak vista, Erabiltzailea erabiltzailea) {

        this.vista = vista;
        this.erabiltzailea = erabiltzailea;

        kargatuKlaseakCombo();
        kargatuTaula();
        ekitaldiakHasieratu();
    }

    // ================= TAULA =================
    private void kargatuTaula() {

        DefaultTableModel modeloa = new DefaultTableModel(
                new Object[]{"ID", "Klasea", "Data"}, 0
        );

        for (Erreserba r : dao.lortuErreserbakErabiltzailearenarabera(erabiltzailea.getIdErabiltzailea())) {

            modeloa.addRow(new Object[]{
                    r.getIdErreserba(),
                    r.getKlaseIzena(),
                    r.getData()
            });
        }

        vista.getTaulaErreserbak().setModel(modeloa);
    }

    // ================= KOMBOA =================
    private void kargatuKlaseakCombo() {

        vista.getComboKlaseak().removeAllItems();

        for (Klasea k : klaseaDAO.lortuKlaseak()) {

            vista.getComboKlaseak().addItem(
                    k.getIdKlasea() + " - " + k.getIzena()
            );
        }
    }

    // ================= EKITALDIAK =================
    private void ekitaldiakHasieratu() {

        // SORTU
        vista.getBtnSortu().addActionListener(e -> {
            vista.getPanelFormularioa().setVisible(true);
        });

        // GORDE
        vista.getBtnGorde().addActionListener(e -> {

            try {
                String selected = vista.getComboKlaseak().getSelectedItem().toString();
                int idKlasea = Integer.parseInt(selected.split(" - ")[0]);

                Erreserba r = new Erreserba();

                r.setIdBezeroa(erabiltzailea.getIdErabiltzailea());
                r.setData(LocalDate.parse(vista.getTxtData().getText()));
                r.setIdKlasea(idKlasea);

                dao.erreserbaTxertatu(r);

                vista.getPanelFormularioa().setVisible(false);
                kargatuTaula();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // EZABATU
        vista.getBtnEzabatu().addActionListener(e -> {

            int fila = vista.getTaulaErreserbak().getSelectedRow();
            if (fila == -1) return;

            int id = (int) vista.getTaulaErreserbak().getValueAt(fila, 0);

            dao.erreserbaEzabatu(id);
            kargatuTaula();
        });

        // TXOSTENA
        vista.getBtnTxostenak().addActionListener(e -> {
            sortuTxostena();
        });

        // UTZI
        vista.getBtnUtzi().addActionListener(e -> {
            vista.getPanelFormularioa().setVisible(false);
        });

        // IRten
        vista.getBtnIrten().addActionListener(e -> {
            vista.dispose();
        });
    }

    // ================= TXOSTENA =================
    private void sortuTxostena() {

        try (PrintWriter pw = new PrintWriter(new FileWriter("erreserba_txostena.txt"))) {

            pw.println("=== ERRESERBEN TXOSTENA ===\n");
            pw.println("Erabiltzailea: " + erabiltzailea.getIzena());
            pw.println("Erreserba kopurua: " + vista.getTaulaErreserbak().getRowCount());
            pw.println();

            for (int i = 0; i < vista.getTaulaErreserbak().getRowCount(); i++) {

                String klasea = vista.getTaulaErreserbak().getValueAt(i, 1).toString();
                String data = vista.getTaulaErreserbak().getValueAt(i, 2).toString();

                pw.printf("%s | %s%n", klasea, data);
            }

            JOptionPane.showMessageDialog(
                    vista,
                    "Txostena ondo sortu da.",
                    "Arrakasta",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                    vista,
                    "Errorea txostena sortzean.",
                    "Errorea",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
