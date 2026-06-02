package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class LeihoNagusia extends JFrame {

    // Botoi guztiak definitu
    public JButton btnJokalariak = new JButton("1 - Jokalariak ikusi");
    public JButton btnTaldeak = new JButton("2 - Taldeak ikusi");
    public JButton btnJokalariakGehitu = new JButton("3 - Jokalari bat gehitu");
    public JButton btnTaldeakGehitu = new JButton("4 - Talde bat gehitu");
    public JButton btnJokalariBilatu = new JButton("5 - Jokalaria erakutsi (ID)");
    public JButton btnTaldeBilatu = new JButton("6 - Taldea ikusi (ID)");
    public JButton btnIrten = new JButton("7 - IRTEERA");
    
    // Taulen modeloak eta osagaiak
    public DefaultTableModel dtm1 = new DefaultTableModel();
    public DefaultTableModel dtm2 = new DefaultTableModel();
    public JTable taulaFUT = new JTable(dtm1);
    public JTable taulaTal = new JTable(dtm2);

    public LeihoNagusia() {
        setTitle("Futbol Kudeaketa - MVC");
        setSize(950, 600); // Leihoa zabaldu dugu dena ondo sartzeko
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // 1. MENU PANELA (Ezkerraldean egongo da)
        // GridLayout(7, 1) erabiltzen dugu: 7 errenkada eta zutabe 1 botoiak zutabean jartzeko
        JPanel menuPanela = new JPanel(new GridLayout(7, 1, 10, 15));
        menuPanela.setBorder(new EmptyBorder(10, 10, 10, 10));
        menuPanela.setPreferredSize(new Dimension(250, 0)); // Menuaren zabalera finkatu
        
        menuPanela.add(btnJokalariak);
        menuPanela.add(btnTaldeak);
        menuPanela.add(btnJokalariakGehitu);
        menuPanela.add(btnTaldeakGehitu);
        menuPanela.add(btnJokalariBilatu);
        menuPanela.add(btnTaldeBilatu);
        menuPanela.add(btnIrten);

        // 2. TAULEN ZUTABEAK PRESTATU
        dtm1.addColumn("dni");
        dtm1.addColumn("nombre");
        dtm1.addColumn("apellido");
        dtm1.addColumn("salario");
        dtm1.addColumn("idEquipo");
        
        dtm2.addColumn("idEquipo");
        dtm2.addColumn("nombre");
        dtm2.addColumn("ciudad");

        // 3. TAULEN PANELA (Erdigunean egongo da)
        // GridLayout(2, 1) erabiltzen dugu taula bat bestearen azpian jartzeko
        JPanel taulaPanela = new JPanel();
        taulaPanela.setLayout(new GridLayout(2, 1, 10, 10)); 
        taulaPanela.setBorder(new EmptyBorder(10, 0, 10, 10)); // Margenak egokitu
        
        taulaPanela.add(new JScrollPane(taulaFUT));
        taulaPanela.add(new JScrollPane(taulaTal));

        // 4. PANELAK LEIHOKO BORDERLAYOUT-EAN TXERTATU
        add(menuPanela, BorderLayout.WEST);   // Menua ezkerrera
        add(taulaPanela, BorderLayout.CENTER); // Taulak erdialdera (gainontzeko espazio guztia hartuko dute)

        // Leihoa pantailaren erdian agertzeko
        setLocationRelativeTo(null); 
        setVisible(true);
    }
}