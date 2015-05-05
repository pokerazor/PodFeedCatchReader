package nutzerVerwaltung;

public interface LoginSchnittstelle {
	
	boolean logInVerifizieren(int nutzerID, String passwort);
	NutzerRolle rolleVonNutzerAusgeben(int nutzerID);
	int neuenNutzerAnlegen(String name, String passwort, NutzerRolle rolle);
	Nutzer getAktuellerNutzer();

}
