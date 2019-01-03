package ProgrammingAssignment;
import java.util.*;
import java.time.*;
public class Employee {
private String employeeID;
private String firstName;
private String lastName;
private LocalDate hiredate;

public Employee (String id, String firstname, String lastname){
	this.employeeID=id;
	this.firstName=firstname;
	this.lastName=lastname;
}
public String getEmployeeID(){
	return employeeID;
}
public String getFirstName(){
	return firstName;
}
public String getLastName(){
	return lastName;
}
public LocalDate getHireDate(){
	return hiredate;
}
public void setLastName(String newname){
	this.lastName=newname;
}
}
