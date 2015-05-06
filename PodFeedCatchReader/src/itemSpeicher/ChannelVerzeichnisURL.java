package itemSpeicher;

import java.util.Vector;

public class ChannelVerzeichnisURL{
	
	private Vector<ChannelURL> liste;
	
	public ChannelVerzeichnisURL(){
		liste = new Vector<ChannelURL>();
		for(int i = 1; i < 10; ++i){
			ChannelURL c = new ChannelURL("http://channel"+ i + ".de");
			for(int j = 1; j < 4; ++j){
				c.setItem(new Item(j, ItemArt.Text, "Dies ist Item " + j + " von Channel" + i));
			}
			liste.add(c);
		}
	}

	public Vector<ChannelURL> getChannels() {
		return liste;
	}
}