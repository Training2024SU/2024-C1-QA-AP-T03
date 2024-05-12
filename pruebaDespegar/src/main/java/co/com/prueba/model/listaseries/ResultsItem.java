package co.com.prueba.model.listaseries;

import java.util.List;

public class ResultsItem{
	private Object next;
	private Thumbnail thumbnail;
	private Stories stories;
	private Object previous;
	private Creators creators;
	private Comics comics;
	private int startYear;
	private String rating;
	private Object description;
	private String resourceURI;
	private String title;
	private String type;
	private int endYear;
	private Characters characters;
	private List<UrlsItem> urls;
	private String modified;
	private int id;
	private Events events;

	public Object getNext(){
		return next;
	}

	public Thumbnail getThumbnail(){
		return thumbnail;
	}

	public Stories getStories(){
		return stories;
	}

	public Object getPrevious(){
		return previous;
	}

	public Creators getCreators(){
		return creators;
	}

	public Comics getComics(){
		return comics;
	}

	public int getStartYear(){
		return startYear;
	}

	public String getRating(){
		return rating;
	}

	public Object getDescription(){
		return description;
	}

	public String getResourceURI(){
		return resourceURI;
	}

	public String getTitle(){
		return title;
	}

	public String getType(){
		return type;
	}

	public int getEndYear(){
		return endYear;
	}

	public Characters getCharacters(){
		return characters;
	}

	public List<UrlsItem> getUrls(){
		return urls;
	}

	public String getModified(){
		return modified;
	}

	public int getId(){
		return id;
	}

	public Events getEvents(){
		return events;
	}
}