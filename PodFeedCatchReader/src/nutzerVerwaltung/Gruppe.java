package nutzerVerwaltung;

import java.util.Vector;

public class Gruppe {

	int gruppenID;
	String name;
	Vector<Nutzer> nutzer;
	
	public Gruppe(int id, String name){
		gruppenID = id;
		this.name = name;
		nutzer = new Vector<Nutzer>();
	}

	public Vector<Nutzer> getNutzer() {
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
