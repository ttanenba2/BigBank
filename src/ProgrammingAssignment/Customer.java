package ProgrammingAssignment;
import java.io.*;
import java.util.Scanner;
public class Customer {
	public class BankAccount {

	}
	private Integer CustomerID=null;
	private String firstName;
	private String lastName;
	private String socialSecNum;
	private Address address;
	
	private static Integer lastCustID = 0;
	
	public  void initializeCustomerID(String filename) throws IOException{
		try{
			File hopscotch=new File(filename);
			Scanner input=new Scanner(hopscotch);//open input file in a readable format
			lastCustID=input.nextInt();
		//	this.CustomerID=lastCustID;
		}
	catch (FileNotFoundException e){
		System.out.println("We cannot find that file. Please try again.");
	}
	}//end InitializeCustomerId method

public void saveLastCustomerID(String filename) throws IOException{
	try{
		Integer chadash=lastCustID;
		FileWriter filewriter= new FileWriter(filename);
		filewriter.write(chadash);
		filewriter.close();
	}
catch (FileNotFoundException	e){
	System.out.println("We cannot find that file. Please try again.");
}
}

	public boolean verifySocialSecurityNumber (String socialSecNum){
		if (socialSecNum.length()!=9){return false;}
		if (!socialSecNum.matches("[0-9]+")) {return false;}
		char[]destarray=new char[10];
		try { 
           socialSecNum.getChars(0, 10, destarray, 0); 
          Integer midd=(Integer)(destarray[3]+destarray[4]);
          if (midd==0){return false;}
          Integer end=(Integer)(destarray[5]+destarray[6]+destarray[7]+destarray[8]);
          if (end==0){return false;}
          Integer beg=(Integer) (destarray[0]+destarray[1]+destarray[2]);
          if (beg==0||beg==666||destarray[0]==9) {return false;}
        } 
        catch (Exception ex) { 
            System.out.println(ex); 
        } 
		
		return true;
	}
public Customer (String firstName, String lastName, String socialSecNum, Address address)
{
	if (verifySocialSecurityNumber(socialSecNum)==false) {throw new InvalidDataException("Whoops- missing data.");}
	try{
		this.setLastname(lastName);
		this.setFirstname(firstName);
		this.setSocialSecNum(socialSecNum);
		this.setAddress(address);}
	catch (MissingDataException e) {
		System.out.println("Missing data.");
	}
	this.CustomerID=++lastCustID;
}//end constructor
public Customer (String firstName, String lastName, String socialSecNum, String street, String city, String state, String zip){
	this(firstName, lastName, socialSecNum, new Address(street, city,state,zip));
}
//copy constructor
public Customer(Customer o){
	this.CustomerID=o.getCustomerID();
	this.firstName=o.getFirstName();
	this.lastName=o.getLastName();
	this.socialSecNum=o.getSocialSecNum();
	this.address=o.getAddress();
}
public String getFirstName(){
	String f= this.firstName;
	return f;
}
public String getLastName(){
	String l=this.lastName;
	return l;
}
public String getSocialSecNum(){
	String s= this.socialSecNum;
	return s;
}
public Address getAddress(){
	Address a= this.address;
	return a;
}
public Integer getCustomerID(){
	Integer c=this.CustomerID;
	return c;
}
public void setLastname(String lastname){
	this.lastName=lastname;
}
public void setFirstname(String firstname){
	this.firstName=firstname;
}
public void setSocialSecNum(String socsecnum)
{
	this.socialSecNum=socsecnum;
}
public void setAddress (Address a){
	this.address=a;
}
@Override
public boolean equals (Object O){
	if (O==null){return false;}
	if (O instanceof Customer){
		Customer YY=(Customer)O;
		if (this.socialSecNum==YY.getSocialSecNum()){
			return true;
		}
		else return false;
	}
	return false;
}

public int compareTo (Customer cust){
		return this.socialSecNum.compareTo(cust.getSocialSecNum());
}
public String toString(){
	StringBuilder str=new StringBuilder();
	str.append(this.firstName+"\n");
	str.append(this.lastName+"\n");
	str.append(this.socialSecNum+"\n");
	str.append(this.address.getStreet()+", "+this.address.getCity()+", "+this.address.getAddressState()+", "+this.address.getZipcode()+"\n");
	return str.toString();
}
}//close class
