package ProgrammingAssignment;
import java.time.*;

public class BankAccount {
private	String AccountID;
private Double initialBalance;
private Double currentBalance;	
private LocalDate accountOpened;
private Customer customer;

public BankAccount (String AccountID, Double initialBalance, Customer customer) 
{if (initialBalance<100){throw new InvalidDataException("Initial balance cannot be less than one hundred dollars.");}
this.initialBalance=initialBalance;
this.currentBalance=initialBalance;
this.accountOpened=LocalDate.now();
this.customer=customer;
}


public void deposit (Double amount){
	if (amount<0) {throw new InvalidDataException("Amount cannot be less than zero.");}
	this.currentBalance=this.currentBalance+amount;
}
public void withdrawal (Double amount){
	if (amount<0||amount>this.currentBalance){throw new InvalidDataException("Amount must be greater than zero and less than your current balance.");}
	this.currentBalance=currentBalance-amount;
}
public String getAccountID(){
	return this.AccountID;
}
public Double getBalance(){
	return this.currentBalance;
}
public String getCustFirstName(){
	return this.customer.getFirstName();
}
public String getCustLastName(){
	return this.customer.getLastName();
}
public String getCustSocialSecNum(){
	return this.customer.getSocialSecNum();
}
public Integer getCustID(){
	return this.customer.getCustomerID();
}
public Address getCustAddress(){
	return this.customer.getAddress();
}
public LocalDate getAccountOpen1date(){
	return this.accountOpened;
}
public double getInitialBalance(){
	return this.initialBalance;
}
@Override
public boolean equals (Object O){
	if (O==null){return false;}
	if (O instanceof BankAccount){
		BankAccount YY=(BankAccount)O;
		if (this.AccountID==YY.getAccountID()){
			return true;
		}
		else return false;
	}
	return false;
}

public int compareTo (BankAccount ba){
		return this.AccountID.compareTo(ba.getAccountID());
}
public String toString(){
	StringBuilder str=new StringBuilder();
	str.append(this.AccountID+"\n");
	str.append("Initial Balance: "+this.initialBalance+"\n");
	str.append("Current Balance: "+this.currentBalance+"\n");
	str.append("Account Opened: :"+ this.accountOpened+"\n");
	str.append("Customer Information: \n");
	str.append(this.customer.getFirstName()+" ");
	str.append(this.customer.getLastName()+"\n");
	str.append("Social Security Number: "+this.customer.getSocialSecNum()+"\n");
	str.append(this.customer.getAddress().getStreet()+", "+this.customer.getAddress().getCity()+", "+this.customer.getAddress().getAddressState()+", "+this.customer.getAddress().getZipcode()+"\n");
	return str.toString();
}
}//close class