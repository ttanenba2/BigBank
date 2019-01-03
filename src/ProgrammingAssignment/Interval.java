package ProgrammingAssignment;

public enum Interval {
	DAILY(365),  MONTHLY(12), YEARLY(1);

private int peryear;
private Interval (int i){
	this.peryear=i;
}
public int getPerYear(){
	return peryear;
}
}
