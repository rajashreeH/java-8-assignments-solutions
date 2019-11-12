package lamda_functional_interface;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Utility {
	
	
	static List<String> getBusSchedule(String start, Duration frequency){
		
		long dur=frequency.toHours();
		LocalTime startTime=LocalTime.parse(start);
		LocalTime endTime=LocalTime.MAX;
		long time= Duration.between(startTime, endTime).toHours()/dur;
		System.out.println(time);
		
	
		List<String> schedule=Stream.iterate(startTime, s->s.plusHours(dur))
				.limit(time)
				.map(s->s.toString())
				.collect(Collectors.toList());
		
		System.out.println("schedule:"+schedule);
		System.out.println("start time:"+startTime);
		System.out.println("endTime:"+endTime);
		
		return null;
	}

	public static void main(String[] args) {
		
		List<String> busSchedule=getBusSchedule("02:20", Duration.ofHours(2));

	}

}
