package designpatterns.creational.builder;

class Person {
	public String name;
	public String position;

	@Override
	public String toString() {
		return "Person [name=" + name + ", position=" + position + "]";
	}
}

class PersonBuilder {
	protected Person person = new Person();

	public PersonBuilder withName(String name) {
		person.name = name;
		return this;
	}

	public Person build() {
		return person;
	}
}

public class FluentBuilderWithRecursiveGenerics {
	public static void main(String[] args) {

		PersonBuilder pb = new PersonBuilder();
		Person person = pb.withName("John").build();
		System.out.println(person);
	}
}
