package designpatterns.creational.singleton;

class LazySingleton {

	private static LazySingleton instance;

	private LazySingleton() {
		System.out.println("Initializating a lazy singleton.");

	}
	// method 1 :- using 'synchronized keyword' to protect the singleton from being
	// instantiated more than once
//	public static synchronized LazySingleton getInstance() {
//		if (instance == null) {
//			instance = new LazySingleton();
//		}
//		return instance;
//	}

	// method 2:- double-checked locking
	public static LazySingleton getInstance() {
		if (instance == null) {
			synchronized (LazySingleton.class) {
				if (instance == null) {
					instance = new LazySingleton();
				}
			}
		}
		return instance;
	}
}

public class LazySingletonDemo {

}
