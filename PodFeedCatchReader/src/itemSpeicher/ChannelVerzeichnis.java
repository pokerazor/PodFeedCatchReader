package itemSpeicher;

import java.util.LinkedList;
import java.util.Vector;

public class ChannelVerzeichnis{
	
	private Vector<Channel> liste;
	
	public ChannelVerzeichnis(){
		liste = new Vector<Channel>();
	}

	public Vector<Channel> getChannels() {
		return liste;
	}

	public void setChannels(Vector<Channel> liste) {
		this.liste.addAll(liste);
	}
	
	public void setChannel(Channel channel) {
		this.liste.add(channel);
	}
	
	

}
