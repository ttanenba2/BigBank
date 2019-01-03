package ProgrammingAssignment;
import java.util.*;
public class UseBank {
public static void main (String[]args){
	Scanner input=new Scanner(System.in);
System.out.println("Which bank are you using?");
String shemTov=input.nextLine();
System.out.println("Enter your address as street, city, state, zip.Press Enter between each part.");
Address makom=new Address (input.nextLine(),input.nextLine(), input.nextLine(), input.nextLine() );

Bank current=new Bank(shemTov, makom);
System.out.println("What would you like to do?  \n");
StringBuilder str=new StringBuilder("1.	Add a customer \n");
str.append("2.	Add a new Account \n");
str.append("3.	Close Account  \n");
str.append("4.	Remove a Customer   \n");
str.append("5.	Manage Account \n");
str.append("6.	Manage Customer  \n");
str.append("7.	Get Total Bank Balance  \n");
str.append("8.	List Accounts  \n");
str.append("9.	Exit Application   \n");
System.out.println(str.toString());
int reply=input.nextInt();
{switch (reply)
	{case 1:
		System.out.println("Enter a first name, last name, social security number, street, city, state, zip, and file name. Press Enter once after each entry.");
		current.addCustomer(input.nextLine(), input.nextLine(), input.nextLine(), input.nextLine(), input.nextLine(), input.nextLine(), input.nextLine(), input.nextLine());
		input.nextLine();
		break;

	case 2:
		System.out.println("Enter the first name, last name, and social security number for the customer who owns the account. Press Enter once after each entry.");
		String first=input.nextLine(); String last=input.nextLine(); String soc=input.nextLine();
		Customer ploni=current.findCustomer(soc);
	    
		input.nextLine();
		System.out.println("Enter the account ID and the initial balance. Press enter after each entry." );
		current.addBankAccount(input.nextLine(), input.nextDouble(), ploni);
		input.nextLine();
		break;

	case 3:
		System.out.println("Enter the accountID of the account you wish to close, as well as the social security number of the corresponding customer. Press Enter after each entry.");
		String ID=input.nextLine();
		String ssn=input.nextLine();
		boolean hi=current.closeAccount(ID, ssn);
		if (hi=false) {System.out.println("try again.");}
		input.nextLine();
		break;

	case 4:
		System.out.println("Enter the customer's social security number.");
		String socialSecNum=input.nextLine();
		boolean decoy=current.removeCustomer(socialSecNum);
		if (decoy==false){ throw new InvalidDataException("Try again.");}
		input.nextLine();
		break;

	case 5:
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
				current.deposit(critical, amt);
				break;
			case 2:
				System.out.println("How much would you like to withdraw?");
				Double skm=input.nextDouble();
				input.nextLine();
				boolean fake=	current.withdraw(critical, skm);
				if (fake==false){throw new InvalidDataException("Try again.");}
				break;
			case 3:
				System.out.println(current.getAccountBalance(critical));
				break;
			default:
				break;
			}
			
		}//end switch
		input.nextLine();
		input.nextLine();
		break;

	case 6:
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
			current.openAccount(AID, dbl, crucial);
				break;
			case 2:
				current.getCustomerBalances(crucial);
				break;
			case 3:
				System.out.println("Enter the new address as street, city, state, zip. Press Enter after each.");
				String st=input.nextLine();
				String ct=input.nextLine();
				String stt=input.nextLine();
				String zip=input.nextLine();
				Address chadash=new Address(st, ct, stt, zip);
				for (Customer c:current.getCustomers()){
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
				Customer here=current.findCustomer(crucial);
						snsnsn=here.getSocialSecNum();
					
				current.closeAccount(aid, snsnsn);}
				catch(InvalidDataException e){}
				break;
			case 5:
				System.out.println("Enter the account ID.");
				String iidd=input.nextLine();
				BankAccount ba=current.findAccount(iidd);
				
					if (ba.getCustID().equals(crucial)){
						System.out.println(ba.getBalance());
					}
				
			default:
				break;
			}
			
		}//end switch
		

		
		input.nextLine();
		break;

	case 7:
		double total=0;
		for (BankAccount ba:current.getBankAccounts()){
			total+=ba.getBalance();
		}
		System.out.println( total);
		
		break;

	case 8:
		System.out.println(current.getBankAccounts().toString());
		input.nextLine();
		break;

	case 9:
		System.out.println("Goodbye.");
		System.exit(0);
	default:
		}//close cases
}	//close switch statement
}//close main method
}//close class
