package itemSpeicher;

import java.util.LinkedList;

public class ChannelURL{
	
	private String URL;
	private String name;
	private LinkedList<Item> items;
	
	public ChannelURL(String URL){
		this.URL = URL;
		items = new LinkedList<Item>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LinkedList<Item> getitems() {
		return items;
	}

	public void setitems(LinkedList<Item> items) {
		this.items.addAll(items);
	}
	
	public void setitem(Item item){
		this.items.addFirst(item);
	}

	public String getURL() {
		return URL;
	}
	
	

}
