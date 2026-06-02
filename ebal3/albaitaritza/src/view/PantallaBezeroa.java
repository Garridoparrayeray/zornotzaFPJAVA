package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PantallaBezeroa extends JFrame {

	public JButton btnHitzorduBerria = new JButton("Hitzordu berria");
	public JButton btnHitzorduEzabatu = new JButton("Hitzordu ezabatu");
	public JButton btnTxostenaSortu = new JButton("Txostena sortu");
	public JButton btnIrten = new JButton("Irten");

	public DefaultTableModel dtm = new DefaultTableModel();
	public JTable taulaHitzorduak = new JTable(dtm);

	public JLabel lblData = new JLabel("Data (YYYY-MM-DD)");
	public JTextField txtData = new JTextField(15);

	public JLabel lblOrdua = new JLabel("Ordua (HH:MM)");
	public JTextField txtOrdua = new JTextField(15);

	public JLabel lblAnimalia = new JLabel("Animalia");
	public JComboBox cmbAnimalia = new JComboBox<>();

	public JButton btnGorde = new JButton("Gorde");
	public JButton btnUtzi = new JButton("Utzi");
	public JPanel panelBehea = new JPanel();

	public JPanel getPanelBehea() {
		return panelBehea;
	}

	public void setPanelBehea(JPanel panelBehea) {
		this.panelBehea = panelBehea;
	}

	public PantallaBezeroa() {
		setTitle("Albaitaritza - Nire hitzorduak");
		setSize(900, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout(10, 10));

		// GOIA: botoiak
		JPanel panelGoia = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		Dimension btnSize = new Dimension(170, 30);
		btnHitzorduBerria.setPreferredSize(btnSize);
		btnHitzorduEzabatu.setPreferredSize(btnSize);
		btnTxostenaSortu.setPreferredSize(btnSize);
		btnIrten.setPreferredSize(btnSize);
		panelGoia.add(btnHitzorduBerria);
		panelGoia.add(btnHitzorduEzabatu);
		panelGoia.add(btnTxostenaSortu);
		panelGoia.add(btnIrten);

		// ERDIA: taula
		dtm.addColumn("ID");
		dtm.addColumn("Animalia");
		dtm.addColumn("Data");
		dtm.addColumn("Ordua");
		taulaHitzorduak.setFillsViewportHeight(true);
		JScrollPane scroll = new JScrollPane(taulaHitzorduak);

		// BEHEA: formularioa
		panelBehea = new JPanel(new GridBagLayout());
		panelBehea.setVisible(false);
		panelBehea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.fill = GridBagConstraints.HORIZONTAL;

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.0;
		panelBehea.add(lblData, gbc);
		gbc.gridx = 1;
		gbc.weightx = 1.0;
		panelBehea.add(txtData, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.0;
		panelBehea.add(lblOrdua, gbc);
		gbc.gridx = 1;
		gbc.weightx = 1.0;
		panelBehea.add(txtOrdua, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 0.0;
		panelBehea.add(lblAnimalia, gbc);
		gbc.gridx = 1;
		gbc.weightx = 1.0;
		panelBehea.add(cmbAnimalia, gbc);

		JPanel panelBotoiakBehea = new JPanel(new GridLayout(1, 2, 10, 0));
		btnGorde.setPreferredSize(new Dimension(0, 30));
		btnUtzi.setPreferredSize(new Dimension(0, 30));
		panelBotoiakBehea.add(btnGorde);
		panelBotoiakBehea.add(btnUtzi);

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		panelBehea.add(panelBotoiakBehea, gbc);

		add(panelGoia, BorderLayout.NORTH);
		add(scroll, BorderLayout.CENTER);
		add(panelBehea, BorderLayout.SOUTH);
	}

	public JTable getTablaHitzorduak() {
		return taulaHitzorduak;
	}
}
