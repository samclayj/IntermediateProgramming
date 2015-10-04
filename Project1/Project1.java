import java.util.Scanner; //Scanner import
import java.io.*; //Necessary file error import

public class Project1 {
  public static void main(String[] args) throws IOException {
    //Create Scanner 
    Scanner numberFile = new Scanner(new File("project1.txt"));
    
    //Print name
    System.out.println("Samuel Jentsch");
    
    //Create array
    int[] numArray = new int[50];
    
    int total = 0;
    for(int i = 0; i < numArray.length; i++) {
      numArray[i] = numberFile.nextInt();
      total += numArray[i];
    }//end for
    
    for(int i = 0; i < numArray.length - 1; i++) { //Iterate from first index, to one before last
      int min = numArray[i]; //Set the minimum to the next index each iteration to compare
      int minIndex = i;//Set minIndex to the current index being checked
      for(int j = i + 1; j < numArray.length; j++) { //start the j loop one ahead of i since i is the one being compared. Check all the way to the last index
        //Note: if j didn't equal i + 1 the loop would check the already ordered min numbers which would cause the order to incorrectly change.
        if(min > numArray[j]) {//if the current min is higher, a new minimum has been found
          min = numArray[j];//set min to the new minimum number
          minIndex = j;//set the minIndex to the index corresponding to the new minimum number
        }//end if
      }//end for
      
      if(minIndex != i) {//if the minIndex does not equal i, it means a new min has been found
        numArray[minIndex] = numArray[i];//put the new minimum in the array at minIndex, the index of the minimum number that will now be switched into i so that it is reordered.
        numArray[i] = min;//set numArray at i to min, this sets the index currently being compared to the new found minimum number
      }//end if
    }//end for
    
    for(int i = 0; i < numArray.length; i++) {
      System.out.print(numArray[i] + " ");
    }//end for
    
    //Print lowest
    System.out.println("\nLowest number is " + numArray[0] + ".");
    
    //Print highest
    System.out.println("Highest number is " + numArray[numArray.length - 1] + ".");
    
    //Print average
    System.out.println("Average is " + (total / (double)numArray.length) + ".");
    
  }//end main
}//end class