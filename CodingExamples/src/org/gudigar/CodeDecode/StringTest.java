package org.gudigar.CodeDecode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

class Emp{
	private int id;
	private String name;
	
	
	public Emp(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + "]";
	}
	
}

public class StringTest {

	public static void main(String[] args) {
		
		Map<Emp, Integer> empMap = new LinkedHashMap<>();
		
		empMap.put(new Emp(101, "Abhishek"), 1);
		empMap.put(new Emp(102, "Abhishek"), 1);
		empMap.put(new Emp(103, "Abhishek"), 1);
		empMap.put(new Emp(104, "Abhishek"), 1);
		
		empMap.entrySet().stream().forEach(s -> System.out.println(s.getKey() + " - " + s.getValue()));
				
				
				
				//sorted(Map.Entry.comparingByKey(Comparator.comparing(Emp::getId)))
						//.collect(Collectors.toList());
		
//		for(Entry<Emp, Integer> entry :  collect) {
//			System.out.println(entry.getKey().toString() + "---- " + entry.getValue());
//		}
//	
		//Hashmap
		//
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//i/p - "i love india"
		//o/p - "india love i"
		
		//String str = "i love india";
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		int j =1;
//		StringBuilder sb = new StringBuilder();
//		Map<String, Integer> words = new HashMap<String, Integer>();
//		for (int i = 0; i < str.length(); i++) {
//
//			if(str.charAt(i) == ' ' ) {
//				words.put(sb.toString(), j);
//				sb = new StringBuilder();
//				j++;
//				continue;
//			}
//			sb.append(str.charAt(i)); 
//		}
//		words.put(sb.toString(), j);
//		
//		//Map [{i,1}, {love, 2}. {india, 3}]
//		
//		List<Entry<String, Integer>> collect = words.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
//					.collect(Collectors.toList());
//		
//		sb = new StringBuilder();
//		for(Entry<String, Integer> entry: collect) {
//			sb.append(entry.getKey() + " ");
//		}
//		sb.deleteCharAt(sb.length()-1);
//		System.out.print(sb.toString());	
	}

}
