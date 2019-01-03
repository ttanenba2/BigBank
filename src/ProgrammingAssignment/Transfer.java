package ProgrammingAssignment;

public class Transfer  extends Transaction  {
private String toAccountID;

public Transfer (String fromAcctID, String toAcctID, double amt){
	this.toAccountID=fromAcctID;
	this.toAccountID=toAcctID;
	this.transAmount=amt;
}
}
