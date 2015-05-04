package itemSpeicher;

public interface KonsumentenSchnittstellePrivat {
	
	void ItemKonsumierenText(int ChannelID, int ItemID);
	boolean kommentieren(String kommentar);
	boolean ChannelAbonnierenURL(int ChannelID);

}
