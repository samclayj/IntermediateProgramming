
public class Item extends Thing {

	/***Data Fields***/
	private boolean breakable;
	private boolean contains;
	private Item containedItem;
	
	/***Constructor***/
	public Item() {
		
	}
	
	public Item(String name, String description) {
		super(name, description);
	}
	
	public Item(String name, String description, boolean breakable, boolean contains, Item containedItem) {
		super(name, description);
		setBreakable(breakable);
		setContains(contains);
		setContainedItem(containedItem);
	}

	/***Set/Get***/
	public boolean isBreakable() {
		return breakable;
	}

	public void setBreakable(boolean breakable) {
		this.breakable = breakable;
	}

	public boolean isContains() {
		return contains;
	}

	public void setContains(boolean contains) {
		this.contains = contains;
	}

	public Item getContainedItem() {
		return containedItem;
	}

	public void setContainedItem(Item containedItem) {
		this.containedItem = containedItem;
	}
	
	
}
