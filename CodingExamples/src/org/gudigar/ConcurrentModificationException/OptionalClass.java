package org.gudigar.ConcurrentModificationException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalClass {

	/*
	Object - Either it contains data or null value. If data, we can execute the program. if null, program will throw NPE

	Customer
	   id
	   name

	main
	   Customer c1 = new Customer(101,"abc");
	   c1.getName() -> this will give data

	   Customer c2 = new Customer(101,null);
	   String name = c2.getName() -> gives null
	   name.toUpperCase() -> throws NPE

	To avoid this, we can do null check before doing any operations
	But how could i know c2.getName() is getting null?
	Or what if Customer class contains more than 100 fields and adding null check condition to each one of them will be tiring

	So to avoid these scenarios and to avoid unpredictable NPE, java introduced Optional class

	Optional is a public final class. It contains 3 static methods and is used for optional object creation - empty(), of(), ofNullable().
	it also contains couple of instance methods - equals, get, isPresent, map, orElse etc
	Also contains concrete methods - 
	*/
	public static void main(String[] args) throws Exception {
		
		Customer customer = new Customer(101, "Abhishek", "abhi@gmail.com", Arrays.asList("1412124141", "211434353"));
		
		//How to create optional object
		
		//Empty
		//empty() method will return empty Optional object
		Optional<Object> emptyOptional = Optional.empty();
		System.out.println(emptyOptional);
		
		//Of
		//If we pass any null object into Of method, it will do null check internally and it will give NPE
		//When we know the object we are passing is not null, then we can use Of method
		/*
		Optional<String> emailOptional = Optional.of(customer.getEmail());
		System.out.println(emailOptional);
		*/
		
		//OfNullable
		//ofNullable = empty() + of()
		//if object is null, then empty() is called and return empty optional object, 
		//if object is not null, of() method is called
		//hence ofNullable will never throw NPE
		Optional<String> emailOptional2 = Optional.ofNullable(customer.getEmail());
		if(emailOptional2.isPresent()) {
			System.out.println(emailOptional2.get());
		}
		//System.out.println(emailOptional2.get()); This will throw NoSuchElement exception
		
		//If the object value is null and i want to return a default value in case of null value, then we can use orElse
		//Here we can return some message or throw some customized exception
		System.out.println(emailOptional2.orElse("default@gmail.com"));
		//We have orElseGet(). it need input as a supplier functional interface. Supplier will have one get method and its return type. 
		//Both orElse or orElseGet used for same purpose
		/*
		System.out.println(emailOptional2.orElseThrow(() -> new IllegalArgumentException("email not present")));
		*/
		
		//get value from emailOptional2 and convert it to uppercase using map()
		System.out.println(emailOptional2.map(String::toUpperCase).orElseGet(() -> "default email..."));	
		
		
		getCustomerByEmailId("pqr@gmail.com"); 

	}
	
	public static Customer getCustomerByEmailId(String email) throws Exception {
		List<Customer> customers = Database.getAll();
		return customers.stream()
				.filter(customer -> customer.getEmail().equals(email)).findAny()
				.orElseThrow(() -> new Exception("no customer present with this email id"));
		
	}
}
