package textuelleFeeds;

import feedSpeicher.FeedArt;

public interface FeedErstellenSchnittstelle {
	
	public void erstelleFeed(FeedArt art, String inhalt, int ChannelID);

}
