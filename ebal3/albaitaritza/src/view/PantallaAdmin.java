package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PantallaAdmin extends JFrame {

    public JButton btnSortu = new JButton("Animalia sortu");
    public JButton btnEditatu = new JButton("Animalia editatu");
    public JButton btnEzabatu = new JButton("Animalia ezabatu");
    public JButton btnEsportatu = new JButton("Esportatu .bin");
    public JButton btnIrten = new JButton("Irten");

    public DefaultTableModel dtm = new DefaultTableModel();
    public JTable taula = new JTable(dtm);

    public JLabel lblIzena = new JLabel("Izena");
    public JTextField txtIzena = new JTextField(15);

    public JLabel lblAdina = new JLabel("Adina");
    public JTextField txtAdina = new JTextField(15);

    public JLabel lblIdJabea = new JLabel("Jabe ID");
    public JTextField txtIdJabea = new JTextField(15);

    public JLabel lblMota = new JLabel("Mota");
    public JComboBox<String> cmbMota = new JComboBox<>(new String[]{"TXAKURRA", "KATUA"});

    public JLabel lblExtra = new JLabel("Extra");
    public JTextField txtExtra = new JTextField(15);

    public JButton btnGorde = new JButton("Gorde");
    public JButton btnUtzi = new JButton("Utzi");
    public JPanel panelBehea = new JPanel();


	public PantallaAdmin() {
        setTitle("Albaitaritza - Admin: Animalien kudeaketa");
        setSize(900, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // GOIA: botoiak
        JPanel panelGoia = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 10));
        Dimension btnSize = new Dimension(140, 30);
        btnSortu.setPreferredSize(btnSize);
        btnEditatu.setPreferredSize(btnSize);
        btnEzabatu.setPreferredSize(btnSize);
        btnEsportatu.setPreferredSize(btnSize);
        btnIrten.setPreferredSize(btnSize);
        panelGoia.add(btnSortu);
        panelGoia.add(btnEditatu);
        panelGoia.add(btnEzabatu);
        panelGoia.add(btnEsportatu);
        panelGoia.add(btnIrten);

        // ERDIA: taula
        dtm.addColumn("ID");
        dtm.addColumn("Izena");
        dtm.addColumn("Adina");
        dtm.addColumn("Mota");
        dtm.addColumn("Extra");
        dtm.addColumn("Jabe ID");
        taula.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(taula);

        // BEHEA: formularioa
         panelBehea = new JPanel(new GridBagLayout());
        panelBehea.setVisible(false);
        panelBehea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0.0; panelBehea.add(lblIzena, gbc);
        gbc.gridx = 1; gbc.weightx = 1.0; panelBehea.add(txtIzena, gbc);

        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0.0; panelBehea.add(lblAdina, gbc);
        gbc.gridx = 1; gbc.weightx = 1.0; panelBehea.add(txtAdina, gbc);

        gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 0.0; panelBehea.add(lblIdJabea, gbc);
        gbc.gridx = 1; gbc.weightx = 1.0; panelBehea.add(txtIdJabea, gbc);

        gbc.gridx = 0; gbc.gridy = 3; gbc.weightx = 0.0; panelBehea.add(lblMota, gbc);
        gbc.gridx = 1; gbc.weightx = 1.0; panelBehea.add(cmbMota, gbc);

        gbc.gridx = 0; gbc.gridy = 4; gbc.weightx = 0.0; panelBehea.add(lblExtra, gbc);
        gbc.gridx = 1; gbc.weightx = 1.0; panelBehea.add(txtExtra, gbc);

        JPanel panelBotoiakBehea = new JPanel(new GridLayout(1, 2, 10, 0));
        btnGorde.setPreferredSize(new Dimension(0, 30));
        btnUtzi.setPreferredSize(new Dimension(0, 30));
        panelBotoiakBehea.add(btnGorde);
        panelBotoiakBehea.add(btnUtzi);

        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2;
        panelBehea.add(panelBotoiakBehea, gbc);

        add(panelGoia, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(panelBehea, BorderLayout.SOUTH);
    }

    public JTable getTabla() { return taula; }
    public JPanel getPanelBehea() {
		return panelBehea;
	}

	public void setPanelBehea(JPanel panelBehea) {
		this.panelBehea = panelBehea;
	}
}
