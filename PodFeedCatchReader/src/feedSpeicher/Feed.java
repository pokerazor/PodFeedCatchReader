package feedSpeicher;

public class Feed{
	
	private int id;
	private FeedArt art;
	private String inhalt;
	
	public Feed(int id){
		this.id = id;
	}

	public FeedArt getArt() {
		return art;
	}

	public void setArt(FeedArt art) {
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
