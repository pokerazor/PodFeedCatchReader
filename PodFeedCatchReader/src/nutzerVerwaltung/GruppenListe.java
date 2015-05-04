package nutzerVerwaltung;

import java.util.LinkedList;

public class GruppenListe {
	
	private LinkedList<Gruppe> gruppen;
	
	public GruppenListe(){
		gruppen = new LinkedList<Gruppe>();
	}
	
	public void setGruppe(Gruppe neueGruppe){
		gruppen.add(neueGruppe);
	}
	
	public LinkedList<Gruppe> getGruppen(){
		return gruppen;
	}

}
