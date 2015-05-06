package itemSpeicher;

import java.util.Vector;

public interface KonsumentenSchnittstellePrivat extends KonsumentenSchnittstelle{
	
	String ItemKonsumierenText(int ChannelID, int ItemID);
	Vector<Item> gibAlleTextItemsZuNuzer(int nutzerID);
	String ItemKonsumierenTextURL(String URL, int ItemID);
	boolean ChannelAbonnierenURL(int nutzerID, String ChannelURL);

}
