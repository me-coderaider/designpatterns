package designpatterns.creational.singleton;

import java.io.File;
import java.io.IOException;

class StaticBlockSingleton {

	private StaticBlockSingleton() throws IOException {
		System.out.println("Singleton is initializing");
		File.createTempFile(".", "."); // this will throw an exception
	}

	// 'instance' is no longer final
	private static StaticBlockSingleton instance;
	static {
		try {
			instance = new StaticBlockSingleton();
		} catch (Exception e) {
			System.err.println("Failed to create singleton");
		}
	}

	public static StaticBlockSingleton getInstance() {
		return instance;
	}
}

public class StaticBlockSingletonDemo {

}
