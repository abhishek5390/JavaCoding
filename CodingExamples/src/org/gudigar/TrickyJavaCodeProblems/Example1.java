package org.gudigar.TrickyJavaCodeProblems;

public class Example1 {

	public static void main(String[] args) {
		System.out.println("-------------------Code 1-----------------");
		//\u000d System.out.println("Comment executed");
		
		System.out.println("-------------------Code 2-----------------");
		//Find the mistake in the below code
		//String s = "ONE"+1+2+"TWO"+"THREE"+3+4+FOUR"+"FIVE"+5;
		//System.out.println(s);
				
		System.out.println("-------------------Code 3-----------------");
		//Unary operations. What will be the output
		int i = 10 + +11 - -12 + +13 - -14 + +15;
		System.out.println(i);		
		
		System.out.println("-------------------Code 4-----------------");
//		String one = "Random";
//		String two = "RAndom";
		
//		String one = "Random";
//		String two = "Random";
		
//		String one = "Random";
//		String two = new String("RAndom");
		
//		String one = "Random";
//		String two = new String("Random");
		
//		String one = new String("Random");
//		String two = new String("RAndom");
		
		String one = new String("Random");
		String two = new String("Random");
		
		System.out.println(one == two);
		System.out.println(one.equals(two));
		System.out.println(one.equalsIgnoreCase(two));
		
		System.out.println("-------------------Code 5-----------------");
		System.out.println(Fruit.TYPE);
		
		System.out.println("-------------------Code 6-----------------");
		System.out.println(Fruit1.name);
		
		System.out.println("-------------------Code 7-----------------");
		Integer i1 = 127;
		Integer i2 = 127;
		System.out.println(i1 == i2);
		Integer i3 = 128;
		Integer i4 = 128;
		System.out.println(i3 == i4);
		//Concept of cache working with Integer. Only till value 127, cache pool will have values stored for Integers,
		//beyond 127, a new object is created with different memory address
		//Caching principle for Integer, Byte, Long &  Short = -127 to 127
		//For character wrapper class, it is 0 to 127
		
		System.out.println("-------------------Code 8-----------------");
		System.out.println(Math.min(Double.MIN_VALUE, 0.0d));
		//Math.min - min function checks what is the minimum value between 2 paramters provided
		//Double.MIN_VALUE = 4.9E-324 (absolute value, not  negative). This value is greater than 0.0d
		
		System.out.println(Math.min(Integer.MIN_VALUE, 0.0d));
		//Integer.MIN_VALUE = -2147483648 (negative value). This value is lesser than 0.0d
		
		System.out.println("-------------------Code 9-----------------");
		long longWithL = 1000 * 60 * 60 * 24 * 365L;
		long longWithoutL = 1000 * 60 * 60 * 24 * 365;
		
		System.out.println(longWithL); //31536000000
		System.out.println(longWithoutL); //1471228928. when all numbers are multiplied and the values goes beyond the boundary of integers,
		//it starts truncating it to 32-bit max value. Max value which Integer can hold is 2147483648
		
		System.out.println("-------------------Code 9-----------------");
		System.out.println("Abhishek"+10+20);
		System.out.println("Abhishek"+10*20);
		System.out.println("Abhishek"+20+10*20);
		System.out.println("Abhishek"+20/10+20);
		System.out.println("Abhishek"+20+10+5*20);
		System.out.println("Abhishek"+100/20+20+10);
	}
}

interface IFruit{
	//by default public static final variable
	public String TYPE = "Apple";
}

class Fruit implements IFruit{
	
}

class IFruit1{
	//Static keyword is applicable to variables, methods, block of codes and nested classes.
	protected static String name = "Mango";
}

class Fruit1 extends IFruit1{
	
}




