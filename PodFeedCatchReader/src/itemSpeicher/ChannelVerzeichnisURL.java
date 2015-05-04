package itemSpeicher;

import java.util.LinkedList;

public class ChannelVerzeichnisURL{
	
	private LinkedList<Channel> liste;
	
	ChannelVerzeichnisURL(){
		liste = new LinkedList<Channel>();
	}

	public LinkedList<Channel> getChannels() {
		return liste;
	}
}