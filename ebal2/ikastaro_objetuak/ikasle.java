package ikastaro_objektuak;

import java.util.ArrayList;

public class Ikasle {
	String izena;
	int adina;
	ArrayList<Ikastaro>ikastaroLista;
	
	
	public Ikasle() {
		this.izena = "";
		this.adina = 0;
	}
	
	//kontruktor añadir ikasles
	public Ikasle(String izena, int adina) {
		this.izena = izena;
		this.adina = 0;
		this.ikastaroLista = new ArrayList<>();
	}
	

	//konstrujtor konpleto ikasles
	public Ikasle(String izena, int adina, ArrayList<Ikastaro> ikastaroLista) {
		this.izena = izena;
		this.adina = 0;
		this.ikastaroLista = new ArrayList<>();
	}
	
	/**
	 * @return the izena
	 */
	public String getIzena() {
		return izena;
	}

	/**
	 * @param izena the izena to set
	 */
	public void setIzena(String izena) {
		this.izena = izena;
	}

	/**
	 * @return the adina
	 */
	public int getAdina() {
		return adina;
	}

	/**
	 * @param adina the adina to set
	 */
	public void setAdina(int adina) {
		this.adina = adina;
	}

	/**
	 * @return the ikastaroLista
	 */
	public ArrayList<Ikastaro> getIkastaroLista() {
		return ikastaroLista;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Ikasle [izena=").append(izena);
		sb.append(", adina=").append(adina);

		if (ikastaroLista == null || ikastaroLista.isEmpty()) {
			sb.append("] Ez dago matrikulatuta inongo ikastarotan.");
		} else {
			sb.append("], Ikastaroak: [");
			for (int i = 0; i < ikastaroLista.size(); i++) {
				sb.append(ikastaroLista.get(i).getIkastaro());
				if (i < ikastaroLista.size() - 1) {
					sb.append(", ");
				}
			}
			sb.append("]");
		}
		
		return sb.toString();
	}
	/**
	 * @param ikastaroLista the ikastaroLista to set
	 */
	public void setIkastaroLista(ArrayList<Ikastaro> ikastaroLista) {
		this.ikastaroLista = ikastaroLista;
	}

	public void gehituIkastaroa(Ikastaro ikastaroa) {
		if(!ikastaroLista.contains(ikastaroa)) {
			ikastaroLista.add(ikastaroa);
		}
	}
	
}
