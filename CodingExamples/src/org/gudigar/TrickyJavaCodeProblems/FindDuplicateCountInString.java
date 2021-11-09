package org.gudigar.TrickyJavaCodeProblems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FindDuplicateCountInString {

	public static void main(String[] args) {

		findDuplicateWord("I am am learning java java java");
		findDuplicateChar("javaj2ee");
		Character firstRecurringChar = findFirstRecurringChar("DBC");
		if(firstRecurringChar != null) {
			System.out.println("First recurring character is : " + firstRecurringChar);
		}else {
			System.out.println("there are no recurring characters");
		}

	}

	private static Character findFirstRecurringChar(String str) {
		Set<Character> tempSet = new HashSet<>();
		for (int i = 0; i < str.length(); i++) {
			boolean add = tempSet.add(str.charAt(i));
			if(!add) {
				return str.charAt(i);
			}
		}
		return (Character) null;
		
	}

	private static void findDuplicateChar(String str) {
		Map<Character, Integer> charMap = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(charMap.get(c) != null) {
				charMap.put(c, charMap.get(c) + 1);
			}else {
				charMap.put(c, 1);
			}
		}

		Iterator<Character> iterator = charMap.keySet().iterator();
		while(iterator.hasNext()) {
			Character keyChar = iterator.next();
			if(charMap.get(keyChar) > 1) {
				System.out.println("The char " + keyChar + " appeared " + charMap.get(keyChar) + " no of times" );
			}
		}

	}

	private static void findDuplicateWord(String str) {
		String[] splitString = str.split(" ");

		Map<String, Integer> stringMap = new HashMap<>();;
		for (String tempString : splitString) {

			//if(stringMap.containsKey(tempString)) {
			if(stringMap.get(tempString) != null) {
				stringMap.put(tempString, stringMap.get(tempString) + 1);
			}else {
				stringMap.put(tempString, 1);
			}
		}
		System.out.println("StringMap: " + stringMap);

		for(Entry<String, Integer> entry : stringMap.entrySet()) {
			System.out.println(entry.getKey() + "------" + entry.getValue());
		}

		Iterator<String> iterator = stringMap.keySet().iterator();
		while(iterator.hasNext()) {
			String key = iterator.next();
			if(stringMap.get(key) > 1) {
				System.out.println("The word " + key + " appeared " + stringMap.get(key) + " no of times" );
			}
		}
	}
}
