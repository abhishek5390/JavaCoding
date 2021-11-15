package org.gudigar.CodeDecode;

public class ShadowingStaticMethod {

	/*
	 * Shadowing of Static methods
		What happens if we merge the below 2 concepts
		1. Overriding 
		2. Static methods 
	 */
	public static void main(String[] args) {
		//Dynamic polymorphism
		Animal animal = new AquaticAnimal();
		animal.specialCapability();
		//output - I am an aquatic animal		

		animal.color();
		//output - Animal color is black
		AquaticAnimal.color();
		//Output - Aquatic Animal color is white
		
		
	}

}

class Animal{
	public void specialCapability() {
		System.out.println("I am an animal");
	}
	
	public static void color() {
		System.out.println("Animal color is black");
	}
	
}

class AquaticAnimal extends Animal{
	public void specialCapability() {
		System.out.println("I am an aquatic animal");
	}
	
	public static void color() {
		System.out.println("Aquatic Animal color is white");
	}
}
