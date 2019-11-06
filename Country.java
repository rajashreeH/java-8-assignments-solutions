package lamda_functional_interface;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class Country {
	
	public static void displayCountries(List<String> country) {
		country.forEach(c->System.out.println("Country:"+c));
	}
	
	public static void displayCountryCapitals(Map<String,String> countryCapital) {
		countryCapital.forEach((k,v)-> System.out.println("country:"+k+" and its capital:"+v));
	}
	
	public static void sortCountriesByName(List<String> country){
		System.out.println("**********sort by name reverse order**************");
		Collections.sort(country, (c1,c2)->c2.compareTo(c1));
		country.forEach(c->System.out.println(c));
	}

	static void removeCountry(List<String> country,Predicate<String> predicate){
		System.out.println("************country length greater then 6**************");
		for(String p : country) {
			if(predicate.test(p)) {
				System.out.println(p);
			}
		}
	}
	
	public static void sortCountriesBylength(List<String> country) {
		System.out.println("**********sort by length**************");
		Collections.sort(country, (c1,c2)-> {
			if(c1.length()>c2.length()) {
				return -1;
			}
			else if(c1.length()<c2.length()) {
				return 1;
			}
			else {
				return c1.compareTo(c2);
			}
		
		});
		country.forEach(c->System.out.println(c));
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> country=new ArrayList<>();
		country.add("india");
		country.add("china");
		country.add("america");
		Map<String,String> countryCapital=new HashMap<String, String>();
		countryCapital.put("india", "delhi");
		countryCapital.put("china", "beijing");
		
		displayCountries(country);
		displayCountryCapitals(countryCapital);
		sortCountriesByName(country);
		sortCountriesBylength(country);
		removeCountry(country,c->c.length()>6);

			
	}


}
