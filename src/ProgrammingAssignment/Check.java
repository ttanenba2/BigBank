package ProgrammingAssignment;
import java.time.*;

public class Check {
	private String accountID;
	private double amount;
	private int checkNum;
	private LocalDate dateProcessed;
	private String description;
	
	public Check(String accountID, int checkNum, double amount,  String description) {//LocalDate date,
		this.accountID = accountID;
		this.amount =amount;
		this.checkNum= checkNum;
		dateProcessed = LocalDate.now();
		this.description = description;
	}
	public String getAccountID() {
		return accountID;
	}
	public double getAmount() {
		return amount;
	}
	public int getCheckNum() {
		return checkNum;
	}
	public LocalDate getDateProcessed() {
		return dateProcessed;
	}
	public String getDescription() {
		return description;
	}

}
