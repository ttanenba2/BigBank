package ProgrammingAssignment;

import java.io.IOException;

public class Deposit extends Transaction {
//private DepositType type; //only this its transtype not deposti type
private String employeeID;
//private double totalamount;
private DepositType depositType;
private CheckDeposit[] checkDeposits;  //it could be null


//extends for actid?

public Deposit(String accountID, int totalAmount, CheckDeposit[] checkDeposits) throws IOException{
	super(accountID, totalAmount, TransType.DEPOSIT);
	this.depositType = DepositType.check;   //bc its just checkdeposits
	this.checkDeposits = checkDeposits; //shallow copy
}

public Deposit(String accountID, double cashAmount ) throws IOException {
	super(accountID, cashAmount, TransType.DEPOSIT);
	this.depositType = DepositType.cash;
}
public Deposit(String accountID, double totalAmount, CheckDeposit[] checkDeposits, double cashAmount) throws IOException {
	super(accountID, totalAmount, TransType.DEPOSIT);
	this.checkDeposits = checkDeposits;// shallow copy
	this.depositType = DepositType.mixed;
	
}

public DepositType getDepositType(){
	return depositType;
}
public CheckDeposit[] getCheckDeposits() {//added
	return this.checkDeposits;
}







//public Deposit (String acctID, double cashAmount){
	//if (cashAmount<0) {
	//	throw new InvalidDataException("Amount cannot be less than zero.");
	//	}
	
	/*BankAccount account = findAccount(acctID);  //to static and bank
	account.getbalance()=(relevant.getbalance()+amount);  
	*/
//}


/*public Deposit(String accountID, double totalAmount, CheckDeposit[]) {
	if(totalAmount<0) {
		throw new InvalidDataException("Amount cannot be less than zero.");
	}
	type = DepositType.check;//
	//in bankaccount add checkdeposits to Transactions
	
}*/






}
