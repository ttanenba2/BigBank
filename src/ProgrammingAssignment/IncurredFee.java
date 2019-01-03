package ProgrammingAssignment;
import java.time.*;
public class IncurredFee extends fee{
	
	private String accountID;
	private LocalDate feeDate;
	
	public IncurredFee(String accountID, FEETYPE feeType, double amount ) {
		super(feeType, amount);
		feeDate = LocalDate.now();
		this.accountID = accountID;
	}
	
	public String getAccountID() {
		return accountID;
	}
	public LocalDate getFeeDate() {
		return feeDate;
	}
	
	

}
