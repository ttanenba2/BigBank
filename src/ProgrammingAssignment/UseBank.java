package ProgrammingAssignment;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
public class UseBank {
	
public static void main (String[]args){
	Scanner input=new Scanner(System.in);
	
	/*This code would help us instantiate BigBank as the current bank. 
	Since our program only uses BigBank for the time being, we instantiated it elsewhere in our code
	so that the information does not need to be reentered every time. If the program expands to include 
	multiple banks, we will use the following code.
System.out.println("Which bank are you using?");
String bankName=input.nextLine();

System.out.println("Enter your address as street, city, state, zip. Press Enter between each part.");
Address bankAddress=new Address (input.nextLine(),input.nextLine(), input.nextLine(), input.nextLine() );

Bank current=new Bank(bankName, bankAddress);
**/
	Bank BigBank=Bank.getInstance();//we used the Singleton pattern to ensure that the same bank is always returned.
	//--Here put teller login:
	//This, too, can use user input instead of hardcoding: 
	//System.out.println("Enter id, name, login, password");- Save data from input Scanner. 
	//We hardcoded a few tellers to enable easier testing. 
	Teller[] tellers=new Teller[100];
	tellers[0]=new Teller("1", "Josh", "Smith", "JSlogin", "JSpassword");
	tellers[1]=new Teller("2", "Harry", "Potter", "HPlogin", "HPpassword");
	tellers[2]=new Teller("3", "Cynthia", "Banks", "CBlogin", "CBpassword");
	LocalDate last;
	try{
		try{
		Teller currentTeller;
	
	System.out.println("Hello, Teller. \n Please enter your username.");
	Scanner incoming=new Scanner(System.in);
	String currentLogin=incoming.nextLine();
	for (Teller t:tellers){
		if (t.getLoginID().equals(currentLogin)){
		currentTeller=t;
		}
	}
	System.out.println("Hello, "+currentTeller.getName()+". Please enter your password.");
	String currentPassword=incoming.nextLine();
	while(!currentPassword.equals(currentTeller.getPassword())){
		System.out.println("Invalid password. Please try again.");
		System.out.println("Hello, "+currentTeller.getName()+". Please enter your password.");
		 currentPassword=incoming.nextLine();
	}}
		catch (Exception e){
			System.out.println("Failed to identify this teller. Please restart the program and try again.");
			System.exit(1);
		}
System.out.println("What would you like to do?  \n");
StringBuilder str=new StringBuilder("1.	Add a customer \n");
str.append("2.	Add a new Account \n");
str.append("3.	Close Account  \n");
//str.append("4.	Remove a Customer   \n");
str.append("4.	List Accounts  \n");
str.append("5.	Manage Account \n");
str.append("6.	Manage Customer  \n");
str.append("7.	Get Total Bank Balance  \n");
str.append("8.  Print all statements. \n");
str.append("9.  Print a full statement \n");
str.append("0.	Exit Application   \n");
System.out.println(str.toString());
int reply=input.nextInt();
{switch (reply)
	{case 1://add customer
		System.out.println("Enter a first name, last name, social security number, street, city, state, zip, and file name. Press Enter once after each entry.");
		BigBank.addCustomer(input.nextLine(), input.nextLine(), input.nextLine(), input.nextLine(), input.nextLine(), input.nextLine(), input.nextLine(), input.nextLine());
		input.nextLine();
		break;

	case 2://add account
		System.out.println("Enter the first name, last name, and social security number for the customer who owns the account. Press Enter once after each entry.");
		String first=input.nextLine(); String last=input.nextLine(); String soc=input.nextLine();
		Customer ploni=BigBank.findCustomer(soc);
	    
		input.nextLine();
		System.out.println("Enter the account ID and the initial balance. Press enter after each entry." );
		BigBank.addBankAccount(input.nextLine(), input.nextDouble(), ploni);
		input.nextLine();
		break;

	case 3://close account
		System.out.println("Enter the accountID of the account you wish to close, as well as the social security number of the corresponding customer. Press Enter after each entry.");
		String ID=input.nextLine();
		String ssn=input.nextLine();
		boolean hi=BigBank.closeAccount(ID, ssn);
		if (hi=false) {System.out.println("try again.");}
		input.nextLine();
		break;

	/*case 4://remove customer
		System.out.println("Enter the customer's social security number.");
		String socialSecNum=input.nextLine();
		boolean decoy=BigBank.removeCustomer(socialSecNum);
		if (decoy==false){ throw new InvalidDataException("Try again.");}
		input.nextLine();
		break;*/
 
	case 4: // List accounts
		//dont know if this will print properly
		System.out.println(BigBank.toString());  //this prints basic account info, statements will be different
		break;
		
	case 5: //manage account
		System.out.println("Enter the account ID.");
	String critical=input.nextLine();
		System.out.println("What would you like to do?");
		System.out.println("1. Deposit");
		System.out.println("2. Withdraw ");
		System.out.println("3. Get Balance");
		int choice=input.nextInt();
		{switch (choice)
			{case 1:
				System.out.println("How much would you like to deposit?");
				Double amt=input.nextDouble();
				input.nextLine();
				BigBank.deposit(critical, amt);
				break;
			case 2:
				System.out.println("How much would you like to withdraw?");
				Double skm=input.nextDouble();
				input.nextLine();
				boolean fake=	BigBank.withdraw(critical, skm);
				if (fake==false){throw new InvalidDataException("Try again.");}
				break;
			case 3:
				System.out.println(BigBank.getAccountBalance(critical));
				break;
			default:
				break;
			}
			
		}//end switch
		input.nextLine();
		input.nextLine();
		break;

	case 6: //manage cusotmer
		System.out.println("Enter customer ID.");
		Integer crucial=input.nextInt();
		input.nextLine();
		System.out.println("Enter the number of your choice.");
		System.out.println("1.	Open an account");
		System.out.println("2.	Get total balances");
		System.out.println("3. Change Address");
		System.out.println("4. Close an Account");
		System.out.println("5. Get Account balance ");
		int bechira=input.nextInt();
		input.nextLine();
		
		{switch (bechira)
			{case 1:
				System.out.println("Enter a new account ID.");
				String AID=input.nextLine();
				System.out.println("Enter the initial balance.");
				Double dbl=input.nextDouble();
				input.nextLine();
				BigBank.openAccount(AID, dbl, crucial);
				break;
			case 2:
				BigBank.getCustomerBalances(crucial);
				break;
			case 3:
				System.out.println("Enter the new address as street, city, state, zip. Press Enter after each.");
				String st=input.nextLine();
				String ct=input.nextLine();
				String stt=input.nextLine();
				String zip=input.nextLine();
				Address chadash=new Address(st, ct, stt, zip);
				for (Customer c:BigBank.getCustomers()){
					if (c.getCustomerID().equals(crucial)){
						c.setAddress(chadash);
					}
				}
				input.nextLine();
				break;
			case 4:
				try{String snsnsn=null;
				System.out.println("Enter the accountID of the account you wish to close.");
				String aid=input.nextLine();
				Customer here=BigBank.findCustomer(crucial);
						snsnsn=here.getSocialSecNum();
					
						BigBank.closeAccount(aid, snsnsn);}
				catch(InvalidDataException e){}
				break;
			case 5:
				System.out.println("Enter the account ID.");
				String iidd=input.nextLine();
				BankAccount ba=BigBank.findAccount(iidd);
				
					if (ba.getCustID().equals(crucial)){    //???
						System.out.println(ba.getBalance());
					}
				
			case 5: //manage account
				System.out.println("Enter the account ID.");
			String critical=input.nextLine();
				System.out.println("What would you like to do?");
				System.out.println("1. Deposit Checks");
				System.out.println("2. Deposit Checks and cash ");
				System.out.println("3. Deposit cash");
				System.out.println("4. Cash Check"
						+ "5. Add Fee"
						+ "6. Transfer");
				int choice=input.nextInt();
				{switch (choice)
					{case 1:
						System.out.println("How many checks?");
						int amountOfChecks=input.nextInt();
						input.nextLine();
						System.out.println("Total Amount on checks");
						int amountOfMoney = input.nextInt();
						input.nextLine();
						CheckDeposit[] checks = new CheckDeposit[amountOfChecks];  //will this work more than once
						for(CheckDeposit cd: checks) {
							System.out.println("Check Number: ");
							int checknum = input.nextInt();
							System.out.println("Bank Routing Number: ");
							int routingnum = input.nextInt();
							input.nextLine();
							cd = new CheckDeposit(checknum, critical, routingnum);
							
						}
						
						break;
					case 2:
						System.out.println("How much would you like to withdraw?");
						Double skm=input.nextDouble();
						input.nextLine();
						boolean fake=	BigBank.withdraw(critical, skm);
						if (fake==false){throw new InvalidDataException("Not enough funds");}
						break;
					case 3:
						System.out.println(BigBank.getAccountBalance(critical));
						break;
					default:
						break;
					}
					
				}//end switch
				input.nextLine();
				input.nextLine();
				break;
			}
			
		}//end switch
		

		
		input.nextLine();
		break;

	case 7: //get total bank balance
		double total=0;
		for (BankAccount ba:BigBank.getBankAccounts()){
			total+=ba.getBalance();
		}
		System.out.println( total);
		
		break;

	case 8://get all statements
		System.out.println(BigBank.toStringStatement());
		input.nextLine();
		break;

	case 9: //get 1 statement 
		System.out.println("Account ID");
		String accountID = input.next(); //declare accountid earlier
		BankAccount b = BigBank.findAccount(accountID);
		System.out.println(b.toStringStatement());
		break;
	
		
	case 10:
		System.out.println("Exiting");
	default:
		}//close cases
}	//close switch statement

if (LocalDate.now().isEqual(last))
{
BigBank.postInterest(Interval.DAILY);
if(LocalDate.now().getDayOfMonth()==LocalDate.now().lengthOfMonth()) {
	BigBank.postInterest(Interval.MONTHLY);
}
last=LocalDate.now();
}}
	catch(IOException e) {
		System.out.println("System encountered an error and needs to close.");
		System.exit(1);
	}
	
}//close main method
}//close class
