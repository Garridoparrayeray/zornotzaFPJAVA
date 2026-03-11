package controller;

import view.*;
import DAO.*;
import model.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Kontrolatzailea implements ActionListener {
    private LeihoNagusia ikuspegia;
    private FutbolistaDAO futbolistaDAO;
    private TaldeaDAO taldeaDAO;

    public Kontrolatzailea(LeihoNagusia ikuspegia) {
        this.ikuspegia = ikuspegia;
        this.futbolistaDAO = new FutbolistaDAO();
        this.taldeaDAO = new TaldeaDAO();

        this.ikuspegia.btnJokalariak.addActionListener(this);
        this.ikuspegia.btnTaldeak.addActionListener(this);
        this.ikuspegia.btnGehituJokalaria.addActionListener(this);
        this.ikuspegia.btnGehituTaldea.addActionListener(this);
        this.ikuspegia.btnBilatuJokalaria.addActionListener(this);
        this.ikuspegia.btnBilatuTaldea.addActionListener(this);
        this.ikuspegia.btnIrten.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == ikuspegia.btnJokalariak) {
            erakutsiJokalariak();
        } else if (source == ikuspegia.btnTaldeak) {
            erakutsiTaldeak();
        }

        else if (source == ikuspegia.btnGehituJokalaria) {
            gehituJokalariaPopup();
        }

        else if (source == ikuspegia.btnGehituTaldea) {
            gehituTaldeaPopup();
        }

        else if (source == ikuspegia.btnBilatuJokalaria) {
            bilatuJokalaria();
        } else if (source == ikuspegia.btnBilatuTaldea) {
            bilatuTaldea();
        }

        else if (source == ikuspegia.btnIrten) {
            System.exit(0);
        }
    }

//
//    private void erakutsiJokalariak() {
//        ArrayList<Futbolista> zerrenda = futbolistaDAO.getFutbolistak();
//        ikuspegia.testuEremua.setText("--- JOKALARI GUZTIAK ---");
//        for (int i = 0; i < zerrenda.size(); i++) {
//            ikuspegia.testuEremua.append(zerrenda.get(i).toString() + "\n");
//        }
//    }
//
//    private void erakutsiTaldeak() {
//        ArrayList<Taldea> zerrenda = taldeaDAO.getTaldeak();
//        ikuspegia.testuEremua.setText("--- TALDE GUZTIAK ---");
//        for (int i = 0; i < zerrenda.size(); i++) {
//            ikuspegia.testuEremua.append(zerrenda.get(i).toString() + "\n");
//        }
//    }

    private void gehituJokalariaPopup() {
        JTextField dni = new JTextField();
        JTextField izena = new JTextField();
        JTextField abizena = new JTextField();
        JTextField soldata = new JTextField();
        JTextField idTaldea = new JTextField();

        Object[] fields = {
            "DNI:", dni, "Izena:", izena, "Abizena:", abizena,
            "Soldata:", soldata, "Talde ID:", idTaldea
        };

        int aukera = JOptionPane.showConfirmDialog(ikuspegia, fields, "Jokalari Berria", JOptionPane.OK_CANCEL_OPTION);
        
        if (aukera == JOptionPane.OK_OPTION) {
            Futbolista f = new Futbolista(dni.getText(), izena.getText(), abizena.getText(), 
                                         Double.parseDouble(soldata.getText()), 
                                         Integer.parseInt(idTaldea.getText()));
            futbolistaDAO.addFutbolista(f);
            ikuspegia.testuEremua.setText("Jokalaria ondo gehitu da.");
        }
    }

    private void gehituTaldeaPopup() {
        JTextField id = new JTextField();
        JTextField izena = new JTextField();
        JTextField herria = new JTextField();

        Object[] fields = { "ID Taldea:", id, "Izena:", izena, "Herria:", herria };

        int aukera = JOptionPane.showConfirmDialog(ikuspegia, fields, "Talde Berria", JOptionPane.OK_CANCEL_OPTION);
        
        if (aukera == JOptionPane.OK_OPTION) {
            Taldea t = new Taldea(Integer.parseInt(id.getText()), izena.getText(), herria.getText());
            taldeaDAO.addTaldea(t);
            ikuspegia.testuEremua.setText("Taldea ondo gehitu da.");
        }
    }

