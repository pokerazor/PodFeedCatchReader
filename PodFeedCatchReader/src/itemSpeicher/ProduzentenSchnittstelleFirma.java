package itemSpeicher;


public interface ProduzentenSchnittstelleFirma {
	boolean erstelleItem(ItemArt art, String inhalt, int ChannelID);
	boolean erstelleChannel(String name);
	boolean abonniereChannelFuerGruppe(int ChannelID, int gruppeID);
}
