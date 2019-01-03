package ProgrammingAssignment;

public class Administrator extends Teller{
private String adminPassword;

public Administrator(String id, String fn, String ln, String login, String password){
	super(id, fn, ln, login, password);
}
public Administrator(String id, String fn, String ln, String login, String password, String adminPassword){
	super(id, fn, ln, login, password);
	this.adminPassword=adminPassword;
}
}
