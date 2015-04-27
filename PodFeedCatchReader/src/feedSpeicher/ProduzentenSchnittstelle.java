package feedSpeicher;


public interface ProduzentenSchnittstelle {
	void erstelleFeed(FeedArt art, String inhalt, int ChannelID);
	void erstelleChannel(String name);
}
