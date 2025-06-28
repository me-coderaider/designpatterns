package designpatterns.creational.factory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.lang.reflect.Type;
import org.javatuples.Pair;
import org.reflections.Reflections;

interface HotDrink {
	void consume();
}

class Tea implements HotDrink {

	@Override
	public void consume() {
		System.out.println("This tea is delicious");
	}
}

class Coffee implements HotDrink {

	@Override
	public void consume() {
		System.out.println("This coffee is delicious");
	}
}

interface HotDrinkFactory {
	HotDrink prepare(int amount);
}

class TeaFactory implements HotDrinkFactory {
	@Override
	public HotDrink prepare(int amount) {
		System.out.println("Put in tea bag, boil water, pour " + amount + "ml, add lemon, enjoy!");
		return new Tea();
	}
}

class CoffeeFactory implements HotDrinkFactory {

	@Override
	public HotDrink prepare(int amount) {
		System.out.println("Grind some beans, boil water, pour " + amount + " ml, add cream and sugar, enjoy!");
		return new Coffee();
	}
}

class HotDrinkMachine {
	public enum AvailableDrink {
		COFFEE, TEA
	}

	private Map<AvailableDrink, HotDrinkFactory> factories = new HashMap<>();

	private List<Pair<String, HotDrinkFactory>> namedFactories = new ArrayList<>();

	public HotDrinkMachine() throws Exception {
		// option 1: use an enum
		for (AvailableDrink drink : AvailableDrink.values()) {
			String s = drink.toString();
			String factoryName = "" + Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
			Class<?> factory = Class.forName("designpatterns.creational.factory." + factoryName + "Factory");
			factories.put(drink, (HotDrinkFactory) factory.getDeclaredConstructor().newInstance());
		}

		// option 2: find all implementors of HotDrinkFactory using 'Reflection' library
		Set<Class<? extends HotDrinkFactory>> types = new Reflections("designpatterns.creational.factory") // ""
				.getSubTypesOf(HotDrinkFactory.class);
		for (Class<? extends HotDrinkFactory> type : types) {
			namedFactories.add(new Pair<>(type.getSimpleName().replace("Factory", ""),
					type.getDeclaredConstructor().newInstance()));
		}
	}

	public HotDrink makeDrink() throws IOException {
		System.out.println("Available drinks");
		for (int index = 0; index < namedFactories.size(); ++index) {
			Pair<String, HotDrinkFactory> item = namedFactories.get(index);
			System.out.println("" + index + ": " + item.getValue0());
		}

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String s;
			int i, amount;
			if ((s = reader.readLine()) != null && (i = Integer.parseInt(s)) >= 0 && i < namedFactories.size()) {
				System.out.println("Specify amount: ");
				s = reader.readLine();
				if (s != null && (amount = Integer.parseInt(s)) > 0) {
					return namedFactories.get(i).getValue1().prepare(amount);
				}
			}
			System.out.println("Incorrect input, try again.");
		}
	}

	public HotDrink makeDrink(AvailableDrink drink, int amount) {
		return ((HotDrinkFactory) factories.get(drink)).prepare(amount);
	}
}

class AbstractFactoryDemo { // NOT WORKING
	public static void main(String[] args) throws Exception {
		HotDrinkMachine machine = new HotDrinkMachine();
		HotDrink tea = machine.makeDrink(HotDrinkMachine.AvailableDrink.TEA, 200);
		tea.consume();

		// interactive
//		HotDrink drink = machine.makeDrink();
//		drink.consume();
	}
}