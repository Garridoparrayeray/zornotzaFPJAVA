package view;

import javax.swing.*;
import java.awt.*;

public class PantailaLogin extends JFrame {

    private JTextField txtErabiltzailea;
    private JPasswordField txtPasahitza;
    private JButton btnSartu;

    public PantailaLogin() {

        setTitle("Saioa hasi - Gimnasioa");
        setSize(350, 220);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        initUI();
    }

    private void initUI() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10));

        // ================= ERABILTZAILEA =================
        JPanel userPanel = new JPanel(new BorderLayout());
        userPanel.add(new JLabel("Erabiltzailea:"), BorderLayout.NORTH);
        txtErabiltzailea = new JTextField();
        userPanel.add(txtErabiltzailea, BorderLayout.CENTER);

        // ================= PASAHITZA =================
        JPanel passPanel = new JPanel(new BorderLayout());
        passPanel.add(new JLabel("Pasahitza:"), BorderLayout.NORTH);
        txtPasahitza = new JPasswordField();
        passPanel.add(txtPasahitza, BorderLayout.CENTER);

        // ================= BOTOIA =================
        btnSartu = new JButton("Saioa hasi");

        // ================= GEHITU =================
        panel.add(userPanel);
        panel.add(passPanel);
        panel.add(new JLabel()); // tartea
        panel.add(btnSartu);

        add(panel);
    }

    // ================= GETTERS =================
    public JTextField getTxtErabiltzailea() {
        return txtErabiltzailea;
    }

    public JPasswordField getTxtPasahitza() {
        return txtPasahitza;
    }

    public JButton getBtnSartu() {
        return btnSartu;
    }
}
