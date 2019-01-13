package ProgrammingAssignment;

import java.io.IOException;
/////////this could be done wrong, not sure what was supposed to be done
public class InterestPosting extends Transaction {
	private double interestRate;
	private double currentBalance;
	private Interval interval;
	public InterestPosting(String fromAccountID, InterestRate interestRate, double currentBalance, Interval interval) throws IOException {
		super(fromAccountID, currentBalance*interestRate.getRate(), TransType.INTEREST );
	}
	//public 
	

}
