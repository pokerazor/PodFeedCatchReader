package itemSpeicher;

import java.util.Vector;

public interface KonsumentenSchnittstelleUni extends KonsumentenSchnittstelle{
	
	String ItemKonsumieren(int ChannelID, int ItemID);
	Vector<Item> AlleItemsZuNuzer(int nutzerID);
	String ItemKonsumierenURL(String URL, int ItemID);
	boolean ChannelAbonnierenURL(int nutzerID, String ChannelURL);
	boolean ChannelAbonnierenVerzeichnis(int nutzerID, int ChannelID);

}
