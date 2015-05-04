package itemSpeicher;

import java.util.LinkedList;

public class ChannelVerzeichnisURL{
	
	private LinkedList<ChannelURL> liste;
	
	ChannelVerzeichnisURL(){
		liste = new LinkedList<ChannelURL>();
		for(int i = 1; i < 10; ++i){
			ChannelURL c = new ChannelURL("http://channel"+ i + ".de");
			for(int j = 1; j < 4; ++j){
				c.setFeed(new Item(j, ItemArt.Text, "Dies ist Item " + j + " von Channel" + i));
			}
			liste.add(c);
		}
	}

	public LinkedList<ChannelURL> getChannels() {
		return liste;
	}
}