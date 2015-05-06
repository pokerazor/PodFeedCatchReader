package nutzerVerwaltung;

import itemSpeicher.Channel;

import java.util.Vector;

public class Gruppe {

	int gruppenID;
	String name;
	Vector<Nutzer> nutzer;
	private Vector<Channel> abonnierteChannels;
	
	public Gruppe(int id, String name){
		gruppenID = id;
		this.name = name;
		nutzer = new Vector<Nutzer>();
		abonnierteChannels = new Vector <Channel>();
	}

	public Vector<Channel> getAbonnierteChannels() {
		return abonnierteChannels;
	}

	public Vector<Nutzer> getNutzer() {
		return nutzer;
	}

	public void setNutzer(Nutzer neuerNutzer) {
		nutzer.add(neuerNutzer);
	}

	public int getGruppenID() {
		return gruppenID;
	}

	public String getName() {
		return name;
	}
	
	public String toString() {
		return name;
	}
	
	public void setChannel(Channel channel) {
		System.out.println("Channel abonniert: Gruppenname: " + name + " Channel: " + channel.getName());
		abonnierteChannels.add(channel);
	}

	
	
	
	
}
