package view;

import javax.swing.*;
import java.awt.*;

/**
 * Bezero bat aldatzeko leihoa
 */
public class LeihoBezeroaAldatu extends JFrame {

    public JLabel lblId = new JLabel("ID (aldatu nahi den bezeroa):");
    public JTextField txtId = new JTextField(15);

    public JLabel lblIzena = new JLabel("Izena:");
    public JTextField txtIzena = new JTextField(15);

    public JLabel lblAbizena = new JLabel("Abizena:");
    public JTextField txtAbizena = new JTextField(15);

    public JLabel lblDni = new JLabel("DNI:");
    public JTextField txtDni = new JTextField(15);

    public JLabel lblTelefonoa = new JLabel("Telefonoa:");
    public JTextField txtTelefonoa = new JTextField(15);

    public JButton btnBilatu = new JButton("Bilatu");
    public JButton btnAldatu = new JButton("Aldatu");
    public JButton btnItzuli = new JButton("Itzuli");

    public JTextArea txtFeedback = new JTextArea(6, 30);

    public LeihoBezeroaAldatu() {
        setTitle("Bezeroa Aldatu");
        setSize(400, 470);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0; panel.add(lblId, gbc);
        gbc.gridx = 1; panel.add(txtId, gbc);

        gbc.gridx = 0; gbc.gridy = 1; panel.add(lblIzena, gbc);
        gbc.gridx = 1; panel.add(txtIzena, gbc);

        gbc.gridx = 0; gbc.gridy = 2; panel.add(lblAbizena, gbc);
        gbc.gridx = 1; panel.add(txtAbizena, gbc);

        gbc.gridx = 0; gbc.gridy = 3; panel.add(lblDni, gbc);
        gbc.gridx = 1; panel.add(txtDni, gbc);

        gbc.gridx = 0; gbc.gridy = 4; panel.add(lblTelefonoa, gbc);
        gbc.gridx = 1; panel.add(txtTelefonoa, gbc);

        JPanel panelBotoiak = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        Dimension btnSize = new Dimension(100, 25);
        btnBilatu.setPreferredSize(btnSize);
        btnAldatu.setPreferredSize(btnSize);
        btnItzuli.setPreferredSize(btnSize);
        panelBotoiak.add(btnBilatu);
        panelBotoiak.add(btnAldatu);
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
