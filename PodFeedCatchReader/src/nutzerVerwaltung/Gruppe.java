package nutzerVerwaltung;

import java.util.LinkedList;

public class Gruppe {

	int gruppenID;
	String name;
	LinkedList<Nutzer> nutzer;
	
	public Gruppe(int id, String name){
		gruppenID = id;
		this.name = name;
		nutzer = new LinkedList<Nutzer>();
	}

	public LinkedList<Nutzer> getNutzer() {
		return nutzer;
	}

	public void setNutzer(Nutzer neuerNutzer) {
		nutzer.add(neuerNutzer);
	}

	public int getGruppenID() {
		return gruppenID;
	}

	public String getName() {
		return name;
	}
	
	
	
}
