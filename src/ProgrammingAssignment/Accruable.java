package ProgrammingAssignment;
import java.time.*;
public interface Accruable {
	public double getInterestPosted( int month, int year);  //ints?
	public double getInterestPosted(LocalDate startDate, LocalDate endDate);     
	public void postInterest(InterestRate interestRate, Interval interval);
}
