package designpatterns.creational.prototype;

import java.util.Arrays;

class Address {
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
}

class Person {
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
}

public class PrototypeDemo {
	public static void main(String[] args) {
		Person john=new Person(new String[] {"John", "Wick"}, new Address("The Continental", 123));
		
		Person jane=john;// john & jane refers to the same object and as a result both share same data.
		// Hence we're overriding 'john' when we update 'jane'
		jane.names[0]="Jane";
		jane.address.houseNumber=124;
		
		System.out.println(john);
		System.out.println(jane);
	}
}
