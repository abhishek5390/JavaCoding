package org.gudigar.CodeDecode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class BreakSingletonPattern {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, 
										SecurityException, InstantiationException, IllegalAccessException, 
										IllegalArgumentException, InvocationTargetException, FileNotFoundException, 
										IOException, CloneNotSupportedException {
		Singleton originalSingleton = Singleton.getSingletonInstance();
		Singleton duplicateSingleton = Singleton.getSingletonInstance();
		
		System.out.println("Hashcode for originalSingleton is " + originalSingleton.hashCode());
		System.out.println("Hashcode for duplicateSingleton is " + duplicateSingleton.hashCode());
		
		//To check if the singleton class is written correctly or not
		//Output
		//Hashcode for originalSingleton is 1297685781
		//Hashcode for duplicateSingleton is 1297685781
		
		//Ways to break Singleton design pattern
		//Reflection- way we can create a instance of Singleton class, but hashcode will be different
		
		//get the hold of singleton class
		Class<?> singletonInstance = Class.forName("org.gudigar.CodeDecode.Singleton");
		//Now get the hold of its constructor
		Constructor<Singleton> contructor = (Constructor<Singleton>) singletonInstance.getDeclaredConstructor();
		//We need to make Singleton class private constructor no more private, so that this constructor is accesible in this class
		contructor.setAccessible(true);
		
		Singleton brokenSingletonUsingReflection = contructor.newInstance();
		System.out.println("Hashcode for brokenSingletonUsingReflection is " + brokenSingletonUsingReflection.hashCode());
		//Output - Hashcode for brokenSingletonUsingReflection is 1252585652
		
		System.out.println("**********************************************");
		System.out.println("Breaking through serialization");
		//2nd way - Serialization
		
		//way to serialize a object
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Serialization.ser"));
		oos.writeObject(originalSingleton);
		oos.close();
		
		//way to deserialize
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Serialization.ser"));
		Singleton brokenSingletonUsingSerialization = (Singleton) ois.readObject();
		
		//to make it serializable we need to implement serializable interface on Singleton class
		System.out.println("Hashcode for brokenSingletonUsingSerialization is " + brokenSingletonUsingSerialization.hashCode());
		//Output - Hashcode for brokenSingletonUsingSerialization is 1205044462
		
		System.out.println("**********************************************");
		System.out.println("Breaking using cloning");
		//3rd way - Clone method
		
		//we need to implement cloneable inteface on singleton class and override clone method
		Singleton brokenSingletonUsingCloning = (Singleton) originalSingleton.clone();
		System.out.println("Hashcode for brokenSingletonUsingCloning is " + brokenSingletonUsingCloning.hashCode());
		//Output - Hashcode for brokenSingletonUsingCloning is 761960786

	}

}

/*
3 points for creating singleton class
1. Create instance variable of private static and return type is class itself
2. make constructor private. So that object of Singleton class cannot be created using new keyword
3. create public static method which returns the singleton class object
 */

class Singleton implements Serializable, Cloneable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Singleton singleton;
	
	private Singleton() {
	}
	
	public static Singleton getSingletonInstance() {
		//Lazy loading
		if (singleton == null) {
			singleton = new Singleton();
		}
		return singleton;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}
