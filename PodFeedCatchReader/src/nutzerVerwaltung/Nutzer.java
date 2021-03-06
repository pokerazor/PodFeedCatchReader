package nutzerVerwaltung;

import java.util.Vector;

import itemSpeicher.Channel;
import itemSpeicher.ChannelURL;

public class Nutzer {
	
	private int nutzerID;
	private String name;
	private String passwort;
	private NutzerRolle rolle;
	private Vector<Channel> abonnierteChannels;
	private Vector<ChannelURL> abonnierteURLs;
	
	public Nutzer(int id, String name, String passwort, NutzerRolle rolle){
		nutzerID = id;
		this.name = name;
		this.passwort = passwort;
		this.rolle = rolle;
		abonnierteChannels = new Vector <Channel>();
		abonnierteURLs = new Vector <ChannelURL>();
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

	public Vector<Channel> getAbonnierteChannels() {
		return abonnierteChannels;
	}

	public void setChannel(Channel channel) {
		System.out.println("Channel abonniert: Nutzer-ID: " + nutzerID + " Channel: " + channel.getName());
		abonnierteChannels.add(channel);
	}

	public Vector<ChannelURL> getAbonnierteURLs() {
		return abonnierteURLs;
	}

	public void setChannelURL(ChannelURL channel) {
		abonnierteURLs.add(channel);
	}
	
	public String toString() {
		return name;
	}
	

}
