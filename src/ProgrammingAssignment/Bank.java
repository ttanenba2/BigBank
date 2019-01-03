package ProgrammingAssignment;
import java.util.*;
import java.io.*;
public class Bank {
private String bankName;
private Address address;
private ArrayList<Customer> customers;
private ArrayList<BankAccount> bankAccounts;
private HashMap fees[];
private ArrayList<Integer> rates;
private ArrayList<Teller> tellers; 


public Bank (String name, Address makom){
	this.bankName=name;
	this.address=makom;
	this.customers=new ArrayList<Customer>();
	this.bankAccounts=new ArrayList<BankAccount>();
}
public Bank (String name, String street, String city, String state, String zip){
	this.bankName=name;
	this.address=new Address (street, city, state, zip);
}
public Bank(String bankName, Address address, String firstName, String lastName, String socialSecNum, Address address2, String fileName)throws IOException{
	this.bankName=bankName;
	this.address=address;
	this.customers=new ArrayList<Customer>();
	this.bankAccounts=new ArrayList<BankAccount>();
	this.addCustomer(firstName, lastName, socialSecNum, address2.getStreet(), address2.getCity(), address2.getAddressState().toString(), address2.getZipcode(), fileName);
}
public BankAccount findAccount (String accountid){
	BankAccount dc=null;
	for (BankAccount ba:this.getBankAccounts()){
		if (ba.getAccountID().equals(accountid)){
			dc=ba;
			return dc;
		}
	}
	 throw new InvalidDataException("No such account.") ;
}

public Customer findCustomer (Integer custid){
	Customer dc=null;
	for (Customer c:this.getCustomers()){
		if (c.getCustomerID().equals(custid)){
			dc=c;
			return dc;
		}
	}	 throw new InvalidDataException("No such customer.") ;

}
public Customer findCustomer (String ssn){
	Customer dc=null;
	for (Customer c:this.getCustomers()){
		if (c.getSocialSecNum().equals(ssn)){
			dc=c;
			return dc;
		}
	}	 throw new InvalidDataException("No such customer.") ;

}

public Integer addCustomer(String firstName, String lastName, String socialSecNum, String street, String city, String state, String zip, String filename){
	try
	{Address blip=new Address(street, city, state, zip);
	Customer chadash=new Customer(firstName, lastName, socialSecNum, blip);
	boolean present=false;
	for (Customer c:this.customers)
	{
		if (c.getSocialSecNum().equals(chadash.getSocialSecNum())) {present=true;}
	}
	if (present==false)
	{chadash.initializeCustomerID(filename);
	customers.add(chadash);}
	return chadash.getCustomerID();
	}//end try
	catch (Exception e)
	{
		System.out.println("The system has encountered an error and needs to close. We apologize for any inconvenience.");
		return null;
	}
	
}
public void addBankAccount(String AccountID, Double initialBalance, Customer customer){
	BankAccount chadash=new BankAccount(AccountID, initialBalance, customer);
	//change BankAccount constructor to take int instead of Customer
	
	boolean present=false;
	for (BankAccount c:this.bankAccounts)
	{
		if (c.equals(chadash)) {present=true;}
	}
	if (present==false)
	{
	bankAccounts.add(chadash);
	}
}

public void openAccount(String ID, Double ib, String f, String l, String ss, String st, String c, String stt, String z){
	Customer chadash=new Customer(f, l, ss, st, c, stt,z);
	openAccount(ID, ib, chadash.getCustomerID());
}

public void openAccount(String accountID, Double initialBalance, Integer customerID){
	Customer seesaw=null;
	for (Customer c:this.customers){
		if (c.getCustomerID()==customerID){ seesaw=new Customer(c);}
	}
	BankAccount chadash=new BankAccount(accountID, initialBalance, seesaw);
	this.bankAccounts.add(chadash);
}
public void deposit (String AccountID, Double amount)  {
	for (BankAccount a:this.bankAccounts){
	
		if (a.getAccountID().equals(AccountID)) {
			a.deposit(amount);
		}
	}
}
public boolean withdraw(String AccountID, Double amount){
	for (BankAccount a:this.bankAccounts){
		
		if (a.getAccountID().equals(AccountID)) {
			a.withdrawal(amount);
			return true;
		}
	}
return false;
}
public boolean closeAccount(String accountID, String socialSecNum){
	Customer proud=null;
for (BankAccount a:this.bankAccounts){
		if (a.getAccountID().equals(accountID)) {
			Integer id=a.getCustID();
			for (Customer c: this.customers)
			{if (c.getCustomerID()==id) {proud=new Customer (c);}
			if (proud.getSocialSecNum()!=null)
			{
				if (a.getBalance()<=0){
					this.bankAccounts.remove(a);
					return true;
				}
			}
			}//close for 
		}//close if
	}//close for
return false;
}//close method

public boolean removeCustomer(String socialSecNum){
	Boolean has=false;
	for (Customer c:this.customers){
		if (c.getSocialSecNum().equals(socialSecNum)){
			for (BankAccount b:this.bankAccounts)
			{
				if (b.getCustID().equals(c.getCustomerID())){
					has=true;
				}
			}//close for
		}//close if
		if (has=true)
			{this.customers.remove(c);
			return true;}
	}//close for
	return false;
}//close method
//GETTERS
public String getName(){
	return this.bankName;
}
public Address getAddress(){
	Address where=new Address(this.address);
	return where;
}
public ArrayList<Customer> getCustomers(){
	return this.customers;
}
public ArrayList<BankAccount> getBankAccounts(){
	ArrayList<BankAccount>give=new ArrayList<BankAccount>(this.bankAccounts);
	return give;
}
//SETTERS
public void setName(String name){
	this.bankName=name;
}
public void setAddress (Address addr){
	this.address=addr;
}
public double getTotal(){
	double total=0;
	for (BankAccount b:this.bankAccounts)
	{
		total=total+=b.getBalance();
	}
	return total;
}
public Double getAccountBalance(String accountID){
	for (BankAccount b:this.bankAccounts){
		if (b.getAccountID().equals(accountID)){
			return b.getBalance();
		}
	}
	return null;
}
public Double getCustomerBalances(Integer customerID){
	double total=0;
	for (BankAccount b:this.bankAccounts){
		if (b.getCustID().equals(customerID)){
			total+=b.getBalance();
		}
		
	}
	return total;
}

public Double getCustomerBalances(String SoSeNu){
	double total=0;
	for (BankAccount b:this.bankAccounts){
		
		if (b.getCustSocialSecNum().equals(SoSeNu)){
			total=total+=b.getBalance();
		}
	}
	return total;
}

public String toString(){
	StringBuilder str=new StringBuilder();
	str.append(this.bankName+"\n");
	str.append(this.address+"\n");
	str.append("Cusstomers: "+this.customers+"\n");
	str.append("Bank Accounts: "+ this.bankAccounts+"\n");
		return str.toString();
}
public void transfer (BankAccount acctfrom, BankAccount acctto, int amt){
	@TODO
}
public void addFee(feeType, int){//add fee types
	@TODO
}
public Fee getFee (feeType){
	@TODO
}
public void postInterestRate(Interval){
	@TODO
}
public void setInterestRate (double amt){
	 @TODO
}
public void cashCheck (Check check){
	@TODO
}
public void depositCheck (Check check, int acctID){
	@TODO
}
}//close class