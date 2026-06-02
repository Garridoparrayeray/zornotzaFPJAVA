package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class LeihoBezeroakIkusi extends JFrame {

    // Bezeroak erakusteko
    public DefaultTableModel dtm = new DefaultTableModel();
    JTable taula = new JTable(dtm);
    public LeihoBezeroakIkusi() {
        setTitle("Bezero guztiak ikusi");
        setSize(700, 400);
        setLocationRelativeTo(null); // Leihoa pantailaren erdian
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        // Layout nagusia
        setLayout(new BorderLayout(10,10));

        // JTable scroll pane batean
        taula.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(taula);
        dtm.addColumn("id");
        dtm.addColumn("izena");
        dtm.addColumn("helbidea");
        dtm.addColumn("postakodea");
        dtm.addColumn("telefonoa");
        
        add(scroll, BorderLayout.CENTER);

        setVisible(true);
    }
}