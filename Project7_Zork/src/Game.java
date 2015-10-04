import java.util.ArrayList;
import java.util.Scanner;

public class Game {

	/***Data Fields***/
	private Scanner input;
	ArrayList<String> commands;
	private boolean endGame;
	private ArrayList<Item> backPack;
	
	private Room currentRoom;
	
	/***Constructor***/
	public Game() {
		init();
		runGame();
	}//end constructor
	
	/***Init***/
	private void init() {
		//Scanner for use throughout class
		input = new Scanner(System.in);
		
		//to start off game should not end
		endGame = false;
		
		//Initialize array with available user commands
		commands = new ArrayList<String>();
		commands.add("help");
		commands.add("look");
		commands.add("look at.*");
		commands.add("pick up.*");
		commands.add("use.*");
		commands.add("throw.*");
		commands.add("go through.*");
		commands.add("quit");
		commands.add("introduction");
		
		initGame();
		
	}//end init
	
	private void initGame() {
		/***Back pack***/
		this.backPack = new ArrayList<Item>();
		
		/***Main Room***/
		Door hatchExit = new Door("Pod door", "All you need is the key card... Then you can escape.");
		hatchExit.setLocked(true);
		Door armoryDoor = new Door("Armory door", "A reinforced steel door. You find yourself wishing to be half as strong as that door.");
		Door controlRoomDoor = new Door("Control room door", "A door covered in buttons and levers in homage to the control room.");
		controlRoomDoor.setLocked(true);
		ArrayList<Door> mainRoomDoors = new ArrayList<Door>();
		mainRoomDoors.add(hatchExit);
		mainRoomDoors.add(armoryDoor);
		mainRoomDoors.add(controlRoomDoor);
		
		Item controlRoomKey = new Item("Large key", "A convenient tag reads that it unlocks the door to the control room.");
		Item lockBox = new Item("Key box", "There's no telling what lies inside.");
		lockBox.setBreakable(true);
		lockBox.setContains(true);
		lockBox.setContainedItem(controlRoomKey);
		
		ArrayList<Item> mainRoomItems = new ArrayList<Item>();
		mainRoomItems.add(lockBox);
		
		Room mainRoom = new Room("The Brig", "Iron bars and such.");
		mainRoom.setItems(mainRoomItems);
		mainRoom.setDoors(mainRoomDoors);
		
		hatchExit.setOneSide(mainRoom);
		armoryDoor.setOneSide(mainRoom);
		
		controlRoomDoor.setOneSide(mainRoom);
		controlRoomDoor.setKey(controlRoomKey);
		
		this.currentRoom = mainRoom;
		
		/***************/
		
		/***Armory***/
		Item lunchBox = new Item ("Captain America lunch box", "One of the crew must have left it behind.");
		lunchBox.setBreakable(true);
		lunchBox.setContains(false);
		ArrayList<Item> armoryItems = new ArrayList<Item>();
		armoryItems.add(lunchBox);
		
		Room armory = new Room("The Armory", "Tons of normally useful supplies. It looks pretty disorganized. If only you had some time... It looks like something is sitting on the floor.");
		armory.setItems(armoryItems);
		ArrayList<Door> armoryDoors = new ArrayList<Door>();
		armoryDoors.add(armoryDoor);
		armoryDoor.setOtherSide(armory);
		armory.setDoors(armoryDoors);
		/**************/
		
		/***Control Room***/
		Room controlRoom = new Room("The Control Room", "A whole lot of controls. You though you'd have a lot more time to figure out what they do. This room appears to be empty.");
		ArrayList<Door> controlRoomDoors = new ArrayList<Door>();
		controlRoomDoor.setOtherSide(controlRoom);
		controlRoomDoors.add(controlRoomDoor);
		Door eSupplyRoomDoor = new Door("Emergency Supply Door", "A Red Door with an emergency sign stuck across it.");
		eSupplyRoomDoor.setOneSide(controlRoom);
		controlRoomDoors.add(eSupplyRoomDoor);
		controlRoom.setDoors(controlRoomDoors);
		/******************/
		
		/***Emergency Supply Room***/
		Room eSupplyRoom = new Room("The Emergency Supply Room", "A special room with emergency supplies, but is there a key card? You see a piggy bank sitting on the shelf.");
		eSupplyRoomDoor.setOtherSide(eSupplyRoom);
		ArrayList<Door> eSupplyRoomDoors = new ArrayList<Door>();
		eSupplyRoomDoors.add(eSupplyRoomDoor);
		eSupplyRoom.setDoors(eSupplyRoomDoors);
		Item keyCard = new Item("Key card", "Just what you need!");
		keyCard.setBreakable(false);
		keyCard.setContains(false);
		Item captainWallet = new Item("Captain's piggy bank", "The Captain's piggy bank. It must be his emergency change supply. He must have been in a hurry to get out.");
		captainWallet.setBreakable(true);
		captainWallet.setContains(true);
		captainWallet.setContainedItem(keyCard);
		ArrayList<Item> eSupplyItems = new ArrayList<Item>();
		eSupplyItems.add(captainWallet);
		eSupplyRoom.setItems(eSupplyItems);
		
		hatchExit.setKey(keyCard);
		
		/***Outside***/
		Room outside = new Room("Outside", "You win!");
		ArrayList<Door> outsideDoors = new ArrayList<Door>();
		hatchExit.setOtherSide(outside);
		outsideDoors.add(hatchExit);
	}//end initGame

