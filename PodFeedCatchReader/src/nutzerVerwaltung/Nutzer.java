package nutzerVerwaltung;

import java.util.LinkedList;

import itemSpeicher.Channel;
import itemSpeicher.ChannelURL;

public class Nutzer {
	
	private int nutzerID;
	private String name;
	private String passwort;
	private NutzerRolle rolle;
	private LinkedList<Channel> abonnierteChannels;
	private LinkedList<ChannelURL> abonnierteURLs;
	
	public Nutzer(int id, String name, String passwort, NutzerRolle rolle){
		nutzerID = id;
		this.name = name;
		this.passwort = passwort;
		this.rolle = rolle;
	}

	public int getNutzerID() {
		return nutzerID;
	}

	public String getName() {
		return name;
	}

	public String getPasswort() {
		return passwort;
	}

	public NutzerRolle getRolle() {
		return rolle;
	}

	public LinkedList<Channel> getAbonnierteChannels() {
		return abonnierteChannels;
	}

	public void setChannel(Channel channel) {
		abonnierteChannels.add(channel);
	}

	public LinkedList<ChannelURL> getAbonnierteURLs() {
		return abonnierteURLs;
	}

	public void setChannelURL(ChannelURL channel) {
		abonnierteURLs.add(channel);
	}
	
	

}
