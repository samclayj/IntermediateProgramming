import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Scanner;

public class Maze2 {

	final static int UP = 0;
	final static int DOWN = 1;
	final static int LEFT= 2;
	final static int RIGHT = 3;
	
	public static ArrayList<char[][]> solutions;
	
	public static void main(String[] args) {

		System.out.println("Samuel Jentsch");

		//get current directory
		File direct = new File(".");

		//get all of the files matching maze.* in the current directory
		File[] files = direct.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.toLowerCase().matches("maze.*.txt");
			}
		});

		//Check if files were found
		if(files.length == 0) {
			System.out.println("No Files were found.");
			System.exit(0);
		}

		//Load the maze into a char[][] array and start the maze solver for each file
		for(int k = 0; k < files.length; k++) {
			File mazeFile = files[k];
			try {
				Scanner mazeFileReader = new Scanner(mazeFile);
				ArrayList<String> fileStrings = new ArrayList<String>();

				while(mazeFileReader.hasNext())
					fileStrings.add(mazeFileReader.nextLine());

				char[][] charArray = new char[fileStrings.size()][fileStrings.get(0).length()];

				//Populate array and save starting index
				Point sIndex = new Point();
				for(int i = 0; i < charArray.length; i++) {
					String str = fileStrings.get(i);
					char[] cArr = str.toCharArray();
					for(int j = 0; j < cArr.length; j++) {
						charArray[i][j] = cArr[j];
						if(Character.toUpperCase(cArr[j]) == 'S') {
							//Save starting index
							sIndex.x = i;
							sIndex.y = j;
						}//end if
					}//end inner for
				}//end for
				System.out.println("Solving: ");
				printCharArray(charArray);
				
				refreshSolutions();
				solveAllMazes(charArray, sIndex, new int[] {UP, DOWN, LEFT, RIGHT});
				/*for(char[][] c: solutions)
					printCharArray(c);*/
				optimalSolution();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}	
		}
	}//end main

	public static void solveAllMazes(char[][] maze, Point index, int[] spaces) {
		//printCharArray(maze);
		for(int i = 0; i < spaces.length ; i++) {
			switch(spaces[i]) {
			case UP:
				solveMaze(cloneMaze(maze), new Point(index.x - 1, index.y));
				break;
			case DOWN:
				solveMaze(cloneMaze(maze), new Point(index.x + 1, index.y));
				break;
			case LEFT:
				solveMaze(cloneMaze(maze), new Point(index.x, index.y - 1));
				break;
			case RIGHT:
				solveMaze(cloneMaze(maze), new Point(index.x, index.y + 1));
				break;
			default:
			}//end switch
		}//end for
	}

	public static void solveMaze(char[][] maze, Point index) {
		boolean solved = false;
		
		int[] spaceArray = {-1, -1, -1, -1};

		if(index.x < 0 || index.x > maze.length - 1)
			return;
		else if(index.y < 0 || index.y > maze[0].length - 1)
			return;
		else if(maze[index.x][index.y] == ' ')
			maze[index.x][index.y] = 'H';

		//Base case
		//check up
		if(index.x - 1 >= 0)
			if(maze[index.x - 1][index.y] == 'E') { 
				solutions.add(cloneMaze(maze));
				solved = true;
			}
		//check down
		if(index.x + 1 < maze.length - 1)
			if(maze[index.x + 1][index.y] == 'E') {
				solutions.add(cloneMaze(maze));
				solved = true;
			}
		//check right
		if(index.y + 1 < maze[0].length - 1)
			if(maze[index.x][index.y + 1] == 'E') {
				solutions.add(cloneMaze(maze));
				solved = true;
			}
		//check left
		if(index.y - 1 >= 0)
			if(maze[index.x][index.y - 1] == 'E') {
				solutions.add(cloneMaze(maze));
				solved = true;
			}

		if(solved)
			return;
		
		//Try moves
		//check up
		if(index.x - 1 >= 0)
			if(maze[index.x - 1][index.y] == ' ') 
				spaceArray[0] = UP;
		//check down
		if(index.x + 1 < maze.length - 1)
			if(maze[index.x + 1][index.y] == ' ') 
				spaceArray[1] = DOWN;
		//check left
		if(index.y - 1 >= 0)
			if(maze[index.x][index.y - 1] == ' ') 
				spaceArray[2] = LEFT;
		//check right
		if(index.y + 1 < maze[0].length - 1)
			if(maze[index.x][index.y + 1] == ' ') 
				spaceArray[3] = RIGHT;

		boolean noSpace = true;
		for(int i = 0; i < spaceArray.length; i++) 
			if(spaceArray[i] != -1) {
				noSpace = false;
				break;
			}
		
		if(noSpace == false)
			solveAllMazes(cloneMaze(maze), (Point)index.clone(), spaceArray.clone());
	}

	public static char[][] cloneMaze(char[][] cArr) {
		//Perform a deep copy
		char[][] cTemp = new char[cArr.length][cArr[0].length];
		for(int i = 0; i < cArr.length; i++) {
			for(int j = 0; j < cArr[i].length; j++) {
				cTemp[i][j] = cArr[i][j];
			}
		}
		
		return cTemp;
	}
	
	public static void printCharArray(char[][] cArr) {
		for(int i = 0; i < cArr.length; i++) {
			for(int j = 0; j < cArr[i].length; j++) {
				System.out.print(cArr[i][j]);
			}
			System.out.println();
		}
	}//end printCharArray

	public static void refreshSolutions() {
		solutions = new ArrayList<char[][]>();
	}
	
	public static void optimalSolution() {
		//find best solution
		int max = countH(solutions.get(0));
		int min = max;
		int minIndex = 0;
		for(int i = 0; i < solutions.size(); i++) {
			min = countH(solutions.get(i));
			if(min > max) {
				min = max;
				minIndex = i;
			}
		}
		
		//print best solution
		char[][] optimal = solutions.get(minIndex);
		printCharArray(optimal);
	}//end optimalSolution
	
	public static int countH(char[][] cArr) {
		int count = 0;
		for(int i = 0; i < cArr.length; i++) {
			for(int j = 0; j < cArr[i].length; j++) {
				if(cArr[i][j] == 'H')
					count++;
			}
		}
		return count;
	}
}
