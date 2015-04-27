package itemSpeicher;

public class Item{
	
	private int id;
	private ItemArt art;
	private String inhalt;
	
	public Item(int id){
		this.id = id;
	}

	public ItemArt getArt() {
		return art;
	}

	public void setArt(ItemArt art) {
		this.art = art;
	}

	public String getInhalt() {
		return inhalt;
	}

	public void setInhalt(String inhalt) {
		this.inhalt = inhalt;
	}

	public int getId() {
		return id;
	}
	

}
