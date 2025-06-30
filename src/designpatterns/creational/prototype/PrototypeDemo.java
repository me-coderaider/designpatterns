package designpatterns.creational.prototype;

import java.util.Arrays;

class Address implements Cloneable {
	public String streeName;
	public int houseNumber;

	public Address(String streeName, int houseNumber) {
		super();
		this.streeName = streeName;
		this.houseNumber = houseNumber;
	}

	@Override
	public String toString() {
		return "Address [streeName=" + streeName + ", houseNumber=" + houseNumber + "]";
	}
	
	// deep copy
	@Override
//	protected Object clone() throws CloneNotSupportedException {
	public Object clone() throws CloneNotSupportedException {
		//return super.clone();
		return new Address(streeName, houseNumber);// valid deep-copy mechanism
	}
}

class Person implements Cloneable{
	public String[] names;
	public Address address;

	public Person(String[] names, Address address) {
		super();
		this.names = names;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [names=" + Arrays.toString(names) + ", address=" + address + "]";
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
//		return super.clone();
		return new Person(names, address); // this is wrong, reason being names & address are references and will point to same object. 
	}
}

public class PrototypeDemo {
	public static void main(String[] args) throws Exception {
		Person john=new Person(new String[] {"John", "Wick"}, new Address("The Continental", 123));
		
		Person jane=(Person) john.clone();
		jane.names[0]="Jane";
		jane.address.houseNumber=124;
		
		System.out.println(john);
		System.out.println(jane);
	}
}
