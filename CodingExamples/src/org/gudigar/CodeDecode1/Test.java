package org.gudigar.CodeDecode1;

public class Test {
	
	public static void main(String[] args) {
		
		int[] numbers = {100, 50, 70, 110, 90};
		Integer firstBigInt = null;
		Integer secondBigInt = null;
		Integer tempInt = null;
		for (int i = 0; i < numbers.length; i++) {
			if(firstBigInt == null) {
				firstBigInt = numbers[i]; //100
				continue;
			}
			
			//50>100
			if(numbers[i] > firstBigInt ) {
				tempInt = firstBigInt; //50
				firstBigInt = numbers[i]; //70
				
				
				if(secondBigInt == null) {
					secondBigInt = tempInt; //60
				}
				
				if(tempInt > secondBigInt) {
					secondBigInt = tempInt;  //60
				}
				
			}
			else if(secondBigInt == null || (secondBigInt != null && numbers[i] > secondBigInt)) {
				secondBigInt = numbers[i];
			}
			
		}
		
		System.out.println(firstBigInt);
		System.out.println(secondBigInt);
	}
}
