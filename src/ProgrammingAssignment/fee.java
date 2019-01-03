package ProgrammingAssignment;

public class fee {
private double feeAmount;
private FEETYPE type;

public fee (FEETYPE type, double amt){
	this.feeAmount=amt;
	this.type=type;
}

public double getFeeAmount(){
	return this.feeAmount;
}
public FEETYPE getFeeType(){
	return this.type;
}
}
