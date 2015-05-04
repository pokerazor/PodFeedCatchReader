import gui.MainWindow;

import java.awt.EventQueue;

import konfiguration.Konfiguration;


public class Main {
	private static Konfiguration currentKonfig;

	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					currentKonfig=new Konfiguration();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
