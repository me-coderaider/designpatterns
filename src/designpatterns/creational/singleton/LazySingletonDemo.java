package designpatterns.creational.singleton;

class LazySingleton {

	private static LazySingleton instance;

	private LazySingleton() {
		System.out.println("Initializating a lazy singleton.");

	}

	public static LazySingleton getInstance() {
		if (instance == null) {
			instance = new LazySingleton();
		}
		return instance;
	}
}

public class LazySingletonDemo {

}
