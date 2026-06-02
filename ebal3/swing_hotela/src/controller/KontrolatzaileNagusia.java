package controller;
import view.*;

public class KontrolatzaileNagusia {
	public KontrolatzaileNagusia(LeihoNagusia leihoa) {
		leihoa.btnIrten.addActionListener(e ->{
			LeihoLogin login = new LeihoLogin();
			new KontrolatzaileLogin(login);
			login.setVisible(true);
			leihoa.setVisible(false);
			
		});
		
		leihoa.btnBezeroaAldatu.addActionListener(e ->{
			
		});
		leihoa.btnBezeroaEzabatu.addActionListener(e ->{
			LeihoBezeroaEzabatu leihoberria = new LeihoBezeroaEzabatu();
			new KontrolatzaileBezKendu(leihoberria);
			leihoberria.setVisible(true);
			leihoa.setVisible(false);
		});
		leihoa.btnBezeroaGehitu.addActionListener(e ->{
			LeihoBezeroaGehitu leihoberria = new LeihoBezeroaGehitu();
			new KontrolatzaileBezGehitu(leihoberria);
			leihoberria.setVisible(true);
			leihoa.setVisible(false);
		});
		leihoa.btnBezeroakIkusi.addActionListener(e ->{
			LeihoBezeroakIkusi leihoberria = new LeihoBezeroakIkusi();
			new KontrolatzaileBezIkusi(leihoberria);
			leihoberria.setVisible(true);
			leihoa.setVisible(false);
		});
		
		
		
		leihoa.btnGelaAldatu.addActionListener(e ->{
			
		});
		leihoa.btnGelaEzabatu.addActionListener(e ->{
			
		});
		leihoa.btnGelakIkusi.addActionListener(e ->{
			
		});
		leihoa.btnGelaGehitu.addActionListener(e ->{
			
		});
	}
	
}
