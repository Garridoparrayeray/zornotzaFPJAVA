package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LeihoTaldeBilatu extends JDialog {

    public JTextField txtBilatuId = new JTextField(10);
    public JButton btnBilatu = new JButton("Bilatu");
    
    public JTextField lblNombre = new JTextField();
    public JTextField lblCiudad = new JTextField();

    public LeihoTaldeBilatu(JFrame parent) {
        super(parent, "Taldea Bilatu", true);
        setSize(350, 200);
        setLayout(new BorderLayout());
        setLocationRelativeTo(parent);

        JPanel bilaketaPanela = new JPanel();
        bilaketaPanela.add(new JLabel("Sartu Talde ID-a:"));
        bilaketaPanela.add(txtBilatuId);
        bilaketaPanela.add(btnBilatu);

        JPanel emaitzaPanela = new JPanel(new GridLayout(2, 2, 10, 10));
        emaitzaPanela.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        emaitzaPanela.add(new JLabel("Izena:"));
        emaitzaPanela.add(lblNombre);
        emaitzaPanela.add(new JLabel("Hiria:"));
        emaitzaPanela.add(lblCiudad);

        lblNombre.setEditable(false);
        lblCiudad.setEditable(false);

        add(bilaketaPanela, BorderLayout.NORTH);
        add(emaitzaPanela, BorderLayout.CENTER);
    }
}