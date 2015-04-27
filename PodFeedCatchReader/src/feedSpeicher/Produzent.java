package feedSpeicher;

import java.util.LinkedList;

public class Produzent implements ProduzentenSchnittstelle{
	
	ChannelVerzeichnis verzeichnis;
	
	Produzent(ChannelVerzeichnis verzeichnis){
		this.verzeichnis = verzeichnis;
	}

	@Override
	public void erstelleFeed(FeedArt art, String inhalt, int ChannelID) {
		LinkedList<Channel> channels = verzeichnis.getChannels(); 
		Channel c;
		int counter = 0;
		while(channels.get(counter) != null && channels.get(counter).getId() != ChannelID){
			++counter;
		}
		c = channels.get(counter);
		Feed f = new Feed(c.getFeeds().size()+1);
		f.setArt(art);
		f.setInhalt(inhalt);
		c.setFeed(f);
		
	}

	@Override
	public void erstelleChannel(String name) {
		LinkedList<Channel> channels = verzeichnis.getChannels(); 
		Channel c = new Channel(channels.size()+1);
		c.setName(name);
		channels.add(c);
		
	}

	

}
