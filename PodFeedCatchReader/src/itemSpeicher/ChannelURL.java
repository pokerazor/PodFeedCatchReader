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

	public LinkedList<Item> getFeeds() {
		return items;
	}

	public void setFeeds(LinkedList<Item> items) {
		this.items.addAll(items);
	}
	
	public void setFeed(Item item){
		this.items.addFirst(item);
	}

	public String getURL() {
		return URL;
	}
	
	

}
