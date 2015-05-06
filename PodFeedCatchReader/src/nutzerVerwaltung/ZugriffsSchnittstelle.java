package nutzerVerwaltung;

import java.util.Vector;

public interface ZugriffsSchnittstelle {

	boolean erstelleGruppe(String name);
	boolean weiseGruppeZu(int gruppenID, int nutzerID);
	Vector <Gruppe> gibAlleGruppen();
	Vector <Nutzer> gibAlleNutzer();
}
