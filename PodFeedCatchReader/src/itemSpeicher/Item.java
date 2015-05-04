package itemSpeicher;

import java.util.LinkedList;

public class Item{
	
	private int id;
	private ItemArt art;
	private String inhalt;
	private LinkedList<String> kommentare;
	
	public Item(int id){
		this.id = id;
		kommentare = new LinkedList<String>();
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
	
	public void setKommentar(String kommentar){
		kommentare.add(kommentar);
	}
	
	public LinkedList<String> getKommentare(){
		return kommentare;
	}
	

}
