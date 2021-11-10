package org.gudigar.JavaTutorials;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapVsFlatMap {

	public static void main(String[] args) {
		
//		map and flatmap()
//		introduced in java 8.
//		Both these methods are intermediate methods and returns another stream as output.
		
		List<Customer> customers = Database.getAll();
		
//		map() method is used for transformation
//		takes Stream<T> as input and return Stream<R>
//		method signature: Stream<R> map(Stream<T> input){}
//		<R> Stream<R> map(Function<? super T, ? extends R> mapper);
//		Its mapper functions produces single value for each input value. Hence it is called one-to-one mapping

//		Data transformation - converting lower to upper case is called mapping, returning it as another stream is called data transformation
//		Ex: Stream.of{"a","b","c","d"} -> [A,B,C,D]

		//Requirement: Get List of emails from List of customer
		List<String> emails = customers.stream().map(customer -> customer.getEmail()).collect(Collectors.toList());
		System.out.println(emails);
		//customer -> customer.getEmail() -> one to one mapping
		
//      ****************************************************************************************************************
//		flatmap() method is used for transformation & flattering
//		flatmap() -> map() + flattering.
//		takes Stream<Stream<T>> as input and return Stream<R>
//		method signature: Stream<R> flatmap(Stream<Stream<T>> input){}
//		<R> Stream<R> flatmap(Function<? super T, ? extends Stream<? extends R>> mapper);
//		Its mapper functions produces multiple value for each input value. Hence it is called one-to-many mapping
		
//		Data Flattering - converting stream of stream into single stream
//		{[1,2],[3,4],[5,6],[7,8]} -> [1,2,3,4,5,6,7,8]
		
		//Requirement: Get List of phone numbers from List of customer
		List<List<String>> phoneNos = customers.stream().map(customer -> customer.getPhoneNos()).collect(Collectors.toList());
		System.out.println(phoneNos);
		//Output - [[321312412, 123213124], [658675635, 324235255], [967362525, 141626357], [4365476586, 1421325235]]
		//here i get data in non flattered structured and we cannot expect List<String> as return type. Hence flat map is preferred.
		//customer -> customer.getPhoneNos() -> one to many mapping
		
		//Here flatMap takes input as stream of stream
		List<String> phoneNos1 = customers.stream().flatMap(customer -> customer.getPhoneNos().stream()).collect(Collectors.toList());
		System.out.println(phoneNos1);
		//Output -> [321312412, 123213124, 658675635, 324235255, 967362525, 141626357, 4365476586, 1421325235]	
	}

}

class Database{
	public static List<Customer> getAll(){
		return Stream.of(
				new Customer(101, "ABC", "abc@gmail.com", Arrays.asList("321312412", "123213124")),
				new Customer(102, "DEF", "def@gmail.com", Arrays.asList("658675635", "324235255")),
				new Customer(103, "GHI", "ghi@gmail.com", Arrays.asList("967362525", "141626357")),
				new Customer(104, "JKL", "jkl@gmail.com", Arrays.asList("4365476586", "1421325235"))
				).collect(Collectors.toList());
	}
}

class Customer{
	private int id;
	private String name;
	private String email;
	private List<String> phoneNos;
	
	public Customer() {
	}

	public Customer(int id, String name, String email, List<String> phoneNos) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNos = phoneNos;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<String> getPhoneNos() {
		return phoneNos;
	}
	public void setPhoneNos(List<String> phoneNos) {
		this.phoneNos = phoneNos;
	}	
}

/*
Difference between Map() and flatMap()
		Map()									FlatMap()
1. process stream of values					process stream of stream of values
2. does mapping only						does mapping and flattering
3. mapper functions produces single      	mapper function produces multiple values for
   value for each input value  				each input value
4. it is one to one mapping					it is one to many mapping
5. Data transformation: from stream 		Data transformation: from Stream<Stream> to stream
   to stream
*/