/**
 * 
 */
package konfiguration;

import gui.LicenseKeyInput;
import gui.MainWindow;

import javax.swing.JDialog;

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

	public Integer getLicenseState(){
		if (currentLicenseState==null){
			currentLicenseState=requestLicenseState();
		}
		return currentLicenseState; 
	}

	public void setCurrentLicenseState(Integer currentLicenseState) {
		this.currentLicenseState = currentLicenseState;
		System.out.println(currentLicenseState.intValue());
		
		if (currentLicenseState.intValue() != LICENSE_STATE_INVALID.intValue()) {
			showMainWindows(this.currentLicenseState);
		}
		
	}

	private Integer requestLicenseState() {
		this.requestWindow=new LicenseKeyInput(this);
		this.requestWindow.DisplayLicenseQuestion(this);
		// TODO Auto-generated method stub
		return LICENSE_STATE_PRIVATE;
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
		MainWindow window = new MainWindow(currentLicenseState);
	}
	
}
