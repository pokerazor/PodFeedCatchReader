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

}
