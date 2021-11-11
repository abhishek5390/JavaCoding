package org.gudigar.JavaTutorials;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ConsumerPredicateSupplier {

	/*
	 Consumer, Predicate and Supplier are the predefined functional interface in java8
	 We need to understand these 3 functional interfaces in order to play with Streams API

	 Consumer Functional interface
	 This is used when an object needs to be consumed i.e taken as input and some operations are performed on object without returning any result
	 //Input type is type generic, it can accept any type of data, object, wrapper class or primitive
	 	void accept(T t);


	Predicate Functional interface
	used for conditional check. like whenever i need to return result as true or false
		boolean test(T t);


	Supplier Functional interface
	used in all context where there is no input but an output is expected
		T get();

	 */
	public static void main(String[] args) {
		//Consumer Functional interface

		//Traditional approach
		Consumer<Integer> c1 = new ConsumerDemo();
		c1.accept(10);

		//using lambda expression and making it as anonymous function
		Consumer<Integer> consumer = t -> System.out.println("Printing : "+ t);
		consumer.accept(10);

		//In java 8 stream API, there is method called foreach which will always accepts consumer functional interface
		List<Integer> list1 = Arrays.asList(1,2,3,4,5);
		//We can pass consumer interface reference to the foreach method
		//internally it will call abstract method of consumer functional interface and does operations for each element in the list
		list1.stream().forEach(consumer); 

		//instead of passing consumer interface, we can directly pass the lambda expression
		list1.stream().forEach(t -> System.out.println("Print : "+ t)); 

		System.out.println("***********************************************************");
		//Predicate Functional interface

		//traditional approach
		Predicate<Integer> p1 = new PredicateDemo();
		System.out.println(p1.test(10));

		//using lambda expression
		Predicate<Integer> predicate = t -> t % 2 == 0;
		System.out.println(predicate.test(5));
		
		//In java 8 stream API, there is method called filter which will always accepts predicate functional interface
		List<Integer> list2 = Arrays.asList(1,2,3,4,5);
		//We can pass predicate interface reference to the filter method
		//internally it will call abstract method of predicate functional interface and does filtering operations
		list2.stream().filter(predicate).forEach(t -> System.out.println("Print even : " + t));
		
		//instead of passing predicate interface, we can directly pass the lambda expression
		list1.stream().filter(t -> t % 2 != 0).forEach(t -> System.out.println("Print odd : "+ t)); 
		
		System.out.println("***********************************************************");
		//Supplier Functional interface
		
		//Traditional approach
		Supplier<String> s1 = new SupplierDemo();
		System.out.println(s1.get());
		
		//using lambda expression
		Supplier<String> supplier = () -> "Hello Abhishek";
		System.out.println(supplier.get());
		
//		In Java 8, we can use Supplier functional interface for the below Scenario:
//		list of element and doing filter condition. After filtering, not getting any result and want to return dummy result.
//		As a dummy return statement, we can use supplier interface
		List<String> list3 = Arrays.asList("a", "b");
		System.out.println(list3.stream().findAny().orElseGet(supplier));
		list3 = Arrays.asList();
		System.out.println(list3.stream().findAny().orElseGet(() -> "No items in the list"));
	}	
}

//traditional approach
class ConsumerDemo implements Consumer<Integer>{
	@Override
	public void accept(Integer t) {
		System.out.println("Printing : "+ t);	
	}
}

//traditional approach
class PredicateDemo implements Predicate<Integer>{
	@Override
	public boolean test(Integer t) {
		if(t%2==0) {
			return true;
		}
		return false;
	}
}

//Traditional approach
class SupplierDemo implements Supplier<String>{
	@Override
	public String get() {
		return "Hi Abhishek";
	}
	
}