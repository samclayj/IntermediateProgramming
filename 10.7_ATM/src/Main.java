import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		Account[] accountArr = new Account[10];
		
		for(int i = 0; i < 10; i++) {
			accountArr[i] = new Account(i, 100);
		}//end for
		
		Account chosenAccount = new Account();
		boolean goodId = false;
		while(!goodId) {
			System.out.print("Enter an id: ");
			int id = input.nextInt();
			if(id >= 0 && id <= accountArr.length - 1) {
				chosenAccount = accountArr[id];
				goodId = true;
			}//end if
		}//end while
		
		int userSelection = 0;
		while(userSelection != 4) {
			System.out.printf("\nMain Menu\n \n1: Check balance \n2: Withdraw \n3: Deposit \n4: Exit");
			System.out.printf("\nEnter a choice: ");
			userSelection = input.nextInt();
			switch (userSelection) {
				case 1:
					System.out.printf("\nThe balance is $%.2f.", chosenAccount.getBalance());
					break;
				case 2:
					System.out.printf("\nEnter the amount to withdraw: ");
					chosenAccount.withdraw(input.nextDouble());
					break;
				case 3:
					System.out.printf("\nEnter the amount to deposit: ");
					chosenAccount.deposit(input.nextDouble());
					break;
				case 4:
					break;
				default:
					System.out.printf("\nNo such option.");
					break;
			}//end switch
		}//end while
		
	}//end main

}//end class
