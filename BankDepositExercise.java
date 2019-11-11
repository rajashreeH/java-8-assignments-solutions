package lamda_functional_interface;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.StringJoiner;

public class BankDepositExercise {

	static String getMaturityDate(String investmentDate, Period duration) {
		
		LocalDate startDate=LocalDate.parse(investmentDate);
		LocalDate endDate=startDate.plus(duration);
		String endDateString=endDate.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
		return endDateString;
	}
	
	static String getInvestmentPeriod(String investmentDate, String maturityDate){
		
		LocalDate startDate=LocalDate.parse(investmentDate);
		LocalDate endDate=LocalDate.parse(maturityDate);
		Period period=Period.between(startDate, endDate);
		
		String invPeriod=period.getYears()+"years,"+period.getMonths()+"months";
		/*StringJoiner invPeriod=new StringJoiner("", "<", ">")
				.add(String.valueOf(period.getYears()))
				.add(String.valueOf(period.getMonths()));*/
		
		return invPeriod.toString();
	}
	
	public static void main(String[] args) {
		
		String startDate="2019-05-01";
		Period duration=Period.ofMonths(6);
		String endDate=getMaturityDate(startDate, duration);
		System.out.println("investment maturity Date:"+endDate);
		String investmentPeriod=getInvestmentPeriod("2019-01-01", "2021-05-05");
		System.out.println("investment period:"+investmentPeriod);

	}

}
