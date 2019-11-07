package lamda_functional_interface;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamOperationsExercise {

	public static void displayPlayers(List<Player> players) {
		players.stream()
		.map(Player::getPlayerName)
		.forEach(System.out::println);
	}
	
	public static void displayPlayersForCountry(String country,List<Player> players) {
		
		System.out.println("********displayPlayersForCountry********");
		players.stream()
		.filter(p->p.getCountry().getCountryName().equals(country))
		.filter(p->p.getHighestScore()>100)
		.map(Player::getPlayerName)
		.forEach(System.out::println);
	}
	
	public static List<String> getPlayerNames(List<Player> players) {
		System.out.println("********displayPlayersName scored more then 5000********");
		
		LinkedList<String> playersName=players.stream()
		.filter(p->p.getRuns()>5000)
		
		.map(Player::getPlayerName)
		.collect(Collectors.toCollection(LinkedList::new));
		return playersName;
	}
	
	public static void getAverageRunsByCountry(String country,List<Player>  players) {
		System.out.println("****avg*******");
		Double avg=players.stream()
		.filter(p->p.getCountry().getCountryName().equals(country))
		.mapToDouble(Player::getRuns)
		.average().orElse(Double.NaN);
		
		System.out.println("Average runs scored by "+country+" is "+avg);
		
		
	}
	public static void getPlayerNamesSorted(List<Player> players) {
		System.out.println("*****sortedName");
		players.stream()
		.sorted((p1,p2)->p1.getCountry().getCountryName().compareTo(p2.getCountry().getCountryName()))
		.sorted((p1,p2)->p1.getMatchesPlayed()-p2.getMatchesPlayed())
		.forEach(p->System.out.println(p.getPlayerName()));
		
	}
	
	public static Map<String, String> getPlayerCountry(List<Player> players) {
		System.out.println("********players name and country who player more then 200 match  *******");
		Map<String, String> playersCountry= players.stream()
		.filter(p->p.getMatchesPlayed()>200)
		.collect(Collectors.toMap(Player::getPlayerName, p->p.getCountry().getCountryName()));
		return playersCountry;
		
		//not done
	}
	
	public static Optional<Player> getMaxRunsPlayer(List<Player> players) {
		System.out.println("********max run scored player name*******");
		Optional<Player> maxRunPlayer=players.stream()
		.sorted((p1,p2)->p2.getHighestScore()-p1.getHighestScore())
		.findFirst();
		
		return maxRunPlayer;
	}
	
	public static Player findPlayer(String name, String country,List<Player> players) {
		System.out.println("********get player of perticular name and country*******");
		Player abd=players.stream()
		.filter(p->p.getPlayerName().equals(name))
		.filter(p->p.getCountry().getCountryName().equals(country))
		.findAny().orElse(null);
		return abd;
	}
	
	public static boolean checkHighScorerByCountry(String country,List<Player> players) {
		System.out.println("********checkHighScorerByCountry*******");
		boolean checkPlayer=players.stream()
		.filter(p->p.getCountry().getCountryName().equals(country))
		.filter(p->p.getRuns()>10000)
		.findAny().isPresent();
		
		return checkPlayer;
	}
	
	public static void main(String[] args) {
		
	   List<Player> playerDetails=Arrays.asList(new Player[] {
				new Player("virat", 145, 20000, 183, new Country(01, "india")),
				new Player("abd", 170, 18000, 163, new Country(02, "sa")),
				new Player("abd", 140, 14000, 63, new Country(01, "india")),
				new Player("gayle", 250, 25000, 283, new Country(03, "west indies")),
				new Player("msd", 245, 21000, 183, new Country(01, "india")),
				new Player("stoke", 245, 21000, 183, new Country(04, "england")),
				new Player("gil", 2, 20, 3, new Country(01, "india"))
				
		});
	  
	  displayPlayers(playerDetails);
	  displayPlayersForCountry("india", playerDetails);
	  List<String> seniorPlayers=getPlayerNames(playerDetails);
	  
	  for (String string : seniorPlayers) {
		System.out.println(string);
	  }
	  
	  getAverageRunsByCountry("india", playerDetails);
	  getPlayerNamesSorted(playerDetails);
	  Map<String,String> playerCountry=getPlayerCountry(playerDetails); //NOT DONE
	  
	  playerCountry.forEach((k,v)->System.out.println(k+" "+v));
	  
	 Optional<Player> mazRunPlayer= getMaxRunsPlayer(playerDetails);
	 System.out.println("Max runs scored player is:"+mazRunPlayer.get().getPlayerName());
	 
	 Player player1=findPlayer("abd","sa",playerDetails);
	 System.out.println("player named abd and from sa:"+player1);
	 
	 boolean checkPlayer=checkHighScorerByCountry("england",playerDetails);
	 System.out.println("is player present:"+checkPlayer);
	}

}
