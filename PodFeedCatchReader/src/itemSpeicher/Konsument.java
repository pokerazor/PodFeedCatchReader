package itemSpeicher;

import nutzerVerwaltung.NutzerListe;

public class Konsument implements KonsumentenSchnittstellePrivat, KonsumentenSchnittstelleUni, KonsumentenSchnittstelleFirma{

	ChannelVerzeichnis verzeichnis;
	ChannelVerzeichnisURL verzeichnisURL;
	NutzerListe nutzer;
	
	public Konsument(ChannelVerzeichnis verzeichnis, ChannelVerzeichnisURL verzeichnisURL, NutzerListe nutzer){
		this.verzeichnis = verzeichnis;
		this.verzeichnisURL = verzeichnisURL;
		this.nutzer = nutzer;
	}
	
	@Override
	public String ItemKonsumierenText(int ChannelID, int ItemID) {
		boolean channelExistiert = false;
		boolean itemExistiert = false;
		Channel channel = null;
		Item item = null;
		
		for(int i = 0; i < verzeichnis.getChannels().size(); ++i){
			if(verzeichnis.getChannels().get(i).getId() == ChannelID){
				channelExistiert = true;
				channel = verzeichnis.getChannels().get(i);
			}
		}
		
		if(channelExistiert == true){
			for(int i = 0; i < channel.getFeeds().size(); ++i){
				if(channel.getFeeds().get(i).getId() == ItemID){
					itemExistiert = true;
					item = channel.getFeeds().get(i);
				}
			}
			
			if(itemExistiert == true && item.getArt() == ItemArt.Text){
				return item.getInhalt();
			}else{
				return null;
			}
			
		}else{
			return null;
		}
		
	}
	
	@Override
	public String ItemKonsumierenTextAudio(int ChannelID, int ItemID) {
		boolean channelExistiert = false;
		boolean itemExistiert = false;
		Channel channel = null;
		Item item = null;
		
		for(int i = 0; i < verzeichnis.getChannels().size(); ++i){
			if(verzeichnis.getChannels().get(i).getId() == ChannelID){
				channelExistiert = true;
				channel = verzeichnis.getChannels().get(i);
			}
		}
		
		if(channelExistiert == true){
			for(int i = 0; i < channel.getFeeds().size(); ++i){
				if(channel.getFeeds().get(i).getId() == ItemID){
					itemExistiert = true;
					item = channel.getFeeds().get(i);
				}
			}
			
			if(itemExistiert == true && item.getArt() != ItemArt.Video){
				return item.getInhalt();
			}else{
				return null;
			}
			
		}else{
			return null;
		}
		
	}

	@Override
	public String ItemKonsumieren(int ChannelID, int ItemID) {
		boolean channelExistiert = false;
		boolean itemExistiert = false;
		Channel channel = null;
		Item item = null;
		
		for(int i = 0; i < verzeichnis.getChannels().size(); ++i){
			if(verzeichnis.getChannels().get(i).getId() == ChannelID){
				channelExistiert = true;
				channel = verzeichnis.getChannels().get(i);
			}
		}
		
		if(channelExistiert == true){
			for(int i = 0; i < channel.getFeeds().size(); ++i){
				if(channel.getFeeds().get(i).getId() == ItemID){
					itemExistiert = true;
					item = channel.getFeeds().get(i);
				}
			}
			
			if(itemExistiert == true){
				return item.getInhalt();
			}else{
				return null;
			}
			
		}else{
			return null;
		}
		
	}

	

	@Override
	public boolean kommentieren(int ChannelID, int ItemID, String kommentar) {
		boolean channelExistiert = false;
		boolean itemExistiert = false;
		Channel channel = null;
		Item item = null;
		
		for(int i = 0; i < verzeichnis.getChannels().size(); ++i){
			if(verzeichnis.getChannels().get(i).getId() == ChannelID){
				channelExistiert = true;
				channel = verzeichnis.getChannels().get(i);
			}
		}
		
		if(channelExistiert == true){
			for(int i = 0; i < channel.getFeeds().size(); ++i){
				if(channel.getFeeds().get(i).getId() == ItemID){
					itemExistiert = true;
					item = channel.getFeeds().get(i);
				}
			}
			
			if(itemExistiert == true){
				item.setKommentar(kommentar);
				return true;
			}else{
				return false;
			}
			
		}else{
			return false;
		}
		
	}

