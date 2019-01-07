package ProgrammingAssignment;

import java.io.IOException;

public class Withdrawal extends Transaction {
public Withdrawal (String acctID, double amt) throws IOException{
	super(acctID, amt, TransType.WITHDRAWAL);
	//this.accountID=acctID;
	//this.transAmount=amt;
}
}
