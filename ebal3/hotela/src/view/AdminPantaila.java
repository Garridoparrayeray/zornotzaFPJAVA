package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Admin-aren pantaila — gelak kudeatzen ditu (sortu, editatu, ezabatu). Plus:
 * gelak bitarrera esportatu.
 */
public class AdminPantaila extends JFrame {
// Goiko botoiak
	public JButton btnSortu = new JButton("Gela sortu");
	public JButton btnEditatu = new JButton("Gela editatu");
	public JButton btnEzabatu = new JButton("Gela ezabatu");
	public JButton btnEsportatu = new JButton("Esportatu .bin");
	public JButton btnIrten = new JButton("Irten");
// Taula
	public DefaultTableModel dtm = new DefaultTableModel();
	public JTable taula = new JTable(dtm);
// Beheko formularioa
	public JLabel lblSolairua = new JLabel("Solairua");
	public JTextField txtSolairua = new JTextField(15);
	public JLabel lblPrezioa = new JLabel("Prezioa");
	public JTextField txtPrezioa = new JTextField(15);
	public JLabel lblMota = new JLabel("Mota");
	public JComboBox<String> cmbMota = new JComboBox<>(new String[] { "ARRUNTA", "SUITE" });
	public JLabel lblExtra = new JLabel("Extra");
	public JTextField txtExtra = new JTextField(15);
	public JButton btnGorde = new JButton("Gorde");
	public JButton btnUtzi = new JButton("Utzi");
	private JPanel panelBotoiakBehea = new JPanel();
	public AdminPantaila() {
		setTitle("Hotela - Admin: Gelen kudeaketa");
		setSize(900, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout(10, 10));
// GOIA
		JPanel panelGoia = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 10));
		Dimension btnSize = new Dimension(130, 30);
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
		dtm.addColumn("Solairua");
		dtm.addColumn("Prezioa");
		dtm.addColumn("Mota");
		dtm.addColumn("Extra");
		taula.setFillsViewportHeight(true);
		JScrollPane scroll = new JScrollPane(taula);
// BEHEA: formularioa
		JPanel panelBehea = new JPanel(new GridBagLayout());
		panelBehea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.0;
		panelBehea.add(lblSolairua, gbc);
		gbc.gridx = 1;
		gbc.weightx = 1.0;
		panelBehea.add(txtSolairua, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.0;
		panelBehea.add(lblPrezioa, gbc);
		gbc.gridx = 1;
		gbc.weightx = 1.0;
		panelBehea.add(txtPrezioa, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 0.0;
		panelBehea.add(lblMota, gbc);
		gbc.gridx = 1;
		gbc.weightx = 1.0;
		panelBehea.add(cmbMota, gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 0.0;
		panelBehea.add(lblExtra, gbc);
		gbc.gridx = 1;
		gbc.weightx = 1.0;
		panelBehea.add(txtExtra, gbc);
		setPanelBotoiakBehea(new JPanel(new GridLayout(1, 2, 10, 0)));
		btnGorde.setPreferredSize(new Dimension(0, 30));
		btnUtzi.setPreferredSize(new Dimension(0, 30));
		getPanelBotoiakBehea().add(btnGorde);
		getPanelBotoiakBehea().add(btnUtzi);
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		panelBehea.add(getPanelBotoiakBehea(), gbc);
		add(panelGoia, BorderLayout.NORTH);
		add(scroll, BorderLayout.CENTER);
		add(panelBehea, BorderLayout.SOUTH);
	}

	public JTable getTabla() {
		return taula;
	}

	public JPanel getPanelBotoiakBehea() {
		return panelBotoiakBehea;
	}

	public void setPanelBotoiakBehea(JPanel panelBotoiakBehea) {
		this.panelBotoiakBehea = panelBotoiakBehea;
	}
}