//    private void bilatuJokalaria() {
//        String dni = JOptionPane.showInputDialog(ikuspegia, "Sartu bilatu nahi duzun Jokalariaren DNIa:");
//        if (dni != null) {
//            Futbolista f = futbolistaDAO.getFutbolistaByDni(dni);
//            if (f != null) {
//                ikuspegia.testuEremua.setText(f.toString());
//            } else {
//                ikuspegia.testuEremua.setText("Ez da jokalaria aurkitu.");
//            }
//        }
//    }

//    private void bilatuTaldea() {
//        String idStr = JOptionPane.showInputDialog(ikuspegia, "Sartu bilatu nahi duzun Taldearen IDa:");
//        if (idStr != null) {
//            Taldea t = taldeaDAO.getTaldeaById(Integer.parseInt(idStr));
//            if (t != null) {
//                ikuspegia.testuEremua.setText(t.toString());
//            } else {
//                ikuspegia.testuEremua.setText("Ez da taldea aurkitu.");
//            }
//        }
//    }
    private void erakutsiJokalariak() {
        ArrayList<Futbolista> zerrenda = futbolistaDAO.getFutbolistak();
        
        String[] columnNames = {"DNI", "Izena", "Abizena", "Soldata", "Talde ID"};
        ikuspegia.modelo.setColumnIdentifiers(columnNames);
        
        ikuspegia.modelo.setRowCount(0);
        
        
        for (Futbolista f : zerrenda) {
            Object[] fila = {f.getNan(), f.getIzena(), f.getAbizena(), f.getSoldata(), f.getIdTaldea()};
            ikuspegia.modelo.addRow(fila);
        }
    }

    private void erakutsiTaldeak() {
        ArrayList<Taldea> zerrenda = taldeaDAO.getTaldeak();
        
        String[] columnNames = {"ID", "Izena", "Herria"};
        ikuspegia.modelo.setColumnIdentifiers(columnNames);
        ikuspegia.modelo.setRowCount(0);
        
        for (Taldea t : zerrenda) {
            Object[] fila = {t.getIdTaldea(), t.getIzena(), t.getHerria()};
            ikuspegia.modelo.addRow(fila);
        }
    }

    private void bilatuJokalaria() {
        String dni = JOptionPane.showInputDialog(ikuspegia, "Sartu bilatu nahi duzun Jokalariaren DNIa:");
        if (dni != null) {
            Futbolista f = futbolistaDAO.getFutbolistaByDni(dni);
            
            String[] columnNames = {"DNI", "Izena", "Abizena", "Soldata", "Talde ID"};
            ikuspegia.modelo.setColumnIdentifiers(columnNames);
            ikuspegia.modelo.setRowCount(0);
            
            if (f != null) {
                Object[] fila = {f.getNan(), f.getIzena(), f.getAbizena(), f.getSoldata(), f.getIdTaldea()};
                ikuspegia.modelo.addRow(fila);
            } else {
                JOptionPane.showMessageDialog(ikuspegia, "Ez da jokalaria aurkitu.");
            }
        }
    }

    private void bilatuTaldea() {
        String idStr = JOptionPane.showInputDialog(ikuspegia, "Sartu bilatu nahi duzun Taldearen IDa:");
        if (idStr != null) {
            Taldea t = taldeaDAO.getTaldeaById(Integer.parseInt(idStr));
            
            String[] columnNames = {"ID", "Izena", "Herria"};
            ikuspegia.modelo.setColumnIdentifiers(columnNames);
            ikuspegia.modelo.setRowCount(0);
            
            if (t != null) {
                Object[] fila = {t.getIdTaldea(), t.getIzena(), t.getHerria()};
                ikuspegia.modelo.addRow(fila);
            } else {
                JOptionPane.showMessageDialog(ikuspegia, "Ez da taldea aurkitu.");
            }
        }
    }

}