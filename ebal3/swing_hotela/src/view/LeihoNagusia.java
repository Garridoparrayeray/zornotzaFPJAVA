package view;

import javax.swing.*;
import java.awt.*;

/**
 * Leiho nagusia - Bezeroak eta gelak kudeatzeko
 */
public class LeihoNagusia extends JFrame {

    public JButton btnBezeroaGehitu = new JButton("Bezeroa gehitu");
    public JButton btnBezeroaAldatu = new JButton("Bezeroa aldatu");
    public JButton btnBezeroaEzabatu = new JButton("Bezeroa ezabatu");
    public JButton btnBezeroakIkusi = new JButton("Bezeroak ikusi");

    public JButton btnGelaGehitu = new JButton("Gela gehitu");
    public JButton btnGelaAldatu = new JButton("Gela aldatu");
    public JButton btnGelaEzabatu = new JButton("Gela ezabatu");
    public JButton btnGelakIkusi = new JButton("Gelak ikusi");

    public JButton btnIrten = new JButton("Irten");

    public LeihoNagusia() {
        setTitle("Hotela - Menu Nagusia");
        setSize(450, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel panelBezeroak = new JPanel(new GridLayout(4, 1, 5, 5));
        panelBezeroak.setBorder(BorderFactory.createTitledBorder("Bezeroak"));
        panelBezeroak.add(btnBezeroaGehitu);
        panelBezeroak.add(btnBezeroaAldatu);
        panelBezeroak.add(btnBezeroaEzabatu);
        panelBezeroak.add(btnBezeroakIkusi);

        JPanel panelGelak = new JPanel(new GridLayout(4, 1, 5, 5));
        panelGelak.setBorder(BorderFactory.createTitledBorder("Gelak"));
        panelGelak.add(btnGelaGehitu);
        panelGelak.add(btnGelaAldatu);
        panelGelak.add(btnGelaEzabatu);
        panelGelak.add(btnGelakIkusi);

        JPanel panelErdia = new JPanel(new GridLayout(1, 2, 10, 10));
        panelErdia.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelErdia.add(panelBezeroak);
        panelErdia.add(panelGelak);

        JPanel panelBehean = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnIrten.setPreferredSize(new Dimension(120, 30));
        btnIrten.setBackground(new Color(255, 160, 122));
        btnIrten.setOpaque(true);
        panelBehean.add(btnIrten);

        add(panelErdia, BorderLayout.CENTER);
        add(panelBehean, BorderLayout.SOUTH);
    }
}
