package ProgrammingAssignment;

import java.io.IOException;

public class Transfer  extends Transaction  {
private String toAccountID;
//private String fromAccountID; //in other places I did accountid as int so hv to fix that
//private double amount;
public Transfer (String fromAcctID, String toAcctID, double amt) throws IOException{
	super(fromAcctID, amt, TransType.TRANSFER);  //Im switchin transaction back to recieve this for now bc it has instance variables for them how r there getters with no way of setting them
	this.toAccountID=toAcctID;
	
	//this.fromAccountID=fromAcctID;
	//this.amount=amt;
}
//getters and setters...
public String toString() {
	return super.toString() +"/nTransfer from Account " + super.getAccountID() + " to Account " + toAccountID;
}
}
