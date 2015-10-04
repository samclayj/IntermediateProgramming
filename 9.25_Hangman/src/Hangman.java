import java.util.Scanner;

public class Hangman {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String[] words = {"program", "dog", "cat", "parrot", "paradigm", "everyone", "cake", "calculator",
				"watch", "palindrome"};
		int randomIndex = (int) ((Math.random() * words.length));
		
		String gameWord = words[randomIndex];

		StringBuilder gameWordMod = new StringBuilder();
		
		for(int i = 0; i < gameWord.length(); i++) {
			gameWordMod.append('*');
		}
		
		boolean correctGuess = false;
		
		String guess = "";
		int tries = 0;
		while(!correctGuess) {
			System.out.print("\n(guess) enter a letter in word " + gameWordMod + " > ");
			guess = input.next();
			int previousIndex = 0;
			int currentIndex = 0;
			for(int i = 0; i < gameWord.toCharArray().length; i++) {
				currentIndex = gameWord.indexOf(guess.toCharArray()[0], previousIndex);
				if(currentIndex != -1) {
					gameWordMod.setCharAt(currentIndex, guess.toCharArray()[0]);
					previousIndex = currentIndex + 1;
				}//end if
			}//end for
			if(gameWordMod.indexOf("*") == -1)
				correctGuess = true;
			else
				tries++;
		}//end while
		System.out.printf("\nYou won! It took %d tries.", tries);
	
	}//end main

}//end class
