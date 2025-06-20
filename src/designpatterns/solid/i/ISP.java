package designpatterns.solid.i;

class Document {
}

interface Machine {
	void print(Document d);

	void fax(Document d) throws Exception;

	void scan(Document d) throws Exception;
}

// okay if you need a multifunction machine
class MultiFunctionPrinter implements Machine {
	public void print(Document d) {
		//
	}

	public void fax(Document d) {
		//
	}

	public void scan(Document d) {
		//
	}
}

// not good, as we've to implement the unnecessary methods + in case of throwing 'exceptions' that is also a different issue.
class OldFashionedPrinter implements Machine {
	public void print(Document d) {
		// yep
	}

	public void fax(Document d) throws Exception {
		throw new Exception(); // keep 'empty' or 'throw some exception'
	}

	public void scan(Document d) throws Exception {
		throw new Exception();
	}
}

// Segregating the 'Machine' interface into different interfaces.
interface Printer {
	void Print(Document d) throws Exception;
}

interface Scanner {
	void Scan(Document d) throws Exception;
}

interface Fax {
	void fax(Document d) throws Exception;
}

class JustAPrinter implements Printer { // creating a simple print just by implementing only Printer.
	public void Print(Document d) {

	}
}

class Photocopier implements Printer, Scanner { // creating a photocopier by implement 2 interfaces i.e. Printer &
												// Scanner
	public void Print(Document d) throws Exception {
		throw new Exception();
	}

	public void Scan(Document d) throws Exception {
		throw new Exception();
	}
}

interface MultiFunctionDevice extends Printer, Scanner //
{

}

class MultiFunctionMachine implements MultiFunctionDevice { // creating a big-machine using a bigger interface 'MultiFunctionDevice'
	// compose this out of several modules
	private Printer printer;
	private Scanner scanner;

	public MultiFunctionMachine(Printer printer, Scanner scanner) {
		this.printer = printer;
		this.scanner = scanner;
	}

	public void Print(Document d) throws Exception {
		printer.Print(d);
	}

	public void Scan(Document d) throws Exception {
		scanner.Scan(d);
	}
}
