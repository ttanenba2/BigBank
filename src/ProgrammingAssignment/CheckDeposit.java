package ProgrammingAssignment;

public class CheckDeposit {
	private int checkNum;
	private int accountID;
	private int bankRoutingID;
	private CheckStatus checkStatus; 
	
	public CheckDeposit(int checkNum, int accountID, int bankRoutingID) {//, CheckStatus checkStatus
		this.checkNum = checkNum;
		this.accountID = accountID;
		this.bankRoutingID = bankRoutingID;
		//this.checkStatus=checkStatus;
		
	}
	//getters
	public CheckStatus getCheckStatus() {
		return checkStatus;
	}
	//setters
	public void setCheckStatus(CheckStatus checkStatus) {
		this.checkStatus = checkStatus;
	}
	public int getAccountID() {
		// TODO Auto-generated method stub
		return accountID;
	}
	public int getCheckNum() {
		return checkNum;
	}
	//toString*
	public String toString() {
		StringBuilder bob = new StringBuilder();
		bob.append("Check Deposit    Check Number: " + checkNum+"/n")
		bob.append("AccountID: " + accountID + "  Bank Routing ID: " + bankRoutingID +"/n");
		bob.append("Check Status: " + checkStatus);
		return bob.toString();
		
	}
}
