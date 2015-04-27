package textuelleFeeds;

import itemSpeicher.ItemArt;

public interface FeedErstellenSchnittstelle {
	
	public void erstelleFeed(ItemArt art, String inhalt, int ChannelID);

}
