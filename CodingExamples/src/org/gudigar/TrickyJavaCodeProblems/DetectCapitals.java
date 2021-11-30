package org.gudigar.TrickyJavaCodeProblems;

import java.util.function.Predicate;

public class DetectCapitals {

	/*
	 * Judge whether the given word has right usage of capitals
	 * Right usage:
	 * All capitals Ex: USA
	 * All lower case Ex: abhishek
	 * First letter capital Ex: Gudigar
	 */
	public static void main(String[] args) {
		//Approach 1: 
		//Count number of uppercase letters
		//if it is zero or length of string, return true
		//If it is not 1, return false
		//If it is 1 and if first letter is uppercase, return true
		
		//Time Complexity - O(N) , where N is length of the word
		//O(N) - Algorithm is dependent of size of the input
		
		String word = "Abhi";
		System.out.println(word + " is valid? - " +detectCapitalUse(word));

		//Can we do better?
		//Disadvantage - not quitting at wrong character
		//Ex: AaA
		// valid - A A A .........   condition 1
		// valid - a a a .........   conditions 2
		// valid - A a a .........   condition 2
		
		System.out.println(word + " is valid? - " +detectCapitalUse1(word));
		
		System.out.println(word + " is valid? - " +detectCapitalUse2(word));
	}

	private static boolean detectCapitalUse(String word) {
		int noOfCapitals = 0;
		for (int i = 0; i < word.length(); i++) {
			if(Character.isUpperCase(word.charAt(i))) {
				noOfCapitals++;
			}
		}
		
		if(noOfCapitals == 0 || noOfCapitals == word.length()) return true;
		return noOfCapitals == 1 && Character.isUpperCase(word.charAt(0));	
	}
	
	private static boolean detectCapitalUse1(String word) {
		int length = word.length();
		//condition 1
		if(Character.isUpperCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
			for (int i = 2; i < length; i++) {
				if(Character.isLowerCase(word.charAt(i))) return false;
			}
		}else {
			for (int i = 1; i < length; i++) {
				if(Character.isUpperCase(word.charAt(i))) return false;
			}
		}
		return true;
	}
	
	private static boolean detectCapitalUse2(String word) {
		int length = word.length();
		
		Predicate<Character> correctCase = Character::isLowerCase;
		
		if(Character.isUpperCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
			correctCase = Character::isUpperCase;
		}
		for (int i = 1; i < length; i++) {
			if(!correctCase.test(word.charAt(i))) return false;
		}
		return true;
	}
}
