package itemSpeicher;

import java.util.Vector;

public class Channel{
	
	private int id;
	private String name;
	private Vector<Item> items;
	
	public Channel(int id){
		this.id = id;
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

	public int getId() {
		return id;
	}
	
	public String toString() {
		return name;
		
	}
	
	

}
