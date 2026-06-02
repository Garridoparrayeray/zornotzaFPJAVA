package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Bezero guztiak ikusteko leihoa
 */
public class LeihoBezeroakIkusi extends JFrame {

    public DefaultTableModel dtm = new DefaultTableModel();
    public JTable taula = new JTable(dtm);

    public JButton btnEguneratu = new JButton("Eguneratu");
    public JButton btnItzuli = new JButton("Itzuli");

    public LeihoBezeroakIkusi() {
        setTitle("Bezero guztiak");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        dtm.addColumn("ID");
        dtm.addColumn("Izena");
        dtm.addColumn("Abizena");
        dtm.addColumn("DNI");
        dtm.addColumn("Telefonoa");

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
