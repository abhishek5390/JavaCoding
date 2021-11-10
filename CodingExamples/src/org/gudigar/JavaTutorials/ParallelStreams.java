package org.gudigar.JavaTutorials;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class ParallelStreams {

	/*
	Java Parallel Streams 
	introduced in java 8
	meant for utilizing multiple cores of the processor.
	
	Normally any java code has one stream of processing, where it is executed sequentially. 
	Whereas by using parallel streams, we can divide code into multiple streams that are executed in parallel on separate cores
	and final result is the combination of individual outcomes.
	
	The order of execution, however, is not under our control.
	 */
	public static void main(String[] args) {
		//iterate 100 records using normal and parallel stream and evaulate the performance
		
		long start = 0;
		long end = 0;
		
		/*
		start = System.currentTimeMillis();
		IntStream.range(1, 100).forEach(System.out::println);
		end = System.currentTimeMillis();
		System.out.println("Plain stream took time - " + (end - start));
		//Time it took is around 73 millisecs
		//Order of execution is sequential
		
		System.out.println("******************************************************************");
		//2 ways of creating parallel stream - using parallel() method or using parallelStream()
		start = System.currentTimeMillis();
		IntStream.range(1, 100).parallel().forEach(System.out::println);
		end = System.currentTimeMillis();
		System.out.println("Parallel stream took time - " + (end - start));
		//Time it took is around 26 millisecs
		//Order of execution is sequential is random
		*/
		
		//Normal stream
		IntStream.range(1, 10).forEach(x -> System.out.println("Thread : " + Thread.currentThread().getName() + " : " + x));
		
		//Parallel stream
		IntStream.range(1, 10).parallel().forEach(x -> System.out.println("Thread : " + Thread.currentThread().getName() + " : " + x));
		
		System.out.println("******************************************************************");
		List<Employee> employees = EmployeeDatabase.getEmployees();
		//find average using normal stream. (using map reduce function)
		start = System.currentTimeMillis();
		double salaryWithStream = employees.stream().map(Employee::getSalary).mapToDouble(i -> i).average().getAsDouble();
		end = System.currentTimeMillis();
		System.out.println("Normal stream execution time - " + (end - start) + " .Average Salary with Normal stream : " + salaryWithStream);
		//Output : Normal stream execution time - 161
		
		
		//find average using normal stream. (using map reduce function)
		start = System.currentTimeMillis();
		double salaryWithParallelStream = employees.parallelStream().map(Employee::getSalary).mapToDouble(i -> i).average().getAsDouble();
		end = System.currentTimeMillis();
		System.out.println("Parallel stream execution time - " + (end - start) + " .Average Salary with parallel stream: " + salaryWithParallelStream);
		//Output: Parallel stream execution time - 2
	}

}

class EmployeeDatabase{
	
	public static List<Employee> getEmployees(){
		List<Employee> employees = new ArrayList<>();
		for (int i = 1; i <=1000; i++) {
			employees.add(new Employee(i, "employee"+i, "A", Double.valueOf(new Random().nextInt(1000*100))));
		}
		return employees;
	}
}
