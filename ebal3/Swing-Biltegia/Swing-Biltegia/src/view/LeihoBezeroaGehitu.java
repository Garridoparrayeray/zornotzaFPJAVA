package view;

import javax.swing.*;
import java.awt.*;

/**
 * Bezeroa gehitzeko leihoa
 */
public class LeihoBezeroaGehitu extends JFrame {

    // Etiketak
    public JLabel lblId = new JLabel("ID:");
    public JLabel lblIzena = new JLabel("Izena:");
    public JLabel lblHelbidea = new JLabel("Helbidea:");
    public JLabel lblPostaKodea = new JLabel("Posta kodea:");
    public JLabel lblTelefonoa = new JLabel("Telefonoa:");

    // TextField
    public JTextField txtId = new JTextField(15);
    public JTextField txtIzena = new JTextField(15);
    public JTextField txtHelbidea = new JTextField(15);
    public JTextField txtPostaKodea = new JTextField(15);
    public JTextField txtTelefonoa = new JTextField(15);

    // Botoiak
    public JButton btnGehitu = new JButton("Gehitu");
    public JButton btnItzuli = new JButton("Itzuli");

    // Feedback
    public JTextArea txtFeedback = new JTextArea(8,30);

    public LeihoBezeroaGehitu(){
        setTitle("Bezeroa Gehitu");
        setSize(400,450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Etiketak + TextField
        gbc.gridx=0; gbc.gridy=0; panel.add(lblId,gbc);
        gbc.gridx=1; panel.add(txtId,gbc);

        gbc.gridx=0; gbc.gridy=1; panel.add(lblIzena,gbc);
        gbc.gridx=1; panel.add(txtIzena,gbc);

        gbc.gridx=0; gbc.gridy=2; panel.add(lblHelbidea,gbc);
        gbc.gridx=1; panel.add(txtHelbidea,gbc);

        gbc.gridx=0; gbc.gridy=3; panel.add(lblPostaKodea,gbc);
        gbc.gridx=1; panel.add(txtPostaKodea,gbc);

        gbc.gridx=0; gbc.gridy=4; panel.add(lblTelefonoa,gbc);
        gbc.gridx=1; panel.add(txtTelefonoa,gbc);

        // Botoiak
        JPanel panelBotoiak = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
        Dimension btnSize = new Dimension(120,25);
        btnGehitu.setPreferredSize(btnSize);
        btnItzuli.setPreferredSize(btnSize);
        panelBotoiak.add(btnGehitu);
        panelBotoiak.add(btnItzuli);
        gbc.gridx=0; gbc.gridy=5; gbc.gridwidth=2; panel.add(panelBotoiak,gbc);

        // Feedback JTextArea
        gbc.gridx=0; gbc.gridy=6; gbc.gridwidth=2; gbc.fill=GridBagConstraints.BOTH;
        gbc.weightx=1.0; gbc.weighty=1.0;
        JScrollPane scroll = new JScrollPane(txtFeedback);
        panel.add(scroll,gbc);

        add(panel);
        setVisible(true);
    }
}