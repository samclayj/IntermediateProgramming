/*Samuel Jentsch
 * Project2- Tic-Tac-Toe*/

import java.util.Scanner;

public class TicTacToe {
  
  public static void main(String[] args) {
    
    //Create array for board values
    char[][] board = initBoard();
    
    //Greet
    System.out.println("Welcome to Sam's Tic-Tac-Toe!");
    
    boolean didEnd = false;
    
    //Start game
    while(!didEnd) {
      board = getMove('X', board);
      didEnd = checkBoard(board);
      if(didEnd)
        break;
      board = getMove('O', board);
      didEnd = checkBoard(board);
      if(didEnd)
        break;
    }//end while game
    
    System.out.println("Thanks for playing!");
    
  }//end main
  
  public static char[][] initBoard() { 
    //create array
    char[][] b = new char[3][3];   
    //fill board with spaces
    for(int i = 0; i < b.length; i++) {
      for (int j = 0; j < b[i].length; j++) {
        b[i][j] = ' ';
      }//end for
    }//end for  
    
    return b;
  }//end initBoard
  
  public static void printBoard(char[][] b) {
    
    System.out.printf("-------------\t-------------");
    System.out.printf("\n| %c | %c | %c |\t| 1 | 2 | 3 |", b[0][0], b[0][1], b[0][2]);
    System.out.printf("\n| %c | %c | %c |\t| 4 | 5 | 6 |", b[1][0], b[1][1], b[1][2]);
    System.out.printf("\n| %c | %c | %c |\t| 7 | 8 | 9 |", b[2][0], b[2][1], b[2][2]);
    System.out.printf("\n-------------\t-------------");
    
  }//end printBoard
  
  public static char[][] getMove(char player, char[][] b) {
    //player is either X or O.
    Scanner input = new Scanner(System.in);
    
    int move;
    int[] convertedMove;
    boolean goodMove = false;
    
    if(player == 'X') {
      while(!goodMove) {
      System.out.println("\nIt is X's turn: ");
      printBoard(b);
      System.out.println();
      move = input.nextInt();
      convertedMove = convertChoice(move);
      goodMove = checkSpace(convertedMove, b);
      if(!goodMove) {
       System.out.println("Sorry, that was an invalid move.");
      }//if
      else {
        b[convertedMove[0]][convertedMove[1]] = 'X';
        goodMove = true;
      }//end else
      }//end while
      return b;
    }//end if player X
    
    else if(player == 'O') {
      while(!goodMove) {
      System.out.println("\nIt is O's turn: ");
      printBoard(b);
      System.out.println();
      move = input.nextInt();
      convertedMove = convertChoice(move);
      goodMove = checkSpace(convertedMove, b);
      if(!goodMove) {
       System.out.println("Sorry, that was an invalid move.");
      }//if
      else {
        b[convertedMove[0]][convertedMove[1]] = 'O';
        goodMove = true;
      }//end else
      }//end while
      return b;
    }//end else if player O
    
    return b;
    
  }//end getMove
  
  public static int[] convertChoice(int choice) {
    //convert 1-9 into board[i][j] index
    int[] indices = new int[2];
    switch (choice) {
      case 1:
        indices[0] = 0;
        indices[1] = 0;
        break;
      case 2:
        indices[0] = 0;
        indices[1] = 1;
        break;
      case 3:
        indices[0] = 0;
        indices[1] = 2;
        break;
      case 4: 
        indices[0] = 1;
        indices[1] = 0;
        break;
      case 5:
        indices[0] = 1;
        indices[1] = 1;
        break;
      case 6:
        indices[0] = 1;
        indices[1] = 2;
        break;
      case 7:
        indices[0] = 2;
        indices[1] = 0;
        break;
      case 8:
        indices[0] = 2;
        indices[1] = 1;
        break;
      case 9:
        indices[0] = 2;
        indices[1] = 2;
        break;
      default:
        indices[0] = -1;
        indices[1] = -1;     
    }//end switch
    
    return indices;
    
  }//end convertChoice
  
  public static boolean checkSpace(int[] move, char[][] b) {
    //Check to see if user entered invalid move or if space is already filled. The passed array will contatin {-1,-1} if invalid move was entered.
    //return true if move is ok.
    
    if(move[0] == -1 || move[1] == -1) {
      //Invalid move entered
      return false;
    }//end check invalid
     else if(b[move[0]][move[1]] == ' ') {
      //Space chosen is empty, move is ok.
      return true;
    }//end if
    else {
      //Space chosen is already filled
      return false;
    }//end else
    
  }//end checkSpace
  
  public static boolean checkBoard(char[][] b) {
    
    for(int cCheck = 0; cCheck < b.length; cCheck++) {
      
      /***Check for winner by 3 in a row on columns***/
      char d = b[0][cCheck];
      char e = b[1][cCheck];
      char f = b[2][cCheck];
      
      if((d == e) && (e == f) && (d == f) && (d == 'X' || d == 'O')) {
       //Someone won
        printBoard(b);
        if(d == 'X')
          System.out.println("\nPlayer X won!");
        else
          System.out.println("\nPlayer O won!");
        return true;
      }  
      
      /***Check for winner by 3 in a row on rows***/
      d = b[cCheck][0];
      e = b[cCheck][1];
      f = b[cCheck][2];
      
      if((d == e) && (e == f) && (d == f) && (d == 'X' || d == 'O')) {
       //Someone won
        printBoard(b);
        if(d == 'X')
          System.out.println("\nPlayer X won!");
        else
          System.out.println("\nPlayer O won!");
        return true;
      }  
      
      /***Check for winner by 3 in a row diagonal (left to right)***/
      d = b[0][0];
      e = b[1][1];
      f = b[2][2];
      
      if((d == e) && (e == f) && (d == f) && (d == 'X' || d == 'O')) {
       //Someone won
        printBoard(b);
        if(d == 'X')
          System.out.println("\nPlayer X won!");
        else
          System.out.println("\nPlayer O won!");
        return true;
      }  
      
      /***Check for winner by 3 in a row diagonal (right to left)***/
      d = b[2][0];
      e = b[1][1];
      f = b[0][2];
      
      if((d == e) && (e == f) && (d == f) && (d == 'X' || d == 'O')) {
       //Someone won
        printBoard(b);
        if(d == 'X')
          System.out.println("\nPlayer X won!");
        else
          System.out.println("\nPlayer O won!");
        return true;
      }  
      
    }//end for
    
    //Check for draw
      int dCount = 0;
      for(char[] space: b) {
        for(char element: space) {
          if(element != ' ')
            dCount++;
        }//end for
      }//end for
      
      if(dCount >= 9) {
        printBoard(b);
        System.out.println("\nYou have a draw!");
        return true;
      }//end if
    
    System.out.println("\nContinue playing.");
      
    return false;

  }//end checkBoard
  
}//end class