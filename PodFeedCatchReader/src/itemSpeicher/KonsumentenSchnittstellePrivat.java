package itemSpeicher;

public interface KonsumentenSchnittstellePrivat extends KonsumentenSchnittstelle{
	
	String ItemKonsumierenText(int ChannelID, int ItemID);
	String ItemKonsumierenTextURL(String URL, int ItemID);
	boolean ChannelAbonnierenURL(int nutzerID, String ChannelURL);

}
