package org.gudigar.JavaTutorials;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapReduce {
//	Map-reduce is a functional programming model serves 2 purpose
//	map -> transforming data
//	reduce -> Aggregating data
//	(combine elements of a stream and produces a single value)

//	Ex: Stream[2,4,6,9,1,3,7] -> Sum of numbers present in stream?
//	Map() -> transform Stream<Object> into Stream<int>
//	Reduce() -> combine stream of int and produce the sum result

//	Reduce method
//	Signature: T reduce(T identity, BinaryOperator<T> accumulator);
//	identity is initial value of type T
//	accumulator is a function of combining two values
//
//	Integer sumResult = Stream.of(2,4,6,7,9,1,7)
//	                        .reduce(0, (a,b)->a+b)
//	Identity : 0 which is initial value
//	Accumulator : (a,b)->a+b
	
	public static void main(String[] args) {
		
		//Find the sum of all integers in the list
		List<Integer> numbers = Arrays.asList(3,7,8,1,5,9);
		
		//Stream provided sum reduction method
		int sum1 = numbers.stream().mapToInt(i -> i).sum();
		System.out.println(sum1);
		int sum2 = numbers.stream().mapToInt(Integer::intValue).sum();
		System.out.println(sum2);
		
		//Or
		//Reduce method
		Integer sum3 = numbers.stream().reduce(0, (a,b) -> a+b);
		System.out.println(sum3);
		Optional<Integer> sum4 = numbers.stream().reduce(Integer::sum); //Reduce sum with method reference
		System.out.println(sum4.get());
		
		//Multiply all the numbers
		Integer multiply = numbers.stream().reduce(1, (a,b) -> a*b);
		System.out.println(multiply);
		
		//Find the maximum number
		Integer maxNo = numbers.stream().reduce(0, (a,b) -> a>b?a:b);
		System.out.println(maxNo);
		
		//Find the minimum number using reduce method reference
		Integer minNo = numbers.stream().reduce(Integer::min).get(); //
		System.out.println(minNo);
		
		List<String> words = Arrays.asList("corejava", "spring","hibernate");
		
		//Find the longest word
		Optional<String> longestString = words.stream().reduce((word1,word2) -> word1.length() > word2.length() ? word1 : word2);
		System.out.println(longestString.get());
		
		//Realtime example of filter, map and reduce
		//Evaulate avg salary of gradeA employees
		List<Employee> employees = EmpDatabase.getAll();
		double avgSalary = employees.stream()
				.filter(emp -> emp.getGrade().equalsIgnoreCase("A"))
				.map(emp -> emp.getSalary())
				.mapToDouble(Double::doubleValue)
				.average().getAsDouble();
		System.out.println(avgSalary);
		
		//Evaulate sum of salary of gradeA employees
		double sumSalary = employees.stream()
				.filter(emp -> emp.getGrade().equalsIgnoreCase("A"))
				.map(emp -> emp.getSalary())
				.mapToDouble(i -> i)
				.sum();
		System.out.println(sumSalary);
	}
}

class EmpDatabase{
	public static List<Employee> getAll(){
		return Stream.of(
				new Employee(101, "AAA", "A", 600000),
				new Employee(102, "BBB", "B", 300000),
				new Employee(103, "CCC", "A", 200000),
				new Employee(104, "DDD", "A", 500000),
				new Employee(105, "EEE", "C", 400000)
				).collect(Collectors.toList());
	}
}

class Employee{
	private int id;
	private String name;
	private String grade;
	private double salary;
	
	public Employee() {
	}
	
	public Employee(int id, String name, String grade, double salary) {
		this.id = id;
		this.name = name;
		this.grade = grade;
		this.salary = salary;
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
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}	
}
