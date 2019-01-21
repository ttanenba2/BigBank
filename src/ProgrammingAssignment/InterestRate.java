package ProgrammingAssignment;
import java.time.*;

public class InterestRate {
private double rate;
private LocalDate rateSetDate;
private Interval interval;

public InterestRate(double amt, LocalDate setDate){
	this.rate=amt;
	this.rateSetDate=setDate;
}
public double getRate(){
	return rate;
}
public LocalDate getRateSetDate(){
	return rateSetDate;
}
public String toString() {
	return "Rate: " + rate + "  Rate Set: " + rateSetDate;
}
}
