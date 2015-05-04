package itemSpeicher;

public interface KonsumentenSchnittstellePrivat extends KonsumentenSchnittstelle{
	
	void ItemKonsumierenText(int ChannelID, int ItemID);
	boolean ChannelAbonnierenURL(int ChannelID);

}
