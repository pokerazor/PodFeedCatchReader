package itemSpeicher;


public interface ProduzentenSchnittstelle {
	void erstelleItem(ItemArt art, String inhalt, int ChannelID);
	void erstelleChannel(String name);
}
