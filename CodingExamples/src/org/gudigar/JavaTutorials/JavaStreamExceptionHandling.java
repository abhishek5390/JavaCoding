package org.gudigar.JavaTutorials;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class JavaStreamExceptionHandling {

	public static void main(String[] args) {
		
		//We have given list of string and want to convert into list of integers
		List<String> list = Arrays.asList("44", "373", "567");
		//Ideal approach
		List<Integer> intList = list.stream().map(Integer::parseInt).collect(Collectors.toList());
		System.out.println("Ideal Approach of converting list of strings to list of integers: " + intList);
		System.out.println("***********************************************************************");
		
		//Traditional approach. Iterate through list and type cast using Integer.parseInt
		System.out.println("Traditional approach of converting list of strings to list of int");
		list.forEach(s -> System.out.println(Integer.parseInt(s)));
		System.out.println("***********************************************************************");
		
		//what happens if someone modifies the input content to illegal string like Arrays.asList("44", "373", "xyz");
		//when we run the above code, it gives NumberFormatException, since xyz is not a valid integer and type casting fails
		//this type of exceptions are unchecked ones
		
		list = Arrays.asList("44", "373", "xyz");
		//How to handle unchecked exceptions
		//simple approach. Not recommended way to handle exception using try-catch when used in lambda
		System.out.println("Handling unchecked exception by using try-catch block inside lambda");
		list.forEach(s -> {
			try {
				System.out.println(Integer.parseInt(s));
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		});
		System.out.println("***********************************************************************");
		
		//alternative way. Abstract the try-catch block code into a separate method and using method reference in foreach function. Not recommended approach
		System.out.println("Handling unchecked exception by using method reference");
		list.forEach(JavaStreamExceptionHandling::printlist);
		System.out.println("***********************************************************************");
		
		//Best approach
		//Foreach method accept consumer. So we will create a method (handleExceptionIfAny) which will return the consumer and handle the exception inside this method.
		System.out.println("Handling unchecked exception in method which return consumer");
		list.forEach(handleExceptionIfAny(s->System.out.println(Integer.parseInt(s))));
		System.out.println("***********************************************************************");
		
		//The above code is not a generic exception hierarchy
		/*
		List<Integer> list2 = Arrays.asList(1,2);
		list2.forEach(handleExceptionIfAny(s->System.out.println(Integer.parseInt(s))));
		//This will throw exception, because handleExceptionIfAny method will always accepts Consumer as a String, but we are parsing list2 having Integer
		*/
		
		System.out.println("Handling unchecked exception in generic method");
		//Rather than hardcoding, if we make generic, above code can handle any type of data. Create a generic method called handleGenericException
		list.forEach(handleGenericException(s->System.out.println(Integer.parseInt(s)), NumberFormatException.class));
		System.out.println("***********************************************************************");
		
		//System.out.println("Handling unchecked exception in generic method but passing different unchecked exception");
		//If i change it to Arthimetic exception, exception will not be handled. It will throw numberformatexception
		//list.forEach(handleGenericException(s->System.out.println(Integer.parseInt(s)), ArithmeticException.class));
		//System.out.println("***********************************************************************");
		
		//Creating a new list having integers and passing ArthimeticException
		System.out.println("Handling unchecked exception by creating a new list having integers and passing ArthimeticException");
		List<Integer> list2 = Arrays.asList(1,0);
		list2.forEach(handleGenericException(s -> System.out.println(10/s), ArithmeticException.class));
		//Output: 10
		//Exception: / by zero
		System.out.println("***********************************************************************");
		
		//How to handle checked exception in Java 8 streams
		System.out.println("Handling checked exception - traditional approach");
		List<Integer> list3 = Arrays.asList(10,20);
		list3.forEach(i -> {
			try {
				Thread.sleep(i);
				System.out.println(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		System.out.println("***********************************************************************");
		
		System.out.println("Handling checked exception - generic approach");
		list3.forEach(handleCheckedExceptionConsumer(i -> {
			Thread.sleep(i);
			System.out.println(i);
		}));
	}
	

	public static void printlist(String s) {
		try {
			System.out.println(Integer.parseInt(s));
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}
	
	//static method, return Consumer object of type string, since we are passing String, and converting it to Integer.parseInt
	//Consumer interface accept the argument and not return anything
	static Consumer<String> handleExceptionIfAny(Consumer<String> payload){
		return obj -> {
			try {
				payload.accept(obj);
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		};
	}
	
	static <Target, ExObj extends Exception> Consumer<Target> handleGenericException(Consumer<Target> targetConsumer, Class<ExObj> exObjClass){
		return obj -> {
			try {
				targetConsumer.accept(obj);
			} catch (Exception e) {
				try {
					ExObj exObj = exObjClass.cast(e);
					System.out.println("Exception: " + exObj.getMessage());
				} catch (ClassCastException ex) {
					throw ex;
				}
			}
		};
	}
	
	//This method is used to handle the checked exception
	static <Target> Consumer<Target> handleCheckedExceptionConsumer(CheckedExceptionHandlerConsumer<Target, Exception> handlerConsumer){
		return obj -> {
			try {
				handlerConsumer.accept(obj);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		};
	}
}

@FunctionalInterface
interface CheckedExceptionHandlerConsumer<Target, ExObj extends Exception>{
	public void accept(Target target) throws ExObj;
}
