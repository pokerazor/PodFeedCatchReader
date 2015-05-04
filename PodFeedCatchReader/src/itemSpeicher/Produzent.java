package itemSpeicher;

import java.util.LinkedList;

public class Produzent implements ProduzentenSchnittstelleUni, ProduzentenSchnittstelleFirma{
	
	ChannelVerzeichnis verzeichnis;
	
	public Produzent(ChannelVerzeichnis verzeichnis){
		this.verzeichnis = verzeichnis;
	}

	@Override
	public boolean erstelleItem(ItemArt art, String inhalt, int ChannelID) {
		LinkedList<Channel> channels = verzeichnis.getChannels(); 
		Channel c;
		int counter = 0;
		while(channels.get(counter) != null && channels.get(counter).getId() != ChannelID){
			++counter;
		}
		c = channels.get(counter);
		if(c.getId() != ChannelID){
			return false;
		}
		Item f = new Item(c.getFeeds().size()+1);
		f.setArt(art);
		f.setInhalt(inhalt);
		c.setFeed(f);
		return true;
	}

	@Override
	public boolean erstelleChannel(String name) {
		LinkedList<Channel> channels = verzeichnis.getChannels(); 
		Channel c = new Channel(channels.size()+1);
		c.setName(name);
		channels.add(c);
		return true;
	}

	@Override
	public boolean abonniereChannelFuerGruppe(int ChannelID, int gruppeID) {
		// TODO Auto-generated method stub
		return false;
	}

}
