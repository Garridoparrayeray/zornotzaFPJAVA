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

public class LeihoJokalariBilatu extends JDialog {

    public JTextField txtBilatuDni = new JTextField(10);
    public JButton btnBilatu = new JButton("Bilatu");
    
    // Campos para mostrar resultados (no editables)
    public JTextField lblNombre = new JTextField();
    public JTextField lblApellido = new JTextField();
    public JTextField lblSalario = new JTextField();
    public JTextField lblIdEquipo = new JTextField();

    public LeihoJokalariBilatu(JFrame parent) {
        super(parent, "Jokalaria Bilatu", true);
        setSize(350, 250);
        setLayout(new BorderLayout());
        setLocationRelativeTo(parent);

        // Panel de búsqueda (Arriba)
        JPanel bilaketaPanela = new JPanel();
        bilaketaPanela.add(new JLabel("Sartu DNI:"));
        bilaketaPanela.add(txtBilatuDni);
        bilaketaPanela.add(btnBilatu);

        // Panel de resultados (Centro)
        JPanel emaitzaPanela = new JPanel(new GridLayout(4, 2, 10, 10));
        emaitzaPanela.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        emaitzaPanela.add(new JLabel("Izena:"));
        emaitzaPanela.add(lblNombre);
        emaitzaPanela.add(new JLabel("Abizena:"));
        emaitzaPanela.add(lblApellido);
        emaitzaPanela.add(new JLabel("Soldata:"));
        emaitzaPanela.add(lblSalario);
        emaitzaPanela.add(new JLabel("Taldea:"));
        emaitzaPanela.add(lblIdEquipo);

        // Hacer que los campos de resultado no sean editables
        lblNombre.setEditable(false);
        lblApellido.setEditable(false);
        lblSalario.setEditable(false);
        lblIdEquipo.setEditable(false);

        add(bilaketaPanela, BorderLayout.NORTH);
        add(emaitzaPanela, BorderLayout.CENTER);
    }
}