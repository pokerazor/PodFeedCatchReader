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

	public LinkedList<Item> getitems() {
		return items;
	}

	public void setitems(LinkedList<Item> items) {
		this.items.addAll(items);
	}
	
	public void setitem(Item item){
		this.items.addFirst(item);
	}

	public int getId() {
		return id;
	}
	
	public String toString() {
		return name;
		
	}
	
	

}
