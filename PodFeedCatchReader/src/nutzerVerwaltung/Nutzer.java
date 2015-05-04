package nutzerVerwaltung;

public class Nutzer {
	
	private int nutzerID;
	private String name;
	private String passwort;
	private NutzerRolle rolle;
	
	public Nutzer(int id, String name, String passwort, NutzerRolle rolle){
		nutzerID = id;
		this.name = name;
		this.passwort = passwort;
		this.rolle = rolle;
	}

	public int getNutzerID() {
		return nutzerID;
	}

	public String getName() {
		return name;
	}

	public String getPasswort() {
		return passwort;
	}

	public NutzerRolle getRolle() {
		return rolle;
	}
	
	

}
