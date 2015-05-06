package itemSpeicher;

import java.util.Vector;

public class ChannelURL{
	
	private String URL;
	private String name;
	private Vector<Item> items;
	
	public ChannelURL(String URL){
		this.URL = URL;
		items = new Vector<Item>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Vector<Item> getItems() {
		return items;
	}

	public void setItems(Vector<Item> items) {
		this.items.addAll(items);
	}
	
	public void setItem(Item item){
		this.items.add(item);
	}

	public String getURL() {
		return URL;
	}
	
	

}
