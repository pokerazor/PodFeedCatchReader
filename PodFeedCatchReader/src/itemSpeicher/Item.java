package itemSpeicher;

import java.util.Vector;

public class Item{
	
	private int id;
	private ItemArt art;
	private String inhalt;
	private Vector<String> kommentare;
	
	public Item(int id, ItemArt art, String inhalt){
		this.id = id;
		this.art = art;
		this.inhalt = inhalt;
		kommentare = new Vector<String>();
	}

	public ItemArt getArt() {
		return art;
	}

	public String getInhalt() {
		return inhalt;
	}

	public int getId() {
		return id;
	}
	
	public void setKommentar(String kommentar){
		kommentare.add(kommentar);
	}
	
	public Vector<String> getKommentare(){
		return kommentare;
	}
	
	public String toString(){
		return inhalt;
	}
	

}
