package ProgrammingAssignment;

public class Deposit {
private DepositType type;
private String employeeID;

public Deposit(int acctID, int amt, DepositType type){
	this.type=type;
	@TODO
}
public Deposit (String acctID, double cashAmount){
	if (cashAmount<0) {
		throw new InvalidDataException("Amount cannot be less than zero.");
		}
	
	/*BankAccount account = findAccount(acctID);  //to static and bank
	account.getbalance()=(relevant.getbalance()+amount);  
	*/
}
public DepositType getDepositType(){
	return type;
}

public Deposit(String accountID, double totalAmount, CheckDeposit[]) {
	if(totalAmount<0) {
		throw new InvalidDataException("Amount cannot be less than zero.");
	}
	type = DepositType.check;//
	//in bankaccount add checkdeposits to Transactions
	
}






}
