package ProgrammingAssignment;
import java.time.*;
/////////////??
public class CDAccount extends SavingsAccount{
	private LocalDate maturityDate;
	private InterestRate interestRate;
	public CDAccount (String accountID, double initialDeposit, Customer customer,
			Interval interestInterval, double interestEarned, LocalDate maturityDate, InterestRate interestRate) {
		super(accountID, initialDeposit, customer, interestInterval, interestEarned);
		this.maturityDate = maturityDate;
		this.interestRate = interestRate;
	}
	//getters?

	public InterestRate getInterestRate() {
		return interestRate;
	}
}
