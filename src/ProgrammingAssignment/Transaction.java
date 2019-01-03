package ProgrammingAssignment;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.*;
import java.util.Scanner;

public class Transaction {
	private long lastTransactionID;
	private String accountID;
	private double transAmount;
	private LocalDate transDate;
	private long transID;
	private TransType transType;
	private Scanner scan;
	
	public Transaction() {
		
		//get transid form file
		File file=new File("c:/transactionIDs.txt");//I couldnt save files ther
		
		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lastTransactionID=scan.nextLong();
	}
	
	public String getAccountID() {
		return accountID;
	}
	public double getTransAmount() {
		return transAmount;
	}
	public LocalDate getTransDate() {
		return transDate;
	}
	public long getTransID() {
		return transID;
	}
	public TransType getTransType() {
		return transType;
	}
	

}
