
public class Main {

	public static void main(String[] args) {
		int[] qs = {-1, -1, -1, -1};
		
		
		
	}
	
	public static boolean solveQueen(int[] board, int row) {
		boolean solved = false;
		boolean didWork;
		for(int i = 0; i < board.length; i++) {
			if(checkBoard(board)) {
				didWork = solveQueen(board, row + 1);
				if(didWork == false)
					board[row] = -1;
			}
			else
				board[row] = -1;
		}//end for
		
		if(board[board.length - 1] == -1)
			solved = false;
			
		if(solved)
			printBoard(board);
			
		return solved;
	}
	
	public static boolean checkBoard(int[] b) {
		boolean check = false;
		
		//Check for Q on same column as another Q. If 1D array has same number as another portion of 1D array, 
		//Q is on same column.
		for(int i = 0; i < b.length; i++) {
			int count = 0;
			for(int j = 0; j < b.length; j++) {
				if(b[i] == b[j])
					count++;
				if(count > 1)
					check = true;
			}
		}
		
		return check;
	}
	
	public static void printBoard(int[] b) {
		
	}
	
}
