package org.gudigar.CodeDecode;

public class IsJavaPassByValueOrReference {
	 int number;
	public static void main(String[] args) {
		// Any computer languages are divided into 2 types
		//Pass by value
		//Pass by references
		
		//Pass by reference
		//Professor has some notes. Students need some notes. Professor pass original notes
		//Students misplaces original notes. Another student will not have any notes
		//You are sending memory address of variable into a function. And variable gets modify into that function, 
		//which means changing the real address of that variable & Original variable gets modifie
		
		
		//Pass by Value
		//Professor has some notes. Students need some notes. Professor pass photocopy of original notes
		//Students misplaces original notes. Another student can still get photocopy of notes
		//Rather than passing real memory address, copy the variable into another memory location and pass it as 
		//parameter to the function
		//ML-x(ABC) copied ML-z(ABC) => ML-z(123)
		
		//Is Java pass by value or pass by reference?
		//by default java is pass by value
		//When a variable is passed into a method, by default java creates a copy of variable and the copy is passed 
		//into that method. So when the variable copy is modified in the method, the original remains intact
		int a = 2;
		changePrimitive(a);
		System.out.println("value of a is : " + a);
		//Output - value of a is : 2
		
		//What happens if i pass Object references. 
		//Here if we make any instance variable changes in passed reference, does it affect in parent reference? - YES
		//Here when u pass object, you are actually passing the reference to memory location where object resides
		//hence when modify something at that memory address, it will reflected everywhere
		//BUt it is not pass by refernce, it is just you are passing reference as a value
		
		IsJavaPassByValueOrReference ref = new IsJavaPassByValueOrReference();
		ref.number = 2;
		
		changeObjectRefernce(ref);
		System.out.println("Value of number: " + ref.number);
		
	}

	private static void changeObjectRefernce(IsJavaPassByValueOrReference ref) {
		ref.number = 12;
	}

	private static void changePrimitive(int aCopy) {
		aCopy =13;
		
	}

}


