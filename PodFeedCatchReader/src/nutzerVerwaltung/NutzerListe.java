package nutzerVerwaltung;

import java.util.Vector;

public class NutzerListe {
	
	private Vector<Nutzer> nutzer;
	
	public NutzerListe(){
		nutzer = new Vector<Nutzer>();
	}
	
	public void setNutzer(Nutzer neuerNutzer){
		nutzer.add(neuerNutzer);
	}
	
	public Vector<Nutzer> getNutzer(){
		return nutzer;
	}

}