	@Override
	public String ItemKonsumierenURL(String URL, int ItemID) {
		boolean channelExistiert = false;
		boolean itemExistiert = false;
		ChannelURL channel = null;
		Item item = null;
		
		for(int i = 0; i < verzeichnisURL.getChannels().size(); ++i){
			if(verzeichnisURL.getChannels().get(i).getURL() == URL){
				channelExistiert = true;
				channel = verzeichnisURL.getChannels().get(i);
			}
		}
		
		if(channelExistiert == true){
			for(int i = 0; i < channel.getFeeds().size(); ++i){
				if(channel.getFeeds().get(i).getId() == ItemID){
					itemExistiert = true;
					item = channel.getFeeds().get(i);
				}
			}
			
			if(itemExistiert == true){
				return item.getInhalt();
			}else{
				return null;
			}
			
		}else{
			return null;
		}
	}

	@Override
	public String ItemKonsumierenTextURL(String URL, int ItemID) {
		boolean channelExistiert = false;
		boolean itemExistiert = false;
		ChannelURL channel = null;
		Item item = null;
		
		for(int i = 0; i < verzeichnisURL.getChannels().size(); ++i){
			if(verzeichnisURL.getChannels().get(i).getURL() == URL){
				channelExistiert = true;
				channel = verzeichnisURL.getChannels().get(i);
			}
		}
		
		if(channelExistiert == true){
			for(int i = 0; i < channel.getFeeds().size(); ++i){
				if(channel.getFeeds().get(i).getId() == ItemID){
					itemExistiert = true;
					item = channel.getFeeds().get(i);
				}
			}
			
			if(itemExistiert == true && item.getArt() == ItemArt.Text){
				return item.getInhalt();
			}else{
				return null;
			}
			
		}else{
			return null;
		}
	}

	@Override
	public boolean ChannelAbonnierenVerzeichnis(int nutzerID, int ChannelID) {
		boolean channelExistiert = false;
		boolean nutzerExistiert = false;
		Channel c = null;
		
		for(int i = 0; i < verzeichnis.getChannels().size(); ++i){
			if(verzeichnis.getChannels().get(i).getId() == ChannelID){
				c = verzeichnis.getChannels().get(i);
			}
		}
		
		if(channelExistiert == true){
			for(int i = 0; i < nutzer.getNutzer().size(); ++i){
				if(nutzer.getNutzer().get(i).getNutzerID() == nutzerID){
					nutzer.getNutzer().get(i).setChannel(c);
					nutzerExistiert = true;
					return true;
				}
			}
			
			if(nutzerExistiert == false){
				return false;
			}
			
		}else{
			return false;
		}
		
		return false;
	}

	@Override
	public boolean ChannelAbonnierenURL(int nutzerID, String ChannelURL) {
		boolean channelExistiert = false;
		boolean nutzerExistiert = false;
		ChannelURL c = null;
		
		for(int i = 0; i < verzeichnisURL.getChannels().size(); ++i){
			if(verzeichnisURL.getChannels().get(i).getURL() == ChannelURL){
				c = verzeichnisURL.getChannels().get(i);
			}
		}
		
		if(channelExistiert == true){
			for(int i = 0; i < nutzer.getNutzer().size(); ++i){
				if(nutzer.getNutzer().get(i).getNutzerID() == nutzerID){
					nutzer.getNutzer().get(i).setChannelURL(c);
					nutzerExistiert = true;
					return true;
				}
			}
			
			if(nutzerExistiert == false){
				return false;
			}
			
		}else{
			return false;
		}
		
		return false;
	}

	

}
