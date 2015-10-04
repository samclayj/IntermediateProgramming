import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Account userAccount = new Account("George", 1122, 1000);
		userAccount.setAnnualInterestRate(1.5);
		
		userAccount.deposit(30.0, "Check");
		userAccount.deposit(40.0, "Refund");
		userAccount.deposit(50.0, "Return");
		
		userAccount.withdraw(5.0, "Lunch");
		userAccount.withdraw(4.0, "Drink");
		userAccount.withdraw(2.0, "Gum");
		
		System.out.printf("Account %d, Name %s", userAccount.getID(), userAccount.getName());
		System.out.printf("\nBalance: $%.2f", userAccount.getBalance());
		System.out.printf("\nMonthly interest rate: %%%.4f", userAccount.getMonthlyInterestRate()*100);
		System.out.printf("\nMonthly interest amount: $%.2f", userAccount.getMonthlyInterest());
		System.out.printf("\nDate created: %s", (userAccount.getDateCreated()).toString());
		
		for(int i = 0; i < userAccount.transactions.size(); i++) {
		
			System.out.printf("\n\nType: %c", userAccount.transactions.get(i).getType());
			System.out.printf("\nDate of transaction: %s", userAccount.transactions.get(i).getDate().toString());
			System.out.printf("\nAmount of transaction: %.2f", userAccount.transactions.get(i).getAmount());
			System.out.printf("\nBalance after transaction: %.2f", userAccount.transactions.get(i).getBalance());
			System.out.printf("\nDescription: %s", userAccount.transactions.get(i).getDescription());
			
		}
		
	}//end main
	
}
