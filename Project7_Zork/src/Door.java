
public class Door extends Thing {

	/***Data Fields***/
	private boolean locked;
	private boolean open;
	private Room oneSide;
	private Room otherSide;
	private Item key;
	
	/***Constructor***/
	public Door() {
		
	}
	
	public Door(String name, String description) {
		super(name, description);
	}
	
	public Door(String name, String description, boolean locked, boolean open, Room oneSide, Room otherSide, Item key) {
		super(name, description);
		setLocked(locked);
		setOpen(open);
		setOneSide(oneSide);
		setOtherSide(otherSide);
		setKey(key);
	}

	/***Set/Get***/
	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public Room getOneSide() {
		return oneSide;
	}

	public void setOneSide(Room oneSide) {
		this.oneSide = oneSide;
	}

	public Room getOtherSide() {
		return otherSide;
	}

	public void setOtherSide(Room otherSide) {
		this.otherSide = otherSide;
	}

	public Item getKey() {
		return key;
	}

	public void setKey(Item key) {
		this.key = key;
	}
	
	
}
