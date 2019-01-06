package ProgrammingAssignment;

import java.io.IOException;

public class Transfer  extends Transaction  {
private String toAccountID;
//private String fromAccountID; //in other places I did accountid as int so hv to fix that
//private double amount;
public Transfer (String fromAcctID, String toAcctID, double amt) throws IOException{
	super(fromAcctID, amt);  //Im switchin transaction back to recieve this for now bc it has instance variables for them how r there getters with no way of setting them
	//this.fromAccountID=fromAcctID;
	this.toAccountID=toAcctID;
	//this.amount=amt;
}
//getters and setters... 
}
