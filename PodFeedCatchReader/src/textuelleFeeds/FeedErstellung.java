package textuelleFeeds;

import itemSpeicher.ItemArt;
import itemSpeicher.ProduzentenSchnittstelle;

public class FeedErstellung implements FeedErstellenSchnittstelle{

	private ProduzentenSchnittstelle ps;
	
	FeedErstellung(ProduzentenSchnittstelle ps){
		this.ps = ps;
	}

	@Override
	public void erstelleFeed(ItemArt art, String inhalt, int ChannelID) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
