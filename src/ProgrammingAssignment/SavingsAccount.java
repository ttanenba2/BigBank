package ProgrammingAssignment;

import java.time.*;

public class SavingsAccount extends BankAccount implements Accruable {
	private Interval interestInterval;
	private double interestEarned;
	
	public SavingsAccount(String accountID, double initialDeposit, Customer customer)  {  //Interval interestInterval)added parameters
		super(accountID, initialDeposit, customer);
		//where do you set the instance variables
	}
	public void getInterestPosted(Month month, int year ) {//month is int or enum?
		//super.deposit(new InterestPosting(month, year); // Transactions.addmade transactions protected*, = initialDeposit * INTERERESTRATE;
		
	
	}
	public void getInterestPosted(LocalDate startDate, LocalDate endDate) {
		super.deposit(new InterestPosting(startDate, endDate))
	}

}
