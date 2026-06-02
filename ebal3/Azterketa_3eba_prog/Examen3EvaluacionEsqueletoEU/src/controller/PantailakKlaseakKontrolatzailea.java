package controller;

import view.PantailaKlaseak;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import dao.klaseakDAO;
import model.Klaseak;
import view.PantailaLogin;

public class PantailakKlaseakKontrolatzailea {
	klaseakDAO klasDAO = new klaseakDAO();
	DefaultTableModel dtm = new DefaultTableModel();
	private String modoa = null;
	private int fila = -1;
	private int idaukeratua = -1;
	public PantailakKlaseakKontrolatzailea(PantailaKlaseak leihoa) {
		klaseakKargatu(leihoa);
		leihoa.getBtnIrten().addActionListener(e -> {
			PantailaLogin leihoBerria = new PantailaLogin();
			new LoginKontrolatzailea(leihoBerria);
			leihoa.setVisible(false);
			leihoBerria.setVisible(true);
		});
		leihoa.getBtnSortu().addActionListener(e -> {
			leihoa.getPanelFormularioa().setVisible(true);
			modoa = "SORTU";

		});
		leihoa.getBtnGorde().addActionListener(e -> {
			if (leihoa.getPanelFormularioa().isVisible() == false) {
				JOptionPane.showMessageDialog(leihoa, "Sortu formularioa lehenengo");
				return;
			}
			if (leihoa.getTxtIzena().getText().isEmpty() || leihoa.getTxtInstruktorea().getText().isEmpty()
					|| leihoa.getTxtOrdutegia().getText().isEmpty()) {
				JOptionPane.showMessageDialog(leihoa, "Zutable guztiak bete lehenengo");
				return;
			}
			Klaseak k = new Klaseak(leihoa.getTxtIzena().getText(), leihoa.getTxtInstruktorea().getText(),
					leihoa.getTxtOrdutegia().getText());
			if ("SORTU".equals(modoa)) {
				klasDAO.setKlaseak(k);
			} else if ("EDITATU".equals(modoa)) {
				klasDAO.updateKlaseak(k, idaukeratua);
			}
			dtm.setRowCount(0);
			klaseakKargatu(leihoa);
		});
		leihoa.getBtnEditatu().addActionListener(e -> {
			modoa = "EDITATU";

			fila = leihoa.getTaula().getSelectedRow();
			if (fila == -1) {
				JOptionPane.showMessageDialog(leihoa, "Zutabea hautatu lehenengo");
			}
			idaukeratua = (int) dtm.getValueAt(fila, 0);
			leihoa.getTxtIzena().setText(String.valueOf(dtm.getValueAt(fila, 1)));
			leihoa.getTxtInstruktorea().setText(String.valueOf(dtm.getValueAt(fila, 2)));
			leihoa.getTxtOrdutegia().setText(String.valueOf(dtm.getValueAt(fila, 3)));
		});
		leihoa.getBtnUtzi().addActionListener(e -> {
			leihoa.getPanelFormularioa().setVisible(false);

		});
	}

	public void klaseakKargatu(PantailaKlaseak leihoa) {
		dtm = leihoa.getDtm();
		for (Klaseak k : klasDAO.getKlaseak()) {
			dtm.addRow(new Object[] { k.getIdKlasea(), k.getIzena(), k.getInstruktorea(), k.getOrdutegia() });
		}
	}

}
