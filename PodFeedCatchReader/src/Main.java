import gui.MainWindow;
import itemSpeicher.ChannelVerzeichnis;
import itemSpeicher.Produzent;
import itemSpeicher.ProduzentenSchnittstelleUni;

import java.awt.EventQueue;

import konfiguration.Konfiguration;


public class Main {
	private static Konfiguration currentKonfig;
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChannelVerzeichnis channelVerzeichnis = new ChannelVerzeichnis();
					currentKonfig = new Konfiguration();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