	/***Methods***/
	public void runGame() {
		System.out.println("Samuel Jentsch");
		System.out.println("***To win unlock and go through the Pod door.***");
		introduction();
		help();		
		
		//Continue running game until win or quite
		while(!endGame) {
			//Game
			System.out.println("\nCommand: ");
			String userInput1 = getInput();
			String userInput = userInput1.toLowerCase();
			
			int commandIndex = parseInput(userInput);
			executeInput(commandIndex, userInput);
			if(this.currentRoom.getName().equalsIgnoreCase("outside"))
				this.endGame = true;
		}//end while
		
		System.out.println("You enter the pod. It's a little cramped, but you figure it's better than drowning.\n After spending a few minutes reading the user's manual, you shoot off to the surface.");
	}//end runGame

	public String getInput() {
		String userInput = input.nextLine();
		return userInput;
	}//end getInput
	
	public int parseInput(String input) {
		for(int i = 0; i < this.commands.size(); i++) {
			if(input.matches(commands.get(i))) {
				return i;
			}//end if
		}//end for
		return -1;
	}//end parseInput
	  
	public void executeInput(int cIndex, String input) {
		/***Find arguments from string to pass***/		
		String finalParameter = " ";
		if(cIndex != -1) {
			//Format a string from the commands array to remove the .* regex
			String formattedRegexCommand = this.commands.get(cIndex).replaceAll("[.,*]", "");
			//Format the user input so that the command is removed, leaving only the parameter.
			String parameter = input.replaceFirst(formattedRegexCommand, "");
			//Trim the parameter to remove whitespace
			finalParameter = parameter.trim();
		}
		
		//Based on the index retrieved by parseInput, call a command with the parameter retrieved from above
		switch (cIndex) {
		case 0:
			help();
			break;
		case 1:
			look();
			break;
		case 2:
			lookAt(finalParameter);
			break;
		case 3:
			pickUp(finalParameter);
			break;
		case 4:
			use(finalParameter);
			break;
		case 5:
			throwCommand(finalParameter);
			break;
		case 6:
			goThrough(finalParameter);
			break;
		case 7: 
			quit();
			break;
		case 8:
			introduction();
			break;
		default:
			System.out.println("Sorry, that command is not available. Type 'help' for a list of commands.");
		}//end switch
	}//end executeInput()
	
	/***Text Command Methods***/
	public void help() {
		ArrayList<String> helpCommands = new ArrayList<String>();
		helpCommands.add("help");
		helpCommands.add("look");
		helpCommands.add("look at *THING*");
		helpCommands.add("pick up *ITEM*");
		helpCommands.add("use *ITEM*");
		helpCommands.add("throw *ITEM*");
		helpCommands.add("go through *DOOR*");
		helpCommands.add("quit");
		helpCommands.add("introduction");
		
		System.out.print("Commands:\n");
		for(String element: helpCommands)
			System.out.println(element);
	}//end help
	
	public void look() {
		System.out.println(currentRoom.getName() + "- " + currentRoom.getDescription());

		//Print out name and description for each door in the current room.
		if(this.currentRoom.getDoors().size() > 0) { 
			System.out.println("Doors: ");
			for(Door theDoor: this.currentRoom.getDoors()) 
				System.out.println("\t" + theDoor.getName() + "- " + theDoor.getDescription());
		}

		//Print out name and description for each item in the current room.
		if(this.currentRoom.getItems().size() > 0) {
			System.out.println("Items: ");
			for(Item theItem: this.currentRoom.getItems()) 
				System.out.println("\t" + theItem.getName() + "- " + theItem.getDescription());
		}
		
		//Print out name and description for each item in player backpack
		if(this.backPack.size() > 0) {
			System.out.println("Back pack: ");
			for(Item theItem: this.backPack) 
				System.out.println("\t" + theItem.getName() + "- " + theItem.getDescription());
		}
	}//end look

	public void lookAt(String arg) {
		boolean foundArg = false;
		if(arg.length() > 0) {			
			//Search doors in current room for matching name. Print name and description.
			for(Thing theThing: this.currentRoom.getDoors())
				if(arg.equalsIgnoreCase(theThing.getName())) {
					System.out.println(theThing.getDescription());
					foundArg = true;
				}
			
			//Search items in the current room for matching name. Print name and description.
			for(Thing theThing: this.currentRoom.getItems())
				if(arg.equalsIgnoreCase(theThing.getName())) {
					System.out.println(theThing.getDescription());
					foundArg = true;
				}
			
			//Search items in the player backpack for matching name. Print name and description.
			for(Thing theThing: this.backPack)
				if(arg.equalsIgnoreCase(theThing.getName())) {
					System.out.println(theThing.getDescription());
					foundArg = true;
				}	
		}
		if(!foundArg)
			System.out.println("Please enter something contained in the room you would like to look at. *look at THING*");
	}//end lookAt
	
