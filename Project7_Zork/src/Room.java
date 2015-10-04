import java.util.ArrayList;

public class Room extends Thing {

	/***Data Fields***/
	private ArrayList<Item> items = new ArrayList<Item>();
	private ArrayList<Door> doors = new ArrayList<Door>();
	
	/***Constructor***/
	public Room() {
	
	}
	
	public Room(String name, String description) {
		super(name, description);
	}
	
	public Room(String name, String description, ArrayList<Item> items, ArrayList<Door> doors) {
		super(name, description);
		setItems(items);
		setDoors(doors);
	}

	/***Set/Get***/
	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		if(items != null)
			this.items = items;
	}

	public ArrayList<Door> getDoors() {
		return doors;
	}

	public void setDoors(ArrayList<Door> doors) {
		if(doors != null)
			this.doors = doors;
	}
	
	
}
