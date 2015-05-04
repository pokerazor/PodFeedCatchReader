package itemSpeicher;

public interface KonsumentenSchnittstelleUni extends KonsumentenSchnittstelle{
	
	void ItemKonsumieren(int ChannelID, int ItemID);
	boolean ChannelAbonnierenURL(int ChannelID);
	boolean ChannelAbonnierenVerzeichnis(int ChannelID);

}
