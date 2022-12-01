```Java
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class NIO
{
	public static ArrayList<Item> objectList = new ArrayList<>();

	public static void main(String[] args) throws IOException
	{
		Item[] items = null;
		Path path = Paths.get("content.json");
		List<String> lines = Files.readAllLines(path);
		String jsonString = "";
		// A proper JSON string needs to be created for ObjectMapper
		for (String s : lines) {
			jsonString = jsonString + s;
		}
		ObjectMapper mapper = new ObjectMapper();
		items = mapper.readValue(jsonString, Item[].class);
		// Place each object in a list
		for (Item i : items) {
			objectList.add(i);
		}
	}
}

class Item
{
	private String name = "";
	private int qty = 0;

	/*********************
	 * CONSTRUCTORS
	 *********************/
	public Item()
	{
		// Default constructor is needed for ObjectMapper to work properly
	}

	public Item(String name, int qty)
	{
		this.name = name;
		this.qty = qty;
	}

	/*********************
	 * GETTERS/SETTERS
	 *********************/
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public int getQty() { return qty; }
	public void setQty(int qty) { this.qty = qty; }
}
```
