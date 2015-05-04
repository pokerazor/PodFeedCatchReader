package itemSpeicher;

public interface KonsumentenSchnittstelleUni {
	
	void ItemKonsumieren(int ChannelID, int ItemID);
	boolean kommentieren(String kommentar);
	boolean ChannelAbonnierenURL(int ChannelID);
	boolean ChannelAbonnierenVerzeichnis(int ChannelID);

}
