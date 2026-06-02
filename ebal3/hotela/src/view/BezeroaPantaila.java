package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Bezeroaren pantaila — bere erreserbak BAKARRIK ikusten ditu. Erreserba
 * berriak sortu eta ezabatu ditzake. Txostena ere sor dezake.
 */
public class BezeroaPantaila extends JFrame {
	public JButton btnErreserbaBerria = new JButton("Erreserba berria");
	public JButton btnErreserbaEzabatu = new JButton("Erreserba ezabatu");
	public JButton btnTxostenaSortu = new JButton("Txostena sortu");
	public JButton btnIrten = new JButton("Irten");
	public DefaultTableModel dtm = new DefaultTableModel();
	public JTable taulaErreserbak = new JTable(dtm);
	public JLabel lblData = new JLabel("Data (YYYY-MM-DD)");
	public JTextField txtData = new JTextField(15);
	public JLabel lblGela = new JLabel("Gela");
	public JComboBox<model.Gela> cmbGela = new JComboBox<>();
	public JButton btnGorde = new JButton("Gorde");
	public JButton btnUtzi = new JButton("Utzi");

	public BezeroaPantaila() {
		setTitle("Hotela - Nire erreserbak");
		setSize(900, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout(10, 10));
		JPanel panelGoia = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		Dimension btnSize = new Dimension(170, 30);
		btnErreserbaBerria.setPreferredSize(btnSize);
		btnErreserbaEzabatu.setPreferredSize(btnSize);
		btnTxostenaSortu.setPreferredSize(btnSize);
		btnIrten.setPreferredSize(btnSize);
		panelGoia.add(btnErreserbaBerria);
		panelGoia.add(btnErreserbaEzabatu);
		panelGoia.add(btnTxostenaSortu);
		panelGoia.add(btnIrten);
		dtm.addColumn("ID");
		dtm.addColumn("Gela");
		dtm.addColumn("Data");
		taulaErreserbak.setFillsViewportHeight(true);
		JScrollPane scroll = new JScrollPane(taulaErreserbak);
		JPanel panelBehea = new JPanel(new GridBagLayout());
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
		panelBehea.add(lblGela, gbc);
		gbc.gridx = 1;
		gbc.weightx = 1.0;
		panelBehea.add(cmbGela, gbc);
		JPanel panelBotoiakBehea = new JPanel(new GridLayout(1, 2, 10, 0));
		btnGorde.setPreferredSize(new Dimension(0, 30));
		btnUtzi.setPreferredSize(new Dimension(0, 30));
		panelBotoiakBehea.add(btnGorde);
		panelBotoiakBehea.add(btnUtzi);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		panelBehea.add(panelBotoiakBehea, gbc);
		add(panelGoia, BorderLayout.NORTH);
		add(scroll, BorderLayout.CENTER);
		add(panelBehea, BorderLayout.SOUTH);
	}

	public JTable getTablaErreserbak() {
		return taulaErreserbak;
	}
}