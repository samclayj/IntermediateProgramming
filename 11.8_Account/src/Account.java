import java.util.*;

public class Account {
	
	/***Data Fields***/
	private int id = 0;
	private double balance = 0;
	private double annualInterestRate = 0;
	private Date dateCreated;
	
	private String name;
	ArrayList<Transaction> transactions;
	/*****************/

	/***Constructor Methods***/
	public Account() {
		dateCreated = new Date();
		transactions = new ArrayList<Transaction>();
	}//end Account
	
	public Account(int userID, double userBalance) {
		id = userID;
		balance = userBalance;
		dateCreated = new Date();
		transactions = new ArrayList<Transaction>();
	}//end Account(default values)
	
	public Account(String name, int userId, double userBalance) {
		setName(name);
		setID(userId);
		setBalance(userBalance);
		dateCreated = new Date();
		transactions = new ArrayList<Transaction>();
	}//end Account with name
	
	/***Setter and Getter Methods***/
	public int getID() {
		return id;
	}//end getID
	
	public void setID(int newID) {
		id = newID;
	}//end setID
	
	public double getBalance() {
		return balance;
	}//end getBalance
	
	public void setBalance(double newBalance) {
		balance = newBalance;
	}//end setBalance
	
	public double getAnnualInterestRate() {
		return annualInterestRate*100;
	}//end getAnnualInterestRate
	
	public void setAnnualInterestRate(double newInterestRate) {
		annualInterestRate = newInterestRate/100;
	}//end setAnnualInterestRate
	
	public Date getDateCreated() {
		return dateCreated;
	}//end getDateCreated
	
	public void setName(String name) {
		this.name = name;
	}//end setName
	
	public String getName() {
		return this.name;
	}//end getName
	
	/***Methods***/
	public double getMonthlyInterestRate() {
		return (annualInterestRate / 12.0);
	}//end getMonthlyInterestRate
	
	public double getMonthlyInterest() {
		return (balance * getMonthlyInterestRate());
	}//end getMonthlyInterest
	
	public void withdraw(double amount, String description) {
		this.balance -= amount;
		transactions.add(new Transaction('W', amount, this.balance, description));
	}//end withdraw
	
	public void deposit(double amount, String description) {
		this.balance += amount;
		transactions.add(new Transaction('D', amount, this.balance, description));
	}//end deposit
	
}//end class
