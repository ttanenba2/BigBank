package ProgrammingAssignment;

public class Teller extends Employee {
private String loginID;
private String password;

public Teller (String id, String fn, String ln){
super(id, fn, ln);
}
public Teller (String id, String fn, String ln, String login, String password){
super(id, fn, ln);
this.loginID=login;
this.password=password;
}
public String getLoginID(){
	return loginID;
}
public void setLoginID(String currentLogin, String newLogin){
	if (this.loginID.equals(currentLogin)){
		this.loginID=newLogin;
	}
}
public void resetPassword(String currentPassword, String newPassword){
	if (this.password.equals(currentPassword)){
		this.password=newPassword;
	}
}
}
