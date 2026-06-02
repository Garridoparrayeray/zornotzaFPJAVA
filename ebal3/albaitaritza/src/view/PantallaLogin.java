package view;

import javax.swing.*;
import java.awt.*;

public class PantallaLogin extends JFrame {

    public JLabel lblIzena = new JLabel("Erabiltzailea:");
    public JTextField txtIzena = new JTextField(15);

    public JLabel lblPasahitza = new JLabel("Pasahitza:");
    public JPasswordField txtPasahitza = new JPasswordField(15);

    public JButton btnSaioaHasi = new JButton("Saioa hasi");

    public PantallaLogin() {
        setTitle("Saioa hasi - Albaitaritza");
        setSize(420, 220);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel panelGoia = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0; panelGoia.add(lblIzena, gbc);
        gbc.gridx = 1; panelGoia.add(txtIzena, gbc);
        gbc.gridx = 0; gbc.gridy = 1; panelGoia.add(lblPasahitza, gbc);
        gbc.gridx = 1; panelGoia.add(txtPasahitza, gbc);

        btnSaioaHasi.setPreferredSize(new Dimension(200, 30));
        JPanel panelBehean = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBehean.add(btnSaioaHasi);

        add(panelGoia, BorderLayout.CENTER);
        add(panelBehean, BorderLayout.SOUTH);
    }
}
