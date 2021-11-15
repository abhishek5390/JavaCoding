package org.gudigar.JavaTutorials;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ImmutableClassDemo {
	/*
	 * Immutable class are the ones whose object cannot be modified in anyway once created
	 * Once we create object of immutable class and initialize any fields of that object, it cannot be changed
	 * and remains same through out the life of the object
	 * If there are methods which changes the contents of the object, new object is created with modified content.
	 * Original object does not change
	 * 
	 * Ex; String class. It contains methods which can try to change the content of variables, but ultimately it will 
	 * return new object with modified content
	 * Other examples are all the wrapper classes for primitives
	 * 
	 * Steps to create immutable classes
	 * 1. Methods of class should not be overriden by subclasses. To do that, mark class as final
	 * 
	 * 2. Make all fields private and final. If field is primitive type, then its value cant be changed
	 * as it is final. If field is holding a reference to another object, then declaring that field as 
	 * final means its reference cant be changed, and object can be changed
	 * Having access modifier as private for the fields ensure that fields are not accessed outside the class
	 * 
	 * 3. Initialize all the fields in a constructor
	 * 
	 * 4. Dont provide setter method or any method that can change the state of the object.
	 * Only provide methods that can access the value (like getters)
	 * 
	 * 5. In case any of the fields of the class holds reference to a mutable object, any change to those objects
	 * should also not be allowed. for that-
	 *   a. Make sure that there are no methods within the class that can change those mutable objects(change any of the field content)
	 *   b. Dont share reference of the mutable object, if any of the methods of your class return the reference of the 
	 *   mutable object, then its contents can be changed
	 *   c. If reference must be returned, create copies of your internal mutable objects and return those copies rather
	 *   than original object. The copy you are creating of the internal mutable object must be deep copy and 
	 *   not the shallow copy
	 *   
	 */
	public static void main(String[] args) {
		EmployeeDemo e1 = new EmployeeDemo(1001, "AAA", new BigDecimal("90000.00"), getDob("04/02/1986"), new Address("Street1", "City1"), Arrays.asList("J1", "J2"));
		EmployeeDemo e2 = new EmployeeDemo(1002, "BBB", new BigDecimal("40000.00"), getDob("25/06/1990"), new Address("Street2", "City2"), Arrays.asList("J3", "J4"));
		EmployeeDemo e3 = new EmployeeDemo(1003, "CCC", new BigDecimal("10000.00"), getDob("13/04/1980"), new Address("Street3", "City3"), Arrays.asList("J5", "J6"));
		EmployeeDemo e4 = new EmployeeDemo(1001, "DDD", new BigDecimal("30000.00"), getDob("31/01/1995"), new Address("Street4", "City4"), Arrays.asList("J7", "J8"));
	
		ConcurrentHashMap<EmployeeDemo, String> empMap = new ConcurrentHashMap<>();
		empMap.put(e1, "IT");
		empMap.put(e2, "Finance");
		empMap.put(e3, "IT");
		empMap.put(e4, "Finance");
		
		Set<Entry<EmployeeDemo, String>> entrySet = empMap.entrySet();
		for(Entry<EmployeeDemo, String> entry : entrySet) {
			EmployeeDemo emp = entry.getKey();
			String dept = entry.getValue();
			System.out.println(emp);
			System.out.println(dept);
		}
		System.out.println("-------------------");
		e1.getDob().setTime(7897009880L);
		
		e1.getAddress().setCity("Bangalore");
		//Output
		//EmployeeDemo [id=1001, name=AAA, salary=90000.00, dob=Thu Apr 02 15:06:49 IST 1970]
		//null
		System.out.println(e1);
		System.out.println(empMap.get(e1));
	}

	private static Date getDob(String dob) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			return dateFormat.parse(dob);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}

final class EmployeeDemo{
	private final Integer id;
	private final String name;
	private final BigDecimal salary;
	private final Date dob;
	private final Address address;
	private final List<String> skills;
	
	public EmployeeDemo(Integer id, String name, BigDecimal salary, Date dob, Address address, List<String> skills) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.dob = dob;
		this.address = address;
		this.skills = skills;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public Date getDob() {
		//return dob;
		return new Date(dob.getTime()); //deep copy, cloned copy
	}

	public Address getAddress() {
		Address address = new Address();
		address.setAddressLine1(this.address.getAddressLine1());
		address.setCity(this.address.getCity());
		return address;
		
		//return address;
	}

	public List<String> getSkills() {
		return new ArrayList<>(skills);
		//return skills;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((salary == null) ? 0 : salary.hashCode());
		result = prime * result + ((skills == null) ? 0 : skills.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeDemo other = (EmployeeDemo) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (salary == null) {
			if (other.salary != null)
				return false;
		} else if (!salary.equals(other.salary))
			return false;
		if (skills == null) {
			if (other.skills != null)
				return false;
		} else if (!skills.equals(other.skills))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EmployeeDemo [id=" + id + ", name=" + name + ", salary=" + salary + ", dob=" + dob + ", address="
				+ address + "]";
	}
	
}

class Address{
	private String addressLine1;
	private String city;
	
	public Address() {
		super();
	}
	
	public Address(String addressLine1, String city) {
		super();
		this.addressLine1 = addressLine1;
		this.city = city;
	}
	
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [addressLine1=" + addressLine1 + ", city=" + city + "]";
	}
	
	
}