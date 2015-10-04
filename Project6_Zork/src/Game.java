import java.util.ArrayList;
import java.util.Scanner;

public class Game {

	/***Data Fields***/
	private Scanner input;
	ArrayList<String> commands;
	private boolean endGame;
	
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
		commands.add("open.*");
		commands.add("use.*");
		commands.add("throw.*");
		commands.add("go through.*");
		commands.add("quit");
		commands.add("introduction");
		
	}//end init

	/***Methods***/
	public void runGame() {
		System.out.println("Samuel Jentsch");
		introduction();
		help();		
		
		//Continue running game until win or quite
		while(!endGame) {
			//Game
			System.out.println("\nEnter command.");
			String userInput1 = getInput();
			String userInput = userInput1.toLowerCase();
			
			int commandIndex = parseInput(userInput);
			executeInput(commandIndex, userInput);
		}//end while
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
			open(finalParameter);
			break;
		case 5:
			use(finalParameter);
			break;
		case 6:
			throwCommand(finalParameter);
			break;
		case 7:
			goThrough(finalParameter);
			break;
		case 8: 
			quit();
			break;
		case 9:
			introduction();
			break;
		default:
			System.out.println("Unsupported command. Please try again.");
			help();
		}//end switch
	}//end executeInput()
	
	/***Text Command Methods***/
	public void help() {
		ArrayList<String> helpCommands = new ArrayList<String>();
		helpCommands.add("help");
		helpCommands.add("look");
		helpCommands.add("look at *THING*");
		helpCommands.add("pick up *ITEM*");
		helpCommands.add("open *ITEM*");
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
		System.out.println("\nThe 'look' command was called.");
	}//end look

	public void lookAt(String arg) {
		if(arg.length() > 0)
			System.out.printf("\nThe 'look at' command was called with %s.", arg);
		else
			System.out.println("Please enter what you'd like to look at. *look at THING*");
	}//end lookAt
	
	public void pickUp(String arg) {
		if(arg.length() > 0)
			System.out.printf("\n The 'pick up' command was called with %s.", arg);
		else
			System.out.println("Please enter what you'd like to pick up. *pick up THING*");
	}//end pickUp
	
	public void open(String arg) {
		if(arg.length() > 0)
			System.out.printf("\nThe 'open' command was called with %s.", arg);
		else
			System.out.println("Please enter what you'd like to open. *open THING*");
	}//end open
	
	public void use(String arg) {
		if(arg.length() > 0)
			System.out.printf("\nThe 'use' command was called with %s.", arg);
		else
			System.out.println("Please enter what you'd like to use. *use THING*");
	}//end use
	
	public void throwCommand(String arg) {
		if(arg.length() > 0)
			System.out.printf("\n The 'throw' command was called with %s.", arg);
		else
			System.out.println("Please enter what you'd like to throw. *throw ITEM*");
	}//end throwCommand
	
	public void goThrough(String arg) {
		if(arg.length() > 0)
			System.out.printf("\nThe 'introduction' commanded was called with %s.", arg);
		else
			System.out.println("Please enter what you'd like to go through. *go through THING*");
	}//end goThrough
	
	public void quit() {
		System.out.println("\nThe 'quit' command was called.");
		System.exit(0);
	}//end quit
	
	public void introduction() {
		System.out.println("\nWelcome to the game! Currently you can enter commands that don't do anything too exciting. A true game experience to follow in Project 7...");
	}//end introduction
	
}//end class
