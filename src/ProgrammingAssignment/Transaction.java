package ProgrammingAssignment;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.*;
import java.util.Scanner;

public class Transaction {
	private static long lastTransactionID=0;
	private String accountID;
	private double transAmount;
	private LocalDate transDate;
	private long transID;
	private TransType transType;
	private Scanner scan;
	
	public Transaction(){
		initializeTransactionID(C:\transactionID.txt);
		saveLastTransactionID(C:\transactionID.txt);
	}
	
	
	private void initializeTransactionID (string filename) throws IOException {
		try{
			File transIdFile=new File(filename);
		Scanner input=new Scanner(transIdFile);//open input file in a readable format
		lastTransactionID=input.nextInt();
	    this.transID=lasttransID++;
	}
catch (FileNotFoundException e){
	System.out.println("We cannot find that file. Please try again.");
}
	}
	
	
	private  void saveLastTransactionID(String filename) throws IOException{
		try{
			Integer chadash=lastTransactionID;
			FileWriter filewriter= new FileWriter(filename);
			filewriter.write(chadash);
			filewriter.close();
		}
	catch (FileNotFoundException	e){
		System.out.println("We cannot find that file. Please try again.");
	}
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
