package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PantailaErreserbak extends JFrame {

    private JTable taulaErreserbak;

    private JButton btnSortu;
    private JButton btnEzabatu;
    private JButton btnTxostenak;
    private JButton btnIrten;

    // FORMULARIOA
    private JPanel panelFormularioa;
    private JTextField txtData;
    private JComboBox<String> comboKlaseak;

    private JButton btnGorde;
    private JButton btnUtzi;
	private DefaultTableModel dtm;

    public PantailaErreserbak() {

        setTitle("Nire erreserbak");
        setSize(800, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        getContentPane().setLayout(new BorderLayout(10, 10));

        // ================= TAULA =================
        dtm = new DefaultTableModel();
        dtm.addColumn("ID");
        dtm.addColumn("Klasea");
        dtm.addColumn("Data");
        taulaErreserbak = new JTable(dtm);
        getContentPane().add(new JScrollPane(taulaErreserbak), BorderLayout.CENTER);

        // ================= BOTOIAK =================
        JPanel panelBotones = new JPanel();

        btnSortu = new JButton("Erreserba berria");
        btnEzabatu = new JButton("Erreserba ezabatu");
        btnTxostenak = new JButton("Txostena sortu");
        btnIrten = new JButton("Irten");

        panelBotones.add(btnSortu);
        panelBotones.add(btnEzabatu);
        panelBotones.add(btnTxostenak);
        panelBotones.add(btnIrten);

        getContentPane().add(panelBotones, BorderLayout.NORTH);

        // ================= FORMULARIOA =================
        panelFormularioa = new JPanel(new GridLayout(3, 2));

        txtData = new JTextField();
        comboKlaseak = new JComboBox<>();

        btnGorde = new JButton("Gorde");
        btnUtzi = new JButton("Utzi");

        panelFormularioa.add(new JLabel("Data (YYYY-MM-DD)"));
        panelFormularioa.add(txtData);

        panelFormularioa.add(new JLabel("Klasea"));
        panelFormularioa.add(comboKlaseak);

        panelFormularioa.add(btnGorde);
        panelFormularioa.add(btnUtzi);

        panelFormularioa.setVisible(false);

        getContentPane().add(panelFormularioa, BorderLayout.SOUTH);
    }

    // ================= GETTERS =================
    public JTable getTaulaErreserbak() { return taulaErreserbak; }
    public DefaultTableModel getDtm() {
		return dtm;
	}

	/**
	 * @param dtm the dtm to set
	 */
	public void setDtm(DefaultTableModel dtm) {
		this.dtm = dtm;
	}

    public JButton getBtnSortu() { return btnSortu; }
    public JButton getBtnEzabatu() { return btnEzabatu; }
    public JButton getBtnTxostenak() { return btnTxostenak; }
    public JButton getBtnIrten() { return btnIrten; }

    public JPanel getPanelFormularioa() { return panelFormularioa; }
    
    public JTextField getTxtData() { return txtData; }
    public JComboBox<String> getComboKlaseak() { return comboKlaseak; }

    public JButton getBtnGorde() { return btnGorde; }
    public JButton getBtnUtzi() { return btnUtzi; }
}