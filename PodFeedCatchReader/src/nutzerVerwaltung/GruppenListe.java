package nutzerVerwaltung;

import java.util.Vector;

public class GruppenListe {
	
	private Vector<Gruppe> gruppen;
	
	public GruppenListe(){
		gruppen = new Vector<Gruppe>();
	}
	
	public void setGruppe(Gruppe neueGruppe){
		gruppen.add(neueGruppe);
	}
	
	public Vector<Gruppe> getGruppen(){
		return gruppen;
	}
	
	public Vector<Gruppe> gibAlleGruppenZuNutzer(int nutzerID) {
		Vector<Gruppe> gruppenEnthalten = new Vector<Gruppe>();
		for (Gruppe g : gruppen) {
			for (Nutzer n : g.nutzer) {
				if (n.getNutzerID() == nutzerID) {
					gruppenEnthalten.add(g);
				}
			}
		}
		return gruppenEnthalten;
	}

}
