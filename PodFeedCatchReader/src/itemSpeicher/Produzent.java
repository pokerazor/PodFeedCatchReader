package itemSpeicher;

import java.util.Vector;
import java.util.Vector;

import nutzerVerwaltung.Gruppe;
import nutzerVerwaltung.GruppenListe;
import nutzerVerwaltung.Nutzer;

public class Produzent implements ProduzentenSchnittstelleUni, ProduzentenSchnittstelleFirma, ProduzentenSchnittstellePrivat{
	
	ChannelVerzeichnis verzeichnis;
	GruppenListe gruppen;
	
	public Produzent(ChannelVerzeichnis verzeichnis, GruppenListe gruppen){
		this.verzeichnis = verzeichnis;
		this.gruppen = gruppen;
	}
	
	public ChannelVerzeichnis getChannelVerzeichnis() {
		return verzeichnis;
	}

	@Override
	public boolean erstelleItem(ItemArt art, String inhalt, int ChannelID) {
		Vector<Channel> channels = verzeichnis.getChannels(); 
		Channel c;
		int counter = 0;
		while(channels.get(counter) != null && channels.get(counter).getId() != ChannelID){
			++counter;
		}
		c = channels.get(counter);
		if(c.getId() != ChannelID){
			return false;
		}
		Item f = new Item(c.getItems().size()+1, art, inhalt);
		c.setItem(f);
		return true;
	}

	@Override
	public boolean erstelleChannel(String name) {
		Vector<Channel> channels = verzeichnis.getChannels(); 
		Channel c = new Channel(channels.size()+1);
		c.setName(name);
		channels.add(c);
		return true;
	}

	@Override
	public boolean abonniereChannelFuerGruppe(int ChannelID, int gruppeID) {
		boolean channelExistiert = false;
		boolean gruppeExistiert = false;
		Channel c = null;
		Gruppe g = null;
		
		for(int i = 0; i < verzeichnis.getChannels().size(); ++i){
			if(verzeichnis.getChannels().get(i).getId() == ChannelID){
				c = verzeichnis.getChannels().get(i);
			}
		}
		
		if(channelExistiert == true){
			for(int i = 0; i < gruppen.getGruppen().size(); ++i){
				if(gruppen.getGruppen().get(i).getGruppenID() == gruppeID){
					g = gruppen.getGruppen().get(i);
					gruppeExistiert = true;
				}
			}
			
			if(gruppeExistiert == false){
				return false;
			}else{

				for(int i = 0; i < g.getNutzer().size(); ++i){
					g.getNutzer().get(i).setChannel(c);
				}
				
				return true;
			}
			
			
		}else{
			return false;
		}
		
		
	}

}
