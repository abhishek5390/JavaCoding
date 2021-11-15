package org.gudigar.JavaTutorials;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CompletableFutureRunAsyncSupplyAsync {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//create a future object
		ExecutorService service = Executors.newFixedThreadPool(10);
		//Interview question: Difference between submit and execute method of ExecutorService framework?
		//execute() method takes argument as runnable, submit takes argument as Callable
		//I want to return value after thread execution, i will go with submit. This will give me back Future object
		Future<List<Integer>> future = service.submit(() -> {
			//Assume your are doing some api call and api is taking 1 min time to give the response back
			//in this case, main thread will blocked for 1 min
			System.out.println("Thread : " + Thread.currentThread().getName());
			delay(1); //just mimicing the scenario
			//after 1 min, the response is returned
			System.out.println(10/0); //this will throw arithemetic exception, which cannot be handled here. 
			return Arrays.asList(1, 2, 3, 4, 5);
		});
		
		List<Integer> list = future.get(); // Hence here future has to wait for 1 mins and no way to manually complete it
		
		System.out.println(list);
		
		//Here the list available from future cannot be sent as argument for another thread
		//future1+future2+future3 -> not possible
		//possible -> future1.get()
		//future2.get()
		//future3.get()
		
		System.out.println("****************************************");
		
		//How to create CompletableFuture
		CompletableFuture<String> completableFuture = new CompletableFuture<>();
		completableFuture.get(); 
		//get method will block the thread unless and until CompletableFuture is not done executing
		//to avoid that we can use complete method, which will forcefully complete the thread if it is taking long time 
		//and then return the value
		completableFuture.complete("return some dummy data"); //This is how we can complete the thread manually
		
		System.out.println("****************************************");
		
		//runAsync()
		//if we want to run some background task asynchronously and do not want to return anything from the task, 
		//then CompletableFuture.runAsync() method can be used. It takes Runnable object and returns CompletableFuture<Void>
		//1. CompletableFuture.runAsync(Runnable)
		//2. CompletableFuture.runAsync(Runnable, Executor)
		
		//supplyAsync()
		//if we want to run some background task asynchronously and want to return anything from the task, 
		//then CompletableFuture.supplyAsync() method can be used. It takes Supplier<T> and returns CompletableFuture<T>
		//where T is type of value obtained by calling the given supplier
		//1. CompletableFuture.supplyAsync(Supplier<T>)
		//2. CompletableFuture.supplyAsync(Supplier<T>, Executor)
		
		//why there is 2 overloaded method in CompletableFuture, one which is accepting Executor and other not
		//method not having Executor - CompletableFuture will get thread from forkjoin global pool and it will execute the code
		//method having Executor - CompletableFuture will get thread from custom Executor
		
		
		
	}

	private static void delay(int min) {
		try {
			TimeUnit.MINUTES.sleep(min);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}

class RunAsyncDemo{
	//Example: i have to read the Json file (having employee details), where i convert into employee obj and save it in DB. 
	//After execution, i am not expecting any return type from thread
	public void saveEmployee(File jsonFile) {
	
		
	}
	
}


class EmployeeDB {

    private String employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String newJoiner;
    private String learningPending;
    private int salary;
    private int rating;
    
	public EmployeeDB() {
	}

	public EmployeeDB(String employeeId, String firstName, String lastName, String email, String gender, String newJoiner,
			String learningPending, int salary, int rating) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.newJoiner = newJoiner;
		this.learningPending = learningPending;
		this.salary = salary;
		this.rating = rating;
	}
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getNewJoiner() {
		return newJoiner;
	}
	public void setNewJoiner(String newJoiner) {
		this.newJoiner = newJoiner;
	}
	public String getLearningPending() {
		return learningPending;
	}
	public void setLearningPending(String learningPending) {
		this.learningPending = learningPending;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}  
}
