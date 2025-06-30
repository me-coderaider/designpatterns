package designpatterns.creational.singleton;

class CEO {
	private static String name;
	private static int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		CEO.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		CEO.age = age;
	}

	@Override
	public String toString() {
		return "CEO [name=" + name + ", age=" + age + "]";
	}

}

public class MonoStateSingletonDemo {
	public static void main(String[] args) {
		CEO ceo=new CEO();
		ceo.setName("John Wick");
		ceo.setAge(52);
		
		CEO ceo2=new CEO();
		System.out.println(ceo2); // as all the data-storage fields are STATIC, so we'll get ceo2 already initialized 
	}
}
