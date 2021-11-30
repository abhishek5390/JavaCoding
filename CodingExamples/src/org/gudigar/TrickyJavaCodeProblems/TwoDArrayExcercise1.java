package org.gudigar.TrickyJavaCodeProblems;

public class TwoDArrayExcercise1 {

	public static void main(String[] args) {
		
		int[][] twoDArray = {
				{10,25,38},
				{46,15,69},
				{47,98,19},
				{10,81,92}
		};
		
		//Find the sum of each rows
		for (int i = 0; i < 4; i++) {
			int sum = 0;
			for (int j = 0; j < 3; j++) {
				sum += twoDArray[i][j];
			}
			System.out.println("Sum of row " + (i+1) + " is : " + sum );
			
		}
		
		//Find the sum of each column
		for (int i = 0; i < 3; i++) {
			int sum1 = 0;
			for (int j = 0; j < 4; j++) {
				sum1 += twoDArray[j][i];
			}
			
			System.out.println("Sum of column " + (i+1) + " is : " + sum1 );
		}
		
		//Find Max number in each row
		for (int i = 0; i < 4; i++) {
			int max = twoDArray[i][0];
			for (int j = 1; j < 3; j++) {
				max = (twoDArray[i][j] > max) ? twoDArray[i][j] : max;
			}
			System.out.println("Maximum Number in row " + (i+1) + " is : " + max);
		}
		
		//Simplified version of above code
		
		for (int i = 0; i < 4; i++) {
			System.out.println("Maximum Number in row " + (i+1) + " is : " + getMax(twoDArray[i]));
		}
	}

	private static Integer getMax(int[] integers) {
		int max = integers[0];
		for (int i = 1; i < integers.length; i++) {
			max = (max < integers[i]) ? integers[i] : max;
		}
		return max;
	}

}
