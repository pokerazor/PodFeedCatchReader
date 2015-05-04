package itemSpeicher;

public interface KonsumentenSchnittstelleFirma extends ProduzentenSchnittstelleFirma{
	
	void ItemKonsumierenTextAudio(int ChannelID, int ItemID);
	boolean kommentieren(String kommentar);

}
