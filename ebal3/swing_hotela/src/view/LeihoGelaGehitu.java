package view;

import javax.swing.*;
import java.awt.*;

/**
 * Gela bat gehitzeko leihoa (herentzia: ARRUNTA / SUITE)
 */
public class LeihoGelaGehitu extends JFrame {

    public JLabel lblId = new JLabel("ID:");
    public JTextField txtId = new JTextField(15);

    public JLabel lblSolairua = new JLabel("Solairua:");
    public JTextField txtSolairua = new JTextField(15);

    public JLabel lblPrezioa = new JLabel("Prezioa:");
    public JTextField txtPrezioa = new JTextField(15);

    public JLabel lblMota = new JLabel("Mota:");
    public JComboBox<String> cmbMota = new JComboBox<>(new String[]{"ARRUNTA", "SUITE"});

    public JLabel lblExtra = new JLabel("Extra:");
    public JTextField txtExtra = new JTextField(15);

    public JButton btnGehitu = new JButton("Gehitu");
    public JButton btnItzuli = new JButton("Itzuli");

    public JTextArea txtFeedback = new JTextArea(6, 30);

    public LeihoGelaGehitu() {
        setTitle("Gela Gehitu");
        setSize(400, 470);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0; panel.add(lblId, gbc);
        gbc.gridx = 1; panel.add(txtId, gbc);

        gbc.gridx = 0; gbc.gridy = 1; panel.add(lblSolairua, gbc);
        gbc.gridx = 1; panel.add(txtSolairua, gbc);

        gbc.gridx = 0; gbc.gridy = 2; panel.add(lblPrezioa, gbc);
        gbc.gridx = 1; panel.add(txtPrezioa, gbc);

        gbc.gridx = 0; gbc.gridy = 3; panel.add(lblMota, gbc);
        gbc.gridx = 1; panel.add(cmbMota, gbc);

        gbc.gridx = 0; gbc.gridy = 4; panel.add(lblExtra, gbc);
        gbc.gridx = 1; panel.add(txtExtra, gbc);

        JPanel panelBotoiak = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        Dimension btnSize = new Dimension(120, 25);
        btnGehitu.setPreferredSize(btnSize);
        btnItzuli.setPreferredSize(btnSize);
        panelBotoiak.add(btnGehitu);
        panelBotoiak.add(btnItzuli);

        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2;
        panel.add(panelBotoiak, gbc);

        gbc.gridx = 0; gbc.gridy = 6; gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0; gbc.weighty = 1.0;
        txtFeedback.setEditable(false);
        JScrollPane scroll = new JScrollPane(txtFeedback);
        panel.add(scroll, gbc);

        add(panel);
    }
}
