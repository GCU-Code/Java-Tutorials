import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import app.Services.Messenger;

public class IO
{
	public static ArrayList<Item> objectList = new ArrayList<>();

	public static void main(String[] args) throws IOException
	{
		Item[] items = null;
		File file = new File("content.json");
		try (FileInputStream is = new FileInputStream(file);
				BufferedInputStream buff = new BufferedInputStream(is)) {
			String jsonFileContents = new String(buff.readAllBytes());
			ObjectMapper mapper = new ObjectMapper();
			items = mapper.readValue(jsonFileContents, Item[].class);
			for (Item i : items) {
				objectList.add(i);
			}
			buff.close();
			is.close();
		} catch (FileNotFoundException e) {
			System.out.println("The file is either missing or misspelled "
					+ "for " + file + "." );
			e.printStackTrace();
		} catch (IOException e) {
			Messenger.printMessage("The file may not be in the correct JSON format "
					+ "for " + file + ".");
			e.printStackTrace();
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
