package org.gudigar.ConcurrentModificationException;

public class Laptop implements Comparable<Laptop>{
	 private String brand;
	 private int ram;
	 private int price;
	 
	 
	public Laptop(String brand, int ram, int price) {
		super();
		this.brand = brand;
		this.ram = ram;
		this.price = price;
	}
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Laptop [brand=" + brand + ", ram=" + ram + ", price=" + price + "]";
	}
	
	//compareTo is method of Laptop class. So to call compareTo method, we need one object. By default, you have an object which is calling compareTo()
	//and also we are having one more object which is getting passed. In total there are 2 objects acting here. 
	//Here we use this keyword to access the object which is calling compareTo()
	//first obj > second obj = return postive number
	//first obj < second obj = return negative number
	//first obj = second obj = return 0
	@Override
	public int compareTo(Laptop lap2) {
		if(this.getRam() > lap2.getRam()) {
			return 1;
		}else {
			return -1;
		}
	}
	 
	 
}
