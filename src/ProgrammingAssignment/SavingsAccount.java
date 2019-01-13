package ProgrammingAssignment;

import java.io.IOException;
import java.time.*;
import java.util.ArrayList;
//INCOMPLETE//***************************
public class SavingsAccount extends BankAccount implements Accruable {
	private Interval interestInterval;
	private double interestEarned;
	
	public SavingsAccount(String accountID, double initialDeposit, Customer customer,
			Interval interestInterval, double interestEarned)  {  //added parameters
		super(accountID, initialDeposit, customer);
		//where do you set the instance variables
		this.interestInterval = interestInterval;
		this.interestEarned = interestEarned;
	}
	public double getInterestPosted(Month month, int year ) {//month is int or enum?
		//super.deposit(new InterestPosting(month, year); 
		// Transactions.addmade transactions protected*, = initialDeposit * INTERERESTRATE; should make method to access it?
		//return something of type interestPosting??
		double total =0;
		for(Transaction t: Transactions) {  //only works bc Transactions is protected not private
			if(t.getTransType().equals(TransType.INTEREST) && t.getTransDate().getMonth().equals(month) 
					&&t.getTransDate().getYear()==year) {  //its void.. just makes interest and adds to transacion??
				//interestPostings.add(t);
				total+=t.getTransAmount();
			}
		}
		return total;
	}
	public double getInterestPosted(LocalDate startDate, LocalDate endDate) {
		//super.deposit(new InterestPosting(startDate, endDate))
		double total =0;
		//Period p 
		for(Transaction t: Transactions) {  //only works bc Transactions is protected not private
			if(t.getTransType().equals(TransType.INTEREST) && t.getTransDate().isAfter(startDate) //.isAfter(other)
					&&t.getTransDate().isAfter(endDate)) {  //its void.. just makes interest and adds to transacion??
				//interestPostings.add(t);
				total+=t.getTransAmount();
			}
		}
		return total;
		
	}
	public void postInterest(InterestRate interestRate, Interval interval) throws IOException {//interestRate is supposed to be a double or of type InterestRate
		Transactions.add(new InterestPosting(getAccountID(), interestRate, getBalance(), interval));//, TransType.INTEREST));
	}

	public Interval getInterval() {
		return interestInterval;
	}
}
