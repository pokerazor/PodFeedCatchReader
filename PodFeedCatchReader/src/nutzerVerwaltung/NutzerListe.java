package nutzerVerwaltung;

import java.util.LinkedList;

public class NutzerListe {
	
	private LinkedList<Nutzer> nutzer;
	
	public NutzerListe(){
		nutzer = new LinkedList<Nutzer>();
	}
	
	public void setNutzer(Nutzer neuerNutzer){
		nutzer.add(neuerNutzer);
	}
	
	public LinkedList<Nutzer> getNutzer(){
		return nutzer;
	}

}
