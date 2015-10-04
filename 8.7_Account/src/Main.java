import java.util.*;

public class Main {

	public static void main(String[] args) {
		Account userAccount = new Account(1122, 20000);
		userAccount.setAnnualInterestRate(4.5);
		userAccount.withdraw(2500);
		userAccount.deposit(3000);
		System.out.printf("Account %d:", userAccount.getID());
		System.out.printf("\nBalance: $%.2f", userAccount.getBalance());
		System.out.printf("\nMonthly interest rate: %%%.4f", userAccount.getMonthlyInterestRate()*100);
		System.out.printf("\nMonthly interest amount: $%.2f", userAccount.getMonthlyInterest());
		System.out.printf("\nDate created: %s", (userAccount.getDateCreated()).toString());
		
	}//end main
	
}
