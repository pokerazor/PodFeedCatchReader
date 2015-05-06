package itemSpeicher;

import java.util.Vector;

public interface ProduzentenSchnittstelle {
	boolean erstelleItem(ItemArt art, String inhalt, int ChannelID);
	boolean erstelleChannel(String name);
	ChannelVerzeichnis getChannelVerzeichnis();
}
