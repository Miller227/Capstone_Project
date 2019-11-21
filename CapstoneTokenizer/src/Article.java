public class Article {

	private int id;
	private String url;
	private String title;
	private String image; 
	
	public Article() {
		
		id = -1;
		url = null;
		title = null;
		image = null;
		
	}
	
	public Article(int id, String url, String title, String image) {
		
		this.id = id;
		this.url = url;
		this.title = title;
		this.image = image;
		
	}
	
	public int getID() { return id; }
	public String getURL() { return url; }
	public String getTitle() { return title; }
	public String getImage() { return image; }
}
