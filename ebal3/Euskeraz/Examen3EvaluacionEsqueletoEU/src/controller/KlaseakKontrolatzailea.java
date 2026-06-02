package controller;

import javax.swing.JOptionPane;

import dao.KlaseakDAO;
import model.Erabiltzailea;
import model.Klasea;
import view.PantailaKlaseak;
import view.PantailaLogin;

public class KlaseakKontrolatzailea {
	KlaseakDAO kDAO = new KlaseakDAO();
	String MODOA = "";
	int id;
	public KlaseakKontrolatzailea(PantailaKlaseak leihoa) {
		getKlaseak(leihoa);
		
		leihoa.getBtnEditatu().addActionListener(e ->{
			MODOA = "editau";
			int fila = leihoa.getTaula().getSelectedRow();
			if (fila == -1) return;
			id= (int) leihoa.getTaula().getValueAt(fila, 0);

			leihoa.getTxtIzena().setText(leihoa.getDtm().getValueAt(fila, 1).toString());
			leihoa.getTxtInstruktorea().setText(leihoa.getDtm().getValueAt(fila, 2).toString());
			leihoa.getTxtOrdutegia().setText(leihoa.getDtm().getValueAt(fila, 3).toString());
		});
		leihoa.getBtnSortu().addActionListener(e ->{
			leihoa.getPanelFormularioa().setVisible(true);
			MODOA = "sortu";
		});
		leihoa.getBtnIrten().addActionListener(e ->{
			PantailaLogin leihoBerria = new PantailaLogin();
			new LoginKontrolatzailea(leihoBerria);
			leihoBerria.setVisible(true);
			leihoa.setVisible(false);
		});
		
		leihoa.getBtnGorde().addActionListener(e ->{
			if (leihoa.getTxtInstruktorea().getText().isEmpty() || leihoa.getTxtIzena().getText().isEmpty() || leihoa.getTxtOrdutegia().getText().isEmpty()) {
				JOptionPane.showMessageDialog(leihoa, "hutsune guztiak bete");
				return;
			}
			if(!(leihoa.getTxtOrdutegia().getText().matches("^\\d{2}:\\d{2}"))) {
				JOptionPane.showMessageDialog(leihoa, "ordutegia formatu egoki batean ipini");
				return;
			}
			if(MODOA.equals("sortu")) {
				Klasea k = new Klasea(leihoa.getTxtIzena().getText(),leihoa.getTxtInstruktorea().getText(), leihoa.getTxtOrdutegia().getText());
				if(kDAO.setKlasea(k) == true) {
					JOptionPane.showMessageDialog(leihoa, "Klasea Sortu da");
					getKlaseak(leihoa);

				}else {
					JOptionPane.showMessageDialog(leihoa, "Klasea ez da sortu");
				}
			}
			if(MODOA.equals("editau")) {
				Klasea k = new Klasea(id, leihoa.getTxtIzena().getText(),leihoa.getTxtInstruktorea().getText(), leihoa.getTxtOrdutegia().getText());
				if(kDAO.updateKlasea(k) == true) {
					JOptionPane.showMessageDialog(leihoa, "Klasea eguneratu da");
					getKlaseak(leihoa);

				}else {
					JOptionPane.showMessageDialog(leihoa, "Klasea ez da eguneratu");
				}
			}
			
			
			
			
		});
		leihoa.getBtnUtzi().addActionListener(e ->{
			leihoa.getPanelFormularioa().setVisible(false);
		});

	}
	public void getKlaseak(PantailaKlaseak leihoa) {
		leihoa.getDtm().setRowCount(0);
		for(Klasea k : kDAO.getKlaseak()) {
			leihoa.getDtm().addRow(new Object[] {k.getIdKlasea(), k.getIzena(), k.getInstruktorea(), k.getOrdutegia()});
		}
	}
}
