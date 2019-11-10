package lamda_functional_interface;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SpecialStream {

	public static void main(String[] args) {
		
		LinkedList<Integer> square= (LinkedList<Integer>) IntStream.range(20, 50)
		.filter(n->n%3==0)
		.filter(n->n%2==1)
		.map(n->n*n)
		.boxed()
		.collect(Collectors.toCollection(LinkedList::new));
		
		System.out.println("square:"+square);
		
		//Stream infiniteStream=Stream.iterate(5, n->n+5);
		
		Integer multiple[]=Stream.iterate(5, n->n+5)
		.limit(20)
		.toArray(Integer[]::new);
		
		System.out.println("multiple:"+Arrays.toString(multiple));
		

	}

}
