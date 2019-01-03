package ProgrammingAssignment;
import java.lang.String;;
public class Address implements Comparable<Address> , Cloneable {
	private String street;
	private String city;
	private USState addressState;
	private String zipcode;
	

public Address(String street, String city, String state, String zip) {
	try{
	this.street=street;
	this.city=city;
	this.zipcode=zip;
	try{
		this.addressState=USState.valueOf(removeSpace(state));}
	catch (InvalidDataException e)
	{System.out.println("That is not a state. Please try again.");
	System.exit(1);}

	} catch ( MissingDataException e){
		System.out.println("You are missing data.");
	}}
	public Address clone() throws CloneNotSupportedException{
		return (Address)super.clone();
	}
/**This method removes a space character from the state that was inputted as a String.
 * @param state    the string inputted by the user or hardcoded, as in my demo.
 * @return String	the same state, as one word (without any spaces), and in UpperCase letters
 */
public String removeSpace(String state)
{int position=-1;
position=state.indexOf(" ");
if (position>=0)
{state=state.substring(0, position)+state.substring(position+1);}  
return state.toUpperCase();
}

public Address (Address A) {
	this.street=A.getStreet();
	this.city=A.getCity();
	this.addressState=A.getAddressState();
	this.zipcode=A.getZipcode();
}

public  String getStreet()
{
	return this.street;
}
public String getCity(){
	return this.city;
}

public USState getAddressState(){
	return this.addressState;
}
public String getZipcode(){
	return this.zipcode;
}
@Override
public boolean equals (Object O){
	if (this==O) {return true;}
	if(O== null ||O.getClass()!= this.getClass()) 
        return false;
	Address test=(Address)O;
	return (this.street==test.street&&this.city==test.city&&this.addressState==test.addressState&&this.zipcode==test.zipcode);
}
//toString method
	public String toString()
	{StringBuilder stbd=new StringBuilder();
	
	stbd.append(this.street+"\n");
	stbd.append(this.city+" ");
	stbd.append(this.addressState+" ");
	stbd.append(this.zipcode);
	return stbd.toString();}
	
@Override
public int compareTo(Address O){
	
	if (O==null)
	{throw new NullPointerException("There is no such address.");}
	else{ 
		if ( this.zipcode.compareTo(O.getZipcode())!=0)
				return this.zipcode.compareTo(O.getZipcode());
		else return this.street.compareTo(O.getStreet());
				}
}
}


