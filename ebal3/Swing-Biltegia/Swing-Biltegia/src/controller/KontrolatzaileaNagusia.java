package controller;
import view.*;
public class KontrolatzaileaNagusia {

	public KontrolatzaileaNagusia(LeihoNagusia leihoa) {
		leihoa.btnIrten.addActionListener(e -> {
			System.exit(0);
		});
		
		
		leihoa.btnGehitu.addActionListener(e ->{
			LeihoBezeroaGehitu leihoBezGehitu = new LeihoBezeroaGehitu();
			LeihoBezeroaGehituController controller = new LeihoBezeroaGehituController(leihoBezGehitu);
			leihoa.setVisible(false);
			leihoBezGehitu.setVisible(true);
			
		});
		leihoa.btnAldatu.addActionListener(e -> {
			LeihoBezeroaAldatu LeihoBezAldatu = new LeihoBezeroaAldatu();
			LeihoBezAldatuController controller = new LeihoBezAldatuController(LeihoBezAldatu);
			leihoa.setVisible(false);
			LeihoBezAldatu.setVisible(true);
		});
		leihoa.btnEzabatu.addActionListener(e -> {
			LeihoBezeroaEzabatu LeihoBezEzaba= new LeihoBezeroaEzabatu();
			LeihoBezEzabatuController LehioBezEzabaController= new LeihoBezEzabatuController(LeihoBezEzaba);
			leihoa.setVisible(false);
			LeihoBezEzaba.setVisible(true);
		});
		leihoa.btnIkusi.addActionListener(e -> {
			new LeihoBezeroakIkusiController(new LeihoBezeroakIkusi());
			leihoa.setVisible(false);
			/* BESTE MODU BATERA */
		});
	}

}
