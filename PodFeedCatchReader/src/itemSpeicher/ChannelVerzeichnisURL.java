package itemSpeicher;

import java.util.LinkedList;

public class ChannelVerzeichnisURL{
	
	private LinkedList<ChannelURL> liste;
	
	ChannelVerzeichnisURL(){
		liste = new LinkedList<ChannelURL>();
	}

	public LinkedList<ChannelURL> getChannels() {
		return liste;
	}
}