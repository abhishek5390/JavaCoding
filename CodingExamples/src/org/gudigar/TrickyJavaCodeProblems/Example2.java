package org.gudigar.TrickyJavaCodeProblems;

public class Example2 {

	public static void main(String[] args) {
		
		//Nested class
		final class Constants {
			//public static String name = "PI";
			
			//When using nested class, a field name cannot be static in a non static context, 
			//unless we initialize it as constant by declaring it as final. hence compile time error is thrown. 
			
			public static final String name = "PI";
		}
		
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Constants.name);
			}
		});
		thread.start();
	}
}
