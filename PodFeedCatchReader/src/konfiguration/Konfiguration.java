/**
 * 
 */
package konfiguration;

import gui.LicenseKeyInput;

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

	public Integer getLicenseState(){
		if (currentLicenseState==null){
			currentLicenseState=requestLicenseState();
		}
		return currentLicenseState; 
	}

	public void setCurrentLicenseState(Integer currentLicenseState) {
		this.currentLicenseState = currentLicenseState;
	}

	private Integer requestLicenseState() {
		LicenseKeyInput requestWindow=new LicenseKeyInput(this);
		requestWindow.DisplayLicenseQuestion(this);
		// TODO Auto-generated method stub
		return LICENSE_STATE_PRIVATE;
	}

	public Integer checkLicenseKey(String text) {
		if(text.equals(LICENSE_KEY_PRIVATE)){
			return LICENSE_STATE_PRIVATE;
		} else if(text.equals(LICENSE_KEY_EDUCATION)){
			return LICENSE_STATE_PRIVATE;
		} else if(text.equals(LICENSE_KEY_BUSINESS)){
			return LICENSE_STATE_PRIVATE;
		}
		System.out.println(text);
		return LICENSE_STATE_INVALID;
	}
	
}
