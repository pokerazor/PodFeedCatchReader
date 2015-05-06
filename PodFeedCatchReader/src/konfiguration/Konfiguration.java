/**
 * 
 */
package konfiguration;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;

import itemSpeicher.ChannelVerzeichnis;
import itemSpeicher.ChannelVerzeichnisURL;
import itemSpeicher.Konsument;
import itemSpeicher.KonsumentenSchnittstelle;
import itemSpeicher.KonsumentenSchnittstelleFirma;
import itemSpeicher.KonsumentenSchnittstellePrivat;
import itemSpeicher.KonsumentenSchnittstelleUni;
import itemSpeicher.Produzent;
import itemSpeicher.ProduzentenSchnittstelle;
import itemSpeicher.ProduzentenSchnittstelleFirma;
import itemSpeicher.ProduzentenSchnittstellePrivat;
import itemSpeicher.ProduzentenSchnittstelleUni;
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
		
		String state = "";
		try {
			state = readFile("config.txt");
		System.out.print(state);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		switch(state){
		case "privat": setCurrentLicenseState(LICENSE_STATE_PRIVATE);break;
		case "uni": setCurrentLicenseState(LICENSE_STATE_EDUCATION);break;
		case "firma": setCurrentLicenseState(LICENSE_STATE_BUSINESS);break;
		}
		
		if (currentLicenseState==null){
			requestLicenseState();
		}
		return currentLicenseState; 
	}
	
	String readFile(String fileName) throws IOException {
	    BufferedReader br = new BufferedReader(new FileReader(fileName));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            line = br.readLine();
	        }
	        return sb.toString();
	    } finally {
	        br.close();
	    }
	}
	
	void writeFile(String fileName, String text) throws IOException{
		try {
			 
			File file = new File(fileName);
 
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(text);
			bw.close();
 
			System.out.println("Done");
 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean setCurrentLicenseState(Integer currentLicenseState){
		this.currentLicenseState = currentLicenseState;
		System.out.println(currentLicenseState.intValue());
		
			String filename = "config.txt";
			
			if(currentLicenseState == LICENSE_STATE_PRIVATE){
				try {
					writeFile(filename, "privat");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(currentLicenseState == LICENSE_STATE_EDUCATION){
				try {
					writeFile(filename, "uni");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(currentLicenseState == LICENSE_STATE_BUSINESS){
				try {
					writeFile(filename, "firma");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(currentLicenseState == LICENSE_STATE_INVALID){
				try {
					writeFile(filename, "");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(currentLicenseState != LICENSE_STATE_INVALID){
				showMainWindows(currentLicenseState);
				return true;
			}else{
				return false;
			}
		
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
		
		LoginSchnittstelle loginSchnittstelle = verwaltung;
		ZugriffsSchnittstelle zugriffsSchnittstelle = verwaltung;
		
		if (currentLicenseState == this.LICENSE_STATE_PRIVATE) {
			ProduzentenSchnittstellePrivat  produzentenSchnittstelle = new Produzent(channelVerzeichnis, gruppenListe);
			KonsumentenSchnittstellePrivat  konsumentenSchnittstelle = new Konsument(channelVerzeichnis, channelVerzeichnisURL, nutzerListe, gruppenListe);
			
			new MainWindow(currentLicenseState, produzentenSchnittstelle, konsumentenSchnittstelle, loginSchnittstelle, zugriffsSchnittstelle, this);
		}
		
		if (currentLicenseState == this.LICENSE_STATE_EDUCATION) {
			ProduzentenSchnittstelleUni  produzentenSchnittstelle = new Produzent(channelVerzeichnis, gruppenListe);
			KonsumentenSchnittstelleUni  konsumentenSchnittstelle = new Konsument(channelVerzeichnis, channelVerzeichnisURL, nutzerListe, gruppenListe);
			
			new MainWindow(currentLicenseState, produzentenSchnittstelle, konsumentenSchnittstelle, loginSchnittstelle, zugriffsSchnittstelle, this);
		}
		
		if (currentLicenseState == this.LICENSE_STATE_BUSINESS) {
			ProduzentenSchnittstelleFirma  produzentenSchnittstelle = new Produzent(channelVerzeichnis, gruppenListe);
			KonsumentenSchnittstelleFirma  konsumentenSchnittstelle = new Konsument(channelVerzeichnis, channelVerzeichnisURL, nutzerListe, gruppenListe);
			
			new MainWindow(currentLicenseState, produzentenSchnittstelle, konsumentenSchnittstelle, loginSchnittstelle, zugriffsSchnittstelle, this);
		}
		
		
	}
	
}
