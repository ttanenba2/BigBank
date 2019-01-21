package ProgrammingAssignment;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(transType + " ID number " + transID +"/n");
		str.append("Date: " + transDate + "/n");
		str.append("Amount: " + transAmount);
	}
	public Transaction(String fromAccountID, double transAmount, TransType transType) throws IOException{  //added parameters for now
		initializeTransactionID("C:\transactionID.txt");
		saveLastTransactionID("C:\transactionID.txt");
		this.accountID = fromAccountID;
		this.transAmount = transAmount;
		
	}
	
	
	private void initializeTransactionID (String filename) throws IOException {
		try{
			File transIdFile=new File(filename);
		Scanner input=new Scanner(transIdFile);//open input file in a readable format
		lastTransactionID=input.nextInt();
	    this.transID=lastTransactionID++;
	}
catch (FileNotFoundException e){
	System.out.println("We cannot find that file. Please try again.");
}
	}
	
	
	private  void saveLastTransactionID(String filename) throws IOException{
		try{
			int chadash= (int)transID;//lastTransactionID; Integer
			FileWriter filewriter= new FileWriter(filename);
			filewriter.write(chadash);
			filewriter.close();
		}
	catch (FileNotFoundException	e){
		System.out.println("We cannot find that file. Please try again.");
	}
	}
	
	public Transaction getTransaction() {//added 1/20/19
		return this;
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
