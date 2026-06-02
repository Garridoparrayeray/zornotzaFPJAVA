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

public class LeihoTaldeGehitu extends JDialog {

    public JTextField txtIdEquipo = new JTextField();
    public JTextField txtNombre = new JTextField();
    public JTextField txtCiudad = new JTextField();
    
    public JButton btnGorde = new JButton("Gorde");
    public JButton btnUtzi = new JButton("Utzi");

    public LeihoTaldeGehitu(JFrame parent) {
        super(parent, "Talde Berria Gehitu", true);
        setSize(350, 200);
        setLayout(new BorderLayout());
        setLocationRelativeTo(parent);

        JPanel formPanela = new JPanel(new GridLayout(3, 2, 10, 10));
        formPanela.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        formPanela.add(new JLabel("Talde ID-a:"));
        formPanela.add(txtIdEquipo);
        formPanela.add(new JLabel("Izena (Nombre):"));
        formPanela.add(txtNombre);
        formPanela.add(new JLabel("Hiria (Ciudad):"));
        formPanela.add(txtCiudad);

        JPanel botoiPanela = new JPanel();
        botoiPanela.add(btnGorde);
        botoiPanela.add(btnUtzi);

        add(formPanela, BorderLayout.CENTER);
        add(botoiPanela, BorderLayout.SOUTH);
    }
}