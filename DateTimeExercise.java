package lamda_functional_interface;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DateTimeExercise {

	static ArrayList<Tablet> tabletDetails=new ArrayList<>(Arrays.asList(new Tablet[] {
			new Tablet("crocine","bengaluru",LocalDate.parse("2019-02-02"),LocalDate.parse("2019-05-12")),
			new Tablet("Acetaminophen","mumbai",LocalDate.parse("2019-01-02"),LocalDate.parse("2019-04-12")),
			new Tablet("Cipro","bengaluru",LocalDate.parse("2019-02-19"),LocalDate.parse("2020-12-20")),
			new Tablet("dolo","bengaluru",LocalDate.parse("2019-04-20"),LocalDate.parse("2020-12-21")),
			new Tablet("Shingrix","delhi",LocalDate.parse("2019-02-02"),LocalDate.parse("2019-05-12")),
			new Tablet("Ranexa","hubli",LocalDate.parse("2019-01-02"),LocalDate.parse("2019-04-12"))
			
			
	}));
	
	static ArrayList<String> getExpiringTables(int months){
		LocalDate today=LocalDate.now().plusMonths(months);
		ArrayList<String> tabletExpireSoon=tabletDetails.stream()
		.filter(t->t.getExpiry_date().isBefore(today))
		.map(Tablet::getTablet_name)
		.collect(Collectors.toCollection(ArrayList::new));
		return tabletExpireSoon;
	}
	
	static List<Tablet> getExpiringTabletsSorted() {
		
		List<Tablet> tabletSortedByexpDate = tabletDetails.stream()
				.sorted((t1,t2)->t1.getExpiry_date().compareTo(t2.getExpiry_date()))
				.collect(Collectors.toCollection(ArrayList::new));
		
		return tabletSortedByexpDate;
	}
	
	static Map<String,String> getTabletExpiryPeriod(){
		
		LocalDate today=LocalDate.now();
		
		Map<String,String> tabletExpiryPeriod=tabletDetails.stream()
				.collect(Collectors.toMap(Tablet::getTablet_name, t->{
					Period period=Period.between(today,t.getExpiry_date());
					String periodValue=period.getYears()+" year/s "+period.getMonths()+" month/s";
					return periodValue;
				}));
		
		return tabletExpiryPeriod;
	}
	
	static Map<String,List<String>> getSameYearExpiry(){
		
		Map<String,List<String>> sameYearExpiry=tabletDetails.stream()
				.filter(t->{
					Long year=ChronoUnit.YEARS.between(t.manufacture_date, t.expiry_date);
					if(year>0) {
						return false;
					}
					else {
						return true;
					}
					})
				.collect(Collectors.groupingBy(Tablet::getManufacturer,Collectors.mapping(Tablet::getTablet_name, Collectors.toList())));
	
		return sameYearExpiry;
	
	}
	
	public static void main(String[] args) {
		
		System.out.println("************expired tablet****************");
		ArrayList<String> expiredTablet=getExpiringTables(3);
		System.out.println(expiredTablet);
		System.out.println("***********tablets sorted by expired data*********");
		List<Tablet> sortedTablet=getExpiringTabletsSorted();
		System.out.println(sortedTablet);
		System.out.println("*********tablet with expire dates***********");
		Map<String, String> tabletExpirePeriod=getTabletExpiryPeriod();
		System.out.println(tabletExpirePeriod);
		System.out.println("********sameYearExpiredTablets**********");
		Map<String,List<String>> sameYearEpired=getSameYearExpiry();
		System.out.println(sameYearEpired);
	}

}
