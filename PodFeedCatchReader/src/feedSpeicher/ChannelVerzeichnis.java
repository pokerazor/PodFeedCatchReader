package feedSpeicher;

import java.util.LinkedList;

public class ChannelVerzeichnis{
	
	private LinkedList<Channel> liste;
	
	ChannelVerzeichnis(){
		liste = new LinkedList<Channel>();
	}

	public LinkedList<Channel> getChannels() {
		return liste;
	}

	public void setChannels(LinkedList<Channel> liste) {
		this.liste.addAll(liste);
	}
	
	public void setChannel(Channel channel) {
		this.liste.add(channel);
	}
	
	

}
