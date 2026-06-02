package view;

import javax.swing.*;
import java.awt.*;

/**
 * Leiho nagusia - Bezeroak kudeatzeko
 */
public class LeihoNagusia extends JFrame {

    // Botoiak funtzionalitate bakoitzeko
    public JButton btnGehitu = new JButton("1 - Gehitu bezeroa");
    public JButton btnAldatu = new JButton("2 - Aldatu bezeroa");
    public JButton btnEzabatu = new JButton("3 - Ezabatu bezeroa");
    public JButton btnIkusi = new JButton("4 - Bezero guztiak ikusi");
    public JButton btnIrten = new JButton("5 - Irten");

    public LeihoNagusia() {
        setTitle("BezKud");
        setSize(210, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Panel botoiak
        JPanel panelBotoiak = new JPanel(new GridLayout(5, 1, 10, 10));
        JButton[] botoiak = {btnGehitu, btnAldatu, btnEzabatu, btnIkusi, btnIrten};
        Dimension buttonSize = new Dimension(180, 30);
        Color[] koloreak = {
                new Color(135,206,250),
                new Color(255,182,193),
                new Color(144,238,144),
                new Color(255,255,102),
                new Color(255,160,122)
        };

        for(int i=0;i<botoiak.length;i++){
            JButton b = botoiak[i];
            b.setPreferredSize(buttonSize);
            b.setBackground(koloreak[i]);
            b.setOpaque(true);
            b.setBorderPainted(true);
            panelBotoiak.add(b);
        }

        // Zentratu panel botoiak
        JPanel panelEskura = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelEskura.add(panelBotoiak);
        add(panelEskura, BorderLayout.WEST);

        setVisible(true);
    }
}