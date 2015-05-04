package nutzerVerwaltung;

public interface LoginSchnittstelle {
	
	boolean LogInVerifizieren(int nutzerID, String passwort);
	NutzerRolle RolleVonNutzerAusgeben(int nutzerID);
	int neuenNutzerAnlegen(String name, String passwort, NutzerRolle rolle);

}
