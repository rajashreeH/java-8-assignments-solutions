package lamda_functional_interface;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WorkingDaysExercise {

	static List<String> getNextMonthsWorkingDays(){
		
		LocalDate today=LocalDate.now();
		LocalDate firstDayofNextMonth=today.with(TemporalAdjusters.lastDayOfMonth()).plusDays(1);
		LocalDate lastDayOfNextMonth=firstDayofNextMonth.with(TemporalAdjusters.lastDayOfMonth());
		System.out.println(lastDayOfNextMonth);
		
		List<String> workingDays=Stream.iterate(firstDayofNextMonth, d->d.plusDays(1))
				.limit(ChronoUnit.DAYS.between(firstDayofNextMonth, lastDayOfNextMonth))
				.filter(d->{
					if(d.getDayOfWeek().equals(DayOfWeek.SATURDAY)||
							d.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
						return false;
					}
				
						return true;
				
				})
				.map(d->{
					String date=d.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
					return date;
				}).collect(Collectors.toList());
		
		
		return workingDays;
		
	}
	
	public static void main(String[] args) {
		List<String> workingDays=getNextMonthsWorkingDays();
		System.out.println("working days:"+workingDays);

	}

}
