package co.com.prueba.model.listaseries;

import java.util.List;

public class Characters{
	private String collectionURI;
	private int available;
	private int returned;
	private List<Object> items;

	public String getCollectionURI(){
		return collectionURI;
	}

	public int getAvailable(){
		return available;
	}

	public int getReturned(){
		return returned;
	}

	public List<Object> getItems(){
		return items;
	}
}