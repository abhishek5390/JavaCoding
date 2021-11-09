package org.gudigar.ConcurrentModificationException;

import java.util.ArrayList;

public class Generics {

	
	public static void main(String[] args) {
		//Java is type safe language, whenever we need to work with any variable, it should be declared. 
		//Type of variable is known at compile time, not at runtime
		int value = 5;
		
		//Using generics in collections, we can avoid compile time errors when someone tried to add string value in the Integer based collection
		//If generics was not used, when string values is being retrieved and assigned to int variable, runtime error will be thrown
		//handling compile time errors is better than run time errors
		
		//Generics only supports classes / wrapper classes, We cannot use int, double
		Container<Integer> obj = new Container<>();
		obj.setValue(9);
		obj.show();
		
		Container<Double> obj1 = new Container<>();
		obj1.setValue(9.9);
		obj1.show();
		
		//?
		Container<Number> obj2 = new Container<>();
		obj2.demo(new ArrayList<Integer>());
		
		//super
		Container<Integer> obj3 = new Container<>();
		obj3.demo1(new ArrayList<Number>());
		
		//Not supports
		//Container<Student> obj1 = new Container<>();
		//Container<Object> obj1 = new Container<>();
	}

}

//creating custom generic class
//T-Type

//Integer, Double etc all extends Number class
class Container<T extends Number>{
	//Integer value; - thoughout the creation of Container object, value will be only Integer type
	//Object value;  - not type safe. need to mention type exactly
	T value; 
	
	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public void show() {
		System.out.println(value.getClass().getName());
	}
	
	//demo has parameter arraylist which only accepts anything which extends T type
	public void demo(ArrayList<? extends T> obj) {
		
	}
	
	//demo has parameter arraylist which only anything which is super class of T type
	public void demo1(ArrayList<? super T> obj) {
		
	}
}
