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

public class LeihoJokalariGehitu extends JDialog {

    public JTextField txtDni = new JTextField();
    public JTextField txtNombre = new JTextField();
    public JTextField txtApellido = new JTextField();
    public JTextField txtSalario = new JTextField();
    public JTextField txtIdEquipo = new JTextField();
    
    public JButton btnGorde = new JButton("Gorde");
    public JButton btnUtzi = new JButton("Utzi");

    public LeihoJokalariGehitu(JFrame parent) {
        super(parent, "Jokalari Berria Gehitu", true); // 'true' hace que sea modal
        setSize(350, 250);
        setLayout(new BorderLayout());
        setLocationRelativeTo(parent);

        // Panel de formulario
        JPanel formPanela = new JPanel(new GridLayout(5, 2, 10, 10));
        formPanela.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        formPanela.add(new JLabel("DNI:"));
        formPanela.add(txtDni);
        formPanela.add(new JLabel("Izena (Nombre):"));
        formPanela.add(txtNombre);
        formPanela.add(new JLabel("Abizena (Apellido):"));
        formPanela.add(txtApellido);
        formPanela.add(new JLabel("Soldata (Salario):"));
        formPanela.add(txtSalario);
        formPanela.add(new JLabel("Talde ID-a:"));
        formPanela.add(txtIdEquipo);

        // Panel de botones
        JPanel botoiPanela = new JPanel();
        botoiPanela.add(btnGorde);
        botoiPanela.add(btnUtzi);

        add(formPanela, BorderLayout.CENTER);
        add(botoiPanela, BorderLayout.SOUTH);
    }
}