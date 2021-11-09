package org.gudigar.ConcurrentModificationException;

public class CompiletimeVsRuntimePolymorphism {

	public static void main(String[] args) {
		//poly - many
		//morph - behaviour
		
		A obj = new A();
		obj.show(); //calls task1. Here show() method is called from A class
		obj.show(5); //calls task2
		obj.show(5.0f); //calls task3
		
		obj = new B(); //Base class object reference pointing to derived class object
		obj.show(); //calls task4. Here show() method is called from B class
		
		obj = new C();
		obj.show(); //calls task5. Here show() method is called from C class
		
		//Runtime Polymorphism
		//obj.show() is called 3 times in the same way in different occasion
		//Here compiler cannot differentiate between these 3 statements obj.show(). 
		//Compiler is only aware of type of variable, not the value of variable.
		//If we want to decide which function to be called based on value of variable, we have to wait until runtime to do that
		//Compiler wont be knowing which method in the object has to be called and hence pass it on to runtime to decide.
		
		//Java will decide which show method to invoke only at runtime based on what obj is pointing to. 
		//if obj is pointing to B, it will call show method in B
		//if obj is pointing to C, it will call show method in C
	}
}

class A{
	//CompileTime Polymorphism
	//compiler will detect which of the multiple methods it should invoke during compilation, 
	//based on number of parameters or type of parameters
	//This is also known as method overloading
	//Method overloading
	public void show() {
		//task 1
		System.out.println("Show method in A with no paramters");
	}
	
	public void show(int i) {
		//task 2
		System.out.println("Show method in A with one int parameter");
	}
	
	public void show(float i) {
		//task 3
		System.out.println("Show method in A with one float parameter");
	}
}

class B extends A{
	//Method overriding
	public void show() {
		//task 4
		System.out.println("Show method in B");
	}
}

class C extends A{
	//Method overriding
	public void show() {
		//task 5
		System.out.println("Show method in C");
	}
}
