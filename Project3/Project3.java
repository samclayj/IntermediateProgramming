/*Project 3 Connect 4
 * Samuel Jentsch*/

import java.util.Scanner;

public class Project3 {
  
  public static void main(String[] args) {
    
    System.out.println("Samuel Jentsch");
      
    char[][] board = initBoard(); 

    printBoard(board);
    int status = 0;
    while(status == 0) {
      
      getMove('R', board);
      status = checkStatus(board);
      
      if(status == 0) {
      getMove('Y', board);
      status = checkStatus(board);
      }//end if
      
    }//end
    
  }//end main
  
  public static char[][] initBoard() {
    char[][] b = new char[6][7];
    
    for(int i = 0 ; i < b.length; i++) {
      for(int j = 0 ; j < b[i].length; j++)
        b[i][j] = ' ';
    }//end for
    
    return b;
 
  }//end initBoard
  
  public static void printBoard(char[][] b) {
    for(int i = b.length-1; i >= 0; i--) {
      for(int j = 0; j < b[i].length; j++) {
        System.out.printf("| %c ", b[i][j]);
      }//end for
      System.out.printf("|\n");
    }//end for
    System.out.printf("-----------------------------");
  }//end printBoard
  
  public static void getMove(char player, char[][] b) {
    
    Scanner input = new Scanner(System.in);
    int column = 0;
    boolean isInvalid = true;
    
    if(player == 'R') {
      while(isInvalid == true) {
      System.out.print("\nDrop a red disk at column 0-6: ");
      column = input.nextInt();
      isInvalid = executeMove(column, 'R', b);
      printBoard(b);
      }//end while
    }//end R move
    else {
      while(isInvalid == true) {
      System.out.print("\nDrop a yellow disk at column 0-6: ");
      column = input.nextInt();
      isInvalid = executeMove(column, 'Y', b);
      printBoard(b);
      }//end while
    }//end else Y move
    
  }//end getMove
  
  
  public static boolean executeMove(int move, char player, char[][] b) {
    
    if(!(move >= 0 && move <= 6)) {
      //Move is not within the range of the board
      System.out.println("Sorry, that was an invalid move.");
      return true;
    }//end if
    
    int i = 0;
    while(b[i][move] != ' ') {
      if(i + 1 < b.length) 
        i++;
      else {
        //Column chosen is already full
        System.out.println("Sorry, that was an invalid move.");
        return true;
      }//end else
    }//end while
    
    b[i][move] = player;
    
    System.out.println("Good move!");
    return false;
    
  }//end executeMove
  
  public static int checkStatus(char[][] b) {
    //Method returns 0 for (continue playing), 1 for Red win, 2 for Yellow win, 3 for draw
    
    int openSpaces = b.length * b[0].length;
    
    for(int i = 0; i < b.length; i++) {
      for(int j = 0; j < b[i].length; j++) {
        
        //Row check
        if((j + 3) < b[i].length)
          if((b[i][j] == b[i][j+1] && b[i][j] == b[i][j+2] && b[i][j] == b[i][j+3]) && (b[i][j] != ' '))
             switch (b[i][j]) {
               case 'R':
                System.out.println("\nRed player wins!");
                return 1;
               default:
                System.out.println("\nYellow player wins!");
                return 2;
             }//end switch
      
        //Column check
        if((i + 3) < b.length)
         if((b[i][j] == b[i+1][j] && b[i][j] == b[i+2][j] && b[i][j] == b[i+3][j]) && (b[i][j] != ' '))
             switch (b[i][j]) {
               case 'R':
                System.out.println("\nRed player wins!");
                return 1;
               default:
                System.out.println("\nYellow player wins!");
                return 2;
             }//end switch
          
       //Note: diagonal is opposite of what would be expected due to array being printed from the last to first i index
       //Diagonal right to left, bottom to top check
        if((i + 3) < b.length && (j + 3) < b[i].length)
         if((b[i][j] == b[i+1][j+1] && b[i][j] == b[i+2][j+2] && b[i][j] == b[i+3][j+3]) && (b[i][j] != ' '))
             switch (b[i][j]) {
               case 'R':
                System.out.println("\nRed player wins!");
                return 1;
               default:
                System.out.println("\nYellow player wins!");
                return 2;
             }//end switch
        
        //Diagonal right to left, top to bottom check
        if((i + 3) < b.length && (j - 3) >= 0)
         if((b[i][j] == b[i+1][j-1] && b[i][j] == b[i+2][j-2] && b[i][j] == b[i+3][j-3]) && (b[i][j] != ' '))
             switch (b[i][j]) {
               case 'R':
                System.out.println("\nRed player wins!");
                return 1;
               default:
                System.out.println("\nYellow player wins!");
                return 2;
             }//end switch
      
        //Each iteration subtracts from available open spaces if the space is filled.
        if(b[i][j] != ' ')
          openSpaces--;
        if(openSpaces == 0) {
         System.out.println("\nYou have a draw! Thanks for playing!"); 
         return 3;
        }
        
      }//end for
    }//end for
    
    System.out.println("\nContinue playing.");
    return 0;
    
  }//end checkStatus
  
}//end class