/**
 * 
 */
package konfiguration;

import itemSpeicher.ChannelVerzeichnis;
import itemSpeicher.ChannelVerzeichnisURL;
import itemSpeicher.Konsument;
import itemSpeicher.KonsumentenSchnittstelle;
import itemSpeicher.Produzent;
import itemSpeicher.ProduzentenSchnittstelle;
import gui.LicenseKeyInput;
import gui.MainWindow;

import javax.swing.JDialog;

import nutzerVerwaltung.GruppenListe;
import nutzerVerwaltung.LoginSchnittstelle;
import nutzerVerwaltung.NutzerListe;
import nutzerVerwaltung.Verwaltung;
import nutzerVerwaltung.ZugriffsSchnittstelle;

/**
 * @author Hanno - Felix Wagner
 *
 */
public class Konfiguration {
	public static Integer LICENSE_STATE_PRIVATE=1;
	public static Integer LICENSE_STATE_EDUCATION=2;
	public static Integer LICENSE_STATE_BUSINESS=3;
	public static Integer LICENSE_STATE_INVALID=-1;
	
	public static String LICENSE_KEY_PRIVATE="Privat";
	public static String LICENSE_KEY_EDUCATION="Uni DuE";
	public static String LICENSE_KEY_BUSINESS="ACME Inc.";
	
	private Integer currentLicenseState = null;
	private LicenseKeyInput requestWindow;
	
	public Konfiguration() {
		this.getLicenseState();
	}

	public Integer getLicenseState(){
		if (currentLicenseState==null){
			requestLicenseState();
		}
		return currentLicenseState; 
	}

	public boolean setCurrentLicenseState(Integer currentLicenseState) {
		this.currentLicenseState = currentLicenseState;
		System.out.println(currentLicenseState.intValue());
		
		if (currentLicenseState.intValue() != LICENSE_STATE_INVALID.intValue()) {
			showMainWindows(this.currentLicenseState);
			return true;
		}
		return false;
		
	}

	private void requestLicenseState() {
		this.requestWindow=new LicenseKeyInput(this);
		this.requestWindow.DisplayLicenseQuestion(this);
	}

	public Integer checkLicenseKey(String text) {
		if(text.equals(LICENSE_KEY_PRIVATE)){
			return LICENSE_STATE_PRIVATE;
		} else if(text.equals(LICENSE_KEY_EDUCATION)){
			return LICENSE_STATE_EDUCATION;
		} else if(text.equals(LICENSE_KEY_BUSINESS)){
			return LICENSE_STATE_BUSINESS;
		}
		System.out.println(text);
		return LICENSE_STATE_INVALID;
	}
	
	public void showMainWindows(Integer currentLicenseState) {
		ChannelVerzeichnis channelVerzeichnis = new ChannelVerzeichnis();
		GruppenListe gruppenListe = new GruppenListe();
		ChannelVerzeichnisURL channelVerzeichnisURL = new ChannelVerzeichnisURL();
		NutzerListe nutzerListe = new NutzerListe();
		Verwaltung verwaltung = new Verwaltung(nutzerListe, gruppenListe);
		
		System.out.println(currentLicenseState.intValue());
		ProduzentenSchnittstelle produzentenSchnittstelle = new Produzent(channelVerzeichnis, gruppenListe);
		KonsumentenSchnittstelle konsumentenSchnittstelle = new Konsument(channelVerzeichnis, channelVerzeichnisURL, nutzerListe);
		LoginSchnittstelle loginSchnittstelle = verwaltung;
		ZugriffsSchnittstelle zugriffsSchnittstelle = verwaltung;
		new MainWindow(currentLicenseState, produzentenSchnittstelle, konsumentenSchnittstelle);
	}
	
}
