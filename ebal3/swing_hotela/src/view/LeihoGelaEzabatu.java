package view;

import javax.swing.*;
import java.awt.*;

/**
 * Gela bat ezabatzeko leihoa
 */
public class LeihoGelaEzabatu extends JFrame {

    public JLabel lblId = new JLabel("Ezabatu nahi duzun gelaren ID:");
    public JTextField txtId = new JTextField(15);

    public JButton btnBilatu = new JButton("Bilatu");
    public JButton btnEzabatu = new JButton("Ezabatu");
    public JButton btnItzuli = new JButton("Itzuli");

    public JTextArea txtFeedback = new JTextArea(6, 30);

    public LeihoGelaEzabatu() {
        setTitle("Gela Ezabatu");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0; panel.add(lblId, gbc);
        gbc.gridx = 1; panel.add(txtId, gbc);

        JPanel panelBotoiak = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        Dimension btnSize = new Dimension(100, 25);
        btnBilatu.setPreferredSize(btnSize);
        btnEzabatu.setPreferredSize(btnSize);
        btnItzuli.setPreferredSize(btnSize);
        panelBotoiak.add(btnBilatu);
        panelBotoiak.add(btnEzabatu);
        panelBotoiak.add(btnItzuli);

        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 2;
        panel.add(panelBotoiak, gbc);

        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0; gbc.weighty = 1.0;
        txtFeedback.setEditable(false);
        JScrollPane scroll = new JScrollPane(txtFeedback);
        panel.add(scroll, gbc);

        add(panel);
    }
}
