import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		int id;
		String url;
		String title;
		String image;
		ArrayList<Article> articles = new ArrayList();
		
		Scanner reader = new Scanner(new File("C:\\Users\\nicol\\Desktop\\Capstone\\WWE_Data.csv"));
		StringTokenizer row = new StringTokenizer("");
		
		reader.nextLine();
		
		while (reader.hasNextLine()) {

			// get the next line of data
			row = new StringTokenizer(reader.nextLine(), ",");

			id = Integer.parseInt(row.nextToken());
			url = row.nextToken();
			title = row.nextToken();
			image = row.nextToken();

			articles.add(new Article(id, url, title, image));
			
		}
		
		for (Article x : articles)
			System.out.println(x.getID() + ", " + x.getURL() + ", " + x.getTitle() + ", " + x.getImage());
	}
}
