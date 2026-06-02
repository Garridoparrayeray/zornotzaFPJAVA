package controller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JOptionPane;

import view.LeihoLogin;
import view.LeihoNagusia;
import controller.KontrolatzaileNagusia;
public class KontrolatzaileLogin{
	
	public static final File fitxategi = new File("./erabiltzaileak.txt");
	public KontrolatzaileLogin(LeihoLogin leihoa) {
		leihoa.btnIrten.addActionListener(e ->{
			System.exit(0);
		});
		leihoa.btnSartu.addActionListener(e -> {
			if (LoginKredentzialak(leihoa) == true) {
				LeihoNagusia leihoberria = new LeihoNagusia();
				new KontrolatzaileNagusia(leihoberria);
				leihoberria.setVisible(true);
				leihoa.setVisible(false);
			}
		});
		
	}
	public boolean LoginKredentzialak(LeihoLogin leihoa) {
		try(FileReader fr = new FileReader(fitxategi);BufferedReader rd = new BufferedReader(fr)){
			String lerroa = "";
			while ((lerroa = rd.readLine()) !=null) {
				String zatiak[] = lerroa.split(";");
				if(zatiak[0].equals(leihoa.txtIzena.getText()) && zatiak[1].equals(leihoa.txtPasahitza.getText())) {
					JOptionPane.showMessageDialog(leihoa, "Login zuzena");
					return true;
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(leihoa, "Login okerra");

		return false;
	}
	
}
