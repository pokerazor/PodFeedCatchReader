package nutzerVerwaltung;

import java.util.LinkedList;

public class Verwaltung implements LoginSchnittstelle, ZugriffsSchnittstelle{

	NutzerListe nutzer;
	GruppenListe gruppen;
	
	public Verwaltung(NutzerListe nutzer, GruppenListe gruppen){
		this.nutzer = nutzer;
		this.gruppen = gruppen;
	}
	
	@Override
	public boolean erstelleGruppe(String name) {
		int id = gruppen.getGruppen().size()+1;
		Gruppe g = new Gruppe(id, name);
		gruppen.setGruppe(g);
		return true;
	}

	@Override
	public boolean weiseGruppeZu(int gruppenID, int nutzerID) {
		boolean gruppeExistiert = false;
		boolean nutzerExistiert = false;
		Gruppe g = null;
		Nutzer n = null;
		
		for(int i = 0; i < gruppen.getGruppen().size(); ++i){
			if(gruppen.getGruppen().get(i).getGruppenID() == gruppenID){
				g = gruppen.getGruppen().get(i);
				gruppeExistiert = true;
			}
		}
		
		for(int i = 0; i < nutzer.getNutzer().size(); ++i){
			if(nutzer.getNutzer().get(i).getNutzerID() == nutzerID){
				n = nutzer.getNutzer().get(i);
				nutzerExistiert = true;
			}
		}
		
		if(gruppeExistiert == false || nutzerExistiert == false){
			return false;
		}else{
			g.setNutzer(n);
			return true;
		}
	}

	@Override
	public boolean LogInVerifizieren(int nutzerID, String passwort) {
		boolean nutzerExistiert = false;
		Nutzer n = null;
		
		for(int i = 0; i < nutzer.getNutzer().size(); ++i){
			if(nutzer.getNutzer().get(i).getNutzerID() == nutzerID){
				n = nutzer.getNutzer().get(i);
				nutzerExistiert = true;
			}
		}
		
		if(nutzerExistiert == false){
			return false;
		}else{
			if(n.getPasswort() == passwort){
				return true;
			}else{
				return false;
			}
		}
	}

	@Override
	public NutzerRolle RolleVonNutzerAusgeben(int nutzerID) {
		boolean nutzerExistiert = false;
		Nutzer n = null;
		
		for(int i = 0; i < nutzer.getNutzer().size(); ++i){
			if(nutzer.getNutzer().get(i).getNutzerID() == nutzerID){
				n = nutzer.getNutzer().get(i);
				nutzerExistiert = true;
			}
		}
		
		if(nutzerExistiert == false){
			return null;
		}else{
			return n.getRolle();
		}
	}

	@Override
	public int neuenNutzerAnlegen(String name, String passwort,NutzerRolle rolle) {
		int id = nutzer.getNutzer().size()+1; 
		Nutzer neu = new Nutzer(id, name, passwort, rolle);
		nutzer.setNutzer(neu);
		return id;
	}

}
