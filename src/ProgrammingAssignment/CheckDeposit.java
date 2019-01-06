package ProgrammingAssignment;

public class CheckDeposit {
	private int checkNum;
	private int accountID;
	private int bankRoutingID;
	private CheckStatus checkStatus; 
	
	public CheckDeposit(int checkNum, int accountID, int bankRoutingID, CheckStatus checkStatus) {
		this.checkNum = checkNum;
		this.accountID = accountID;
		this.bankRoutingID = bankRoutingID;
		this.checkStatus=checkStatus;
		
	}
	//getters
	public CheckStatus getCheckStatus() {
		return checkStatus;
	}
	//setters
	public void setCheckStatus(CheckStatus checkStatus) {
		this.checkStatus = checkStatus;
	}
	
	//toString*
}
