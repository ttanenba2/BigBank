package ProgrammingAssignment;

import java.io.IOException;

public class Deposit extends Transaction {
//private DepositType type; //only this its transtype not deposti type
private String employeeID;
//private double totalamount;
private DepositType depositType;
private CheckDeposit[] checkDeposits;  //it could be null
private double cashAmount;


//extends for actid?

public Deposit(String accountID, double totalAmount, CheckDeposit[] checkDeposits) throws IOException{
	super(accountID, totalAmount, TransType.DEPOSIT);
	this.depositType = DepositType.check;   //bc its just checkdeposits
	this.checkDeposits = checkDeposits; //shallow copy
}

public Deposit(String accountID, double cashAmount ) throws IOException {
	super(accountID, cashAmount, TransType.DEPOSIT);
	this.depositType = DepositType.cash;
	this.cashAmount = cashAmount;
}
public Deposit(String accountID, double totalAmount, CheckDeposit[] checkDeposits, double cashAmount) throws IOException {
	super(accountID, totalAmount, TransType.DEPOSIT);
	this.checkDeposits = checkDeposits;// shallow copy
	this.depositType = DepositType.mixed;
	this.cashAmount = cashAmount;
	
}

public DepositType getDepositType(){
	return depositType;
}
public CheckDeposit[] getCheckDeposits() {//added
	return this.checkDeposits;
}
public String toString() {
	StringBuilder build = new StringBuilder();
	build.append(super.toString()+"/n");
	build.append("Deposit Type: " + depositType+"/n");
	if(checkDeposits!=null) {
		for(CheckDeposit cd: checkDeposits) {
			build.append(cd.toString() +"/n");
		}
	}
	if(cashAmount!=0) build.append("Cash Amount: " + cashAmount);
	return build.toString();
	
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
