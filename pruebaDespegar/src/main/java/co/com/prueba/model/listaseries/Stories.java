package co.com.prueba.model.listaseries;

import java.util.List;

public class Stories{
	private String collectionURI;
	private int available;
	private int returned;
	private List<ItemsItem> items;

	public String getCollectionURI(){
		return collectionURI;
	}

	public int getAvailable(){
		return available;
	}

	public int getReturned(){
		return returned;
	}

	public List<ItemsItem> getItems(){
		return items;
	}
}