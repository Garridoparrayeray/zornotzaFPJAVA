package controller;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import DAO.jokalariakDAO;
import DAO.taldeakDAO;
import model.futbolaria;
import model.taldea;
import view.*;

public class Kontrolatzailea {
	public jokalariakDAO jokDAO = new jokalariakDAO();
	public taldeakDAO talDAO = new taldeakDAO();

	public Kontrolatzailea(LeihoNagusia leihoa) {
		leihoa.btnIrten.addActionListener(e -> {
			System.exit(0);
		});
		leihoa.btnJokalariak.addActionListener(e -> {
			leihoa.dtm1.setRowCount(0);
			for (futbolaria f : jokDAO.getFutbolaria()) {
					leihoa.dtm1.addRow(new Object[] { f.getDni(), f.getNombre(), f.getApellido(), f.getSalario(),
							f.getIdEquipo() });
			}
		});
		leihoa.btnTaldeak.addActionListener(e -> {
			leihoa.dtm2.setRowCount(0);
			for (taldea t : talDAO.getTaldeak()) {
				leihoa.dtm2.addRow(new Object[] { t.getIdEquipo(), t.getNombre(), t.getCiudad() });
			}
		});
		leihoa.btnJokalariakGehitu.addActionListener(e -> {
			LeihoJokalariGehitu leihoBerria = new LeihoJokalariGehitu(leihoa);
			
			new JokalariaGehituController(leihoBerria);
			
			leihoBerria.setVisible(true);
		});
		leihoa.btnTaldeakGehitu.addActionListener(e->{
			LeihoTaldeGehitu leihoBerria = new LeihoTaldeGehitu(leihoa);
			new TaldeGehituController(leihoBerria);
			leihoBerria.setVisible(true);
		});
		leihoa.btnJokalariBilatu.addActionListener(e->{
			LeihoJokalariBilatu leihoberria = new LeihoJokalariBilatu(leihoa);
			new LeihoJokalariBilatuFController(leihoberria);
			leihoberria.setVisible(true);
			
		});
		leihoa.btnTaldeBilatu.addActionListener(e->{
			LeihoTaldeBilatu leihoberria = new LeihoTaldeBilatu(leihoa);
			new TaldeBilatuController(leihoberria);
			leihoberria.setVisible(true);
		});
	}



}
