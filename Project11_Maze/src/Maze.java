import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Scanner;

public class Maze {
	public static ArrayList<char[][]> solutions;

	public static void main(String[] args) {

		System.out.println("Samuel Jentsch");

		System.out.println("This program only prints out the optimal solution to a given maze.");

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
				solveMaze(charArray, sIndex);
				optimalSolution();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}	
		}
	}//end main

	public static void solveMaze(char[][] maze, Point index) {
		boolean notSolved = true;
		if(index.x - 1 >=0)
			if(maze[index.x - 1][index.y] == 'E') { 
				solutions.add(cloneMaze(maze));
				notSolved = false;
			}
		//check down
		if(index.x + 1 < maze.length)
			if(maze[index.x + 1][index.y] == 'E') {
				solutions.add(cloneMaze(maze));
				notSolved = false;
			}
		//check right
		if(index.y + 1 < maze[0].length)
			if(maze[index.x][index.y + 1] == 'E') {
				solutions.add(cloneMaze(maze));
				notSolved = false;
			}
		//check left
		if(index.y - 1 >= 0)
			if(maze[index.x][index.y - 1] == 'E') {
				solutions.add(cloneMaze(maze));
				notSolved = false;
			}
		
		if(notSolved == false)
			return;

		//Try moves
			//check up
			if(index.x - 1 >= 0)
				if(maze[index.x - 1][index.y] == ' ') { 
					char[][] temp = cloneMaze(maze);
					temp[index.x - 1][index.y] = 'H';
					Point newIndex = new Point(index.x - 1, index.y);
					solveMaze(temp, newIndex);
				}
			//check down
			if(index.x + 1 < maze.length - 1)
				if(maze[index.x + 1][index.y] == ' ') {
					char[][] temp = cloneMaze(maze);
					temp[index.x + 1][index.y] = 'H';
					Point newIndex = new Point(index.x + 1, index.y);
					solveMaze(temp, newIndex);
				}
			//check right
			if(index.y + 1 < maze[0].length - 1)
				if(maze[index.x][index.y + 1] == ' ') {
					char[][] temp = cloneMaze(maze);
					temp[index.x][index.y + 1] = 'H';
					Point newIndex = new Point(index.x, index.y + 1);
					solveMaze(temp, newIndex);
				}
			//check left
			if(index.y - 1 >= 0)
				if(maze[index.x][index.y - 1] == ' ') {
					char[][] temp = cloneMaze(maze);
					temp[index.x][index.y - 1] = 'H';
					Point newIndex = new Point(index.x, index.y - 1);
					solveMaze(temp, newIndex);
				}
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
		int minimum = countH(solutions.get(0));
		int current = minimum;
		int minIndex = 0;
		for(int i = 0; i < solutions.size(); i++) {
			current = countH(solutions.get(i));
			if(current < minimum) {
				minimum = current;
				minIndex = i;
			}
		}
		
		//print best solution
		char[][] optimal = solutions.get(minIndex);
		System.out.println("Optimal: ");
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
