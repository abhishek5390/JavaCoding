package org.gudigar.JavaTutorials;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BiFunctionBiConsumerBiPredicate {
	/*
	BiFunction
	Function- contains one method apply, takes one argument (T) and return result. 
	used when we need to take one input, do data manipulation and return the result. 
		@FunctionalInterface
		public interface Function<T, R>{
			R apply(T t);
		}
	in BiFunction, method name is same, but it takes 2 arguments (T,U) and return result
	used when we need to take 2 inputs, do data manipulation and return the result. 
		@FunctionalInterface
		public interface BiFunction<T, U, R>{
			R apply(T t, U u);
		}
		
		
	BiConsumer
	Consumer- contains one method accept, takes one argument (T) only, no return
	used when we need to take one input, do data manipulation.
		@FunctionalInterface
		public interface Consumer<T>{
			void accept(T t);
		}
	in BiConsumer, method name is same, but it takes 2 arguments (T,U) only, no return
	used when we need to take 2 inputs, do data manipulation. 
		@FunctionalInterface
		public interface BiConsumer<T, U>{
			void accept(T t, U u);
		}
	
	BiPredicate
	Predicate- contains one method test, takes one argument (T) only, and return boolean
	used when we need to take one input, do conditional check and return boolean value
		@FunctionalInterface
		public interface Predicate<T>{
			boolean test(T t);
		}
	in BiPredicate, method name is same, but it takes 2 arguments (T,U) only, and return boolean
	used when we need to take 2 inputs, do conditional check and return boolean value
		@FunctionalInterface
		public interface BiPredicate<T, U>{
			boolean test(T t, U u);
		}
	 */
	public static void main(String[] args) {
		//BiFunction
		//traditional approach
		//From the 2 list of integer, i need to find the duplicates and return the final unique list of integers
		BiFunction biFunction = new BiFunctionDemo();
		List<Integer> list1 = Stream.of(1,3,4,6,7,9).collect(Collectors.toList());
		List<Integer> list2 = Stream.of(2,3,5,6,7,8).collect(Collectors.toList());
		System.out.println("Traditional approach :  " + biFunction.apply(list1, list2));
		
		//using anonymous implementation
		BiFunction<List<Integer>, List<Integer>, List<Integer>> biFunction1 = new BiFunction<List<Integer>, List<Integer>, List<Integer>>() {
			@Override
			public List<Integer> apply(List<Integer> l1, List<Integer> l2) {
				return Stream.of(l1, l2)
						.flatMap(List::stream)
						.distinct()
						.collect(Collectors.toList());
			}
		};
		System.out.println("anonymous implementation : " + biFunction1.apply(list1, list2));
		
		//Using lambda expression approach
		BiFunction<List<Integer>, List<Integer>, List<Integer>> biFunction2  = (l1, l2) -> {
			return Stream.of(l1, l2)
					.flatMap(List::stream)
					.distinct()
					.collect(Collectors.toList());
		};
		System.out.println("lambda approach " + biFunction2.apply(list1, list2));
		
		//Using andThen default method of BiFunction interface
		//andThen - after getting output from apply method, if we need to do any operations on the output, we can use andThen
		//in the above code we got the unique list of integers, but they are not in sorted order ex: [1, 3, 4, 6, 7, 9, 2, 5, 8]
		Function<List<Integer>, List<Integer>> sortedFunction = (lists) -> lists.stream().sorted().collect(Collectors.toList());
		System.out.println("Sorting the output of bifunction : " + biFunction2.andThen(sortedFunction).apply(list1, list2));
		
		//Realtime use of BiFunction
		//In this map, it contains employee name and their salaries. 
		//Now we need to increase their salary with 5000 more;
		Map<String, Integer> map = new HashMap<>();
		map.put("AAA", 50000);
		map.put("BBB", 40000);
		map.put("CCC", 70000);
		map.put("DDD", 20000);
		
		//using anonymous approach
		BiFunction<String, Integer, Integer> increaseSalaryBiFunction = new BiFunction<String, Integer, Integer>() {

			@Override
			public Integer apply(String key, Integer value) {
				return value + 5000;
			}
		};
		map.replaceAll(increaseSalaryBiFunction);
		System.out.println("anonymous approach : " + map);
		
		//using lambda expression approach
		BiFunction<String, Integer, Integer> increaseSal = (key, value) -> value + 10000;
		map.replaceAll(increaseSal);
		System.out.println("Lambda expression approach : " + map);
		
		//Or we can directly pass lambda expression into map.replaceAll() method
		map.replaceAll((key, value) -> value + 20000);
		System.out.println("Direct lambda expression approach : " + map);
		
		System.out.println("*****************************************************************");
		//BiConsumer
		
		//Traditional approach
		BiConsumer<String, Integer> biConsumer = new BiConsumerDemo();
		biConsumer.accept("Abhishek", 5390);
		
		//using anonymous implementation
		BiConsumer<String, Integer> biConsumer1 = new BiConsumer<String, Integer>() {
			@Override
			public void accept(String i1, Integer i2) {
				System.out.println("anonymous implementation - Name : " + i1 + ", DOB : " + i2);
				
			}
		};
		biConsumer1.accept("Prateeksha", 17791);
		
		//Using lambda expression approach
		BiConsumer<String, Integer> biConsumer2 = (i1, i2) -> System.out.println("lambda expression implementation - Key : " + i1 + ", Value : " + i2);
		biConsumer2.accept("Ayansh", 5220);	
		
		//Realtime use of BiConsumer
		//foreach method of map accepts biconsumer interface as argument
		BiConsumer<String, Integer> biConsumer3 = (i1, i2) -> System.out.println("EmployeeName : " + i1 + ", Salary : " + i2);
		map.forEach(biConsumer3);
		//or, we can directly pass the lambda expression
		map.forEach((i1, i2) -> System.out.println("Name : " + i1 + ", Increment : " + i2));
		
		System.out.println("*****************************************************************");
		
		//BiPredicate
		//traditional approach
		BiPredicate<String, String> b1 = new BiPredicateDemo();
		System.out.println("traditional approach : " + b1.test("Abhi", "Abhi"));
		
		//using anonymous implementation
		BiPredicate<String, String> biPredicate = new BiPredicate<String, String>() {
			@Override
			public boolean test(String s1, String s2) {
				return s1.equals(s2);
			}
			
		};
		System.out.println("Palindrome check using biPredicate - anonymous : " + biPredicate.test("sir ", "sir"));
		
		//Using lambda expression approach
		BiPredicate<String, String> equalsPredicate = (s1, s2) -> s1.equals(s2);
		System.out.println("Palindrome check using biPredicate - lambda : " + equalsPredicate.test("sir", "sir"));
		
		BiPredicate<String, String> lengthPredicate = (s1, s2) -> s1.length() == s2.length();
		//BiPredicate interface contain default methods like - and, or, negate
		//and method - validate multiple conditions and all conditions shows throw true.
		boolean andOutput = lengthPredicate.and(equalsPredicate).test("madam", "madam");
		System.out.println("And - output : " + andOutput);
		
		//or method - validate multiple conditions and if one condition is satisfied, then we can go with or method
		boolean orOutput = lengthPredicate.or(equalsPredicate).test("abc", "def");
		System.out.println("Or - output : " + orOutput);
		
		//negate method - opposite of test method	
	}
}

//traditional approach
class BiFunctionDemo implements BiFunction<List<Integer>, List<Integer>, List<Integer>>{
	@Override
	public List<Integer> apply(List<Integer> list1, List<Integer> list2) {
		return Stream.of(list1, list2)
				.flatMap(List::stream)
				.distinct()
				.collect(Collectors.toList());
	}
	
}

//traditional approach
class BiConsumerDemo implements BiConsumer<String, Integer>{
	@Override
	public void accept(String i1, Integer i2) {
		System.out.println("Traditional approach - Input 1 : " + i1 + ", Input 2 : " + i2);
	}
}


//traditional approach
//Take 2 string and check if it is palindrome or not
class BiPredicateDemo implements BiPredicate<String, String>{
	@Override
	public boolean test(String s1, String s2) {
		return s1.equals(s2);
	}
}
