package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Gela guztiak ikusteko leihoa
 */
public class LeihoGelakIkusi extends JFrame {

    public DefaultTableModel dtm = new DefaultTableModel();
    public JTable taula = new JTable(dtm);

    public JButton btnEguneratu = new JButton("Eguneratu");
    public JButton btnItzuli = new JButton("Itzuli");

    public LeihoGelakIkusi() {
        setTitle("Gela guztiak");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        dtm.addColumn("ID");
        dtm.addColumn("Solairua");
        dtm.addColumn("Prezioa");
        dtm.addColumn("Mota");
        dtm.addColumn("Extra");

        taula.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(taula);

        JPanel panelBotoiak = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        Dimension btnSize = new Dimension(120, 25);
        btnEguneratu.setPreferredSize(btnSize);
        btnItzuli.setPreferredSize(btnSize);
        panelBotoiak.add(btnEguneratu);
        panelBotoiak.add(btnItzuli);

        add(scroll, BorderLayout.CENTER);
        add(panelBotoiak, BorderLayout.SOUTH);
    }
}
