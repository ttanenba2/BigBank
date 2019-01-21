package ProgrammingAssignment;

import java.io.IOException;

public class CheckingAccount extends BankAccount{
	public CheckingAccount(String accountID, double initialDeposit, Customer customer) {
		super(accountID, initialDeposit, customer);
	}
	
	//er dont have an option to make checks
	public boolean cashCheck(Check check) throws IOException {//changes to account balance when this is added to other account will be done in bank or cld make this a boolean
		//this means here that the money is being taken out of this checkingAccount that issued the check if there is enough money if there isent then it returns false so that the otherr account can know to be charged a fee and this account is charged a fee
		//Transactions.add(new Transaction(getAccountID(), check.getAmount(), TransType.CHECK));
		if(getBalance()>=check.getAmount()) {
			withdrawal(check.getAmount());//take out the money
			return true; //will change it Deposited in bank
		}
		else {
			//addFee() 
			
			return false;
		}
		
	}
	//public String toString() {
	//	return super.toString() +"/n"
	//}
}
