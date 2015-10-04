import java.util.*;

public class Account {
	
	/***Data Fields***/
	private int id = 0;
	private double balance = 0;
	private double annualInterestRate = 0;
	private Date dateCreated;
	/*****************/
	
	/***Constructor Methods***/
	public Account() {
		dateCreated = new Date();
	}//end Account
	
	public Account(int userID, double userBalance) {
		id = userID;
		balance = userBalance;
		dateCreated = new Date();
	}//end Account(default values)
	
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
	
	/***Methods***/
	public double getMonthlyInterestRate() {
		return (annualInterestRate / 12.0);
	}//end getMonthlyInterestRate
	
	public double getMonthlyInterest() {
		return (balance * getMonthlyInterestRate());
	}//end getMonthlyInterest
	
	public void withdraw(double amount) {
		balance -= amount;
	}//end withdraw
	
	public void deposit(double amount) {
		balance += amount;
	}//end deposit
	
}//end class
