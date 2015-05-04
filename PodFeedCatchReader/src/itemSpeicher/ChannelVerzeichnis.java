package itemSpeicher;

import java.util.LinkedList;

public class ChannelVerzeichnis{
	
	private LinkedList<Channel> liste;
	
	public ChannelVerzeichnis(){
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
