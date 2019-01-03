package ProgrammingAssignment;

public class Deposit {
private DepositType type;
private String employeeID;

public Deposit(int acctID, int amt, DepositType type){
	this.type=type;
	@TODO
}
public Deposit (String acctID, double amt){
	if (amt<0) {throw new InvalidDataException("Amount cannot be less than zero.");}
	BankAccount relevant=BigBank.findAccount(acctID);
	relevant.setCurrentBalance=(relevant.getCurrentBalance()+amount);
}
public DepositType getDepositType(){
	return type;
}
}
