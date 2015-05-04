package itemSpeicher;


public interface ProduzentenSchnittstelleUni {
	boolean erstelleItem(ItemArt art, String inhalt, int ChannelID);
	boolean erstelleChannel(String name);
}
