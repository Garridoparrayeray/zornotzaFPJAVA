package ikastaro_objektuak;

import java.util.ArrayList;

public class Ikastaro {
	String ikastaro;
	String ikastaro_deskribapena;
	String irakaslea;
	ArrayList <Ikasle> IkasleLista;
	
	public Ikastaro() {
		this.ikastaro = "";
		this.ikastaro_deskribapena = "";
		this.irakaslea = "";
		this.IkasleLista = null;
	}
	public Ikastaro(String ikastaro, String ikastaro_deskribapena, String irakaslea, ArrayList<Ikasle> ikasleLista) {
		this.ikastaro = ikastaro;
		this.ikastaro_deskribapena = ikastaro_deskribapena;
		this.irakaslea = irakaslea;
		this.IkasleLista = new ArrayList<>();
	}
	public Ikastaro(String ikastaro, String ikastaro_deskribapena, String irakaslea) {
		this.ikastaro = ikastaro;
		this.ikastaro_deskribapena = ikastaro_deskribapena;
		this.irakaslea = irakaslea;
		this.IkasleLista = new ArrayList<>();
	}

	/**
	 * @return the ikastaro
	 */
	public String getIkastaro() {
		return ikastaro;
	}
	/**
	 * @param ikastaro the ikastaro to set
	 */
	public void setIkastaro(String ikastaro) {
		this.ikastaro = ikastaro;
	}
	/**
	 * @return the ikastaro_deskribapena
	 */
	public String getIkastaro_deskribapena() {
		return ikastaro_deskribapena;
	}
	/**
	 * @param ikastaro_deskribapena the ikastaro_deskribapena to set
	 */
	public void setIkastaro_deskribapena(String ikastaro_deskribapena) {
		this.ikastaro_deskribapena = ikastaro_deskribapena;
	}
	/**
	 * @return the irakaslea
	 */
	public String getIrakaslea() {
		return irakaslea;
	}
	/**
	 * @param irakaslea the irakaslea to set
	 */
	public void setIrakaslea(String irakaslea) {
		this.irakaslea = irakaslea;
	}
	/**
	 * @return the ikasleLista
	 */
	public ArrayList<Ikasle> getIkasleLista() {
		return IkasleLista;
	}
	/**
	 * @param ikasleLista the ikasleLista to set
	 */
	public void setIkasleLista(ArrayList<Ikasle> ikasleLista) {
		IkasleLista = ikasleLista;
	}
	
	
	@Override
	public String toString() {	
		
		StringBuilder sb = new StringBuilder();
		sb.append("Ikastaro [ikastaro=").append(ikastaro);
		sb.append(", ikastaro_deskribapena=").append(ikastaro_deskribapena);
		sb.append(", irakaslea=").append(irakaslea);
		
		if(IkasleLista == null || IkasleLista.isEmpty()) {
			sb.append("] Ez dauka ikaslerik.");
		} else {
			// *** FIX: Manually iterate and append ONLY the name (izena) ***
			sb.append("], Ikasleak: [");
			for (int i = 0; i < IkasleLista.size(); i++) {
				sb.append(IkasleLista.get(i).getIzena()); // Append only the name
				if (i < IkasleLista.size() - 1) {
					sb.append(", ");
				}
			}
			sb.append("]"); // Close the Ikasleak bracket
		}
		
		return sb.toString();
		
	}

	public void IkasleaGehitu(Ikasle ikaslea) {
			this.IkasleLista.add(ikaslea);
	}
}