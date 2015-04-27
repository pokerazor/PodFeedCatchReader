package itemSpeicher;

import java.util.LinkedList;

public class Channel{
	
	private int id;
	private String name;
	private LinkedList<Item> items;
	
	public Channel(int id){
		this.id = id;
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

	public int getId() {
		return id;
	}
	
	

}
