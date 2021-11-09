package org.gudigar.TrickyJavaCodeProblems;

public class Example3 {
	
	static int a = 1111;
	static {
		a = a-- - --a;
		//a-- = 1111-- = 1110
		//--a = --1110 = 1109
		//a = 1111 - 1109 = 2
	}
	//Below block of code will never be executed. 
	{
		a = a++ + ++a;
	}
	public static void main(String[] args) {
		System.out.println(a);

	}

}
