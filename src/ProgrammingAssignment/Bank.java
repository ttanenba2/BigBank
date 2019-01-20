package ProgrammingAssignment;
import java.util.*;
import java.io.*;
import java.time.LocalDate;
public class Bank {
private String bankName;
private Address address;
private ArrayList<Customer> customers;
private ArrayList<BankAccount> bankAccounts;
private HashMap fees[]; //y?
private ArrayList<InterestRate> rates;
private ArrayList<Teller> tellers; 

private double bankInterestRate;

//I instantiated BigBank here so we don't need to reinstantiate each time we test the code.
private volatile static Bank BigBank = null;
private Bank() { }
public static Bank getInstance() {
if (BigBank == null) {
synchronized (Bank.class) {
if (BigBank == null) {
BigBank = new Bank();
}
}
}
return BigBank;
}








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
public  BankAccount findAccount (String accountid){
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
/*public void deposit (String AccountID, Double amount)  {    // there is no such method
	for (BankAccount a:this.bankAccounts){
	
		if (a.getAccountID().equals(AccountID)) {
			//a.deposit(amount);
			a.
		}
	}
}
*/
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
public void transfer (String acctIDfrom, String acctIDto, int amt) throws IOException{  //was bankAccount type but switched it to ids
	//findAccount(accIDfrom);  if acctto would be an ID string, which it may be supposed to be
	Transfer transfer =findAccount( acctIDfrom).transferTo(amt, acctIDto);  //takes money out and stores as transaction
	findAccount(acctIDto).transferFrom(transfer);
}
public void addFee(String accountID, FEETYPE feeType, int amount){//add fee types  add a fee to what?? so added acountid
	findAccount(accountID).addFee(new fee(feeType, amount));
}
public fee getFee (FEETYPE feeType, double feeAmount){//which fee?!?!!, the most recent??? does it make a fee?
	return new fee(feeType, feeAmount);  
}
public void postInterest(Interval interval) throws IOException{
	double total =0;
	for(BankAccount account: bankAccounts) {
		if(account instanceof SavingsAccount ) {//only savingsaccounts hav interest?
			if(account instanceof CDAccount && interval.equals(Interval.MONTHLY)) {
				((SavingsAccount) account).postInterest(((CDAccount) account).getInterestRate(), interval);  //probably womthing wrong here
				
			}
			else if(((SavingsAccount)account).getInterval().equals(interval)) {  //if its the same interval
				((SavingsAccount) account).postInterest(rates.get(rates.size()-1), interval);  //gets most recent from rates ,,bankInt.. created by me as standard rate
			}
			
		}
	}
}
public void setInterestRate (double amount){ //do u need interval or not??
	 rates.add(new InterestRate(amount, LocalDate.now()));
}
public void cashCheck (Check check, String accountIDTo) throws IOException{  //u do need accountID for this in case it bounces
	boolean isCashable= ((CheckingAccount) findAccount(check.getAccountID())).cashCheck(check);
	BankAccount bankAccountTo = findAccount(accountIDTo);
	if(isCashable) {
		//do nothing
		//would change the status to deposited but thats in checkDeposit which wer not rly useing?
	}
	else {//which account gets charged???
		
	 bankAccountTo.addFee(new fee(FEETYPE.RETURNEDCHECK, 10.00) );//made up 10 as the fee
	 bankAccountTo.withdrawal(10.00);//fee deducted from account
	}
}
public void depositCheck (Check check, String accountIDTo) throws IOException{ //accountIDfrom is inside check
	BankAccount bankAccountTo = findAccount(accountIDTo);
	boolean isCashable= ((CheckingAccount) findAccount(check.getAccountID())).cashCheck(check);
	if(isCashable) {//checkDeposit or Deposit, access?????
		for(Transaction t: bankAccountTo.Transactions ) {
			if(t.getTransType()==TransType.DEPOSIT) {//x check? cuz thats for the ones that makes it?
				CheckDeposit[] checkDeposits = ((Deposit)t).getCheckDeposits();
				if(checkDeposits!=null) {
					for(CheckDeposit cd: checkDeposits) {
						if(check.getCheckNum()==cd.getCheckNum()) {
							///do something //TODO******
						}
					}
				}
			}
		}
	}
	else {
	 findAccount(accountIDTo).addFee(new fee(FEETYPE.RETURNEDCHECK, 10.00) );
	 findAccount(accountIDTo).withdrawal(10.00);
	}
}
}//close class
