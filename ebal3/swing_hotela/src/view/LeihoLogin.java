package view;

import javax.swing.*;
import java.awt.*;

/**
 * Login leihoa
 */
public class LeihoLogin extends JFrame {

    public JLabel lblIzena = new JLabel("Erabiltzailea:");
    public JTextField txtIzena = new JTextField(15);

    public JLabel lblPasahitza = new JLabel("Pasahitza:");
    public JPasswordField txtPasahitza = new JPasswordField(15);

    public JButton btnSartu = new JButton("Sartu");
    public JButton btnIrten = new JButton("Irten");

    public LeihoLogin() {
        setTitle("Login");
        setSize(350, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0; panel.add(lblIzena, gbc);
        gbc.gridx = 1; panel.add(txtIzena, gbc);

        gbc.gridx = 0; gbc.gridy = 1; panel.add(lblPasahitza, gbc);
        gbc.gridx = 1; panel.add(txtPasahitza, gbc);

        JPanel panelBotoiak = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        Dimension btnSize = new Dimension(100, 25);
        btnSartu.setPreferredSize(btnSize);
        btnIrten.setPreferredSize(btnSize);
        panelBotoiak.add(btnSartu);
        panelBotoiak.add(btnIrten);

        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        panel.add(panelBotoiak, gbc);

        add(panel);
    }
}
