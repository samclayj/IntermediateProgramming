import java.util.*;

public class TowersOfHanoi {
static long numMoves = 0;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("enter number of disks: ");
		int n = input.nextInt();
		
		System.out.println("The moves are: ");
		moveDisks(n, 'A', 'B', 'C');
		System.out.println("Number of moves: " + numMoves);
	}
	
	public static void moveDisks(int n, char fromTower, char toTower, char auxTower) {
		numMoves++;
		if(n == 1)  { //stopping condition
			System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
		}
		else {
			moveDisks(n - 1, fromTower, auxTower, toTower);
			System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
			moveDisks(n - 1, auxTower, toTower, fromTower);
		}
		
	}
	
	
	
}
