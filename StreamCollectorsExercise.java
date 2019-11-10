package lamda_functional_interface;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamCollectorsExercise {
	
	 public static List<Player> players=Arrays.asList(new Player[] {
				new Player("virat", 145, 20000, 183, new Country(01, "india")),
				new Player("abd", 170, 18000, 163, new Country(02, "sa")),
				new Player("abd", 140, 14000, 63, new Country(01, "india")),
				new Player("gayle", 250, 25000, 283, new Country(03, "west indies")),
				new Player("msd", 245, 21000, 183, new Country(01, "india")),
				new Player("stoke", 245, 21000, 183, new Country(04, "england")),
				new Player("gil", 2, 20, 3, new Country(01, "india"))
				
		});
	   
	
	static Map<String,List<Player>> getPlayersByCountry(){ //
		
		Map<String, List<Player>> playerByCountry= players.stream()
		.collect(Collectors.groupingBy(p->p.getCountry().getCountryName()));

		return playerByCountry;
	}
	
	static Map<String,List<String>> playerByCountry(){
		
		Map<String, List<String>> playerNameByCountry=players.stream()
				.collect(Collectors.groupingBy(p->p.getCountry().getCountryName(),
						Collectors.mapping(Player::getPlayerName, Collectors.toList())));
		
		return playerNameByCountry;
	}
	
	static Map<String,Long> getTotalPlayersByCountry(){
		
		Map<String, Long> countPlayerByCountry=players.stream()
				.collect(Collectors.groupingBy(p->p.getCountry().getCountryName(),
						LinkedHashMap::new,Collectors.counting()));
		return countPlayerByCountry;
	
	}
	
	static Map<String,Integer> getTotalRunsByCountry(){
		
		Map<String, Integer> runsByCountry=players.stream()
				.collect(Collectors.groupingBy(p->p.getCountry().getCountryName(),
						Collectors.summingInt(p->p.getRuns())));
		return runsByCountry;
	}
	
	static Map<String,Integer> getMaxScoreByCountry(){
		
		Map<Object, Optional<Player>> maxRunByCountry=players.stream()
				.collect(Collectors.groupingBy(s->s.getCountry().getCountryName(),
						Collectors.maxBy((p1,p2)->p2.getHighestScore()-p1.getHighestScore())));
	System.out.println(maxRunByCountry);
	return null;
	}
	
	static Map<String,String> getNameByCountry(){
		
		Map<String, String> getName=players.stream()
				.collect(Collectors.groupingBy(p->p.getCountry().getCountryName(),
						Collectors.mapping(Player::getPlayerName, Collectors.joining(","))));
		return getName;
	
	}
	
	public static void main(String[] args) {
		
		  
		   Map<String, List<Player>> playerByCountry= getPlayersByCountry();
		   System.out.println("*******************playerByCountry****************************");
		   System.out.println(playerByCountry);
		   Map<String,List<String>> playerNameByCountry=playerByCountry();
		   System.out.println("*******************playerNameByCountry****************************");
		   System.out.println(playerNameByCountry);
		   Map<String,Long> playerCountByCountry=getTotalPlayersByCountry();
		   System.out.println("******************getTotalPlayersByCountry**********************");
		   System.out.println(playerCountByCountry);
		   Map<String,Integer> totalRunsByCountry=getTotalRunsByCountry();
		   System.out.println("******************getTotalRunsByCountry*********************");
		   System.out.println(totalRunsByCountry);
		   
		   System.out.println("****************getMaxRunByCountry*******");
		   Map<String,Integer> maxRunByCountry=getMaxScoreByCountry();
		   
		   Map<String,String> nameByCountry=getNameByCountry();
		   System.out.println("**************getPlayerNameByCountry*****************");
		   System.out.println(nameByCountry);
	}
}
