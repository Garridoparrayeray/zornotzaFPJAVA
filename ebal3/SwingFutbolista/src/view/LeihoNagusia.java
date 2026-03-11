package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

public class LeihoNagusia extends JFrame {
    // Botoiak bakarrik mantentzen ditugu
    public JButton btnJokalariak = new JButton("1 - Jokalariak ikusi");
    public JButton btnTaldeak = new JButton("2 - Taldeak ikusi");
    public JButton btnGehituJokalaria = new JButton("3 - Jokalaria gehitu");
    public JButton btnGehituTaldea = new JButton("4 - Taldea gehitu");
    public JButton btnBilatuJokalaria = new JButton("5 - Bilatu Jokalaria (DNI)");
    public JButton btnBilatuTaldea = new JButton("6 - Bilatu Taldea (ID)");
    public JButton btnIrten = new JButton("7 - IRTEERA");

    public JTextArea testuEremua = new JTextArea(15, 50);
    public JTable jt = new JTable();
    public DefaultTableModel modelo = new DefaultTableModel();
    
    public LeihoNagusia() {
        setTitle("Futbol Kudeaketa - MVC");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Botoien panela 
        JPanel pnlBotones = new JPanel(new GridLayout(7, 1, 5, 5));
        pnlBotones.add(btnJokalariak); pnlBotones.add(btnTaldeak);
        pnlBotones.add(btnGehituJokalaria); pnlBotones.add(btnGehituTaldea);
        pnlBotones.add(btnBilatuJokalaria); pnlBotones.add(btnBilatuTaldea);
        pnlBotones.add(btnIrten);
        jt.setModel(modelo);
        JScrollPane scrollPane = new JScrollPane(jt);
        add(scrollPane, BorderLayout.CENTER); 
        
        // Testu eremua 
//        testuEremua.setEditable(false);
        add(pnlBotones, BorderLayout.WEST);
//        add(new JScrollPane(testuEremua), BorderLayout.CENTER);

        setVisible(true);
    }
}