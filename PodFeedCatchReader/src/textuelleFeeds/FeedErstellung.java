package textuelleFeeds;

import feedSpeicher.FeedArt;
import feedSpeicher.ProduzentenSchnittstelle;

public class FeedErstellung implements FeedErstellenSchnittstelle{

	private ProduzentenSchnittstelle ps;
	
	FeedErstellung(ProduzentenSchnittstelle ps){
		this.ps = ps;
	}

	@Override
	public void erstelleFeed(FeedArt art, String inhalt, int ChannelID) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