	public void pickUp(String arg) {
		boolean foundArg = false;
		if(arg.length() > 0) {
			//Check for name match in all items contained in room array. Add the item to player backpack if found.
			for(Item theItem: this.currentRoom.getItems())
				if(arg.equalsIgnoreCase(theItem.getName())) {
					this.backPack.add(theItem);
					this.currentRoom.getItems().remove(theItem);
					System.out.printf("%s was added to your backpack.", theItem.getName());
					foundArg = true;
					break;
				}
		}
		if(!foundArg)
			System.out.println("That's not in the room!");
	}//end pickUp
	
	public void open(String arg) {
		if(arg.length() > 0)
			System.out.printf("\nThe 'open' command was called with %s.", arg);
		else
			System.out.println("Please enter what you'd like to open. *open THING*");
	}//end open
	
	public void use(String arg) {
		boolean foundArg = false;
		boolean unlockedDoor = false;
		if(arg.length() > 0) {
			//Search items contained in the user backpack for a matching name. If found use the item.
			for(Item theItem: this.backPack)
				if(arg.equalsIgnoreCase(theItem.getName())) {
					//Search doors in the current room to find a door that uses the item as a key
					for(Door theDoor: this.currentRoom.getDoors()) 
						if(theDoor.getKey() == theItem) {
							theDoor.setLocked(false);
							System.out.println(theDoor.getName() + " was unlocked!");
							unlockedDoor = true;
						}
					
					foundArg = true;
					if(unlockedDoor) {
						//remove used key from inventory and break the loop
						this.backPack.remove(theItem);
						foundArg = true;
						break;
					}//end if unlocked door
				}//end for items in backpack
		}//end if arguement is greater than 0
		
		//if the argument matched an item, foundArg will be set to true. If not, the item wasn't found in the backpack.
		if(!foundArg)
			System.out.println("That's not in your backpack!");
		
		//if the argument matched an item, but the item didn't unlock any doors, nothing happens will print.
		if(foundArg == true && unlockedDoor == false)
			System.out.println("Nothing happens...");
	}//end use
	
	public void throwCommand(String arg) {
		boolean foundArg = false;
		if(arg.length() > 0) {
			//Search items contained in the user backpack for a matching name. If found throw the item.
			for(Item theItem: this.backPack)
				if(arg.equalsIgnoreCase(theItem.getName())) {
					if(theItem.isBreakable()) {
						if(theItem.isContains()) {
							this.currentRoom.getItems().add(theItem.getContainedItem());
							this.backPack.remove(theItem);
							System.out.printf("A '%s' flys into the room out of the broken '%s'.\n", theItem.getContainedItem().getName(), theItem.getName());
							foundArg = true;
							break;
						}//end if item contains another item
						else {
							this.backPack.remove(theItem);
							System.out.printf("The %s breaks, but nothing was inside. You feel bad for breaking it.", theItem.getName());
							foundArg = true;
							break;
						}//end if breakable, but doesn't contain item
					}//end if item is breakable
					else
						System.out.println(theItem.getName() + " isn't breakable. Nothing happens...");
			
					foundArg = true;
				}//end for (search contents of backpack)
		}//end if (argument is actual search parameter)
		if(!foundArg)
			System.out.println("That's not in your backpack!");
	}//end throwCommand
	
	public void goThrough(String arg) {
		boolean foundArg = false;
		if(arg.length() > 0) {
			//Search the doors in the current room for a match. If the door is locked or unlocked, act accordingly.
			for(Door theDoor: currentRoom.getDoors()) 
				if(arg.equalsIgnoreCase(theDoor.getName())) {
					if(theDoor.isLocked() == false) {
						//Switch the rooms on each side of the door, and change the current room to the new room.
						Room tempRoom = theDoor.getOneSide();
						theDoor.setOneSide(this.currentRoom);
						this.currentRoom = theDoor.getOtherSide();
						theDoor.setOtherSide(tempRoom);
						System.out.println("You walk through the door.");
					}//If the door isn't locked, switch rooms
					else
						System.out.println("The door is locked.");
					foundArg = true;
				}
		}
		if(!foundArg)
			System.out.println("That door isn't in the room!");
	}//end goThrough
	
	public void quit() {
		System.out.println("\nThe 'quit' command was called.");
		System.exit(0);
	}//end quit
	
	public void introduction() {
		System.out.println("You awaken to find yourself in the brig of the now abandoned massive mining submarine. The oxygen supply systems are failing fast. \nAll you remember is that one moment you were scanning the bottom of the ocean for " +
				"precious \nmineral deposits, and the next you were tied up and stuck in the brig on some false accusation of inciting mutiny.\n The year is 2130, space has been explored. The uncharted ocean floor is the true last frontier. \nYou've got to find " +
				"the access card so you can access the pod to propel you back to the oceans surface. \nYou've got to open the hatch. \nIt's your only hope.\n");
	}//end introduction
	
}//end class
