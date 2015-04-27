package feedSpeicher;

import java.util.LinkedList;

public class Channel{
	
	private int id;
	private String name;
	private LinkedList<Feed> feeds;
	
	public Channel(int id){
		this.id = id;
		feeds = new LinkedList<Feed>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LinkedList<Feed> getFeeds() {
		return feeds;
	}

	public void setFeeds(LinkedList<Feed> feeds) {
		this.feeds.addAll(feeds);
	}
	
	public void setFeed(Feed feed){
		this.feeds.addFirst(feed);
	}

	public int getId() {
		return id;
	}
	
	

}
