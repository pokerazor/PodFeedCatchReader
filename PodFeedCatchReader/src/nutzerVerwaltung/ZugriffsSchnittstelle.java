package nutzerVerwaltung;

public interface ZugriffsSchnittstelle {

	boolean erstelleGruppe(String name);
	boolean weiseGruppeZu(int gruppenID, int nutzerID);
}
