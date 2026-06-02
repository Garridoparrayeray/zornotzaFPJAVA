package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

public class PantailaKlaseak extends JFrame {

    private JTable taula;
    private JButton btnSortu, btnEditatu, btnIrten;

    // FORMULARIOA
    private JPanel panelFormularioa;
    private JTextField txtIzena, txtInstruktorea, txtOrdutegia;
    private JButton btnGorde, btnUtzi;
    private DefaultTableModel dtm;
    public PantailaKlaseak() {

        setTitle("Klaseen kudeaketa");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setLayout(new BorderLayout());
        dtm = new DefaultTableModel();
        dtm.addColumn("ID");
        dtm.addColumn("Izena");
        dtm.addColumn("Instruktorea");
        dtm.addColumn("Ordutegia");
        // ================= TAULA =================
        taula = new JTable(dtm);
        getContentPane().add(new JScrollPane(taula), BorderLayout.CENTER);

        // ================= BOTOIAK =================
        JPanel panelBotones = new JPanel();

        btnSortu = new JButton("Klasea sortu");
        btnEditatu = new JButton("Klasea editatu");
        btnIrten = new JButton("Irten");

        panelBotones.add(btnSortu);
        panelBotones.add(btnEditatu);
        panelBotones.add(btnIrten);

        getContentPane().add(panelBotones, BorderLayout.NORTH);

        // ================= FORMULARIOA =================
        panelFormularioa = new JPanel(new GridLayout(4, 2));
        panelFormularioa.setVisible(false);

        txtIzena = new JTextField();
        txtInstruktorea = new JTextField();
        txtOrdutegia = new JTextField();

        btnGorde = new JButton("Gorde");
        btnUtzi = new JButton("Utzi");

        panelFormularioa.add(new JLabel("Izena"));
        panelFormularioa.add(txtIzena);

        panelFormularioa.add(new JLabel("Instruktorea"));
        panelFormularioa.add(txtInstruktorea);

        panelFormularioa.add(new JLabel("Ordutegia"));
        panelFormularioa.add(txtOrdutegia);

        panelFormularioa.add(btnGorde);
        panelFormularioa.add(btnUtzi);

        getContentPane().add(panelFormularioa, BorderLayout.SOUTH);
    }

    public DefaultTableModel getDtm() {
		return dtm;
	}

	public void setDtm(DefaultTableModel dtm) {
		this.dtm = dtm;
	}

	// GETTERS
    public JTable getTaula() { return taula; }

    public JButton getBtnSortu() { return btnSortu; }
    public JButton getBtnEditatu() { return btnEditatu; }
    public JButton getBtnIrten() { return btnIrten; }

    public JPanel getPanelFormularioa() { return panelFormularioa; }

    public JTextField getTxtIzena() { return txtIzena; }
    public JTextField getTxtInstruktorea() { return txtInstruktorea; }
    public JTextField getTxtOrdutegia() { return txtOrdutegia; }

    public JButton getBtnGorde() { return btnGorde; }
    public JButton getBtnUtzi() { return btnUtzi; }
}