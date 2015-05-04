package itemSpeicher;

public interface KonsumentenSchnittstelleUni extends KonsumentenSchnittstelle{
	
	String ItemKonsumieren(int ChannelID, int ItemID);
	String ItemKonsumierenURL(String URL, int ItemID);
	boolean ChannelAbonnierenURL(int nutzerID, String ChannelURL);
	boolean ChannelAbonnierenVerzeichnis(int nutzerID, int ChannelID);

}
