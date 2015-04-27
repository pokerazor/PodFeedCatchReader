import gui.MainWindow;

import java.awt.EventQueue;

import konfiguration.Konfiguration;


public class Main {
	private static Konfiguration currentKonfig;

	public static void main(String[] args) {
		Integer currentLicenseState;
		
		currentKonfig=new Konfiguration();
		currentLicenseState=currentKonfig.getLicenseState();
		
		System.out.println(currentLicenseState);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
