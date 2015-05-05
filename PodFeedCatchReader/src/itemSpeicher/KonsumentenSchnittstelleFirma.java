package itemSpeicher;

import java.util.Vector;

public interface KonsumentenSchnittstelleFirma extends KonsumentenSchnittstelle{
	
	String ItemKonsumierenTextAudio(int ChannelID, int ItemID);
	Vector<Item> AlleTextAudioItemsZuNuzer(int nutzerID);

}
