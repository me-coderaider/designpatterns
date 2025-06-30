package designpatterns.creational.singleton;

class BasicSingleton {
	// cannot new this class, however
	// * instance can be created deliberately (reflection)
	// * instance can be created accidentally (serialization)
	private BasicSingleton() {
	}

	private static final BasicSingleton INSTANCE = new BasicSingleton();

	private int value = 0;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	// generated getter
	public static BasicSingleton getInstance() {
		return INSTANCE;
	}
}

class BasicSingletonDemo {

	public static void main(String[] args) {
		BasicSingleton singleton = BasicSingleton.getInstance();
		singleton.setValue(121);

		System.out.println(singleton.getValue());
	}
}
